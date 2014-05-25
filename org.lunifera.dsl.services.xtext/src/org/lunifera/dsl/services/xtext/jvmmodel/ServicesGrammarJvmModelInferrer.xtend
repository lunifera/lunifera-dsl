package org.lunifera.dsl.services.xtext.jvmmodel

import com.google.inject.Inject
import java.util.Set
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.service.LDTOService
import org.lunifera.dsl.service.lib.IDTOService
import org.lunifera.dsl.services.xtext.extensions.ModelExtensions
import org.lunifera.dsl.services.xtext.extensions.ServicesTypesBuilder

import static org.lunifera.dsl.semantic.service.LCardinality.*

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class ServicesGrammarJvmModelInferrer extends AbstractModelInferrer {

	/**
     * convenience API to build and initialize JVM types and their members.
     */
	@Inject extension IQualifiedNameProvider
	@Inject extension ServicesTypesBuilder
	@Inject extension ModelExtensions
	@Inject TypeReferences references

	def dispatch void infer(LDTOService service, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
		acceptor.accept(service.toJvmType).initializeLater [
			fileHeader = (service.eContainer as LTypedPackage).documentation
			documentation = service.getDocumentation
			//			if (service.getSuperType != null && !service.getSuperType.fullyQualifiedName.toString.empty) {
			//				superTypes += references.getTypeForName(service.getSuperType.fullyQualifiedName.toString, service, null)
			//			}
			superTypes += references.getTypeForName(typeof(IDTOService), service, service.dto.toTypeReference)
			// 
			// Constructor
			//
			members += service.toConstructor()[]
			//			if (service.getSuperType == null) {
			//				members += service.toPropertyChangeSupportField()
			//				members += service.toPrimitiveTypeField("disposed", Boolean::TYPE)
			//			}
			//
			// Fields
			//
			//			for (f : service.getFeatures) {
			//				switch f {
			//					LAttribute: {
			//						if (!f.derived && f.fullyQualifiedName != null && !f.fullyQualifiedName.toString.empty) {
			//							members += f.toField
			//						}
			//					}
			//					LReference: {
			//						if (f.fullyQualifiedName != null && !f.fullyQualifiedName.toString.empty) {
			//							members += f.toField
			//						}
			//					}
			//				}
			//			}
			//
			// Field accessors
			//
			//			if (service.getSuperType == null) {
			//				members += service.toIsDisposed()
			//				members += service.toAddPropertyChangeListener()
			//				members += service.toAddPropertyChangeListenerWithProperty()
			//				members += service.toRemovePropertyChangeListener()
			//				members += service.toRemovePropertyChangeListenerWithProperty()
			//				members += service.toFirePropertyChange()
			//			}
			//			members += service.toCheckDisposed()
			//			members += service.toDispose()
			// to fields
			if (service.injectedServices != null) {
				for (f : service.injectedServices.services) {
					switch (f.cardinality) {
						case ZERO_TO_ONE:
							members += f.toField(f.attributeName, f.service.cloneWithProxies)
						case ZERO_TO_MANY:
							members += f.toField(f.attributeName,
								references.getTypeForName(typeof(Set), service, f.service.cloneWithProxies)) [
								initializer = '''new java.util.HashSet<«f.service.simpleName»>()'''
							]
						case ONE_TO_ONE:
							members += f.toField(f.attributeName, f.service.cloneWithProxies)
						case ONE_TO_MANY:
							members += f.toField(f.attributeName,
								references.getTypeForName(typeof(Set), service, f.service.cloneWithProxies)) [
								initializer = '''new java.util.HashSet<«f.service.simpleName»>()'''
							]
					}
				}
			}
			//
			// to methods
			members += service.toGetMethod
			members += service.toFindMethod
			members += service.toFindMethodWithStartindex
			members += service.toUpdateMethod
			members += service.toDeleteMethod
			for (f : service.operations) {
				members += f.toMethod(f.toName, f.getType) [
					documentation = f.getDocumentation
					for (p : f.getParams) {
						parameters += p.toParameter(p.name, p.parameterType)
					}
					body = f.getBody
				]

			//					LReference: {
			//						members += f.toGetter()
			//						if (f.isToMany) {
			//							members += f.toInternalCollectionGetter(f.toName)
			//							members += f.toAdder(f.toName)
			//							members += f.toRemover(f.toName)
			//							members += f.toInternalAdder
			//							members += f.toInternalRemover
			//						} else {
			//							members += f.toSetter()
			//
			//							if (f.isCascading || f.opposite != null) {
			//								members += f.toInternalSetter
			//							}
			//						}
			//					}
			}
			if (service.injectedServices != null) {
				for (f : service.injectedServices.services) {
					switch (f.cardinality) {
						case ZERO_TO_ONE: {
							members += f.toBindService(f.attributeName, f.service.cloneWithProxies)
							members += f.toUnbindService(f.attributeName, f.service.cloneWithProxies)
						}
						case ONE_TO_ONE: {
							members += f.toBindService(f.attributeName, f.service.cloneWithProxies)
							members += f.toUnbindService(f.attributeName, f.service.cloneWithProxies)
						}
						case ZERO_TO_MANY: {
							members += f.toAddService(f.attributeName, f.service.cloneWithProxies)
							members += f.toRemoveService(f.attributeName, f.service.cloneWithProxies)
						}
						case ONE_TO_MANY: {
							members += f.toAddService(f.attributeName, f.service.cloneWithProxies)
							members += f.toRemoveService(f.attributeName, f.service.cloneWithProxies)
						}
					}
				}
			}
		//
		// Methods.
		// 
		//			for (op : service.getOperations) {
		//			}
		]

	//		service.inferMapper(acceptor, isPrelinkingPhase)
	}
}
