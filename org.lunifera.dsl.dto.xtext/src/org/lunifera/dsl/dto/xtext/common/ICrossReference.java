package org.lunifera.dsl.dto.xtext.common;

import java.io.Serializable;

public interface ICrossReference extends Serializable {

	String getTarget();

	Object getId();

}
