/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Sources partially based on org.eclipse.emf.ecore.xcore.scoping.XcoreScopeProvider
 * 
 * Contributors:
 * 		Hans Georg Gl??ckler - Initial implementation
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.dto.xtext.scope;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScope;
import org.lunifera.dsl.common.xtext.scope.CommonScopeProvider;

import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
@SuppressWarnings("restriction")
public class DtoScopeProvider extends CommonScopeProvider {
	@Inject
	private IQualifiedNameProvider fqnProvider;

	@Override
	public IScope getScope(final EObject context, EReference reference) {
		return super.getScope(context, reference);
	}

	// private IScope getScope_LDtoWrappedReference_feature(
	// final LDtoWrappedReference prop) {
	// return new AbstractScope(IScope.NULLSCOPE, false) {
	// @Override
	// protected Iterable<IEObjectDescription> getAllLocalElements() {
	// ArrayList<IEObjectDescription> result = new
	// ArrayList<IEObjectDescription>();
	// if (prop.getDTO() != null) {
	// LDto propClass = prop.getDTO();
	//
	// LType wrappedType = propClass.getWrappedType();
	// if (wrappedType != null
	// && wrappedType instanceof LFeaturesHolder) {
	// LFeaturesHolder holder = (LFeaturesHolder) wrappedType;
	//
	// for (LFeature feature : holder.getAllFeatures()) {
	// result.add(new EObjectDescription(fqnProvider
	// .getFullyQualifiedName(feature), feature,
	// null));
	// }
	// }
	// }
	// return result;
	// }
	// };
	// }
}
