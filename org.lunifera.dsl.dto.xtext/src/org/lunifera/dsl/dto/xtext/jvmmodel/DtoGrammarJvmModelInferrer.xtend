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
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.common.xtext.jvmmodel.CommonGrammarJvmModelInferrer
import org.lunifera.dsl.dto.lib.IMapper
import org.lunifera.dsl.dto.lib.IMapperAccess
import org.lunifera.dsl.dto.xtext.extensions.DtoModelExtensions
import org.lunifera.dsl.dto.xtext.extensions.DtoTypesBuilder
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LEnum
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
import org.lunifera.dsl.semantic.dto.LDtoAbstractReference
import org.lunifera.dsl.semantic.dto.impl.LDtoImpl

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class DtoGrammarJvmModelInferrer extends CommonGrammarJvmModelInferrer {

	@Inject extension IQualifiedNameProvider
	@Inject extension DtoTypesBuilder;
	@Inject extension DtoModelExtensions;
	@Inject TypeReferences references
	@Inject AnnotationCompiler annotationCompiler

	def dispatch void infer(LDto dto, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
		acceptor.accept(dto.toInitialJvmType).initializeLater [
			annotationCompiler.processAnnotation(dto, it)
			var LAttribute idAttribute = null
			var JvmField idField = null
			fileHeader = (dto.eContainer as LTypedPackage).documentation
			documentation = dto.getDocumentation
			if (dto.getSuperType != null && !dto.getSuperType.fullyQualifiedName.toString.empty) {
				superTypes += references.getTypeForName(dto.getSuperType.fullyQualifiedName.toString, dto, null)
			}
			superTypes += references.getTypeForName(typeof(Serializable), dto, null)
			// 
			// Constructor
			//
			members += dto.toConstructor()[]
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
		]

		/**
		 * Infers the DTO mapper
		 */
		dto.inferMapper(acceptor, isPrelinkingPhase)
	}

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

	def void inferMapper(LDto dto, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {

		if ((dto as LDtoImpl).basicGetWrappedType == null) {
			return;
		}

		acceptor.accept(dto.toMapperJvmType).initializeLater [
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
				entityUpper.typeReference = dto.wrappedType.toTypeReference
				entityParam.constraints += entityUpper
				typeParameters += entityParam

				val entityType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference;
				entityType.type = entityParam

				val dtoType = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference;
				dtoType.type = dtoParam
				if (dto.getSuperType != null) {
					superTypes += dto.getSuperType.toMapperTypeReference(dtoType, entityType)
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
}
