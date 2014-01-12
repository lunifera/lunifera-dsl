package org.lunifera.dsl.semantic.entity.impl;

import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LEntity;

public class EntityFactoryImplCustom extends EntityFactoryImpl {

	@Override
	public LEntity createLEntity() {
		return new LEntityImplCustom();
	}

	@Override
	public LBean createLBean() {
		return new LBeanImplCustom();
	}
}
