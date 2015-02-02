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
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.entity.xtext.extensions.EntityTypesBuilder
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LEnum
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LBeanReference
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityReference
import org.lunifera.dsl.semantic.entity.LOperation
import org.lunifera.dsl.xtext.lazyresolver.IndexModelInferrer
import org.lunifera.dsl.xtext.lazyresolver.api.logger.TimeLogger
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * This is the main model inferrer that is automatically registered in AbstractEntityRuntimeModule.
 * It dispatches to specific model inferrers depending on the metamodel element.
 */
class EntityGrammarJvmModelInferrer extends IndexModelInferrer {

	protected val Logger log = LoggerFactory::getLogger(getClass())

	@Inject AnnotationCompiler annotationCompiler

	@Inject extension IQualifiedNameProvider
	@Inject extension EntityTypesBuilder;
	@Inject extension ModelExtensions;
	@Inject TypeReferences references

	// used for test cases with old derived state computer
	def dispatch void infer(LEnum enumX, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		val type = enumX.toEnumerationType(enumX.fullyQualifiedName.toString, null)
		type.inferFullState(enumX, acceptor, isPrelinkingPhase, "")
	}

	def dispatch void inferTypesOnly(LEnum enumX, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		val type = enumX.toEnumerationType(enumX.fullyQualifiedName.toString, null)
		type.markAsToBeDerivedLater(enumX, isPrelinkingPhase)
		acceptor.accept(type);

		// pass inferring to delegates
		inferTypesOnlyByDelegates(enumX, acceptor, isPrelinkingPhase);
	}

	def dispatch void inferFullState(JvmDeclaredType type, LEnum enumX, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase, String selector) {

		acceptor.accept(type).initializeLater [
			
			val TimeLogger doInferLog = TimeLogger.start(getClass());
			
			type.markAsDerived
			fileHeader = (enumX.eContainer as LTypedPackage).documentation
			documentation = enumX.documentation
			for (f : enumX.literals) {
				documentation = f.documentation
				members += f.toEnumerationLiteral(f.name)
			}
			
			doInferLog.stop(log, "Inferring enum " + enumX.name)
		]
	}

	// used for test cases with old derived state computer
	def dispatch void infer(LBean bean, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		val type = bean.toJvmType;
		type.inferFullState(bean, acceptor, isPrelinkingPhase, "bean")
	}

	def dispatch void inferTypesOnly(LBean bean, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		val type = bean.toJvmType;
		type.markAsToBeDerivedLater(bean, isPrelinkingPhase, "bean")
		acceptor.accept(type);
		
		// pass inferring to delegates
		inferTypesOnlyByDelegates(bean, acceptor, isPrelinkingPhase);
	}

	def dispatch void inferFullState(JvmDeclaredType type, LBean bean, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase, String selector) {

		if(selector == null || !selector.equals("bean")) {
			return
		}

		acceptor.accept(type).initializeLater [
			
			val TimeLogger doInferLog = TimeLogger.start(getClass());
			
			// mark the type as derived
			type.markAsDerived()
			annotationCompiler.processAnnotation(bean, it);
			fileHeader = (bean.eContainer as LTypedPackage).documentation
			documentation = bean.getDocumentation
			if (bean.getSuperType == null) {
				superTypes += references.getTypeForName(typeof(Serializable), bean, null)
			}
			if (bean.getSuperType != null && !bean.getSuperType.fullyQualifiedName.toString.empty) {
				superTypes += bean.superTypeJvm.cloneWithProxies
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
					LAttribute: {
						if (!f.derived && f.fullyQualifiedName != null && !f.fullyQualifiedName.toString.empty) {
							members += f.toField
						}
					}
					LReference: {
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
					LAttribute: {
						members += f.toGetter()
						if (!f.derived) {
							if (f.isToMany) {
								members += f.toCollectionSetter(f.name)
								members += f.toInternalCollectionGetter(f.getName)
								members += f.toAdder(f.getName)
								members += f.toRemover(f.getName)
							} else {
								members += f.toSetter()
							}
						}
					}
					LReference: {
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
			
			doInferLog.stop(log, "Inferring bean " + bean.name)
		]
	}

	// used for test cases with old derived state computer
	def dispatch void infer(LEntity entity, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		val type = entity.toJvmType;
		type.inferFullState(entity, acceptor, isPrelinkingPhase, "")
	}

	def dispatch void inferTypesOnly(LEntity entity, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		val type = entity.toJvmType;
		type.markAsToBeDerivedLater(entity, isPrelinkingPhase, "entity")
		acceptor.accept(type);
		
		// pass inferring to delegates
		inferTypesOnlyByDelegates(entity, acceptor, isPrelinkingPhase);
	}

	def dispatch void inferFullState(JvmType type, EObject element, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase, String selector) {
	}

	def dispatch void inferFullState(JvmDeclaredType type, LEntity entity, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase, String selector) {

		if(selector == null || !selector.equals("entity")) {
			return
		}

		acceptor.accept(type).initializeLater [
			
			val TimeLogger doInferLog = TimeLogger.start(getClass());
			
			type.markAsDerived
			annotationCompiler.processAnnotation(entity, it);
			var LAttribute idAttribute = null
			var JvmField idField = null
			fileHeader = (entity.eContainer as LTypedPackage).documentation
			documentation = entity.documentation
			if (entity.getSuperType != null && !entity.getSuperType.fullyQualifiedName.toString.empty) {

				//				superTypes += references.getTypeForName(entity.getSuperType.fullyQualifiedName.toString, entity, null)
				superTypes += entity.superTypeJvm.cloneWithProxies
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
					LAttribute: {
						if (!f.derived && f.fullyQualifiedName != null && !f.fullyQualifiedName.toString.empty) {
							if (f.id || f.uuid) {
								idAttribute = f
								idField = f.toField
								members += idField
							} else {
								members += f.toField
							}
						}
					}
					LReference: {
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
					LAttribute: {
						members += f.toGetter()
						if (!f.derived) {
							if (f.toMany) {
								members += f.toCollectionSetter(f.name)
								members += f.toInternalCollectionGetter(f.name)
								members += f.toAdder(f.name)
								members += f.toRemover(f.name)
							} else {
								members += f.toSetter()
							}
						}
					}
					LReference: {
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
			if (idAttribute != null) {
				members += idAttribute.toEqualsMethod(it, false, idField)
				members += idAttribute.toHashCodeMethod(false, idField)
			}
			
			doInferLog.stop(log, "Inferring entity " + entity.name)
		]
	}
}
