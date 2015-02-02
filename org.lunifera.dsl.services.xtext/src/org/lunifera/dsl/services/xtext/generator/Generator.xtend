package org.lunifera.dsl.services.xtext.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.lunifera.dsl.semantic.service.LService
import org.lunifera.dsl.services.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.xtext.lazyresolver.api.logger.TimeLogger
import org.lunifera.dsl.xtext.lazyresolver.generator.DelegatingGenerator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Generator extends DelegatingGenerator {
	
	static final Logger LOGGER = LoggerFactory.getLogger(typeof(Generator))

	@Inject extension MethodNamingExtensions
	@Inject extension ComponentGenerator
   	@Inject extension IQualifiedNameProvider
   	
   	override dispatch void internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		val log = TimeLogger.start(typeof(Generator));
		super._internalDoGenerate(type, fsa)
		log.stop(LOGGER, "generated " + type.qualifiedName)
	}
   
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)
		
		for (tmp : input.allContents.filter[it instanceof LService].toList) {
			val LService service = tmp as LService
			if(service.name != null) {
				val log = TimeLogger.start(typeof(Generator));
				fsa.deleteFile(service.toServiceComponentName);
				fsa.generateFile(service.toServiceComponentName, "OSGI-INF", service.getServiceContent);
				log.stop(LOGGER, "generated " + service.toServiceComponentName)
			}
		}
	}

	def toServiceComponentName(LService service) {
		service.fullyQualifiedName.toString + ".xml"
	}
}
