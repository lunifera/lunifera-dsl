package org.lunifera.dsl.example.entity.xtext.delegates

import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.OutputConfiguration
import org.lunifera.dsl.xtext.lazyresolver.api.hook.IGeneratorDelegate

@SuppressWarnings("restriction")
class SampleGeneratorDelegate implements IGeneratorDelegate {

	override generate(Resource input, IFileSystemAccess fsa) {
		fsa.deleteFile("ResourceInfo")
		fsa.generateFile("ResourceInfo", "LuniferaSample", input.toContent)
	}

	override getOutputConfigurations() {
		val Set<OutputConfiguration> configs = newHashSet();

		val OutputConfiguration servicesOutput = new OutputConfiguration("LuniferaSample")
		servicesOutput.setDescription("Lunifera Sample")
		servicesOutput.setOutputDirectory("./LuniferaSample")
		servicesOutput.setOverrideExistingResources(true)
		servicesOutput.setCreateOutputDirectory(true)
		servicesOutput.setCleanUpDerivedResources(true)
		servicesOutput.setSetDerivedProperty(true)
		servicesOutput.setKeepLocalHistory(true)
		configs.add(servicesOutput)

		return configs
	}

	def toContent(Resource input) '''
		The resources «input.URI» contains «input.contents.size» entries..
	'''

}
