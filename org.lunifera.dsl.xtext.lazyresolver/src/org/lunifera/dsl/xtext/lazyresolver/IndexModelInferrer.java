package org.lunifera.dsl.xtext.lazyresolver;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.lunifera.dsl.xtext.lazyresolver.api.DerivedRootAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

public class IndexModelInferrer extends AbstractModelInferrer {

	protected Logger log = LoggerFactory.getLogger(IndexModelInferrer.class);

	private @Inject JvmAnnotationReferenceBuilder.Factory annotationRefBuilderFactory;
	private @Inject JvmTypeReferenceBuilder.Factory typeRefBuilderFactory;

	protected @Extension JvmAnnotationReferenceBuilder _annotationTypesBuilder;
	protected @Extension JvmTypeReferenceBuilder _typeReferenceBuilder;

	/**
	 * @noreference This method is called by the framework
	 * @nooverride
	 */
	void setContext(Resource resource) {
		_annotationTypesBuilder = annotationRefBuilderFactory.create(resource
				.getResourceSet());
		_typeReferenceBuilder = typeRefBuilderFactory.create(resource
				.getResourceSet());
	}

	public void infer(EObject e,
			final/* @NonNull */IJvmDeclaredTypeAcceptor acceptor,
			boolean preIndexingPhase) {
		_infer(e, acceptor, preIndexingPhase);
	}

	public void _infer(EObject e, /* @NonNull */
			IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		for (EObject child : e.eContents()) {
			infer(child, acceptor, preIndexingPhase);
		}
	}

	public void inferForLater(JvmType type, EObject e, /* @NonNull */
			IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase, String selector) {
	}

	protected void markAsToBeDerivedLater(JvmDeclaredType type,
			EObject context, boolean isPrelinkingPhase) {
		markAsToBeDerivedLater(type, context, isPrelinkingPhase, "");
	}

	protected void markAsToBeDerivedLater(JvmDeclaredType type,
			EObject context, boolean isPrelinkingPhase, String selector) {
		if (!isPrelinkingPhase) {

			// if(hasSyntaxErrors(entity)) return;
			// register the semantic element using an adapter
			DerivedRootAdapter adapter = new DerivedRootAdapter(context,
					selector);
			type.eAdapters().add(adapter);
		}
	}

	protected void markAsDerived(JvmDeclaredType type) {
		DerivedRootAdapter adapter = (DerivedRootAdapter) EcoreUtil.getAdapter(
				type.eAdapters(), DerivedRootAdapter.class);
		if (adapter != null) {
			type.eAdapters().remove(adapter);
		}
	}

	protected boolean hasSyntaxErrors(EObject o) {
		if (!o.eResource().getErrors().isEmpty()) {
			log.warn("Abort inferring due to syntax errors: " + o);
			return true;
		}
		return false;
	}
}
