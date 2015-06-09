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

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper.IJvmLinkCrossRefStringEnhancer;
import org.lunifera.dsl.xtext.lazyresolver.api.DerivedRootAdapter;
import org.lunifera.dsl.xtext.lazyresolver.api.IIndexDerivedStateComputer;
import org.lunifera.dsl.xtext.lazyresolver.api.ISemanticLoadingResource;
import org.lunifera.dsl.xtext.lazyresolver.api.logger.TimeLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("restriction")
public class SemanticLoadingResource extends BatchLinkableResource implements
		ISemanticLoadingResource {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SemanticLoadingResource.class);

	@Inject
	private LazyJvmTypeLinkingHelper jvmProxyLinkingHelper;

	@Inject
	private IDerivedStateComputer derivedStateComputer;

	private boolean suppressDerivedState;

	@Override
	public EObject getSemanticElement(String fragment) {
		try {
			suppressDerivedState = true;
			return super.getEObject(fragment);
		} finally {
			suppressDerivedState = false;
		}
	}

	@Override
	public EObject getSemanticElement() {
		try {
			suppressDerivedState = true;
			return getContents().get(0);
		} finally {
			suppressDerivedState = false;
		}
	}

	protected void resolveLazyCrossReference(InternalEObject source,
			EStructuralFeature crossRef) {
		if (isPotentialLazyCrossReference(crossRef)
				&& !isJvmHelperLink(source, crossRef)) {
			doResolveLazyCrossReference(source, crossRef);
		}
	}

	protected boolean isJvmHelperLink(InternalEObject source,
			EStructuralFeature crossRef) {
		EStructuralFeature containingFeature = source.eContainingFeature();
		return jvmProxyLinkingHelper.isJvmLink(containingFeature);
	}

	public void installDerivedState(boolean preIndexingPhase) {
		if (preIndexingPhase || !suppressDerivedState) {

			if (!isLoaded)
				throw new IllegalStateException(
						"The resource must be loaded, before installDerivedState can be called.");
			if (!fullyInitialized && !isInitializing) {
				try {
					isInitializing = true;
					if (derivedStateComputer != null)
						derivedStateComputer.installDerivedState(this,
								preIndexingPhase);
					fullyInitialized = true;
				} finally {
					isInitializing = false;
					getCache().clear(this);
				}
			}
		}
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {

		if (getContents().isEmpty()) {
			// TODO check me
			return;
		}

		EObject semanticElement = getSemanticElement();
		if (semanticElement == null)
			throw new IllegalStateException(
					"The Xtext resource must contain at least one element.");
		SaveOptions saveOptions = SaveOptions.getOptions(options);
		setEncodingFromOptions(options);
		getSerializer().serialize(semanticElement,
				new OutputStreamWriter(outputStream, getEncoding()),
				saveOptions);
	}

	@Override
	public EObject getEObject(String uriFragment) {

		// look up the fragment cache
		FragmentCache cache = getFragmentCache();
//		if (cache.containsKey(uriFragment)) {
//			LOGGER.debug("Firstlevel-Fragment-Cache-Hit for " + uriFragment);
//			return cache.get(uriFragment);
//		}

		EObject result = null;
		if (uriFragment.startsWith("/0")) {
			// will access semantic model -> No need to install derived state
			try {
				suppressDerivedState = true;
				result = super.getEObject(uriFragment);
			} finally {
				suppressDerivedState = false;
			}
		} else {
			result = super.getEObject(uriFragment);
		}

		// put result to fragment cache
		cache.put(uriFragment, result);

		return result;
	}

	protected void clearInternalState() {
		try {
			suppressDerivedState = true;
			super.clearInternalState();
		} finally {
			suppressDerivedState = false;
		}
	}

	@SuppressWarnings("sync-override")
	@Override
	public EList<EObject> getContents() {
		if (derivedStateComputer instanceof IIndexDerivedStateComputer) {
			synchronized (getLock()) {
				if (isLoaded && !isLoading && !isInitializing && !isUpdating
						&& !fullyInitialized) {
					try {
						eSetDeliver(false);
						installDerivedState(false);
					} finally {
						eSetDeliver(true);
					}
				}
				return doGetMyContents();
			}
		} else {
			return super.getContents();
		}
	}

	/**
	 * @since 2.4
	 */
	protected EList<EObject> doGetMyContents() {
		if (contents == null) {
			contents = new ContentsList<EObject>();
		}
		return contents;
	}

	protected ILinkingDiagnosticContext createDiagnosticMessageContext(
			Triple<EObject, EReference, INode> triple) {
		return new JvmLinkAwareDiagnosticMessageContext(triple,
				getLinkingHelper(), jvmProxyLinkingHelper);
	}

	public FragmentCache getFragmentCache() {
		return getCache().get("lunifera-fragments", this,
				new Provider<FragmentCache>() {
					public FragmentCache get() {
						return new FragmentCache();
					}
				});
	}

	@SuppressWarnings("serial")
	protected class ContentsList<E extends Object & EObject> extends
			ResourceImpl.ContentsEList<E> {

		private boolean initializing;

		@Override
		public E get(int index) {
			if (!initializing && fullyInitialized && index > 0) {
				try {
					initializing = true;
					EObject context = super.get(index);
					if (isUnDerived(context)) {
						TimeLogger logger = TimeLogger.start(getClass());
						IndexDerivedStateComputer computer = (IndexDerivedStateComputer) derivedStateComputer;
						computer.installDerivedState(
								SemanticLoadingResource.this,
								(JvmDeclaredType) context, false);
						logger.stop(LOGGER, "Inferring index " + index
								+ " for resource " + getURI() + " took");
					}
				} finally {
					initializing = false;
				}
			} else if (initializing && fullyInitialized && index > 0) {
				if (isDerivedStateChainAllowed()) {
					EObject context = super.get(index);
					if (isUnDerived(context)) {
						TimeLogger logger = TimeLogger.start(getClass());
						IndexDerivedStateComputer computer = (IndexDerivedStateComputer) derivedStateComputer;
						computer.installDerivedState(
								SemanticLoadingResource.this,
								(JvmDeclaredType) context, false);
						logger.stop(LOGGER, "Inferring index " + index
								+ " for resource " + getURI() + " took");
					}
				} else {
					LOGGER.error(String
							.format("Index %s should be inferred. But another inferring is already active. Ensure you use the xyzJvm proxies in jvmInferrer. See LazyJvmTypeLinkingHelper. To allow this issue, pass -D%s in vm-arguments.",
									Integer.toString(index),
									SYS_PROPERTY__DERIVED_STATE_CHAIN_ALLOWED));
					throw new IllegalStateException(
							String.format(
									"Index %s should be inferred. But another inferring is already active. Ensure you use the xyzJvm proxies in jvmInferrer. See LazyJvmTypeLinkingHelper. To allow this issue, pass -D%s in vm-arguments.",
									Integer.toString(index),
									SYS_PROPERTY__DERIVED_STATE_CHAIN_ALLOWED));
				}
			}
			return super.get(index);
		}

		private boolean isDerivedStateChainAllowed() {
			return System
					.getProperty(SYS_PROPERTY__DERIVED_STATE_CHAIN_ALLOWED) != null;
		}

		private boolean isUnDerived(EObject context) {
			return EcoreUtil.getAdapter(context.eAdapters(),
					DerivedRootAdapter.class) != null;
		}

		@Override
		public Iterator<E> iterator() {
			return super.iterator();
		}

		@Override
		public ListIterator<E> listIterator() {
			return super.listIterator();
		}

		@Override
		public ListIterator<E> listIterator(int index) {
			return super.listIterator(index);
		}
	}

	protected static class JvmLinkAwareDiagnosticMessageContext implements
			ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext {

		private final Triple<EObject, EReference, INode> triple;
		private final String linkText;

		protected JvmLinkAwareDiagnosticMessageContext(
				Triple<EObject, EReference, INode> triple,
				LinkingHelper linkingHelper,
				LazyJvmTypeLinkingHelper crossRefStringHelper) {
			this.triple = triple;
			this.linkText = getCrossRefString(triple, linkingHelper,
					crossRefStringHelper);
		}

		private String getCrossRefString(
				Triple<EObject, EReference, INode> triple,
				LinkingHelper linkingHelper,
				LazyJvmTypeLinkingHelper crossRefStringHelper) {
			String result = linkingHelper.getCrossRefNodeAsString(
					triple.getThird(), true);

			EStructuralFeature containingFeature = triple.getFirst()
					.eContainingFeature();
			IJvmLinkCrossRefStringEnhancer enhancer = crossRefStringHelper
					.getEnhancer(containingFeature);
			if (enhancer != null) {
				result = enhancer.enhance(triple.getFirst(), containingFeature,
						result);
			}

			return result;
		}

		public EObject getContext() {
			return triple.getFirst();
		}

		public EReference getReference() {
			return triple.getSecond();
		}

		public String getLinkText() {
			return linkText;
		}
	}

	/**
	 * A cache that caches the uriFragment with the scoped result.
	 */
	@SuppressWarnings("serial")
	protected class FragmentCache extends HashMap<String, EObject> {

		public FragmentCache() {
		}

	}
}
