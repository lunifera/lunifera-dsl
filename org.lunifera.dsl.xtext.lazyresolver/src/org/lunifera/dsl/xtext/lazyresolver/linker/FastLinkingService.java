package org.lunifera.dsl.xtext.lazyresolver.linker;

import java.util.Collections;
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
import org.lunifera.dsl.xtext.lazyresolver.api.logger.TimeLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

public class FastLinkingService extends DefaultLinkingService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FastLinkingService.class);

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

		final String crossRefString = getCrossRefNodeAsString(node);
		if (crossRefString != null && !crossRefString.equals("")) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("before getLinkedObjects: node: '"
						+ crossRefString + "'");
			}
			TimeLogger createLog = TimeLogger.start(getClass());
			final IScope scope = getScope(context, ref);
			createLog.stop(LOGGER, "Creating scope for "
					+ crossRefString + " " + toRefName(ref) + " and context "
					+ context + " took");

			QualifiedName qualifiedLinkName = qualifiedNameConverter
					.toQualifiedName(crossRefString);

			TimeLogger doScopeLog = TimeLogger.start(getClass());
			IEObjectDescription eObjectDescription = scope
					.getSingleElement(qualifiedLinkName);
			doScopeLog.stop(LOGGER, "Executing scope for "
					+ crossRefString + " " + toRefName(ref) + " and context "
					+ context + " with result " + eObjectDescription + " took");

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("after getLinkedObjects: node: '" + crossRefString
						+ "' result: " + eObjectDescription);
			}
			if (eObjectDescription != null)
				return Collections.singletonList(eObjectDescription
						.getEObjectOrProxy());
		}
		return Collections.emptyList();
	}

	private String toRefName(EReference ref) {
		EClass type = ref.getEReferenceType();
		return type.getName() + "#" + ref.getName();
	}
}
