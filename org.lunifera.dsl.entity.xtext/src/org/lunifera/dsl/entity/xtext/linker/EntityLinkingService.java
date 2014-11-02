package org.lunifera.dsl.entity.xtext.linker;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LEntityReference;

import com.google.inject.Inject;

public class EntityLinkingService extends DefaultLinkingService {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	/**
	 * @return the first element returned from the injected
	 *         {@link IScopeProvider} which matches the text of the passed
	 *         {@link INode node}
	 */
	public List<EObject> getLinkedObjects(EObject context, EReference ref,
			INode node) throws IllegalNodeException {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		String name = "";
		String uri = context.eResource().getURI().toString();
		if (context instanceof LEntityAttribute) {
			String eName = "";
			String refName = ((LEntityAttribute) context).getName();
			if (context.eContainer() instanceof LEntity) {
				eName = ((LEntity) context.eContainer()).getName();
			}
			name = uri +":  " + eName + "#" + refName + ":" + ref.getName();
		} else if(context instanceof LEntityReference){
			String eName = "";
			String refName = ((LEntityReference) context).getName();
			if (context.eContainer() instanceof LEntity) {
				eName = ((LEntity) context.eContainer()).getName();
			}
			name = uri +":  " + eName + "#" + refName + ":" + ref.getName();
		} else {
			String className = context.eClass().getName();
			name = uri +":  " + className + "#" + ref.getName();
		}

		final String crossRefString = getCrossRefNodeAsString(node);
		if (crossRefString != null && !crossRefString.equals("")) {
			final IScope scope = getScope(context, ref);
			QualifiedName qualifiedLinkName = qualifiedNameConverter
					.toQualifiedName(crossRefString);
			Date start = new Date();
			IEObjectDescription eObjectDescription = scope
					.getSingleElement(qualifiedLinkName);
			Date end = new Date();
			System.out.println((end.getTime() - start.getTime()) + "; "
					+ name);
			if (eObjectDescription != null)
				return Collections.singletonList(eObjectDescription
						.getEObjectOrProxy());
		}
		return Collections.emptyList();
	}
}
