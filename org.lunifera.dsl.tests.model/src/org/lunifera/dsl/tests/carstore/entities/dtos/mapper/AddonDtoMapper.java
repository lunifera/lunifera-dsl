package org.lunifera.dsl.tests.carstore.entities.dtos.mapper;

import org.lunifera.dsl.tests.carstore.entities.Addon;
import org.lunifera.dsl.tests.carstore.entities.Car;
import org.lunifera.dsl.tests.carstore.entities.dtos.AddonDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.CarDto;

/**
 * This class maps the dto {@link AddonDto} to and from the entity {@link Addon}
 * .
 * 
 */
@SuppressWarnings("all")
public class AddonDtoMapper<DTO extends AddonDto, ENTITY extends Addon> extends
		BaseDtoMapper<DTO, ENTITY> {
	/**
	 * Maps the entity {@link Addon} to the dto {@link AddonDto}.
	 * 
	 * @param dto
	 *            - The target dto
	 * @param entity
	 *            - The source entity
	 * 
	 */
	public void mapToDTO(final AddonDto dto, final Addon entity, Context context) {
		context.register(dto, entity);

		super.mapToDTO(dto, entity, context);

		dto.setDescription(toDto_description(entity));
		dto.setCar(toDto_car(entity, context));
	}

	/**
	 * Maps the dto {@link AddonDto} to the entity {@link Addon}.
	 * 
	 * @param dto
	 *            - The source dto
	 * @param entity
	 *            - The target entity
	 * 
	 */
	public void mapToEntity(final AddonDto dto, final Addon entity,
			Context context) {
		context.register(dto, entity);

		super.mapToEntity(dto, entity, context);

		entity.setDescription(toEntity_description(dto));

		entity.setCar(toEntity_car(dto, context));

	}

	/**
	 * Maps the property description from the given entity to dto property.
	 * 
	 * @param in
	 *            - The source entity
	 * @return the mapped value
	 * 
	 */
	protected String toDto_description(final Addon in) {
		return in.getDescription();
	}

	/**
	 * Maps the property description from the given entity to dto property.
	 * 
	 * @param in
	 *            - The source entity
	 * @return the mapped value
	 * 
	 */
	protected String toEntity_description(final AddonDto in) {
		return in.getDescription();
	}

	/**
	 * Maps the property car from the given entity to the dto.
	 * 
	 * @param in
	 *            - The source entity
	 * @return the mapped dto
	 * 
	 */
	protected CarDto toDto_car(final Addon in, Context context) {
		org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = getMapper(
				CarDto.class, Car.class);
		if (mapper == null) {
			throw new IllegalStateException("Mapper must not be null!");
		}

		if (in.getCar() != null) {
			CarDto _dto = context.getDto(in.getCar());
			if (_dto == null) {
				_dto = new CarDto();
				context.register(in.getCar(), _dto);
				mapper.mapToDTO(_dto, in.getCar(), context);
			}
			return _dto;
		} else {
			return null;
		}
	}

	/**
	 * Maps the property car from the given dto to the entity.
	 * 
	 * @param in
	 *            - The source dto
	 * @return the mapped entity
	 * 
	 */
	protected Car toEntity_car(final AddonDto in, Context context) {
		org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = getMapper(
				CarDto.class, Car.class);
		if (mapper == null) {
			throw new IllegalStateException("Mapper must not be null!");
		}

		if (in.getCar() != null) {
			Car _entity = context.getEntity(in.getCar());
			if (_entity == null) {
				_entity = new Car();
				context.register(_entity, in.getCar());
				mapper.mapToDTO(in.getCar(), _entity, context);
			}
			return _entity;
		} else {
			return null;
		}
	}
}
