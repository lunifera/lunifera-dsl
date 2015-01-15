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
import org.lunifera.dsl.dto.lib.Context
import org.lunifera.dsl.dto.lib.IMapper
import org.lunifera.dsl.dto.lib.IMapperAccess
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

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class DtoGrammarJvmModelInferrer extends IndexModelInferrer {

	@Inject AnnotationCompiler annotationCompiler

	@Inject extension IQualifiedNameProvider
	@Inject extension DtoTypesBuilder;
	@Inject extension MethodNamingExtensions
	@Inject extension DtoModelExtensions;
	@Inject TypeReferences references

	def dispatch void inferForLater(JvmType type, EObject element, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase, String selector) {
	}

	def dispatch void infer(LDto dto, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		if(dto.hasSyntaxErrors) return;

		// create dto type
		val type = dto.toJvmType;
		type.markAsToBeDerivedLater(dto, isPrelinkingPhase)
		acceptor.accept(type);

		// create mapper type
		if (dto.wrappedType != null) {
			val mapperType = dto.toMapperJvmType;
			mapperType.markAsToBeDerivedLater(dto, isPrelinkingPhase, "mapper")
			acceptor.accept(mapperType)
		}
	}

	def dispatch void inferForLater(JvmGenericType type, LDto dto, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase, String selector) {
		if (selector.equals("mapper")) {
			type.inferMapperForLater(dto, acceptor, isPrelinkingPhase)
		} else {
			type.inferDtoForLater(dto, acceptor, isPrelinkingPhase)
		}
	}

	def void inferDtoForLater(JvmDeclaredType type, LDto dto, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase) {

		if(dto.hasSyntaxErrors) return;

		acceptor.accept(type).initializeLater [
			type.markAsDerived
			println("inferring dto " + dto.name)
			annotationCompiler.processAnnotation(dto, it);
			var LAttribute idAttribute = null
			var JvmField idField = null
			fileHeader = (dto.eContainer as LTypedPackage).documentation
			documentation = dto.getDocumentation
			if (dto.getSuperType != null && !dto.getSuperType.fullyQualifiedName.toString.empty) {
				superTypes += references.getTypeForName(dto.getSuperType.fullyQualifiedName.toString, dto, null)
			}
			superTypes += references.getTypeForName(typeof(Serializable), dto, null)
			if (dto.getSuperType == null) {
				members += dto.toPropertyChangeSupportField()
				members += dto.toPrimitiveTypeField("disposed", Boolean::TYPE)
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
			val contextTypeRef = newTypeRef(typeof(Context).name, null)
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
						«dto.name» newDto = context.getTarget(this);
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
				parameters += dto.toParameter("context", newTypeRef(typeof(Context).name, null))
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
		]

	}

	def void inferMapperForLater(JvmGenericType type, LDto dto, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase) {

		if(hasSyntaxErrors(dto)) return;

		acceptor.accept(type).initializeLater [
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
				dtoUpper.typeReference = dto.toTypeReference
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
					if (dto.getSuperType.toMapperTypeReference.type != null) {
						superTypes += references.createTypeRef(dto.getSuperType.toMapperTypeReference.type, dtoType,
							entityType)
					}
				} else {
					superTypes += references.getTypeForName(typeof(IMapper), dto, dtoType, entityType)
					members += dto.toField("mapperAccess", references.getTypeForName(typeof(IMapperAccess), dto, null))
					members += dto.toGetMapperAccess

					members += dto.toMapperBindMethod
					members += dto.toMapperUnbindMethod
				}

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
			}
		]
	}

	def dispatch void infer(LEnum enumX, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		if(enumX.hasSyntaxErrors) return;

		// create dto type
		val type = enumX.toEnumerationType(enumX.fullyQualifiedName.toString, null)
		type.markAsToBeDerivedLater(enumX, isPrelinkingPhase)
		acceptor.accept(type);
	}

	def dispatch void inferForLater(JvmDeclaredType type, LEnum enumX, IJvmDeclaredTypeAcceptor acceptor,
		boolean isPrelinkingPhase, String selector) {
		if(hasSyntaxErrors(enumX)) return;

		acceptor.accept(type).initializeLater [
			fileHeader = (enumX.eContainer as LTypedPackage).documentation
			documentation = enumX.documentation
			for (f : enumX.literals) {
				documentation = f.documentation
				members += f.toEnumerationLiteral(f.name)
			}
		]
	}
}
