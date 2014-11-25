package org.lunifera.dsl.xtext.lazyresolver;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.lunifera.dsl.xtext.lazyresolver.api.ISemanticLoadingResource;

@SuppressWarnings("restriction")
public class SemanticLoadingResource extends BatchLinkableResource implements ISemanticLoadingResource {

	private boolean suppressDerivedState;

	/* (non-Javadoc)
	 * @see org.lunifera.dsl.xtext.lazyresolver.ISemanticLoadingResource#getSemanticElement(java.lang.String)
	 */
	@Override
	public EObject getSemanticElement(String fragment) {
		try {
			suppressDerivedState = true;
			return super.getEObject(fragment);
		} finally {
			suppressDerivedState = false;
		}
	}

	public void installDerivedState(boolean preIndexingPhase) {
		if (preIndexingPhase || !suppressDerivedState) {
			super.installDerivedState(preIndexingPhase);
		}
	}

	Map<URI, URI> uris = new HashMap<URI, URI>();

	public EObject getEObject(String uriFragment) {
		// if (uriFragment.startsWith("luniferaJvm")) {
		// String newUriFragment = uriFragment.replace("luniferaJvm", "");
		// Triple<EObject, EReference, INode> triple = getEncoder().decode(
		// this, newUriFragment);
		//
		// try {
		// if (triple.getFirst() instanceof LEntity) {
		// Triple<EObject, EReference, INode> fakeTriple = Tuples
		// .create((EObject) ((LEntity) triple.getFirst())
		// .getSuperTypeJvm(),
		// TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE,
		// triple.getThird());
		// return super.getEObject(newUriFragment, fakeTriple);
		// } else if (triple.getFirst() instanceof LEntityReference) {
		// Triple<EObject, EReference, INode> fakeTriple = Tuples
		// .create(triple.getFirst(),
		// TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE,
		// triple.getThird());
		// return super.getEObject(newUriFragment, fakeTriple);
		// } else {
		// return super.getEObject(newUriFragment);
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// return null;
		// }
		// } else {
		return super.getEObject(uriFragment);
		// }
	}

	/* (non-Javadoc)
	 * @see org.lunifera.dsl.xtext.lazyresolver.ISemanticLoadingResource#registerJvmTypeAssociation(org.eclipse.emf.common.util.URI, org.eclipse.emf.common.util.URI)
	 */
	@Override
	public void registerJvmTypeAssociation(URI semanticURI, URI jvmTypeURI) {
		uris.put(semanticURI, jvmTypeURI);
	}

	/* (non-Javadoc)
	 * @see org.lunifera.dsl.xtext.lazyresolver.ISemanticLoadingResource#clearJvmTypeAssociation()
	 */
	@Override
	public void clearJvmTypeAssociation() {
		uris.clear();
	}

	/* (non-Javadoc)
	 * @see org.lunifera.dsl.xtext.lazyresolver.ISemanticLoadingResource#getJvmTypeURI(org.eclipse.emf.common.util.URI)
	 */
	@Override
	public URI getJvmTypeURI(URI semanticURI) {
		return uris.get(semanticURI);
	}
}
