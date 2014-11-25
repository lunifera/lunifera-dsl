package org.lunifera.dsl.xtext.lazyresolver.api;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public interface ISemanticLoadingResource {

	public abstract EObject getSemanticElement(String fragment);

	public abstract void registerJvmTypeAssociation(URI semanticURI,
			URI jvmTypeURI);

	public abstract void clearJvmTypeAssociation();

	public abstract URI getJvmTypeURI(URI semanticURI);

}