package org.lunifera.dsl.example.entity.xtext.delegates

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.entity.xtext.extensions.EntityTypesBuilder
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.xtext.lazyresolver.IndexDerivedStateHelper
import org.lunifera.dsl.xtext.lazyresolver.api.hook.IInferrerDelegate

@SuppressWarnings("restriction")
class JvmInferrerDelegate implements IInferrerDelegate {

	@Inject ModelExtensions modelExt
	@Inject extension EntityTypesBuilder typesBuilder
	@Inject extension TypeReferences references

	@Inject
	IndexDerivedStateHelper stateHelper;

	override void inferTypesOnly(EObject semanticElement, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		if (semanticElement instanceof LEntity) {
			val LEntity lEntity = semanticElement as LEntity;

			// create a generic type
			val JvmGenericType type = typesBuilder.toClass(lEntity,
				"org.lunifera.samples.inferred.delegate." + lEntity.getName());
			stateHelper.markAsToBeDerivedLater(type, semanticElement, false, "luniferaSample");
			acceptor.accept(type);
		}
	}

	override void inferFullState(JvmDeclaredType jvmType, EObject semanticElement, IJvmDeclaredTypeAcceptor acceptor,
		boolean preIndexingPhase, String selector) {

		if (selector != null && selector.equals("luniferaSample")) {
			acceptor.accept(jvmType).initializeLater [
				stateHelper.markAsDerived(jvmType)
				abstract = true
				members +=
					semanticElement.toField("sample", references.getTypeForName(Integer.TYPE, semanticElement, null))
			]
		}
	}
}
