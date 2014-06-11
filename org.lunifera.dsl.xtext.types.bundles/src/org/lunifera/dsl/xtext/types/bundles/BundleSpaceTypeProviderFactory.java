package org.lunifera.dsl.xtext.types.bundles;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;
import org.eclipse.xtext.common.types.access.reflect.ReflectionTypeProvider;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class BundleSpaceTypeProviderFactory extends AbstractTypeProviderFactory {

	@Inject
	private BundleSpaceResourceSetProvider bundleSpaceProvider;

	public BundleSpaceTypeProviderFactory() {
	}

	public BundleSpaceTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		BundleSpaceTypeProvider result = createClasspathTypeProvider(resourceSet);
		return result;
	}

	protected BundleSpaceTypeProvider createClasspathTypeProvider(
			ResourceSet resourceSet) {
		return new BundleSpaceTypeProvider(bundleSpaceProvider.getBundleSpace(resourceSet), resourceSet,
				getIndexedJvmTypeAccess());
	}

	@Override
	public ReflectionTypeProvider createTypeProvider() {
		return (ReflectionTypeProvider) super.createTypeProvider();
	}

	@Override
	public ReflectionTypeProvider findTypeProvider(ResourceSet resourceSet) {
		return (ReflectionTypeProvider) super.findTypeProvider(resourceSet);
	}

}
