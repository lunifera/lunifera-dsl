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
package org.lunifera.dsl.dto.xtext.linker;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LReference;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;
import org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute;
import org.lunifera.dsl.semantic.dto.LDtoInheritedReference;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;
import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityReference;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper;
import org.lunifera.dsl.xtext.lazyresolver.validation.SuppressWarningAdapter;

import com.google.inject.Inject;

public class DtoJvmLinkingHelper extends LazyJvmTypeLinkingHelper {

	@Inject
	private MethodNamingExtensions namingExtension;

	public DtoJvmLinkingHelper() {
		register(LunDtoPackage.Literals.LDTO__SUPER_TYPE,
				LunDtoPackage.Literals.LDTO__SUPER_TYPE_JVM);
		register(LunDtoPackage.Literals.LDTO__WRAPPED_TYPE,
				LunDtoPackage.Literals.LDTO__WRAPPED_TYPE_JVM);

		register(LunTypesPackage.Literals.LATTRIBUTE__TYPE,
				LunTypesPackage.Literals.LATTRIBUTE__TYPE_JVM);

		register(LunDtoPackage.Literals.LDTO_ABSTRACT_REFERENCE__TYPE,
				LunDtoPackage.Literals.LDTO_ABSTRACT_REFERENCE__TYPE_JVM);

		register(
				LunDtoPackage.Literals.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE,
				LunDtoPackage.Literals.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE_TYPE_JVM,
				new IJvmLinkCrossRefStringEnhancer() {
					@Override
					public String enhance(EObject context,
							EStructuralFeature feature, String crossRefString) {
						LDtoInheritedAttribute lAtt = (LDtoInheritedAttribute) context
								.eContainer();
						LAttribute lInhAtt = lAtt.getInheritedFeature();
						if (lInhAtt.eIsProxy()) {
							return crossRefString;
						}
						if (lInhAtt.getType() instanceof LBean) {
							return namingExtension.toDTOBeanSimpleName(lInhAtt
									.getType().getName());
						} else {
							return lInhAtt.getType().getName();
						}
					}
				}, null);

		register(LunDtoPackage.Literals.LDTO__WRAPPED_TYPE,
				LunDtoPackage.Literals.LDTO__WRAPPED_TYPE_JVM);

		register(
				LunDtoPackage.Literals.LDTO_INHERITED_REFERENCE__INHERITED_FEATURE,
				LunDtoPackage.Literals.LDTO_INHERITED_REFERENCE__INHERITED_FEATURE_TYPE_JVM,
				new IJvmLinkCrossRefStringEnhancer() {
					@Override
					public String enhance(EObject context,
							EStructuralFeature feature, String crossRefString) {
						LDtoInheritedReference lRef = (LDtoInheritedReference) context
								.eContainer();
						LReference lInhRef = lRef
								.getInheritedFeature();
						if(lInhRef.eIsProxy()){
							return crossRefString;
						}
						LEntityReference lEntityRef = (LEntityReference) lInhRef;
						if (lEntityRef.getType() instanceof LEntity) {
							return namingExtension
									.toDTOBeanSimpleName(lEntityRef.getType()
											.getName());
						} else {
							return lEntityRef.getType().getName();
						}
					}
				}, null);

		// Also register the need of a proxy for the jvmType of a mapper. But
		// therefore a different crossRefString needs to become used.
		register(LunDtoPackage.Literals.LDTO__SUPER_TYPE,
				LunDtoPackage.Literals.LDTO__SUPER_TYPE_MAPPER_JVM,
				new IJvmLinkCrossRefStringEnhancer() {
					@Override
					public String enhance(EObject context,
							EStructuralFeature feature, String crossRefString) {
						return namingExtension.toMapperName(crossRefString);
					}
				}, new IJvmTypeRefFinisher() {
					@Override
					public void finish(EStructuralFeature jvmLinkFeature,
							JvmTypeReference typeRef) {
						typeRef.eAdapters().add(
								new SuppressWarningAdapter(
										SuppressWarningAdapter.RAW_TYPE));
					}
				});
	}
}
