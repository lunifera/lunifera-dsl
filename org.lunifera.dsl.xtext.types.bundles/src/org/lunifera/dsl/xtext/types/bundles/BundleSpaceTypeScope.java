package org.lunifera.dsl.xtext.types.bundles;

import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

public class BundleSpaceTypeScope extends AbstractTypeScope {

	public BundleSpaceTypeScope(BundleSpaceTypeProvider typeProvider,
			IQualifiedNameConverter qualifiedNameConverter,
			Predicate<IEObjectDescription> filter) {
		super(typeProvider, qualifiedNameConverter, filter);
	}

}
