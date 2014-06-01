package org.lunifera.dsl.entity.xtext.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.lunifera.dsl.semantic.entity.LEntityModel

class Generator extends JvmModelGenerator {

	@Inject extension DtosFileGenerator

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)

		for (tmp : input.allContents.filter[it instanceof LEntityModel].toList) {
			val LEntityModel model = tmp as LEntityModel
			fsa.deleteFile(model.toDtosFileName);
			fsa.generateFile(model.toDtosFileName, "DTOs", model.content);
		}
	}

	def toDtosFileName(LEntityModel model) {
		if(model.packages.size > 0) model.packages.get(0).name + ".dtos" else "xxyy.dtos"
	}

}
