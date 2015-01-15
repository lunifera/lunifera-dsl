package org.lunifera.dsl.xtext.lazyresolver.api;

import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;

public interface IIndexDerivedStateComputer extends IDerivedStateComputer{

	void installDerivedState(DerivedStateAwareResource resource, int index, boolean preLinkingPhase);
	
}
