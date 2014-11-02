package org.lunifera.dsl.xtext.cache.resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.serialization.SerializationUtil;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.lunifera.dsl.xtext.cache.impl.ICache;
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

	public CachingResource() {
		super();
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		if (shouldAttemptCacheLoad(options)) {
			setEncodingFromOptions(options);

			/*
			 * Copy is necessary since we need the input multiple times (for
			 * digest)
			 */
			byte[] content = SerializationUtil.getCompleteContent(inputStream);

			XtextResource cachedResource = doCacheLoad(content, getEncoding(),
					shouldLoadNodeModel(options));
			if (cachedResource == null) {
				doLoadAndAddToCache(content, getEncoding(), options);
			} else {
				LOGGER.info("Resource found in cache: " + getURI());
			}
			fullyInitialized = true;
		} else {
			super.doLoad(inputStream, options);
		}

		if (options != null
				&& Boolean.TRUE.equals(options.get(OPTION_RESOLVE_ALL)))
			EcoreUtil.resolveAll(this);
	}

	protected void doUpdateCacheLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		setEncodingFromOptions(options);

		IParseResult oldParseResult = getParseResult();
		unload();
		
		/*
		 * Copy is necessary since we need the input multiple times (for digest)
		 */
		byte[] content = SerializationUtil.getCompleteContent(inputStream);

		XtextResource cachedResource = doCacheLoad(content, getEncoding(),
				shouldLoadNodeModel(options));
		if (cachedResource == null) {
			doLoadAndAddToCache(content, getEncoding(), options);
			fullyInitialized = true;
		} else {
			fullyInitialized = true;
			IParseResult newParseResult = getParseResult();
			doUpdateInternalState(oldParseResult, newParseResult);

			LOGGER.info("Resource found in cache: " + getURI());
		}

		if (options != null
				&& Boolean.TRUE.equals(options.get(OPTION_RESOLVE_ALL)))
			EcoreUtil.resolveAll(this);
	}

	@SuppressWarnings("sync-override")
	public EList<EObject> getContentsWithDerivedState() {
		synchronized (getLock()) {
			if (isLoaded && !isInitializing) {
				try {
					discardDerivedState();
					eSetDeliver(false);
					installDerivedState(false);
				} finally {
					eSetDeliver(true);
				}
			}
			return doGetContents();
		}
	}

	/**
	 * @since 2.3
	 */
	protected void doLoadAndAddToCache(byte[] content, String encoding,
			Map<?, ?> options) throws IOException {
		super.doLoad(new ByteArrayInputStream(content), options);
		try {
			cache.add(this, content, encoding);
		} catch (Throwable ee) {
			LOGGER.error("Could not add resource to cache for uri: " + uri, ee);
			try {
				cache.clear();
			} catch (Throwable eee) {
				/* We've done what we could. Ignoring. */
				LOGGER.error("Failed to clear resource cache", eee);
			}
		}
	}

	/**
	 * @since 2.3
	 */
	protected XtextResource doCacheLoad(byte[] content, String encoding,
			boolean loadNodeModel) throws IOException {
		XtextResource resource = null;
		try {
			IParseResult oldParseResult = getParseResult();
			resource = cache.load(this, content, encoding, loadNodeModel);
			IParseResult newParseResult = getParseResult();

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

			if (resource != null && loadNodeModel) {
				reattachModificationTracker(getParseResult()
						.getRootASTElement());
				addSyntaxErrors();
			}
		} catch (WrappedException e) {
			if (resource != null) {
				resource.getContents().clear();
				resource.eAdapters().clear();
				resource = null;
			}
		}

		return resource;
	}

	/**
	 * @param oldParseResult
	 *            the previous parse result that should be detached if
	 *            necessary.
	 * @param newParseResult
	 *            the current parse result that should be attached to the
	 *            content of this resource
	 * @since 2.1
	 */
	protected void doUpdateInternalState(IParseResult oldParseResult,
			IParseResult newParseResult) {
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
		updateInternalState(newParseResult);
	}

	public void update(int offset, int replacedTextLength, String newText) {
		if (!isLoaded()) {
			throw new IllegalStateException(
					"You can't update an unloaded resource.");
		}
		try {
			isUpdating = true;
			ReplaceRegion replaceRegion = new ReplaceRegion(new TextRegion(
					offset, replacedTextLength), newText);
			String newContent = insertChangeIntoReplaceRegion(getParseResult()
					.getRootNode(), replaceRegion);
			try {
				unload();
				doLoad(new ByteArrayInputStream(newContent.getBytes()),
						getResourceSet().getLoadOptions());
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
		
//		if(1==1){
//			return false;
//		}
		
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
