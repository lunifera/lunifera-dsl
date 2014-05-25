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
package org.lunifera.dsl.entity.xtext.jvmmodel

import com.google.inject.Inject
import java.io.Serializable 
import org.apache.log4j.Logger
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.common.xtext.jvmmodel.CommonGrammarJvmModelInferrer
import org.lunifera.dsl.entity.xtext.extensions.EntityTypesBuilder
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LEnum
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LBeanReference
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityReference
import org.lunifera.dsl.semantic.entity.LOperation

/**
 * This is the main model inferrer that is automatically registered in AbstractEntityRuntimeModule.
 * It dispatches to specific model inferrers depending on the metamodel element.
 */
class EntityGrammarJvmModelInferrer extends CommonGrammarJvmModelInferrer {

	protected val Logger log = Logger::getLogger(getClass())

	@Inject extension IQualifiedNameProvider
	@Inject extension EntityTypesBuilder;
	@Inject extension ModelExtensions;
	@Inject TypeReferences references

	def dispatch void infer(LEnum enumX, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
		if(hasSyntaxErrors(enumX)) return;

		acceptor.accept(enumX.toEnumerationType(enumX.fullyQualifiedName.toString, null)).initializeLater [
			fileHeader = (enumX.eContainer as LTypedPackage).documentation
			documentation = enumX.documentation
			for (f : enumX.literals) {
				documentation = f.documentation
				members += f.toEnumerationLiteral(f.name)
			}
		]
	}

	def dispatch void infer(LBean bean, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
		if(hasSyntaxErrors(bean)) return;

		acceptor.accept(bean.toJvmType).initializeLater [
			fileHeader = (bean.eContainer as LTypedPackage).documentation
			documentation = bean.getDocumentation
			if (bean.getSuperType == null) {
				superTypes += references.getTypeForName(typeof(Serializable), bean, null)
			}
			if (bean.getSuperType != null && !bean.getSuperType.fullyQualifiedName.toString.empty) {
				superTypes += references.getTypeForName(bean.getSuperType.fullyQualifiedName.toString, bean, null)
			}
			// 
			// Constructor
			//
			members += bean.toConstructor()[]
			if (bean.getSuperType == null) {
				members += bean.toDiposeField()
			}
			//
			// Fields
			//
			for (f : bean.getFeatures) {
				switch f {
					LFeature: {
						if (f.fullyQualifiedName != null && !f.fullyQualifiedName.toString.empty) {
							members += f.toField
						}
					}
				}
			}
			//
			// Field accessors
			//
			if (bean.getSuperType == null) {
				members += bean.toIsDisposed()
			}
			members += bean.toCheckDisposed()
			members += bean.toDispose()
			for (f : bean.getFeatures) {
				switch f {
					case f instanceof LAttribute: {
						members += f.toGetter()
						if (f.isToMany) {
							members += f.toCollectionSetter(f.name)
							members += f.toInternalCollectionGetter(f.getName)
							members += f.toAdder(f.getName)
							members += f.toRemover(f.getName)
						} else {
							members += f.toSetter()
						}
					}
					case f instanceof LReference: {
						members += f.toGetter()
						if (f.isToMany) {
							members += f.toCollectionSetter(f.name)
							members += f.toInternalCollectionGetter(f.getName)
							members += f.toAdder(f.getName)
							members += f.toRemover(f.getName)
							members += f.toInternalAdder
							members += f.toInternalRemover
						} else {
							members += f.toSetter()

							if (f.isCascading && (f as LBeanReference).getOpposite != null) {
								members += f.toInternalSetter
							}
						}
					}
				}
			}
			//
			// Methods. 
			//    
			for (op : bean.getOperations) {
				members += op.toMethod(op.getName, op.getType) [
					documentation = op.getDocumentation
					for (p : op.getParams) {
						parameters += p.toParameter(p.name, p.parameterType)
					}
					body = op.getBody
				]
			}
		]

	}

	def dispatch void infer(LEntity entity, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
		if(hasSyntaxErrors(entity)) return;

		acceptor.accept(entity.toJvmType).initializeLater [
			fileHeader = (entity.eContainer as LTypedPackage).documentation
			documentation = entity.documentation
			if (entity.getSuperType != null && !entity.getSuperType.fullyQualifiedName.toString.empty) {
				superTypes += references.getTypeForName(entity.getSuperType.fullyQualifiedName.toString, entity, null)
			}
			//
			// Constructor
			//
			members += entity.toConstructor()[]
			if (entity.getSuperType == null) {
				members += entity.toDiposeField()
			}
			//
			// Fields
			//
			for (f : entity.features.filter[!(it instanceof LOperation)]) {
				switch f {
					LFeature: {
						if (f.fullyQualifiedName != null && !f.fullyQualifiedName.toString.empty) {
							members += f.toField
						}
					}
				}
			}
			//
			// Field accessors
			//
			if (entity.getSuperType == null) {
				members += entity.toIsDisposed()
			}
			members += entity.toCheckDisposed()
			members += entity.toDispose()
			for (f : entity.features) {
				switch f {
					case f instanceof LAttribute: {
						members += f.toGetter()
						if (f.toMany) {
							members += f.toCollectionSetter(f.name)
							members += f.toInternalCollectionGetter(f.name)
							members += f.toAdder(f.name)
							members += f.toRemover(f.name)
						} else {
							members += f.toSetter()
						}
					}
					case f instanceof LReference: {
						members += f.toGetter()
						if (f.toMany) {
							members += f.toCollectionSetter(f.name)
							members += f.toInternalCollectionGetter(f.name)
							members += f.toAdder(f.name)
							members += f.toRemover(f.name)
							members += f.toInternalAdder
							members += f.toInternalRemover
						} else {
							members += f.toSetter()

							if (f.cascading && (f as LEntityReference).opposite != null) {
								members += f.toInternalSetter
							}
						}
					}
				}
			}
			//
			// Methods.
			//
			for (op : entity.operations) {
				members += op.toMethod(op.name, op.type) [
					documentation = op.documentation
					for (p : op.params) {
						parameters += p.toParameter(p.name, p.parameterType)
					}
					body = op.body
				]
			}
		]

	}
}
