package org.lunifera.dsl.entity.xtext.tests;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.lunifera.dsl.entity.xtext.EntityGrammarStandaloneSetup;

import com.google.inject.Injector;

public class InjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return new EntityGrammarStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
	}

}
