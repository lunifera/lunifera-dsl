package org.lunifera.dsl.services.xtext.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.lunifera.dsl.semantic.service.LService
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.lunifera.dsl.services.xtext.extensions.MethodNamingExtensions

class Generator extends JvmModelGenerator {

	@Inject extension MethodNamingExtensions
	@Inject extension ComponentGenerator
   	@Inject extension IQualifiedNameProvider
   
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)
		
		for (tmp : input.allContents.filter[it instanceof LService].toList) {
			val LService service = tmp as LService
			if(service.name != null) {
				fsa.deleteFile(service.toServiceComponentName);
				fsa.generateFile(service.toServiceComponentName, "OSGI-INF", service.getServiceContent);
			}
		}
	}

	def toServiceComponentName(LService service) {
		service.fullyQualifiedName.toString + ".xml"
	}
}
