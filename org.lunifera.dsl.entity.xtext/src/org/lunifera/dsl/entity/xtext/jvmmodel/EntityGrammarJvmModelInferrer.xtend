package org.lunifera.dsl.entity.xtext.jvmmodel

import com.google.inject.Inject
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.entity.semantic.model.LBean
import org.lunifera.dsl.entity.semantic.model.LEntity
import org.lunifera.dsl.entity.semantic.model.LEnum
import org.lunifera.dsl.entity.xtext.jvmmodel.services.bean.BeanJvmModelInferrer
import org.lunifera.dsl.entity.xtext.jvmmodel.services.enums.EnumJvmModelInferrer
import org.lunifera.dsl.entity.xtext.jvmmodel.services.jpa.JPAEntityJvmModelInferrer

/**
 * This is the main model inferrer that is automatically registered in AbstractEntityRuntimeModule.
 * It dispatches to specific model inferrers depending on the metamodel element.
 */
class EntityGrammarJvmModelInferrer extends AbstractModelInferrer {

    protected val Logger log = Logger::getLogger(getClass())

    @Inject EnumJvmModelInferrer enumJvmModelInferrer;
    @Inject BeanJvmModelInferrer beanJvmModelInferrer;
    @Inject JPAEntityJvmModelInferrer entityJvmModelInferrer;

    /**
     * Returns true if the resource of the specified object has syntax errors.
     * This method allows an eary abort of inferring that would cause NPEs because of not loaded 
     * Ecore proxy instances.
     * Inspired by DefaultFoldingStructureProvider.modelChanged().
     */
    def hasSyntaxErrors(EObject o) {
        val hasSyntaxErrors = o.eResource.errors.exists [ it instanceof XtextSyntaxDiagnostic ]
        if (hasSyntaxErrors) {
            log.warn("Abort inferring due to syntax errors: " + o)
        }
        return hasSyntaxErrors
    }

    def dispatch void infer(LEnum element, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
        if (hasSyntaxErrors(element)) return;
        enumJvmModelInferrer.infer(element, acceptor, isPrelinkingPhase);
    } 

    def dispatch void infer(LBean element, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
        if (hasSyntaxErrors(element)) return;
        beanJvmModelInferrer.infer(element, acceptor, isPrelinkingPhase);
    }

    def dispatch void infer(LEntity element, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
        if (hasSyntaxErrors(element)) return;
        entityJvmModelInferrer.infer(element, acceptor, isPrelinkingPhase);
    }


	/**
	 * The dispatch method {@code infer} is called for each instance of the
	 * given element's type that is contained in a resource.
	 * 
	 * @param element
	 *            the model to create one or more
	 *            {@link org.eclipse.xtext.common.types.JvmDeclaredType declared
	 *            types} from.
	 * @param acceptor
	 *            each created
	 *            {@link org.eclipse.xtext.common.types.JvmDeclaredType type}
	 *            without a container should be passed to the acceptor in order
	 *            get attached to the current resource. The acceptor's
	 *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
	 *            accept(..)} method takes the constructed empty type for the
	 *            pre-indexing phase. This one is further initialized in the
	 *            indexing phase using the closure you pass to the returned
	 *            {@link org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
	 *            initializeLater(..)}.
	 * @param isPreIndexingPhase
	 *            whether the method is called in a pre-indexing phase, i.e.
	 *            when the global index is not yet fully updated. You must not
	 *            rely on linking using the index if isPreIndexingPhase is
	 *            <code>true</code>.
	 */
//   	def dispatch void infer(LEntityModel element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
//   		// Here you explain how your model is mapped to Java elements, by writing the actual translation code.
//   		
//   		// An implementation for the initial hello world example could look like this:
////   		acceptor.accept(element.toClass("my.company.greeting.MyGreetings"))
////   			.initializeLater([
////   				for (greeting : element.greetings) {
////   					members += greeting.toMethod("hello" + greeting.name, greeting.newTypeRef(typeof(String))) [
////   						body = [
////   							append('''return "Hello «greeting.name»";''')
////   						]
////   					]
////   				}
////   			])
//   	}
}

