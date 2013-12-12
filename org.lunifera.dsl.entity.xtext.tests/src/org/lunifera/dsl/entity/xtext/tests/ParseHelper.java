package org.lunifera.dsl.entity.xtext.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class ParseHelper<T extends EObject> extends
		org.eclipse.xtext.junit4.util.ParseHelper<T> {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private IResourceFactory resourceFactory;

	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	public String fileExtension;

	@SuppressWarnings("unchecked")
	public T parse(InputStream[] ins, URI uriToUse, Map<?, ?> options,
			ResourceSet resourceSet) {
		Resource resource = resourceFactory.createResource(uriToUse);
		resourceSet.getResources().add(resource);
		try {
			for (InputStream in : ins) {
				resource.load(in, options);
			}

			final T root = (T) (resource.getContents().isEmpty() ? null
					: resource.getContents().get(0));
			return root;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public T parse(CharSequence... text) throws Exception {
		return parse(resourceSetProvider.get(), text);
	}

	public T parse(ResourceSet resourceSetToUse, CharSequence... texts)
			throws Exception {
		return parse(getAsStreams(texts), computeUnusedUri(resourceSetToUse),
				(Map<?, ?>) null, resourceSetToUse);
	}

	private InputStream[] getAsStreams(CharSequence[] texts) {
		List<InputStream> streams = new ArrayList<InputStream>();
		for (CharSequence seq : texts) {
			streams.add(new StringInputStream(seq == null ? "" : seq.toString()));
		}
		return streams.toArray(new InputStream[streams.size()]);
	}

}
