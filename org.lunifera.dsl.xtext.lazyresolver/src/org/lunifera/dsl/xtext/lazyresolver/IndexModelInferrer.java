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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.lunifera.dsl.xtext.lazyresolver.hook.ExtensionsInferrerDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

public class IndexModelInferrer extends AbstractModelInferrer {

	protected Logger log = LoggerFactory.getLogger(IndexModelInferrer.class);

	private @Inject JvmAnnotationReferenceBuilder.Factory annotationRefBuilderFactory;
	private @Inject JvmTypeReferenceBuilder.Factory typeRefBuilderFactory;

	protected @Extension JvmAnnotationReferenceBuilder _annotationTypesBuilder;
	protected @Extension JvmTypeReferenceBuilder _typeReferenceBuilder;

	@Inject
	private ExtensionsInferrerDelegate inferrerDelegate;

	@Inject
	private IndexDerivedStateHelper helper;

	/**
	 * @noreference This method is called by the framework
	 * @nooverride
	 */
	void setContext(Resource resource) {
		_annotationTypesBuilder = annotationRefBuilderFactory.create(resource
				.getResourceSet());
		_typeReferenceBuilder = typeRefBuilderFactory.create(resource
				.getResourceSet());
	}

	public void infer(EObject e,
			final/* @NonNull */IJvmDeclaredTypeAcceptor acceptor,
			boolean preIndexingPhase) {
		_infer(e, acceptor, preIndexingPhase);
	}

	public void _infer(EObject e, /* @NonNull */
			IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		for (EObject child : e.eContents()) {
			infer(child, acceptor, preIndexingPhase);
		}
	}

	public void inferTypesOnly(EObject e,
			final/* @NonNull */IJvmDeclaredTypeAcceptor acceptor,
			boolean preIndexingPhase) {

		// then iterate the contents
		_inferTypesOnly(e, acceptor, preIndexingPhase);
	}

	public void _inferTypesOnly(EObject e, IJvmDeclaredTypeAcceptor acceptor,
			boolean preIndexingPhase) {

		// pass inferring to delegates first
		inferTypesOnlyByDelegates(e, acceptor, preIndexingPhase);

		for (EObject child : e.eContents()) {
			inferTypesOnly(child, acceptor, preIndexingPhase);
		}
	}

	/**
	 * Delegates the inferTypes call to the delegates.
	 * 
	 * @param semanticElement
	 * @param acceptor
	 * @param preIndexingPhase
	 */
	protected void inferTypesOnlyByDelegates(EObject semanticElement,
			IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		inferrerDelegate.inferTypesOnly(semanticElement, acceptor,
				preIndexingPhase);
	}

	public void inferFullState(JvmType type, EObject e,
			IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase,
			String selector) {
	}

	/**
	 * Delegates the inferTypes call to the delegates.
	 * 
	 * @param jvmType
	 * @param semanticElement
	 * @param acceptor
	 * @param preIndexingPhase
	 * @param selector
	 */
	public void inferFullStateByDelegates(JvmType jvmType,
			EObject semanticElement, IJvmDeclaredTypeAcceptor acceptor,
			boolean preIndexingPhase, String selector) {
		inferrerDelegate.inferFullState((JvmDeclaredType) jvmType,
				semanticElement, acceptor, preIndexingPhase, selector);
	}

	protected void markAsToBeDerivedLater(JvmDeclaredType type,
			EObject context, boolean isPrelinkingPhase) {
		helper.markAsToBeDerivedLater(type, context, isPrelinkingPhase, "");
	}

	protected void markAsToBeDerivedLater(JvmDeclaredType type,
			EObject context, boolean isPrelinkingPhase, String selector) {
		helper.markAsToBeDerivedLater(type, context, isPrelinkingPhase,
				selector);
	}

	protected void markAsDerived(JvmDeclaredType type) {
		helper.markAsDerived(type);
	}
}
