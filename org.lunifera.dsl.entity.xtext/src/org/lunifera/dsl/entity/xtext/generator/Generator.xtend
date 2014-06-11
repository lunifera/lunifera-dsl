package org.lunifera.dsl.entity.xtext.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.lunifera.dsl.semantic.entity.LEntityModel
import org.lunifera.dsl.semantic.common.types.LTypedPackage

class Generator extends JvmModelGenerator {

	@Inject extension DtosFileGenerator

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)

		for (tmp : input.allContents.filter[it instanceof LTypedPackage].toList) {
			val LTypedPackage pkg = tmp as LTypedPackage
			fsa.deleteFile(pkg.toDtosFileName);
			fsa.generateFile(pkg.toDtosFileName, "DTOs", pkg.content);
		}
	}

	def toDtosFileName(LTypedPackage pkg) {
//		if(pkg.size > 0) pkg.name + ".dtos" else "xxyy.dtos"
		pkg.name + ".dtos"
	}

}
