package org.lunifera.dsl.entity.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.lunifera.dsl.semantic.entity.LEntityModel
import org.lunifera.dsl.semantic.common.types.LImport

class DtosFileGenerator {

	@Inject extension IQualifiedNameProvider

	def getContent(LEntityModel model) '''
		package «model.toPackageName» {
		
			«FOR LImport lImport : model.packages.get(0).imports»
			import «lImport.importedNamespace»;
			«ENDFOR»
		}
	'''
	
	def String toPackageName(LEntityModel model){
		if(model.packages.size > 0) model.packages.get(0).name + ".dtos" else "xxyy.dtos"
	}
	
}
