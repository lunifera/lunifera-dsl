package org.lunifera.dsl.xtext.cache.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;

@SuppressWarnings("restriction")
public class IndexResolvingTypeResourceFactory implements Resource.Factory {

	private final IJavaProject javaProject;
	private final WorkingCopyOwner workingCopyOwner;
	private final IndexedJvmTypeAccess indexedJvmTypeAccess;
	private final ResourceSet resourceSet;

	public IndexResolvingTypeResourceFactory(IJavaProject javaProject,
			ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess,
			WorkingCopyOwner workingCopyOwner) {
		if (javaProject == null)
			throw new IllegalArgumentException("javaProject may not be null");
		this.javaProject = javaProject;
		this.resourceSet = resourceSet;
		this.indexedJvmTypeAccess = indexedJvmTypeAccess;
		this.workingCopyOwner = workingCopyOwner;

		registerProtocol(resourceSet);
	}

	private void registerProtocol(ResourceSet resourceSet) {
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(IndexResolvingURIConstants.PROTOCOL, this);
	}

	@Override
	public Resource createResource(URI uri) {
		IndexResolvingTypeResource resource = new IndexResolvingTypeResource(uri);
		resource.setIndexedJvmTypeAccess(indexedJvmTypeAccess);
		return resource;
	}

	/**
	 * @return the javaProject
	 */
	public IJavaProject getJavaProject() {
		return javaProject;
	}

	/**
	 * @return the workingCopyOwner
	 */
	public WorkingCopyOwner getWorkingCopyOwner() {
		return workingCopyOwner;
	}

	/**
	 * @return the indexedJvmTypeAccess
	 */
	public IndexedJvmTypeAccess getIndexedJvmTypeAccess() {
		return indexedJvmTypeAccess;
	}

	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

}
