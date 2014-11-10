package org.lunifera.dsl.xtext.cache.resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.serialization.SerializationUtil;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.lunifera.dsl.semantic.common.types.LScalarType;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.xtext.cache.impl.ICache;
import org.lunifera.dsl.xtext.cache.impl.ICacheEntry;
import org.lunifera.dsl.xtext.cache.stackaware.StackAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class CachingResource extends BatchLinkableResource {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CachingResource.class);
	private static final ImmutableSet<String> GOOD_KEYS = ImmutableSet.of(
			ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE, OPTION_ENCODING,
			ICache.OMIT_NODE_MODEL);

	@Inject
	private ICache cache;

	@Inject
	private IResourceDescriptions descriptions;

	@Inject(optional = true)
	private IDerivedStateComputer derivedStateComputer;
	private ICacheEntry cacheEntry;
	private boolean installingDerivedState;
	private boolean inferringStackVeto;

	public CachingResource() {
		super();
	}

	public void setDerivedStateComputer(IDerivedStateComputer lateInitialization) {
		super.setDerivedStateComputer(lateInitialization);
		this.derivedStateComputer = lateInitialization;
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		if (shouldAttemptCacheLoad(options)) {
			setEncodingFromOptions(options);

			IParseResult oldParseResult = getParseResult();
			/*
			 * Copy is necessary since we need the input multiple times (for
			 * digest)
			 */
			byte[] content = SerializationUtil.getCompleteContent(inputStream);

			cacheEntry = doCacheLoad(content, getEncoding(),
					shouldLoadNodeModel(options));
			if (cacheEntry == null) {
				doLoadAndAddToCache(content, getEncoding(), options);
				if (contents.size() == 0) {
					System.out.println("hmmm");
				}
			} else {
				LOGGER.info("Resource found in cache: " + getURI());
			}

			// if (cacheEntry != null) {
			// updateInternalState(oldParseResult, getParseResult());
			// }
		} else {
			super.doLoad(inputStream, options);
		}

		if (options != null
				&& Boolean.TRUE.equals(options.get(OPTION_RESOLVE_ALL)))
			EcoreUtil.resolveAll(this);
	}

	public void installDerivedState(boolean preIndexingPhase) {
		if (!isLoaded)
			throw new IllegalStateException(
					"The resource must be loaded, before installDerivedState can be called.");
		if (!fullyInitialized && !isInitializing) {

			boolean isBuilderWork = getResourceSet().getLoadOptions()
					.containsKey(
							ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE);

			if (isBuilderWork) {
				StackAdapter stackAdapter = StackAdapter
						.getOrInit(getResourceSet());
				boolean skipInferringFully = !preIndexingPhase
						&& stackAdapter.isMaxReached(getURI());

				if (inferringStackVeto && skipInferringFully) {
					// already initialized preindexing state
					return;
				}
				if (inferringStackVeto) {
					inferringStackVeto = false;
					discardDerivedState();
				}

				if (preIndexingPhase || skipInferringFully) {
					try {
						isInitializing = true;
						if (derivedStateComputer != null){
							// only install preindexing state
							derivedStateComputer
									.installDerivedState(this, true);
						}

						if (skipInferringFully) {
							System.out.println("----- Skipped inferrer for "
									+ getURI());
							fullyInitialized = false;
							inferringStackVeto = true;
						} else {
							fullyInitialized = true;
						}
					} finally {
						isInitializing = false;
						getCache().clear(this);
					}
				} else {
					installingDerivedState = true;
					isInitializing = true;
					try {
						stackAdapter.push(getURI());
						doGetDerivedState(true);
					} finally {
						stackAdapter.pop();
						installingDerivedState = false;
						isInitializing = false;
						getCache().clear(this);
						fullyInitialized = true;
					}
				}
			} else {
				isInitializing = true;
				try {
					doGetDerivedState(false);
				} finally {
					isInitializing = false;
					getCache().clear(this);
					fullyInitialized = true;
				}
			}
		}
	}

	@SuppressWarnings("sync-override")
	@Override
	public EList<EObject> getContents() {
		synchronized (getLock()) {
			if (isLoaded && !isLoading && !isInitializing && !isUpdating
					&& !fullyInitialized && !installingDerivedState) {
				try {
					eSetDeliver(false);
					installDerivedState(false);
				} finally {
					eSetDeliver(true);
				}
			}
			return doGetContents();
		}
	}

	public void installDerivedStateDirectly() {
		try {
			isInitializing = true;
			if (derivedStateComputer != null)
				derivedStateComputer.installDerivedState(this, false);
			fullyInitialized = true;
		} finally {
			isInitializing = false;
			getCache().clear(this);
		}
	}

	// protected void doUpdateCacheLoad(InputStream inputStream, Map<?, ?>
	// options)
	// throws IOException {
	// setEncodingFromOptions(options);
	//
	// IParseResult oldParseResult = getParseResult();
	// unload();
	//
	// /*
	// * Copy is necessary since we need the input multiple times (for digest)
	// */
	// byte[] content = SerializationUtil.getCompleteContent(inputStream);
	//
	// if (content.length == 0) {
	// System.out.println("ojeeeee");
	// }
	//
	// ICacheEntry cacheEntry = doCacheLoad(content, getEncoding(),
	// shouldLoadNodeModel(options));
	// if (cacheEntry == null) {
	// doLoadAndAddToCache(content, getEncoding(), options);
	// } else {
	// // IParseResult newParseResult = getParseResult();
	// // doUpdateInternalState(oldParseResult, newParseResult);
	//
	// LOGGER.info("Resource found in cache: " + getURI());
	// }
	//
	// if (cacheEntry != null) {
	// updateInternalState(oldParseResult, getParseResult());
	// }
	//
	// if (options != null
	// && Boolean.TRUE.equals(options.get(OPTION_RESOLVE_ALL)))
	// EcoreUtil.resolveAll(this);
	// }

	@Override
	public EObject getEObject(String uriFragment) {
		if (uriFragment.startsWith("typeslink")) {
			String typeFQN = normalizeTypeName(uriFragment.replace(
					"typeslink:", ""));
			for (EObject content : getContents()) {
				if (content instanceof JvmType) {
					JvmType type = (JvmType) content;
					if (type.getQualifiedName().equals(typeFQN)) {
						return type;
					}
				}
			}
			return null;
		} else if (uriFragment.startsWith("luniferareflink")) {
			String typeFQN = normalizeTypeName(uriFragment.replace(
					"luniferareflink:", ""));
			for (EObject content : IteratorExtensions.toIterable(getContents()
					.get(0).eAllContents())) {
				if (content instanceof LEntity) {
					LEntity type = (LEntity) content;
					if (type.getName().equals(typeFQN)) {
						return type;
					}
				}
			}
			return null;
		} else if (uriFragment.startsWith("luniferaattlink")) {
			String typeFQN = normalizeTypeName(uriFragment.replace(
					"luniferaattlink:", ""));
			for (EObject content : IteratorExtensions.toIterable(getContents()
					.get(0).eAllContents())) {
				if (content instanceof LScalarType) {
					LScalarType type = (LScalarType) content;
					if (type.getName().equals(typeFQN)) {
						return type;
					}
				}
			}
			return null;
		} else if (uriFragment.startsWith("unresolvedtypeslink")) {
			String typeFQN = normalizeTypeName(uriFragment.replace(
					"unresolvedtypeslink:", ""));

			// first try this resource
			for (EObject content : getContents()) {
				if (content instanceof JvmType) {
					JvmType type = (JvmType) content;
					if (type.getQualifiedName().equals(typeFQN)) {
						return type;
					}
				}
			}

			// then try all resources available in resourceSet
			for (Resource resource : resourceSet.getResources()) {
				if (resource instanceof TypeResource || resource == this) {
					continue;
				}
				for (EObject content : resource.getContents()) {
					if (content instanceof JvmType) {
						JvmType type = (JvmType) content;
						if (type.getQualifiedName().equals(typeFQN)) {
							return type;
						}
					}
				}
			}

			Iterable<IEObjectDescription> temp = descriptions
					.getExportedObjects(TypesPackage.Literals.JVM_TYPE,
							QualifiedName.create(typeFQN.split("\\.")), true);
			if (temp.iterator().hasNext()) {
				IEObjectDescription desc = temp.iterator().next();
				return resourceSet.getEObject(desc.getEObjectURI(), true);
			}

			return null;
		} else {
			try {
				return super.getEObject(uriFragment);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private String normalizeTypeName(String uriFragment) {
		if (uriFragment.contains("<")) {
			uriFragment = uriFragment.substring(0, uriFragment.indexOf("<"));
		}
		return uriFragment;
	}

	/**
	 * @since 2.3
	 */
	protected void doLoadAndAddToCache(byte[] content, String encoding,
			Map<?, ?> options) throws IOException {
		super.doLoad(new ByteArrayInputStream(content), options);
		try {
			cacheEntry = cache.add(this, content, encoding);
		} catch (Throwable ee) {
			LOGGER.error("Could not add resource to cache for uri: " + uri, ee);
			try {
				// cache.clear();
			} catch (Throwable eee) {
				/* We've done what we could. Ignoring. */
				LOGGER.error("Failed to clear resource cache", eee);
			}
		}
	}

	/**
	 * @since 2.3
	 */
	protected void doGetDerivedState(boolean add) {
		try {
			if (cacheEntry != null) {
				cache.loadDS(this, cacheEntry, "", true);
				if (add && contents.size() <= 1) {
					cache.addDerivedState(this, cacheEntry);
				}
			}

			if (contents == null || contents.size() == 0) {
				System.out.println("hmmm");
			}

			fullyInitialized = true;
		} catch (Throwable ee) {

			LOGGER.error("Could not add resource to cache for uri: " + uri, ee);
			try {
				// cache.clear();
			} catch (Throwable eee) {
				/* We've done what we could. Ignoring. */
				LOGGER.error("Failed to clear resource cache", eee);
			}
		}
	}

	/**
	 * @since 2.3
	 */
	protected ICacheEntry doCacheLoad(byte[] content, String encoding,
			boolean loadNodeModel) throws IOException {
		ICacheEntry cacheEntry = null;
		try {
			IParseResult oldParseResult = getParseResult();
			cacheEntry = cache.load(this, content, encoding, loadNodeModel);
			IParseResult newParseResult = getParseResult();
			if (contents.size() == 0) {
				System.out.println("hmmm");
			}
			clearErrorsAndWarnings();

			if (oldParseResult != null
					&& oldParseResult.getRootASTElement() != null
					&& oldParseResult.getRootASTElement() != newParseResult
							.getRootASTElement()) {
				EObject oldRootAstElement = oldParseResult.getRootASTElement();
				if (oldRootAstElement != newParseResult.getRootASTElement()) {
					unload(oldRootAstElement);
					getContents().remove(oldRootAstElement);
				}
			}

			if (cacheEntry != null && loadNodeModel) {
				reattachModificationTracker(getParseResult()
						.getRootASTElement());
				addSyntaxErrors();
			}
		} catch (WrappedException e) {
			LOGGER.error("{}", e);
		}

		return cacheEntry;
	}

	// /**
	// * @param oldParseResult
	// * the previous parse result that should be detached if
	// * necessary.
	// * @param newParseResult
	// * the current parse result that should be attached to the
	// * content of this resource
	// * @since 2.1
	// */
	// protected void doUpdateInternalState(IParseResult oldParseResult,
	// IParseResult newParseResult) {
	// if (oldParseResult != null
	// && oldParseResult.getRootASTElement() != null
	// && oldParseResult.getRootASTElement() != newParseResult
	// .getRootASTElement()) {
	// EObject oldRootAstElement = oldParseResult.getRootASTElement();
	// if (oldRootAstElement != newParseResult.getRootASTElement()) {
	// unload(oldRootAstElement);
	// getContents().remove(oldRootAstElement);
	// }
	// }
	// updateInternalState(newParseResult);
	// }

	public void update(int offset, int replacedTextLength, String newText) {
		if (!isLoaded()) {
			throw new IllegalStateException(
					"You can't update an unloaded resource.");
		}
		try {
			isUpdating = true;
			IParseResult oldParseResult = getParseResult();
			ReplaceRegion replaceRegion = new ReplaceRegion(new TextRegion(
					offset, replacedTextLength), newText);
			String newContent = insertChangeIntoReplaceRegion(getParseResult()
					.getRootNode(), replaceRegion);
			if (newContent == null || newContent.equals("")) {
				System.out.println("nix gut");
			}
			try {
				doLoad(new ByteArrayInputStream(newContent.getBytes()),
						getResourceSet().getLoadOptions());
				// updateInternalState(oldParseResult, getParseResult());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			isUpdating = false;
		}
	}

	private String insertChangeIntoReplaceRegion(ICompositeNode rootNode,
			ReplaceRegion region) {
		final StringBuilder builder = new StringBuilder(rootNode.getText());
		region.shiftBy(0 - rootNode.getTotalOffset()).applyTo(builder);
		return builder.toString();
	}

	/**
	 * @since 2.3
	 */
	protected boolean shouldAttemptCacheLoad(Map<?, ?> options) {

		// if (1 == 1) {
		// return false;
		// }

		boolean resourceIsFine = getContents().isEmpty() && resourceSet != null
				&& uri != null;
		boolean noCacheVeto = options == null
				|| options.get(ICache.DO_NOT_CONSULT_CACHE) == null
				|| Boolean.FALSE.equals(options
						.get(ICache.DO_NOT_CONSULT_CACHE));
		// boolean noSpecialOptions = options == null
		// || Sets.difference(options.keySet(), GOOD_KEYS).isEmpty();
		return resourceIsFine && noCacheVeto;
	}

	/**
	 * @since 2.3
	 */
	protected boolean shouldLoadNodeModel(Map<?, ?> options) {
		boolean loadNodeModel = options == null
				|| options.get(ICache.OMIT_NODE_MODEL) == null
				|| Boolean.FALSE.equals(options.get(ICache.OMIT_NODE_MODEL));
		return loadNodeModel;
	}

}
