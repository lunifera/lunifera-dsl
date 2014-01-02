package org.lunifera.dsl.entity.xtext.scope;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider;
import org.lunifera.dsl.semantic.entity.EntityPackage;

public class EntityBatchScopeProvider extends
		XbaseWithAnnotationsBatchScopeProvider {

	@Override
	public boolean isBatchScopeable(EReference reference) {
		return reference == EntityPackage.Literals.LENTITY__SUPER_TYPE ? true
				: super.isBatchScopeable(reference);
	}

}
