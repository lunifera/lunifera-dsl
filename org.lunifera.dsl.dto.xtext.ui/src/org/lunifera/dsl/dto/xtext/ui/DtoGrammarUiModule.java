

/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.dto.xtext.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.lunifera.dsl.dto.xtext.ui.labeling.DtoGrammarLabelProvider;
import org.lunifera.dsl.dto.xtext.ui.DtoGrammarHighlightingCalculator;
import org.lunifera.dsl.dto.xtext.ui.DtoHighlightingConfiguration;

/**
 * Use this class to register components to be used within the IDE.
 */
public class DtoGrammarUiModule extends
		org.lunifera.dsl.dto.xtext.ui.AbstractDtoGrammarUiModule {
	public DtoGrammarUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return DtoHighlightingConfiguration.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return DtoGrammarHighlightingCalculator.class;
	}

	public Class<? extends org.eclipse.jface.viewers.ILabelProvider> bindILabelProvider() {
		return DtoGrammarLabelProvider.class;
	}

}
