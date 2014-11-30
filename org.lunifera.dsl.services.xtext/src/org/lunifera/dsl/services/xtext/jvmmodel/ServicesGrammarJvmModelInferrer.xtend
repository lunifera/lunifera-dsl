package org.lunifera.dsl.services.xtext.jvmmodel

import com.google.inject.Inject
import java.util.Set
import javax.persistence.EntityManagerFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.service.LCardinality
import org.lunifera.dsl.semantic.service.LDTOService
import org.lunifera.dsl.semantic.service.LInjectedService
import org.lunifera.dsl.semantic.service.LunServiceFactory
import org.lunifera.dsl.services.xtext.extensions.ModelExtensions
import org.lunifera.dsl.services.xtext.extensions.ServicesTypesBuilder

import static org.lunifera.dsl.semantic.service.LCardinality.*
import org.lunifera.dsl.common.xtext.extensions.NamingExtensions
import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOService

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
	@Inject extension NamingExtensions
	@Inject TypeReferences references
	@Inject
	private MethodNamingExtensions dtoNamings;

	def dispatch void infer(LDTOService service, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
		acceptor.accept(service.toJvmType).initializeLater [
			fileHeader = (service.eContainer as LTypedPackage).documentation
			documentation = service.getDocumentation
			if (service.dto.basedOnEntity) {
				superTypes += references.getTypeForName(typeof(AbstractDTOService), service, service.dto.toTypeReference,
					service.dto.wrappedEntity.toTypeReference)

				// Constructor
				members += service.toConstructor()[]

				members += service.toMethod("getDtoClass",
					references.getTypeForName(typeof(Class), service, service.dtoJvm.cloneWithProxies)) [
					body = '''return «service.dto.name».class;'''
				]

				members += service.toMethod("createDto", service.dtoJvm.cloneWithProxies) [
					body = '''return new «service.dto.name»();'''
				]

				members += service.toMethod("createEntity", service.dto.wrappedTypeJvm.cloneWithProxies) [
					body = '''return new «service.dto.wrappedEntity.name»();'''
				]

				members += service.toMethod("getEntityClass",
					references.getTypeForName(typeof(Class), service, service.dto.wrappedTypeJvm.cloneWithProxies)) [
					body = '''return «service.dto.wrappedEntity.name».class;'''
				]

				if (service.dto.idAttribute != null) {
					members += service.toMethod("getId", references.getTypeForName(typeof(Object), service, null)) [
						parameters += service.toParameter('dto', service.dto.toTypeReference)
						body = '''return dto.«service.dto.idAttribute?.toGetterName»();'''
					]
				}else{
					members += service.toMethod("getId", references.getTypeForName(typeof(Object), service, null)) [
						parameters += service.toParameter('dto', service.dtoJvm.cloneWithProxies)
						body = '''throw new UnsupportedOperationException("No id available for DTO.");'''
					]
				}
			} else {

				// Constructor
				members += service.toConstructor()[]

				// create the dto mapper service
				val LInjectedService mapperService = LunServiceFactory.eINSTANCE.createLInjectedService
				mapperService.attributeName = "mapper"
				mapperService.cardinality = LCardinality.ONE_TO_ONE
				mapperService.service = references.getTypeForName(dtoNamings.toFqnMapperName(service.dto), service, null)

				// create the emf service
				val LInjectedService emfService = LunServiceFactory.eINSTANCE.createLInjectedService
				emfService.attributeName = "emf"
				emfService.cardinality = LCardinality.ONE_TO_ONE
				emfService.service = references.getTypeForName(typeof(EntityManagerFactory), service, null)

				if (service.dto.basedOnEntity) {
					members +=
						mapperService.toField(mapperService.attributeName, mapperService.service.cloneWithProxies)
					members += emfService.toField(emfService.attributeName, emfService.service.cloneWithProxies)
				}

				if (service.injectedServices != null) {
					for (f : service.injectedServices.services) {
						switch (f.cardinality) {
							case ZERO_TO_ONE:
								members += f.toField(f.attributeName, f.service.cloneWithProxies)
							case ZERO_TO_MANY:
								members += f.toField(f.attributeName,
									references.getTypeForName(typeof(Set), service, f.service.cloneWithProxies))
							case ONE_TO_ONE:
								members += f.toField(f.attributeName, f.service.cloneWithProxies)
							case ONE_TO_MANY:
								members += f.toField(f.attributeName,
									references.getTypeForName(typeof(Set), service, f.service.cloneWithProxies))
							default:
								members += f.toField(f.attributeName, f.service.cloneWithProxies)
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
				}

				// mapper service
				members +=
					mapperService.toBindService(mapperService.attributeName, mapperService.service.cloneWithProxies)
				members += mapperService.toUnbindService(mapperService.attributeName,
					mapperService.service.cloneWithProxies)

				// entity manager factory
				members += emfService.toBindService(emfService.attributeName, emfService.service.cloneWithProxies)
				members += emfService.toUnbindService(emfService.attributeName, emfService.service.cloneWithProxies)

				// other services
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
