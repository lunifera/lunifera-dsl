package org.lunifera.dsl.dto.xtext.jvmmodel

import com.google.inject.Inject
import java.io.Serializable
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.common.xtext.jvmmodel.CommonGrammarJvmModelInferrer
import org.lunifera.dsl.dto.xtext.extensions.DtoTypesBuilder
import org.lunifera.dsl.dto.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.entity.LBeanReference

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
		if(hasSyntaxErrors(dto)) return;

		acceptor.accept(dto.toJvmType).initializeLater [
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
					case f instanceof LAttribute: {
						members += f.toGetter()
						if (f.isToMany) {
							members += f.toInternalCollectionGetter(f.toName)
							members += f.toAdder(f.toName)
							members += f.toRemover(f.toName)
						} else {
							members += f.toSetter()
						}
					}
					case f instanceof LReference: {
						members += f.toGetter()
						if (f.isToMany) {
							members += f.toInternalCollectionGetter(f.toName)
							members += f.toAdder(f.toName)
							members += f.toRemover(f.toName)
							members += f.toInternalAdder
							members += f.toInternalRemover
						} else {
							members += f.toSetter()

							if (!f.shouldUseCrossReference && f.opposite != null) {
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

	}
}
