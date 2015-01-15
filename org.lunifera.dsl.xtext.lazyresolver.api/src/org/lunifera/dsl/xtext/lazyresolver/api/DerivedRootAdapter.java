package org.lunifera.dsl.xtext.lazyresolver.api;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

public class DerivedRootAdapter extends AdapterImpl {

	private final EObject semantic;
	private final String selector;

	public DerivedRootAdapter(EObject context, String selector) {
		this.semantic = context;
		this.selector = selector;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == DerivedRootAdapter.class;
	}

	/**
	 * @return the semantic
	 */
	public EObject getSemantic() {
		return semantic;
	}

	/**
	 * @return the selector
	 */
	public String getSelector() {
		return selector;
	}

}
