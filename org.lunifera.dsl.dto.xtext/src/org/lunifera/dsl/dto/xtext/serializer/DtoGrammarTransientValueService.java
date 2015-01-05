package org.lunifera.dsl.dto.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;
import org.lunifera.dsl.xtext.lazyresolver.linker.LazyJvmTypeTransientValueService;

@SuppressWarnings("restriction")
public class DtoGrammarTransientValueService extends
		LazyJvmTypeTransientValueService {

	@Override
	public ListTransient isListTransient(EObject semanticObject,
			EStructuralFeature feature) {

		if (feature == LunDtoPackage.Literals.LDTO__SUB_TYPES) {
			return ListTransient.YES;
		}

		return super.isListTransient(semanticObject, feature);
	}

}
