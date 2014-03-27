package org.lunifera.dsl.dto.xtext.jvmmodel

import com.google.inject.Inject
import java.io.Serializable
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.common.xtext.jvmmodel.CommonGrammarJvmModelInferrer
import org.lunifera.dsl.dto.lib.IMapper
import org.lunifera.dsl.dto.lib.IMapperAccess
import org.lunifera.dsl.dto.xtext.extensions.DtoTypesBuilder
import org.lunifera.dsl.dto.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LEnum
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
import org.lunifera.dsl.semantic.dto.LDtoAbstractReference

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class DtoGrammarJvmModelInferrer extends CommonGrammarJvmModelInferrer {

	@Inject extension IQualifiedNameProvider
	@Inject extension DtoTypesBuilder;
	@Inject extension ModelExtensions;
	@Inject TypeReferences references

	def dispatch void infer(LDto dto, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
		acceptor.accept(dto.toJvmType).initializeLater [
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

		if (dto.wrappedType == null) {
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

				if (dto.getSuperType != null) {
					superTypes +=
						references.getTypeForName(dto.getSuperType.toMapperJvmType.qualifiedName.toString, dto, null)
				} else {
					superTypes += references.getTypeForName(typeof(IMapper), dto, dto.toTypeReference,
						dto.wrappedType.toTypeReference)
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
