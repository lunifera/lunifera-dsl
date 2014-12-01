/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.dto.lib.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.lunifera.dsl.dto.lib.IMapper;
import org.lunifera.dsl.dto.lib.services.IQuery;
import org.lunifera.dsl.dto.lib.services.jpa.metadata.EntityDelegate;

@SuppressWarnings("all")
public abstract class AbstractDTOService<DTO, ENTITY> implements
		org.lunifera.dsl.dto.lib.services.IDTOService<DTO> {

	private EntityManagerFactory emf;
	protected IMapper<DTO, ENTITY> mapper;

	protected abstract Class<DTO> getDtoClass();

	protected abstract DTO createDto();

	protected abstract Class<ENTITY> getEntityClass();

	protected abstract ENTITY createEntity();

	protected abstract Object getId(DTO dto);

	/**
	 * {@inherit doc}
	 * 
	 */
	public DTO get(final Object id) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, 1);

		// find the entity
		DTO result = null;
		try {
			ENTITY entity = delegate.getEntity(id);
			if (entity != null) {
				result = createDto();
				mapper.mapToDTO(result, entity, new IMapper.Context());
			}
		} finally {
			em.close();
		}

		return result;
	}

	/**
	 * {@inherit doc}
	 * 
	 */
	public Collection<DTO> find(final IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, PROP_MAX_COLLECTION_CONTENT);

		List<DTO> result = new ArrayList<DTO>();
		try {
			for (ENTITY entity : delegate.getAllEntities(query)) {
				DTO dto = createDto();
				mapper.mapToDTO(dto, entity, new IMapper.Context());
				result.add(dto);
			}
		} finally {
			em.close();
		}

		return result;
	}

	/**
	 * {@inherit doc}
	 * 
	 */
	public Collection<DTO> find(final IQuery query, final int startindex) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, PROP_MAX_COLLECTION_CONTENT);

		List<DTO> result = new ArrayList<DTO>();
		try {
			for (ENTITY entity : delegate.getAllEntities(query, startindex)) {
				DTO dto = createDto();
				mapper.mapToDTO(dto, entity, new IMapper.Context());
				result.add(dto);
			}
		} finally {
			em.close();
		}

		return result;
	}

	/**
	 * {@inherit doc}
	 * 
	 */
	public DTO update(final DTO dto) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		javax.persistence.EntityTransaction txn = em.getTransaction();

		DTO result = createDto();
		try {
			txn.begin();

			ENTITY entity = null;

			Object id = getId(dto);
			if (id != null) {
				entity = em.find(getEntityClass(), getId(dto));
				if (entity != null) {
					mapper.mapToEntity(dto, entity, new IMapper.Context());
					em.persist(entity);
					// map the entity back to the dto since values may be
					// changed in dto
					mapper.mapToDTO(result, entity, new IMapper.Context());
				} else {
					entity = createEntity();
					mapper.mapToEntity(dto, entity, new IMapper.Context());
					em.persist(entity);
					// map the entity back to the dto since values may be
					// changed in dto
					mapper.mapToDTO(result, entity, new IMapper.Context());
				}
			} else {
				entity = createEntity();
				mapper.mapToEntity(dto, entity, new IMapper.Context());
				em.persist(entity);
				// map the entity back to the dto since values may be changed in
				// dto
				mapper.mapToDTO(result, entity, new IMapper.Context());
			}

			txn.commit();
		} finally {
			em.close();
		}

		return result;
	}

	/**
	 * {@inherit doc}
	 * 
	 */
	public void delete(final DTO dto) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		javax.persistence.EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			ENTITY entity = em.find(getEntityClass(), getId(dto));
			if (entity != null) {
				em.remove(entity);
			}

			txn.commit();
		} finally {
			em.close();
		}
	}

	/**
	 * Binds the service
	 * {@link org.lunifera.examples.ecview.dtos.mapper.TMapper} to this
	 * component. <br>
	 * The cardinality is ONE_TO_ONE
	 * 
	 * @param mapper
	 *            the service
	 */
	protected void bindMapper(final IMapper<DTO, ENTITY> mapper) {
		this.mapper = mapper;
	}

	/**
	 * Unbinds the service from this component. <br>
	 * The cardinality is ONE_TO_ONE
	 * 
	 * @param mapper
	 *            the service
	 */
	protected void unbindMapper(final IMapper<DTO, ENTITY> mapper) {
		this.mapper = null;
	}

	/**
	 * Binds the service {@link javax.persistence.EntityManagerFactory} to this
	 * component. <br>
	 * The cardinality is ONE_TO_ONE
	 * 
	 * @param emf
	 *            the service
	 */
	protected void bindEmf(final EntityManagerFactory emf) {
		this.emf = emf;
	}

	/**
	 * Unbinds the service from this component. <br>
	 * The cardinality is ONE_TO_ONE
	 * 
	 * @param emf
	 *            the service
	 */
	protected void unbindEmf(final EntityManagerFactory emf) {
		this.emf = null;
	}

	@Override
	public int size(IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, 1);

		int result = -1;
		try {
			result = delegate.getEntityCount(query);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public boolean contains(Object dto, IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, 1);

		boolean result = false;
		try {
			result = delegate.containsEntityIdentifier(dto, query);
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public DTO getNext(DTO dto, IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, 1);

		DTO result = null;
		try {
			ENTITY entity = delegate.getNextEntity(getId(dto), query);
			if (entity != null) {
				result = createDto();
				mapper.mapToEntity(result, entity, new IMapper.Context());
			}
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public DTO getPrevious(DTO dto, IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, 1);

		DTO result = null;
		try {
			ENTITY entity = delegate.getPreviousEntity(getId(dto), query);
			if (entity != null) {
				result = createDto();
				mapper.mapToEntity(result, entity, new IMapper.Context());
			}
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public DTO getFirst(IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, 1);

		DTO result = null;
		try {
			ENTITY entity = delegate.getFirstEntity(query);
			if (entity != null) {
				result = createDto();
				mapper.mapToEntity(result, entity, new IMapper.Context());
			}
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public DTO getLast(IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, 1);

		DTO result = null;
		try {
			ENTITY entity = delegate.getLastEntity(query);
			if (entity != null) {
				result = createDto();
				mapper.mapToEntity(result, entity, new IMapper.Context());
			}
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public boolean isFirst(DTO dto, IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, 1);

		List<DTO> result = new ArrayList<DTO>();
		try {
			String firstId = (String) delegate.getFirstEntityIdentifier(query);
			if (firstId != null && firstId.equals(getId(dto))) {
				return true;
			}
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public boolean isLast(DTO dto, IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, 1);

		List<DTO> result = new ArrayList<DTO>();
		try {
			String lastId = (String) delegate.getLastEntityIdentifier(query);
			if (lastId != null && lastId.equals(getId(dto))) {
				return true;
			}
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public int indexOf(DTO dto, IQuery query) {
		return 1;
	}

	@Override
	public DTO getByIndex(int index, IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, 1);

		DTO result = null;
		try {
			for (ENTITY entity : delegate.getAllEntities(query, index)) {
				result = createDto();
				mapper.mapToDTO(result, entity, new IMapper.Context());
				break;
			}
		} finally {
			em.close();
		}

		return result;
	}

	@Override
	public List<DTO> getByIndex(int startIndex, int numberOfItems, IQuery query) {
		javax.persistence.EntityManager em = emf.createEntityManager();
		EntityDelegate<ENTITY> delegate = new EntityDelegate<ENTITY>(
				getEntityClass(), em, numberOfItems);

		List<DTO> result = new ArrayList<DTO>();
		try {
			for (ENTITY entity : delegate.getAllEntities(query, startIndex)) {
				DTO dto = createDto();
				mapper.mapToDTO(dto, entity, new IMapper.Context());
				result.add(dto);
			}
		} finally {
			em.close();
		}

		return result;
	}
}
