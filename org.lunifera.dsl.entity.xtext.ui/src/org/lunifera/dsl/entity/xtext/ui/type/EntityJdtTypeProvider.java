package org.lunifera.dsl.entity.xtext.ui.type;

import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess.ShadowedTypeException;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeMirror;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider;
import org.eclipse.xtext.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityJdtTypeProvider extends JdtTypeProvider {

	private static final String PRIMITIVES = URIHelperConstants.PRIMITIVES_URI
			.segment(0);
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EntityJdtTypeProvider.class);

	public EntityJdtTypeProvider(IJavaProject javaProject,
			ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess,
			WorkingCopyOwner workingCopyOwner) {
		super(javaProject, resourceSet, indexedJvmTypeAccess, workingCopyOwner);
	}

	public EntityJdtTypeProvider(IJavaProject javaProject,
			ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		super(javaProject, resourceSet, indexedJvmTypeAccess);
	}

	public EntityJdtTypeProvider(IJavaProject javaProject,
			ResourceSet resourceSet) {
		super(javaProject, resourceSet);
	}

	@Override
	public JvmType findTypeByName(String name) {
		String signature = getSignature(name);
		if (signature == null)
			return null;
		URI resourceURI = getTypeUriHelper().createResourceURI(signature);
		if (resourceURI.segment(0) == PRIMITIVES) {
			return findPrimitiveType(signature, resourceURI);
		} else {
			return findObjectType(signature, resourceURI);
		}
	}

	/* @Nullable */
	private String getSignature(String name) {
		if (Strings.isEmpty(name))
			throw new IllegalArgumentException("null");
		String signature = null;
		try {
			signature = name.startsWith("[") ? name : Signature
					.createTypeSignature(name, true);
		} catch (IllegalArgumentException e) {
			return null;
		}
		return signature;
	}

	private JvmType findPrimitiveType(/* @NonNull */String signature, /* @NonNull */
			URI resourceURI) {
		TypeResource resource = (TypeResource) getResourceForJavaURI(
				resourceURI, true);
		JvmType result = findTypeBySignature(signature, resource);
		return result;
	}

	/* @Nullable */
	private JvmType findObjectType(/* @NonNull */String signature, /* @NonNull */
			URI resourceURI) {
		TypeResource resource = getLoadedResourceForJavaURI(resourceURI);
		try {
			JvmType result = findLoadedOrDerivedObjectType(signature,
					resourceURI, resource);
			if (result != null || resource != null) {
				if (result != null && !canLink(result.getQualifiedName())) {
					return null;
				}
				return result;
			}
			try {
				return findObjectTypeInJavaProject(signature, resourceURI);
			} catch (JavaModelException e) {
				return null;
			} catch (NullPointerException e) { // JDT throws NPEs see
												// https://bugs.eclipse.org/bugs/show_bug.cgi?id=369391
				return null;
			}
		} catch (ShadowedTypeException e) {
			return null;
		}
	}

	/* @Nullable */
	private TypeResource getLoadedResourceForJavaURI(
	/* @NonNull */URI resourceURI) {
		TypeResource resource = (TypeResource) getResourceForJavaURI(
				resourceURI, false);
		return resource;
	}

	/* @Nullable */
	private JvmType findLoadedOrDerivedObjectType(/* @NonNull */String signature, /*
																				 * @
																				 * NonNull
																				 */
			URI resourceURI,
			/* @Nullable */TypeResource resource) {
		JvmType result = resource != null ? findTypeBySignature(signature,
				resource) : null;
		if (result != null) {
			return result;
		}
		result = findObjectTypeInIndex(signature, resourceURI);
		if (result != null) {
			return result;
		}
		return null;
	}

	/* @Nullable */
	private JvmType findObjectTypeInJavaProject(/* @NonNull */String signature, /*
																				 * @
																				 * NonNull
																				 */
			URI resourceURI) throws JavaModelException {
		IType type = findObjectTypeInJavaProject(resourceURI);
		if (type != null) {
			try {
				return createResourceAndFindType(resourceURI, type, signature);
			} catch (IOException ioe) {
				return null;
			} catch (WrappedException wrapped) {
				if (wrapped.getCause() instanceof IOException) {
					return null;
				}
				throw wrapped;
			}
		}
		return null;
	}

	private IType findObjectTypeInJavaProject(/* @NonNull */URI resourceURI)
			throws JavaModelException {
		String topLevelType = resourceURI
				.segment(resourceURI.segmentCount() - 1);
		int lastDot = topLevelType.lastIndexOf('.');
		String packageName = null;
		String typeName = topLevelType;
		if (lastDot != -1) {
			typeName = typeName.substring(lastDot + 1);
			packageName = topLevelType.substring(0, lastDot);
		}
		IType type = getJavaProject().findType(packageName, typeName /*
																	 * ,
																	 * workingCopyOwner
																	 */);
		if (type != null && !canLink(type.getFullyQualifiedName())) {
			return null;
		}
		return type;
	}

	private boolean canLink(String typeName) {
		if (typeName == null) {
			return false;
		}
		IndexedJvmTypeAccess indexedJvmTypeAccess = this
				.getIndexedJvmTypeAccess();
		if (indexedJvmTypeAccess != null
				&& indexedJvmTypeAccess.isIndexingPhase(getResourceSet())) {
			// during indexing we don't see project local types.
			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=410594
			try {
				IType type = getJavaProject().findType(typeName);
				if (type != null && type.exists()) {
					String enabled = System.getProperty(
							"lunifera.linker.constraint", "true");
					if (Boolean.valueOf(enabled)) {
						IResource underlyingResource = type
								.getUnderlyingResource();
						if (underlyingResource == null) {
							return true;
						}
						for (IPackageFragmentRoot root : getJavaProject()
								.getPackageFragmentRoots()) {
							if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
								IResource srcUnderlyingResource = root
										.getUnderlyingResource();
								if (srcUnderlyingResource != null
										&& srcUnderlyingResource
												.contains(underlyingResource)) {
									return false;
								}
							}
						}
					}
					return true;
				}
			} catch (JavaModelException e) {
				LOGGER.error(e.getMessage(), e);
			}
			return false;
		}
		return true;
	}

	/* @Nullable */
	private JvmType createResourceAndFindType(/* @NonNull */URI resourceURI, /*
																			 * @
																			 * NonNull
																			 */
			IType type, /* @NonNull */String signature) throws IOException {
		TypeResource resource = createResource(resourceURI, type);
		resource.load(null);
		return findTypeBySignature(signature, resource);
	}

	private TypeResource createResource(URI resourceURI, IType type) {
		TypeResource resource = new TypeResource(resourceURI);
		resource.setIndexedJvmTypeAccess(getIndexedJvmTypeAccess());
		getResourceSet().getResources().add(resource);
		if (type.exists()) {
			IMirror mirror = createMirror(type);
			resource.setMirror(mirror);
		}
		return resource;
	}

	/* @Nullable */
	private IMirror createMirror(/* @NonNull */IType type) {
		String elementName = type.getElementName();
		if (!elementName.equals(type.getTypeQualifiedName())) {
			// workaround for bug in jdt with binary type names that start with
			// a $ dollar sign
			// e.g. $ImmutableList
			// it manifests itself in a way that allows to retrieve ITypes but
			// one cannot obtain bindings for that type
			return null;
		}
		return new JdtTypeMirror(type, getJdtBasedTypeFactory());
	}

	private JvmType findObjectTypeInIndex(/* @NonNull */String signature, /*
																		 * @NonNull
																		 */
			URI resourceURI) {
		IndexedJvmTypeAccess indexedJvmTypeAccess = getIndexedJvmTypeAccess();
		if (indexedJvmTypeAccess != null) {
			URI proxyURI = resourceURI.appendFragment(getTypeUriHelper()
					.getFragment(signature));
			EObject candidate = indexedJvmTypeAccess.getIndexedJvmType(
					proxyURI, getResourceSet(), true);
			if (candidate instanceof JvmType) {
				return (JvmType) candidate;
			}
		}
		return null;
	}
}
