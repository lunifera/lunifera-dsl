package org.lunifera.dsl.dto.xtext.common;

public interface IMapperAccess {

	/**
	 * Returns the mapper for the given DTO.
	 * 
	 * @param dto
	 * @param entity
	 * @return
	 */
	<D, E> IMapper<D, E> getMapper(Class<D> dto, Class<E> entity);

}
