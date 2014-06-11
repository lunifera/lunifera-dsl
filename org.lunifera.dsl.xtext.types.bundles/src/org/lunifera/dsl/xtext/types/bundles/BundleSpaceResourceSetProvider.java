package org.lunifera.dsl.xtext.types.bundles;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

public class BundleSpaceResourceSetProvider {

	public BundleSpace getBundleSpace(ResourceSet resourceSet) {
		if (resourceSet instanceof XtextResourceSet) {
			XtextResourceSet xtextResourceSet = (XtextResourceSet) resourceSet;
			Object context = xtextResourceSet.getClasspathURIContext();
			if (context instanceof BundleSpace)
				return (BundleSpace) context;
		}
		return null;
	}

}
