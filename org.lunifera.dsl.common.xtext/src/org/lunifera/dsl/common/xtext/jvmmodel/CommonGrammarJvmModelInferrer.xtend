package org.lunifera.dsl.common.xtext.jvmmodel

import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class CommonGrammarJvmModelInferrer extends AbstractModelInferrer {
	
	protected val Logger log = Logger::getLogger(getClass())
	
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
}
