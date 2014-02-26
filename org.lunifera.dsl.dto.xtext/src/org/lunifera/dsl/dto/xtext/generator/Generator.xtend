package org.lunifera.dsl.dto.xtext.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.semantic.dto.LDto
import org.eclipse.xtext.generator.AbstractFileSystemAccess
import org.eclipse.xtext.generator.OutputConfiguration

class Generator extends JvmModelGenerator {

	@Inject extension MethodNamingExtensions
	@Inject extension ComponentGenerator
   
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)
		
		for (tmp : input.allContents.filter[if(it instanceof LDto) wrappedType != null else false].toList) {
			val LDto dto = tmp as LDto
			fsa.deleteFile(dto.toServiceComponentName);
			fsa.generateFile(dto.toServiceComponentName, "OSGI-INF", dto.serviceContent);
		}
	}

	def toServiceComponentName(LDto dto) {
		dto.toFqnMapperName + ".xml"
	}

}
