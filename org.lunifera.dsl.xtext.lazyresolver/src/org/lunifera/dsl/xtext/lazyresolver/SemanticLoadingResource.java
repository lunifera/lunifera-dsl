/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.xtext.lazyresolver;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.lunifera.dsl.xtext.lazyresolver.api.DerivedRootAdapter;
import org.lunifera.dsl.xtext.lazyresolver.api.IIndexDerivedStateComputer;
import org.lunifera.dsl.xtext.lazyresolver.api.ISemanticLoadingResource;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class SemanticLoadingResource extends BatchLinkableResource implements
		ISemanticLoadingResource {

	@Inject
	private IDerivedStateComputer derivedStateComputer;

	private boolean suppressDerivedState;

	@Override
	public EObject getSemanticElement(String fragment) {
		try {
			suppressDerivedState = true;
			return super.getEObject(fragment);
		} finally {
			suppressDerivedState = false;
		}
	}

	@Override
	public EObject getSemanticElement() {
		try {
			suppressDerivedState = true;
			return getContents().get(0);
		} finally {
			suppressDerivedState = false;
		}
	}

	public void installDerivedState(boolean preIndexingPhase) {
		if (preIndexingPhase || !suppressDerivedState) {

			if (!isLoaded)
				throw new IllegalStateException(
						"The resource must be loaded, before installDerivedState can be called.");
			if (!fullyInitialized && !isInitializing) {
				try {
					isInitializing = true;
					if (derivedStateComputer != null)
						derivedStateComputer.installDerivedState(this,
								preIndexingPhase);
					fullyInitialized = true;
				} finally {
					isInitializing = false;
					getCache().clear(this);
				}
			}
		}
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {

		EObject semanticElement = getSemanticElement();
		if (semanticElement == null)
			throw new IllegalStateException(
					"The Xtext resource must contain at least one element.");
		SaveOptions saveOptions = SaveOptions.getOptions(options);
		setEncodingFromOptions(options);
		getSerializer().serialize(semanticElement,
				new OutputStreamWriter(outputStream, getEncoding()),
				saveOptions);
	}

	@Override
	public EObject getEObject(String uriFragment) {
		if (uriFragment.startsWith("/0")) {
			// will access semantic model -> No need to install derived state
			try {
				suppressDerivedState = true;
				return super.getEObject(uriFragment);
			} finally {
				suppressDerivedState = false;
			}
		} else {
			return super.getEObject(uriFragment);
		}
	}

	protected void clearInternalState() {
		try {
			suppressDerivedState = true;
			super.clearInternalState();
		} finally {
			suppressDerivedState = false;
		}
	}

	@SuppressWarnings("sync-override")
	@Override
	public EList<EObject> getContents() {
		if (derivedStateComputer instanceof IIndexDerivedStateComputer) {
			synchronized (getLock()) {
				if (isLoaded && !isLoading && !isInitializing && !isUpdating
						&& !fullyInitialized) {
					try {
						eSetDeliver(false);
						installDerivedState(false);
					} finally {
						eSetDeliver(true);
					}
				}
				return doGetMyContents();
			}
		} else {
			return super.getContents();
		}
	}

	/**
	 * @since 2.4
	 */
	protected EList<EObject> doGetMyContents() {
		if (contents == null) {
			contents = new ContentsList<EObject>();
		}
		return contents;
	}

	protected class ContentsList<E extends Object & EObject> extends
			ResourceImpl.ContentsEList<E> {

		private boolean initializing;

		@Override
		public E get(int index) {
			if (!initializing && fullyInitialized && index > 0) {
				try {
					initializing = true;
					if (isUnDerived(index)) {
						IndexDerivedStateComputer computer = (IndexDerivedStateComputer) derivedStateComputer;
						computer.installDerivedState(
								SemanticLoadingResource.this, index, false);
					}
				} finally {
					initializing = false;
				}
			}
			return super.get(index);
		}

		private boolean isUnDerived(int index) {
			EObject eObject = get(index);
			return EcoreUtil.getAdapter(eObject.eAdapters(),
					DerivedRootAdapter.class) != null;
		}

		@Override
		public Iterator<E> iterator() {
			return super.iterator();
		}

		@Override
		public ListIterator<E> listIterator() {
			return super.listIterator();
		}

		@Override
		public ListIterator<E> listIterator(int index) {
			return super.listIterator(index);
		}

	}
}