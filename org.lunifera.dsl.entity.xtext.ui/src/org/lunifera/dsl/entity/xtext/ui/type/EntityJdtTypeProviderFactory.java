package org.lunifera.dsl.entity.xtext.ui.type;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.xtext.common.types.access.jdt.IJdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IWorkingCopyOwnerProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.access.jdt.NullJdtTypeProvider;

import com.google.inject.Inject;

public class EntityJdtTypeProviderFactory extends JdtTypeProviderFactory {

	@Inject
	private IWorkingCopyOwnerProvider copyOwnerProvider;

	protected IJdtTypeProvider createJdtTypeProvider(IJavaProject javaProject,
			ResourceSet resourceSet) {
		if (javaProject == null)
			// TODO throw a serious exception instead of returning a non working
			// implementation
			return new NullJdtTypeProvider(resourceSet);
		return new EntityJdtTypeProvider(javaProject, resourceSet,
				getIndexedJvmTypeAccess(),
				copyOwnerProvider == null ? DefaultWorkingCopyOwner.PRIMARY
						: copyOwnerProvider.getWorkingCopyOwner(javaProject,
								resourceSet));
	}

}
