package org.lunifera.dsl.dto.xtext.common;

public interface IMapper<D, E> {
	
	void mapToDTO(D dto, E entity);
	
	void mapToEntity(D dto, E entity);
}
