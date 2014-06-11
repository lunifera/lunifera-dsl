package org.lunifera.dsl.xtext.types.bundles;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractConstructorScope;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class BundleSpaceTypeScopeProvider extends AbstractTypeScopeProvider {

	@Inject
	private BundleSpaceTypeProviderFactory typeProviderFactory;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	public BundleSpaceTypeScopeProvider() {

	}

	@Override
	public BundleSpaceTypeScope createTypeScope(IJvmTypeProvider typeProvider,
			Predicate<IEObjectDescription> filter) {
		return new BundleSpaceTypeScope((BundleSpaceTypeProvider) typeProvider,
				qualifiedNameConverter, filter);
	}

	@Override
	public AbstractConstructorScope createConstructorScope(
			IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter) {
		BundleSpaceTypeScope typeScope = createTypeScope(typeProvider, filter);
		return new BundleSpaceConstructorScope(typeScope);
	}

	public void setTypeProviderFactory(
			BundleSpaceTypeProviderFactory typeProviderFactory) {
		this.typeProviderFactory = typeProviderFactory;
	}

	@Override
	public BundleSpaceTypeProviderFactory getTypeProviderFactory() {
		return typeProviderFactory;
	}

}
