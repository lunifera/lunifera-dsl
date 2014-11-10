package org.lunifera.dsl.xtext.cache.stackaware;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class StackAdapter extends AdapterImpl {

	private static final int MAX_STACK = 25;
	private final ResourceSet resourceSet;
	private boolean clearFirst;
	private int current;

	public StackAdapter(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == StackAdapter.class;
	}

	public void push(URI uri) {
		current++;
	}

	public void pop() {
		current--;
		if (current == 1) {
			clearFirst = false;
		}
	}

	public boolean isMaxReached(URI uri) {
		System.out.println("---- CachStack: " + current);
		clearFirst = clearFirst || current >= MAX_STACK;
		return clearFirst;
	}

	public static StackAdapter getOrInit(ResourceSet resourceSet) {
		for (Adapter adapter : resourceSet.eAdapters()) {
			if (adapter.isAdapterForType(StackAdapter.class)) {
				return (StackAdapter) adapter;
			}
		}

		StackAdapter adapter = new StackAdapter(resourceSet);
		resourceSet.eAdapters().add(adapter);

		return adapter;
	}

}
