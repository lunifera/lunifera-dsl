package org.lunifera.dsl.entity.xtext.jvmmodel

import com.google.inject.Inject
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.common.xtext.jvmmodel.CommonGrammarJvmModelInferrer
import org.lunifera.dsl.entity.xtext.extensions.EntityTypesBuilder
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LEnum
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LBeanReference
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityReference

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

	/**
     * Returns true if the resource of the specified object has syntax errors.
     * This method allows an eary abort of inferring that would cause NPEs because of not loaded 
     * Ecore proxy instances.
     * Inspired by DefaultFoldingStructureProvider.modelChanged().
     */
	def hasSyntaxErrors(EObject o) {
		val hasSyntaxErrors = o.eResource.errors.exists[it instanceof XtextSyntaxDiagnostic]
		if (hasSyntaxErrors) {
			log.warn("Abort inferring due to syntax errors: " + o)
		}
		return hasSyntaxErrors
	}

	def dispatch void infer(LEnum enumX, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
		if(hasSyntaxErrors(enumX)) return;

		acceptor.accept(enumX.toEnumerationType(enumX.fullyQualifiedName.toString, null)).initializeLater [
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
			documentation = bean.getDocumentation
			if (bean.getSuperType != null && !bean.getSuperType.fullyQualifiedName.toString.empty) {
				superTypes += references.getTypeForName(bean.getSuperType.fullyQualifiedName.toString, bean, null)
			}
			// 
			// Constructor
			//
			members += bean.toConstructor()[]
			if (bean.getSuperType == null) {
				members += bean.toPrimitiveTypeField("disposed", Boolean::TYPE)
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
			documentation = entity.documentation
			if (entity.getSuperType != null && !entity.getSuperType.fullyQualifiedName.toString.empty) {
				superTypes += references.getTypeForName(entity.getSuperType.fullyQualifiedName.toString, entity, null)
			}
			//
			// Constructor
			//
			members += entity.toConstructor()[]
			if (entity.getSuperType == null) {
				members += entity.toPrimitiveTypeField("disposed", Boolean::TYPE)
			}
			//
			// Fields
			//
			for (f : entity.features) {
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
