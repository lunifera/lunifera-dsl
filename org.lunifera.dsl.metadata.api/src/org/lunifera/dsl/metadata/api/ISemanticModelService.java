package org.lunifera.dsl.metadata.api;

public interface ISemanticModelService {
	
	ISemanticDTO getSemantics(Class<?> c, String dtoId);

}
