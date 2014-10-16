/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Hans Georg Gl??ckler - Initial implementation
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.dto.xtext.valueconverter;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.lunifera.dsl.common.xtext.valueconverter.CommonQualifiedNameProvider;
import org.lunifera.dsl.dto.xtext.extensions.DtoModelExtensions;
import org.lunifera.dsl.semantic.dto.LDtoFeature;
import org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute;
import org.lunifera.dsl.semantic.dto.LDtoInheritedReference;

import com.google.inject.Inject;

public class DtoQualifiedNameProvider extends CommonQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private DtoModelExtensions extensions;
	@Inject
	private LinkingHelper linkingHelper;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj == null) {
			return QualifiedName.create("");
		}

		if (obj instanceof LDtoFeature) {
			LDtoFeature feature = (LDtoFeature) obj;

			String name = "";
			if (extensions.inherited(feature)) {
				CompositeNodeWithSemanticElement node = (CompositeNodeWithSemanticElement) NodeModelUtils
						.getNode(feature);
				if (node == null) {
					// the model is beeing serialized. No grammar available yet
					if(feature instanceof LDtoInheritedAttribute){
						name = ((LDtoInheritedAttribute) feature).getInheritedFeature().getName();
					}else{
						name = ((LDtoInheritedReference) feature).getInheritedFeature().getName();
					}
				} else {
					List<ILeafNode> leafs = IterableExtensions.toList(node
							.getLeafNodes());
					name = linkingHelper.getCrossRefNodeAsString(leafs.get(3),
							false);
				}
			} else {
				name = feature.getName();
			}

			return name != null ? qualifiedNameConverter.toQualifiedName(name)
					: null;
		}
		return super.getFullyQualifiedName(obj);
	}

}
