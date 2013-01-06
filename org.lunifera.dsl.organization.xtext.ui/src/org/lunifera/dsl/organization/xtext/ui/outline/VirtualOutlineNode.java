package org.lunifera.dsl.organization.xtext.ui.outline;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class VirtualOutlineNode extends AbstractOutlineNode {

	private EClass eClass;

	private ITextRegion shortTextRegion;

	private EObject eObject;

	private boolean isLeaf;

	public VirtualOutlineNode(EObject eObject, IOutlineNode parent,
			Image image, Object text, boolean isLeaf) {
		super(parent, image, text, isLeaf);
		this.eObject = eObject;
		this.eClass = eObject.eClass();
		this.isLeaf = isLeaf;
	}

	@Override
	public URI getEObjectURI() {
		return null;
	}

	public EClass getEClass() {
		return eClass;
	}

	public void setShortTextRegion(ITextRegion shortTextRegion) {
		this.shortTextRegion = shortTextRegion;
	}

	@Override
	public ITextRegion getSignificantTextRegion() {
		return shortTextRegion;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapterType) {
		if (adapterType == EClass.class) {
			return eClass;
		}
		return super.getAdapter(adapterType);
	}

	public EObject getEObject(Resource resource) {
		return eObject;
	}

	public boolean hasChildren() {
		return !isLeaf;
	}

	public <T> T readOnly(final IUnitOfWork<T, EObject> work) {
		return getDocument().readOnly(new IUnitOfWork<T, XtextResource>() {
			public T exec(XtextResource state) throws Exception {
				return work.exec(eObject);
			}

		});
	}
}