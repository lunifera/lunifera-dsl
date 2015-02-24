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
package org.lunifera.dsl.dto.xtext.jvmmodel

import com.google.inject.Inject
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.io.Serializable
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.dto.lib.IMapper
import org.lunifera.dsl.dto.lib.IMapperAccess
import org.lunifera.dsl.dto.lib.MappingContext
import org.lunifera.dsl.dto.xtext.extensions.DtoModelExtensions
import org.lunifera.dsl.dto.xtext.extensions.DtoTypesBuilder
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LEnum
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
import org.lunifera.dsl.semantic.dto.LDtoAbstractReference
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.xtext.lazyresolver.IndexModelInferrer
import org.lunifera.dsl.xtext.lazyresolver.api.logger.TimeLogger
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class DtoGrammarJvmModelInferrer extends IndexModelInferrer {

	protected val Logger log = LoggerFactory::getLogger(getClass())

	@Inject AnnotationCompiler annotationCompiler

	@Inject extension IQualifiedNameProvider
	@Inject extension DtoTypesBuilder;
	@Inject extension MethodNamingExtensions
	@Inject extension DtoModelExtensions;
	@Inject TypeReferences references

	def dispatch void inferFullState(JvmType type, EObject element, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase, String selector) {
	}

	// used for test cases with old derived state computer
	def dispatch void infer(LDto dto, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		// create dto type
		val type = dto.toJvmType;
		associateBySelector(dto, type, "dto")
		type.inferDtoFullState(dto, acceptor, isPrelinkingPhase)

		// create mapper type
		if (dto.wrappedType != null) {
			val mapperType = dto.toMapperJvmType;
			associateBySelector(dto, mapperType, "mapper")
			mapperType.inferMapperFullState(dto, acceptor, isPrelinkingPhase)
		}
	}

	def dispatch void inferTypesOnly(LDto dto, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		// create dto type
		val type = dto.toJvmType;
		associateBySelector(dto, type, "dto")
		type.markAsToBeDerivedLater(dto, isPrelinkingPhase)
		acceptor.accept(type);

		// create mapper type
		if (dto.wrappedType != null) {
			val mapperType = dto.toMapperJvmType;
			associateBySelector(dto, mapperType, "mapper")
			mapperType.markAsToBeDerivedLater(dto, isPrelinkingPhase, "mapper")
			acceptor.accept(mapperType)
		}

		// pass inferring to delegates
		inferTypesOnlyByDelegates(dto, acceptor, isPrelinkingPhase);
	}

	def dispatch void inferFullState(JvmGenericType type, LDto dto, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase, String selector) {
		if (selector.equals("mapper")) {
			type.inferMapperFullState(dto, acceptor, isPrelinkingPhase)
		} else {
			type.inferDtoFullState(dto, acceptor, isPrelinkingPhase)
		}
	}

	def void inferDtoFullState(JvmDeclaredType type, LDto dto, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase) {

		acceptor.accept(type).initializeLater [
			type.markAsDerived
			val TimeLogger doInferLog = TimeLogger.start(getClass());
			abstract = dto.abstract
			annotationCompiler.processAnnotation(dto, it);
			var LAttribute idAttribute = null
			var JvmField idField = null
			fileHeader = (dto.eContainer as LTypedPackage).documentation
			documentation = dto.getDocumentation
			if (dto.getSuperType != null && !dto.getSuperType.fullyQualifiedName.toString.empty) {
				superTypes += dto.superTypeJvm.cloneWithProxies
			}
			superTypes += references.getTypeForName(typeof(Serializable), dto, null)
			superTypes += references.getTypeForName(typeof(PropertyChangeListener), dto, null)
			if (dto.getSuperType == null) {
				members += dto.toPropertyChangeSupportField()
				members += dto.toDiposeField
			}
			//
			// Fields
			//
			for (f : dto.getFeatures) {
				switch f {
					LAttribute: {
						if (!f.derived && f.fullyQualifiedName != null && !f.fullyQualifiedName.toString.empty) {
							if (f.isIDorUUID) {
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
			// Constructor
			//
			members += dto.toConstructor()[]
			//
			// Field accessors
			//
			if (dto.getSuperType == null) {
				members += dto.toIsDisposed()
				members += dto.toAddPropertyChangeListener()
				members += dto.toAddPropertyChangeListenerWithProperty()
				members += dto.toRemovePropertyChangeListener()
				members += dto.toRemovePropertyChangeListenerWithProperty()
				members += dto.toFirePropertyChange()
			}
			members += dto.toCheckDisposed()
			members += dto.toDispose()
			for (f : dto.getFeatures) {
				switch f {
					LAttribute: {
						members += f.toGetter()
						if (!f.derived) {
							if (f.isToMany) {
								members += f.toInternalCollectionGetter(f.toName)
								members += f.toAdder(f.toName)
								members += f.toRemover(f.toName)
								members += f.toSetter()
							} else {
								members += f.toSetter()
							}
						}
					}
					LReference: {
						members += f.toGetter()
						if (f.isToMany) {
							members += f.toInternalCollectionGetter(f.toName)
							members += f.toAdder(f.toName)
							members += f.toRemover(f.toName)
							members += f.toInternalAdder
							members += f.toInternalRemover
							members += f.toSetter()
						} else {
							members += f.toSetter()

							if (f.isCascading || f.opposite != null) {
								members += f.toInternalSetter
							}
						}
					}
				}
			}
			//
			// Methods.
			// 
			for (op : dto.getOperations) {
				members += op.toMethod(op.toName, op.getType) [
					documentation = op.getDocumentation
					for (p : op.getParams) {
						parameters += p.toParameter(p.name, p.parameterType)
					}
					body = op.getBody
				]
			}
			if (idAttribute != null) {
				members += idAttribute.toEqualsMethod(it, false, idField)
				members += idAttribute.toHashCodeMethod(false, idField)
			}
			val JvmParameterizedTypeReference typeRef = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference
			typeRef.type = it
			val contextTypeRef = newTypeRef(typeof(MappingContext).name, null)
			if (!dto.abstract) {
				members += dto.toMethod("createDto", typeRef) [
					body = '''return new «dto.name»();'''
				]

				members += dto.toMethod("copy", typeRef.cloneWithProxies) [
					parameters += dto.toParameter("context", contextTypeRef.cloneWithProxies)
					body = '''
						checkDisposed();
						
						if (context == null) {
							throw new IllegalArgumentException("Context must not be null!");
						}
						
						if(context.isMaxLevel()){
							return null;
						}
						
						// if context contains a copied instance of this object
						// then return it
						«dto.name» newDto = context.get(this);
						if(newDto != null){
							return newDto;
						}
						
						try{
							context.increaseLevel();
							
							newDto = createDto();
							context.register(this, newDto);
							
							// first copy the containments and attributes
							copyContainments(this, newDto, context);
							
							// then copy cross references to ensure proper
							// opposite references are copied too.
							copyCrossReferences(this, newDto, context);
						} finally {
							context.decreaseLevel();
						}
						
						return newDto;
					'''
				]
			} else {
				members += dto.toMethod("copy", typeRef.cloneWithProxies) [
					abstract = true
					parameters += dto.toParameter("context", contextTypeRef.cloneWithProxies)
				]
			}
			members += dto.toMethod("copyContainments", references.getTypeForName(Void::TYPE, dto)) [
				parameters += dto.toParameter("dto", typeRef.cloneWithProxies)
				parameters += dto.toParameter("newDto", typeRef.cloneWithProxies)
				parameters += dto.toParameter("context", contextTypeRef.cloneWithProxies)
				body = '''
					checkDisposed();
					
					if (context == null) {
						throw new IllegalArgumentException("Context must not be null!");
					}
					
					«IF dto.superType != null»
						super.copyContainments(dto, newDto, context);
					«ENDIF»
					
					// copy attributes and beans (beans if derived from entity model)
					«FOR att : dto.attributesToCopy»
						«IF att.internalIsToMany»
							«IF att.toRawType instanceof LBean»
								// copy list of «att.toName» dtos
								for(«att.toRawType.toDTOBeanFullyQualifiedName» _dto : «att.toGetterName»()) {
									newDto.«att.toCollectionAdderName»(_dto.copy(context));
								}
							«ELSE»
								// copy list of «att.toName»
								for(«att.toRawType.toName» _att : «att.toGetterName»()) {
									newDto.«att.toCollectionAdderName»(_att);
								}
							«ENDIF»
						«ELSE»
							«IF att.toRawType instanceof LBean»
								// copy dto «att.toName»
								if(«att.toGetterName»() != null) {
									newDto.«att.toSetterName»(«att.toGetterName»().copy(context));
								}
							«ELSE»
								// copy «att.toName»
								newDto.«att.toSetterName»(«att.toGetterName»());
							«ENDIF»
						«ENDIF»
					«ENDFOR»
					
					// copy containment references (cascading is true)
					«FOR ref : dto.containmentReferencesToCopy»
						«IF ref.internalIsToMany»
							// copy list of «ref.toName» dtos
							for(«ref.toRawType.toDTOBeanFullyQualifiedName» _dto : «ref.toGetterName»()) {
								newDto.«ref.toCollectionAdderName»(_dto.copy(context));
							}
						«ELSE»
							// copy dto «ref.toName»
							if(«ref.toGetterName»() != null) {
								newDto.«ref.toSetterName»(«ref.toGetterName»().copy(context));
							}
						«ENDIF»
					«ENDFOR»
				'''
			]
			members += dto.toMethod("copyCrossReferences", references.getTypeForName(Void::TYPE, dto)) [
				parameters += dto.toParameter("dto", typeRef.cloneWithProxies)
				parameters += dto.toParameter("newDto", typeRef.cloneWithProxies)
				parameters += dto.toParameter("context", newTypeRef(typeof(MappingContext).name, null))
				body = '''
					checkDisposed();
					
					if (context == null) {
						throw new IllegalArgumentException("Context must not be null!");
					}
					
					«IF dto.superType != null»
						super.copyCrossReferences(dto, newDto, context);
					«ENDIF»
					
					// copy cross references (cascading is false)
					«FOR ref : dto.crossReferencesToCopy»
						«IF ref.internalIsToMany»
							// copy list of «ref.toName» dtos
							for(«ref.toRawType.toDTOBeanFullyQualifiedName» _dto : «ref.toGetterName»()) {
								newDto.«ref.toCollectionAdderName»(_dto.copy(context));
							}
						«ELSE»
							// copy dto «ref.toName»
							if(«ref.toGetterName»() != null) {
								newDto.«ref.toSetterName»(«ref.toGetterName»().copy(context));
							}
						«ENDIF»
					«ENDFOR»
				'''
			]
			members += dto.toMethod("propertyChange", references.getTypeForName(Void::TYPE, dto)) [
				parameters += dto.toParameter("event", newTypeRef(typeof(PropertyChangeEvent).name, null))
				body = '''
					Object source = event.getSource();
					
					// forward the event from embeddable beans to all listeners. So the parent of the embeddable
					// bean will become notified and its dirty state can be handled properly
					«FOR ref : dto.features.filter[it.toRawType.isBean]»
						if(source == «ref.toName»){
							firePropertyChange("«ref.toName»" + "_" + event.getPropertyName(), event.getOldValue(), event.getNewValue());
						} else 
					«ENDFOR»
					{ 
						«IF dto.superType != null»
						super.propertyChange(event);
						«ELSE»
						// no super class available to forward event
						«ENDIF»
					}
				'''
			]
			doInferLog.stop(log, "Inferring dto " + dto.name)
		]
	}

	def void inferMapperFullState(JvmGenericType type, LDto dto, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase) {

		acceptor.accept(type).initializeLater [
			val TimeLogger doInferLog = TimeLogger.start(getClass());
			type.markAsDerived
			fileHeader = (dto.eContainer as LTypedPackage).documentation
			documentation = '''
				This class maps the dto {@link «dto.toName»} to and from the entity {@link «dto.wrappedType.toName»}.
			'''
			//
			// Constructor
			//
			members += dto.toConstructor()[]
			if (dto.wrappedType != null) {
				val dtoParam = TypesFactory.eINSTANCE.createJvmTypeParameter
				dtoParam.name = "DTO"
				val dtoUpper = TypesFactory.eINSTANCE.createJvmUpperBound

				dtoUpper.typeReference = dto.findDtoTypeReference
				dtoParam.constraints += dtoUpper
				typeParameters += dtoParam

				val entityParam = TypesFactory.eINSTANCE.createJvmTypeParameter
				entityParam.name = "ENTITY"
				val entityUpper = TypesFactory.eINSTANCE.createJvmUpperBound
				entityUpper.typeReference = dto.wrappedTypeJvm?.cloneWithProxies
				entityParam.constraints += entityUpper
				typeParameters += entityParam

				val entityType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference;
				entityType.type = entityParam

				val dtoType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference;
				dtoType.type = dtoParam
				if (dto.getSuperType != null) {
					if (dto.getSuperType != null) {
						superTypes += dto.findSuperDtoMapperType(dtoType, entityType)
					}
				} else {
					superTypes += references.getTypeForName(typeof(IMapper), dto, dtoType, entityType)
					members += dto.toField("mapperAccess", references.getTypeForName(typeof(IMapperAccess), dto, null))
					members += dto.toGetToDtoMapperAccess
					members += dto.toGetToEntityMapperAccess

					members += dto.toMapperBindMethod
					members += dto.toMapperUnbindMethod
				}

				members += dto.toMethod("createEntity", dto.wrappedTypeJvm) [
					documentation = '''Creates a new instance of the entity'''
					body = '''
						«IF dto.wrappedType.abstract»throw new UnsupportedOperationException("Subclass needs to provide dto.");«ELSE»return new «dto.
							wrappedType.toName»();«ENDIF»
					'''
				]

				members += dto.toMethod("createDto", dto.findDtoTypeReference) [
					documentation = '''Creates a new instance of the dto'''
					body = '''
						«IF dto.abstract»throw new UnsupportedOperationException("Subclass needs to provide dto.");«ELSE»return new «dto.
							toName»();«ENDIF»
					'''
				]

				members += dto.toMapToDto
				members += dto.toMapToEntity

				for (f : dto.getFeatures) {
					switch f {
						case f instanceof LDtoAbstractAttribute: {
							val LDtoAbstractAttribute att = f as LDtoAbstractAttribute
							if (att.inherited || att.mapper?.toDTO != null) {
								members += att.toMapToDtoProperty
							}
							if (att.inherited || att.mapper?.fromDTO != null) {
								members += att.toMapToEntityProperty
							}
						}
						case f instanceof LDtoAbstractReference: {
							val LDtoAbstractReference att = f as LDtoAbstractReference
							if (att.inherited || att.mapper?.toDTO != null) {
								members += att.toMapToDtoProperty
							}

							if (att.inherited || att.mapper?.fromDTO != null)
								members += att.toMapToEntityProperty
						}
					}
				}

				val idAtt = dto.findIdProperty
				members += dto.toMethod("createDtoHash", references.getTypeForName(typeof(String), dto, null)) [
					parameters += dto.toParameter("in", references.getTypeForName(typeof(Object), dto, null))
					if (idAtt != null) {
						body = '''
							return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(«dto.toName».class, in);
						'''
					} else {
						body = '''
							throw new UnsupportedOperationException("No id attribute available");
						'''
					}
				]

				members += dto.toMethod("createEntityHash", references.getTypeForName(typeof(String), dto, null)) [
					parameters += dto.toParameter("in", references.getTypeForName(typeof(Object), dto, null))
					if (idAtt != null) {
						body = '''
							return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(«dto.wrappedType.toName».class, in);
						'''
					} else {
						body = '''
							throw new UnsupportedOperationException("No id attribute available");
						'''
					}
				]

			}
			doInferLog.stop(log, "Inferring mapper " + dto.name)
		]
	}

	def LAttribute findIdProperty(LDto dto) {
		for (att : dto.allFeatures.filter(typeof(LAttribute)).map[it as LAttribute]) {
			if (att.isIDorUUID) {
				return att
			}
		}
		return null
	}

	// used for test cases with old derived state computer
	def dispatch void infer(LEnum enumX, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		// create dto type
		val type = enumX.toEnumerationType(enumX.fullyQualifiedName.toString, null)
		type.inferFullState(enumX, acceptor, isPrelinkingPhase, "")
	}

	def dispatch void inferTypesOnly(LEnum enumX, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		// create dto type
		val type = enumX.toEnumerationType(enumX.fullyQualifiedName.toString, null)
		type.markAsToBeDerivedLater(enumX, isPrelinkingPhase)
		acceptor.accept(type);

		// pass inferring to delegates
		inferTypesOnlyByDelegates(enumX, acceptor, isPrelinkingPhase);
	}

	def dispatch void inferFullState(JvmDeclaredType type, LEnum enumX, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase, String selector) {

		acceptor.accept(type).initializeLater [
			type.markAsDerived
			val TimeLogger doInferLog = TimeLogger.start(getClass());
			fileHeader = (enumX.eContainer as LTypedPackage).documentation
			documentation = enumX.documentation
			for (f : enumX.literals) {
				documentation = f.documentation
				members += f.toEnumerationLiteral(f.name)
			}
			doInferLog.stop(log, "Inferring enum " + enumX.name)
		]
	}
}
