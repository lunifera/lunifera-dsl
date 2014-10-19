/**
 * Copyright (c) 2011 - 2014, Hans Georg Glöckler, Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.lunifera.dsl.entity.xtext.ui.contentassist.EntityGrammarProposalProvider;
import org.lunifera.dsl.entity.xtext.ui.labeling.EntityGrammarLabelProvider;
import org.lunifera.dsl.entity.xtext.ui.type.EntityJdtTypeProviderFactory;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EntityGrammarUiModule extends AbstractEntityGrammarUiModule {
	public EntityGrammarUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends IContentProposalProvider> bindIContentProposalProvider() {
		return EntityGrammarProposalProvider.class;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return EntityHighlightingConfiguration.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return EntityGrammarHighlightingCalculator.class;
	}

	public Class<? extends org.eclipse.jface.viewers.ILabelProvider> bindILabelProvider() {
		return EntityGrammarLabelProvider.class;
	}

	public Class<? extends IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
		return EntityJdtTypeProviderFactory.class;
	}

}
