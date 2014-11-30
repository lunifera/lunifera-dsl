package org.lunifera.dsl.xtext.lazyresolver.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.lunifera.dsl.xtext.lazyresolver.api.ISemanticLoadingResource;

public class FastImportedNamespaceAwareLocalScopeProvider extends
		ImportedNamespaceAwareLocalScopeProvider {

	protected IScope getResourceScope(Resource res, EReference reference) {
		EObject context = null;
		if (res instanceof ISemanticLoadingResource) {
			context = ((ISemanticLoadingResource) res).getSemanticElement();
		} else {
			context = res.getContents().get(0);
		}
		IScope globalScope = getGlobalScope(res, reference);
		List<ImportNormalizer> normalizers = getImplicitImports(isIgnoreCase(reference));
		if (!normalizers.isEmpty()) {
			globalScope = createImportScope(globalScope, normalizers, null,
					reference.getEReferenceType(), isIgnoreCase(reference));
		}
		return getResourceScope(globalScope, context, reference);
	}

}
