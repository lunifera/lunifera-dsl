package org.lunifera.dsl.xtext.lazyresolver.scoping;

import java.util.Collections;
import java.util.Map;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

public class CachingTypeScope extends AbstractScope {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CachingTypeScope.class);

	private final Map<QualifiedName, IEObjectDescription> cache;
	private String cacheId;

	public CachingTypeScope(String cacheId, IScope parent) {
		super(parent, false);
		this.cacheId = cacheId;
		this.cache = Maps.newHashMapWithExpectedSize(50);
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		IEObjectDescription cached = cache.get(name);
		if (cached == null) {
			if (cache.containsKey(name)) {
				return null;
			}
			cached = getParent().getSingleElement(name);
			cache.put(name, cached);
			LOGGER.debug("Cached " + name);
		} else {
			LOGGER.debug("Cachehit for " + name + " in " + cacheId);
		}

		LOGGER.debug(String.format("Cache %s has %s entries.", cacheId,
				String.valueOf(cache.size())));
		return cached;
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		IEObjectDescription element = getSingleElement(name);
		return element == null ? Collections.<IEObjectDescription> emptyList()
				: Collections.singletonList(element);
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return Collections.emptyList();
	}

}