package org.lunifera.dsl.common.xtext.scope;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider;

public class CommonBatchScopeProvider extends
		XbaseWithAnnotationsBatchScopeProvider {

	@Override
	public boolean isBatchScopeable(EReference reference) {
		return true;
	}

}
