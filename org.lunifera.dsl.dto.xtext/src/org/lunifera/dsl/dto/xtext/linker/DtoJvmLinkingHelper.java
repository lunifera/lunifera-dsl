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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper;
import org.lunifera.dsl.xtext.lazyresolver.validation.SuppressWarningAdapter;

public class DtoJvmLinkingHelper extends LazyJvmTypeLinkingHelper {

	public DtoJvmLinkingHelper() {
		register(LunDtoPackage.Literals.LDTO__SUPER_TYPE,
				LunDtoPackage.Literals.LDTO__SUPER_TYPE_JVM);
		register(LunDtoPackage.Literals.LDTO_ABSTRACT_REFERENCE__TYPE,
				LunDtoPackage.Literals.LDTO_ABSTRACT_REFERENCE__TYPE_JVM);
		register(LunDtoPackage.Literals.LDTO__WRAPPED_TYPE,
				LunDtoPackage.Literals.LDTO__WRAPPED_TYPE_JVM);

		// Also register the need of a proxy for the jvmType of a mapper. But
		// therefore a different crossRefString needs to become used.
		register(LunDtoPackage.Literals.LDTO__SUPER_TYPE,
				LunDtoPackage.Literals.LDTO__SUPER_TYPE_MAPPER_JVM,
				new IJvmLinkCrossRefStringEnhancer() {
					@Override
					public String enhance(String crossRefString) {
						return crossRefString + "Mapper";
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
