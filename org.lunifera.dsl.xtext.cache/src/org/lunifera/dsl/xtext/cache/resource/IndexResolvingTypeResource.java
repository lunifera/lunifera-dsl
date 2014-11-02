package org.lunifera.dsl.xtext.cache.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.naming.QualifiedName;

@SuppressWarnings("restriction")
public class IndexResolvingTypeResource extends TypeResource {

	public IndexResolvingTypeResource(URI uri) {
		super(uri);
	}

	@Override
	public EObject getEObject(String uriFragment) {
		if(uriFragment.contains("<")) {
			uriFragment = uriFragment.substring(0, uriFragment.indexOf("<"));
		}
		
		EObject result = super.getEObject(uriFragment);
		if (result == null) {
			QualifiedName fqn = QualifiedName.create(uriFragment.split("\\."));
			result = getIndexedJvmTypeAccess().getIndexedJvmType(fqn, uriFragment, resourceSet);
		}
		return result;
	}

}
