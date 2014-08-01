package org.lunifera.dsl.entity.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.serializer.sequencer.LegacyTransientValueService;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

@SuppressWarnings("restriction")
public class EntityGrammarTransientValueService extends
		LegacyTransientValueService {

	@Override
	public ListTransient isListTransient(EObject semanticObject,
			EStructuralFeature feature) {

		if (feature == LunEntityPackage.Literals.LBEAN__SUB_TYPES
				|| feature == LunEntityPackage.Literals.LENTITY__SUB_TYPES) {
			return ListTransient.YES;
		}

		return super.isListTransient(semanticObject, feature);
	}

}
