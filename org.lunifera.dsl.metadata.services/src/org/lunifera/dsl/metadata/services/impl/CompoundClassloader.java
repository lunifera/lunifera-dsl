package org.lunifera.dsl.metadata.services.impl;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

import org.osgi.framework.Bundle;

public class CompoundClassloader extends ClassLoader {

	private Set<Bundle> delegates;

	public CompoundClassloader(Set<Bundle> delegates) {
		this.delegates = delegates;
	}

	@Override
	public URL getResource(String name) {
		for (Bundle delegate : delegates) {
			URL url = delegate.getResource(name);
			if (url != null) {
				return url;
			}
		}
		return null;
	}

	@Override
	public Enumeration<URL> getResources(String name) throws IOException {
		for (Bundle delegate : delegates) {
			Enumeration<URL> url = delegate.findEntries("/", name, true);
			if (url != null) {
				return url;
			}
		}
		return null;
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		for (Bundle delegate : delegates) {
			try {
				Class<?> clazz = delegate.loadClass(name);
				if (clazz != null) {
					return clazz;
				}
			} catch (ClassNotFoundException e) {
			}
		}
		return null;
	}
}
