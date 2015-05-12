/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.xtext.lazyresolver;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelCompleter;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.util.Maps2;
import org.lunifera.dsl.xtext.lazyresolver.api.DerivedRootAdapter;
import org.lunifera.dsl.xtext.lazyresolver.api.IIndexDerivedStateComputer;
import org.lunifera.dsl.xtext.lazyresolver.api.IIndexModelAssociator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

@SuppressWarnings("restriction")
public class IndexDerivedStateComputer extends JvmModelAssociator implements
		IIndexDerivedStateComputer, IIndexModelAssociator {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(IndexDerivedStateComputer.class);

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	@Inject
	private Provider<IJvmModelInferrer> inferrerProvider;

	@Inject
	private JvmModelCompleter completer;

	public void setCompleter(JvmModelCompleter completer) {
		this.completer = completer;
	}

	/**
	 * @since 2.8
	 * @noreference This method is not intended to be referenced by clients
	 */
	public void setInferrerProvider(Provider<IJvmModelInferrer> inferrerProvider) {
		this.inferrerProvider = inferrerProvider;
	}

	/**
	 * Never installs the fully derived state by invoking doLater.
	 */
	public void installDerivedState(final DerivedStateAwareResource resource,
			boolean preIndexingPhase) {
		if (resource.getContents().isEmpty())
			return;

		EObject eObject = resource.getContents().get(0);

		StoppedTask task = Stopwatches
				.forTask("JVM Model inference (JvmModelAssociator.installDerivedState)");
		task.start();
		JvmDeclaredTypeAcceptor acceptor = new JvmDeclaredTypeAcceptor(resource);
		try {
			IndexModelInferrer inferrer = (IndexModelInferrer) inferrerProvider
					.get();
			inferrer.setContext(resource);
			inferrer.inferTypesOnly(eObject, acceptor, preIndexingPhase);
		} catch (RuntimeException e) {
			// LOG.error("Error calling inferrer", e);
		}
		task.stop();
	}

	/**
	 * Installs the complete derived state for the {@link EObject} at the given
	 * index in the resource.
	 */
	@Override
	public void installDerivedState(DerivedStateAwareResource resource,
			JvmDeclaredType derivedOne, boolean preIndexingPhase) {
		DerivedRootAdapter derivedRootAdapter = (DerivedRootAdapter) EcoreUtil
				.getAdapter(derivedOne.eAdapters(), DerivedRootAdapter.class);
		EObject derivedSemantic = derivedRootAdapter.getSemantic();

		StoppedTask task = Stopwatches
				.forTask("JVM Model inference (JvmModelAssociator.installDerivedState)");
		task.start();
		JvmDeclaredTypeAcceptor acceptor = new JvmDeclaredTypeAcceptor(resource);
		try {
			IndexModelInferrer inferrer = (IndexModelInferrer) inferrerProvider
					.get();
			inferrer.setContext(resource);

			// infer the full state by the inferrer
			inferrer.inferFullState(derivedOne, derivedSemantic, acceptor,
					preIndexingPhase, derivedRootAdapter.getSelector());

			// then delegate the inferring to all extension delegates
			inferrer.inferFullStateByDelegates(derivedOne, derivedSemantic,
					acceptor, preIndexingPhase,
					derivedRootAdapter.getSelector());

		} catch (RuntimeException e) {
			// LOG.error("Error calling inferrer", e);
			System.out.println(e);
		}
		if (!preIndexingPhase) {
			for (Pair<JvmDeclaredType, Procedure1<? super JvmDeclaredType>> initializer : acceptor.later) {
				try {
					initializer.getValue().apply(initializer.getKey());
				} catch (RuntimeException e) {
					// LOG.error("Error calling inferrer", e);
					System.out.println(e);
				}
			}
		}
		task.stop();

		if (!preIndexingPhase) {
			completer.complete(derivedOne);
		}
	}

	protected ExtendedAdapter getOrInstall(Resource resource) {
		if (!(resource instanceof XtextResource)) {
			return new ExtendedAdapter();
		}
		String resourceLanguageName = ((XtextResource) resource)
				.getLanguageName();
		if (!languageName.equals(resourceLanguageName)) {
			return new ExtendedAdapter();
		}
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(resource.eAdapters(),
				Adapter.class);
		if (adapter == null) {
			adapter = new ExtendedAdapter();
			resource.eAdapters().add(adapter);
		}
		return (ExtendedAdapter) adapter;
	}

	protected Map<EObject, Set<Pair<String, JvmGenericType>>> selectorTypeMap(
			Resource res) {
		return getOrInstall(res).selectorTypeMap;
	}

	@Override
	public void associateBySelector(EObject sourceElement,
			JvmGenericType jvmElement, String selector) {
		Resource resource = sourceElement.eResource();
		Map<EObject, Set<Pair<String, JvmGenericType>>> selectorTypeMap = selectorTypeMap(resource);

		Set<Pair<String, JvmGenericType>> pairs = selectorTypeMap
				.get(sourceElement);
		if (pairs == null) {
			pairs = new HashSet<Pair<String, JvmGenericType>>(2);
			selectorTypeMap.put(sourceElement, pairs);
		}

		pairs.add(Pair.of(selector, jvmElement));
	}

	@Override
	public JvmGenericType getBySelector(EObject sourceElement, String selector) {
		Resource resource = sourceElement.eResource();
		Set<Pair<String, JvmGenericType>> pairs = selectorTypeMap(resource)
				.get(sourceElement);
		if (pairs != null) {
			for (Pair<String, JvmGenericType> pair : pairs) {
				if (pair.getKey().equals(selector)) {
					return pair.getValue();
				}
			}
		}

		LOGGER.error("No registration found for " + selector + " : "
				+ sourceElement);
		return null;
	}

	protected static class ExtendedAdapter extends JvmModelAssociator.Adapter {
		public Map<EObject, Set<Pair<String, JvmGenericType>>> selectorTypeMap = Maps2
				.newLinkedHashMapWithExpectedSize(40);

	}

}
