/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.xtext.lazyresolver.linker;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper.IJvmLinkCrossRefStringEnhancer;
import org.lunifera.dsl.xtext.lazyresolver.api.logger.TimeLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

public class FastLinkingService extends DefaultLinkingService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FastLinkingService.class);

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private LazyJvmTypeLinkingHelper jvmTypeLinkingHelper;

	/**
	 * @return the first element returned from the injected
	 *         {@link IScopeProvider} which matches the text of the passed
	 *         {@link INode node}
	 */
	public List<EObject> getLinkedObjects(EObject context, EReference ref,
			INode node) throws IllegalNodeException {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		String crossRefString = getCrossRefNodeAsString(node);
		if (crossRefString != null && !crossRefString.equals("")) {

			// enhance the cross reference string before scoping
			try {
				EStructuralFeature containingFeature = context
						.eContainingFeature();
				if (jvmTypeLinkingHelper.isJvmLink(containingFeature)) {
					IJvmLinkCrossRefStringEnhancer enhancer = jvmTypeLinkingHelper
							.getEnhancer(containingFeature);
					if (enhancer != null) {
						crossRefString = enhancer.enhance(context,
								containingFeature, crossRefString);
					}
					if(crossRefString == null || crossRefString.equals("")){
						crossRefString = "LUN__UNDEFINED";
					}
				}
			} catch (Exception e) {
				LOGGER.error("{}", e);
			}

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("before getLinkedObjects: node: '"
						+ crossRefString + "'");
			}

			TimeLogger createLog = TimeLogger.start(getClass());
			final IScope scope = getScope(context, ref);
			createLog.stop(LOGGER, "Creating scope for " + crossRefString + " "
					+ toRefName(ref) + " and context " + context + " took");

			QualifiedName qualifiedLinkName = qualifiedNameConverter
					.toQualifiedName(crossRefString);

			TimeLogger doScopeLog = TimeLogger.start(getClass());
			IEObjectDescription eObjectDescription = scope
					.getSingleElement(qualifiedLinkName);
			doScopeLog.stop(LOGGER, "Executing scope for " + crossRefString
					+ " " + toRefName(ref) + " and context " + context
					+ " with result " + eObjectDescription + " took");

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("after getLinkedObjects: node: '" + crossRefString
						+ "' result: " + eObjectDescription);
			}
			if (eObjectDescription != null)
				return Collections.singletonList(eObjectDescription
						.getEObjectOrProxy());
		}
		return Collections.emptyList();
	}

	private String toRefName(EReference ref) {
		EClass type = ref.getEReferenceType();
		return type.getName() + "#" + ref.getName();
	}
}
