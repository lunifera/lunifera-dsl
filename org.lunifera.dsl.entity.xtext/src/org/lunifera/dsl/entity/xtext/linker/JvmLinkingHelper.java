package org.lunifera.dsl.entity.xtext.linker;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

public class JvmLinkingHelper {

	private Map<EReference, EReference> linkMappings = new HashMap<EReference, EReference>();

	public JvmLinkingHelper() {
		linkMappings.put(LunEntityPackage.Literals.LENTITY__SUPER_TYPE,
				LunEntityPackage.Literals.LENTITY__SUPER_TYPE_JVM);
		linkMappings.put(LunEntityPackage.Literals.LENTITY_REFERENCE__TYPE,
				LunEntityPackage.Literals.LENTITY_REFERENCE__TYPE_JVM);
	}

	public boolean needsJvmLinking(EReference reference) {
		return linkMappings.containsKey(reference);
	}

	public EReference getJvmLinking(EReference reference) {
		return linkMappings.get(reference);
	}

}
