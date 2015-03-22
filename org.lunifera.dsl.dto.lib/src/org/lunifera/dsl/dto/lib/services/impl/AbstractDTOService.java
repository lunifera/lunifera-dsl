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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.eclipse.persistence.internal.sessions.RepeatableWriteUnitOfWork;
import org.eclipse.persistence.sessions.SessionEvent;
import org.eclipse.persistence.sessions.SessionEventAdapter;
import org.lunifera.dsl.dto.lib.IMapper;
import org.lunifera.dsl.dto.lib.IMapperAccess;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.dto.lib.services.DtoServiceException;
import org.lunifera.dsl.dto.lib.services.IQuery;
import org.lunifera.dsl.dto.lib.services.jpa.metadata.EntityDelegate;
import org.lunifera.runtime.common.annotations.DtoUtils;
import org.lunifera.runtime.common.hash.HashUtil;
import org.lunifera.runtime.common.state.ISharedStateContext;

@SuppressWarnings("all")
public abstract class AbstractDTOService<DTO, ENTITY> implements
		org.lunifera.dsl.dto.lib.services.IDTOService<DTO> {

	private EntityManagerFactory emf;
	protected IMapperAccess mapperAccess;

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
				IMapper<DTO, ENTITY> mapper = findToDtoMapper(getDtoClass(),
						(Class<ENTITY>) entity.getClass());
				MappingContext mappingContext = new MappingContext(true);
				mappingContext.increaseLevel();
				result = mapSingle(entity, mapper, mappingContext);
				mappingContext.decreaseLevel();
				mappingContext.flush();
			}
		} finally {
			em.close();
		}

		return result;
	}

	protected DTO mapSingle(ENTITY entity, IMapper<DTO, ENTITY> mapper,
			MappingContext context) {
		DTO result;
		try {
			context.increaseLevel();
			DTO cached = context.get(mapper.createDtoHash(entity));
			if (cached != null) {
				result = cached;
			} else {
				DTO dto = mapper.createDto();
				mapper.mapToDTO(dto, entity, context);
				result = dto;
			}
		} finally {
			context.decreaseLevel();
		}
		return result;
	}

	/**
	 * See {@link IMapperAccess#getToDtoMapper(Class, Class)}
	 * 
	 * @param dtoClass
	 * @param entityClass
	 * @return
	 */
	protected IMapper<DTO, ENTITY> findToDtoMapper(Class<DTO> dtoClass,
			Class<ENTITY> entityClass) {
		return (IMapper<DTO, ENTITY>) mapperAccess.getToDtoMapper(dtoClass,
				entityClass);
	}

	/**
	 * See {@link IMapperAccess#getToEntityMapper(Class, Class)}
	 * 
	 * @param dtoClass
	 * @param entityClass
	 * @return
	 */
	protected IMapper<DTO, ENTITY> findToEntityMapper(Class<DTO> dtoClass,
			Class<ENTITY> entityClass) {
		return (IMapper<DTO, ENTITY>) mapperAccess.getToEntityMapper(dtoClass,
				entityClass);
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
			MappingContext mappingContext = new MappingContext(true);
			mappingContext.increaseLevel();
			for (ENTITY entity : delegate.getAllEntities(query)) {
				IMapper<DTO, ENTITY> mapper = findToDtoMapper(getDtoClass(),
						(Class<ENTITY>) entity.getClass());
				result.add(mapSingle(entity, mapper, mappingContext));
			}
			mappingContext.decreaseLevel();
			mappingContext.flush();
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
			MappingContext mappingContext = new MappingContext(true);
			mappingContext.increaseLevel();
			for (ENTITY entity : delegate.getAllEntities(query, startindex)) {
				IMapper<DTO, ENTITY> mapper = findToDtoMapper(getDtoClass(),
						(Class<ENTITY>) entity.getClass());
				result.add(mapSingle(entity, mapper, mappingContext));
			}
			mappingContext.decreaseLevel();
			mappingContext.flush();
		} finally {
			em.close();
		}

		return result;
	}

	/**
	 * {@inherit doc}
	 * 
	 */
	public void update(final DTO dto) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction txn = em.getTransaction();

		MappingContext entityMappingContext = new MappingContext(false);
		TransactionObserver entityTxnObserver = new TransactionObserver(
				TransactionObserver.UPDATE, em, entityMappingContext);

		MappingContext dtoMappingContext = new MappingContext(true);
		dtoMappingContext.increaseLevel();

		try {
			txn.begin();

			IMapper<DTO, ENTITY> toEntityMapper = findToEntityMapper(
					(Class<DTO>) dto.getClass(),
					(Class<ENTITY>) getEntityClass());

			ENTITY entity = null;
			Object id = getId(dto);
			if (id != null) {
				entity = em.find(getEntityClass(), id);
				if (entity == null) {
					entity = toEntityMapper.createEntity();
				}
			} else {
				entity = toEntityMapper.createEntity();
			}

			// map dto to entity and persist
			toEntityMapper.mapToEntity(dto, entity, entityMappingContext);
			em.merge(entity);

			IMapper<DTO, ENTITY> toDtoMapper = findToDtoMapper(
					(Class<DTO>) dto.getClass(),
					(Class<ENTITY>) entity.getClass());
			// map the entity back to the dto since values may have
			// changed in dto
			toDtoMapper.mapToDTO(dto, entity, dtoMappingContext);

			txn.commit();
			txn = null;
		} finally {
			ISharedStateContext sharedState = dtoMappingContext
					.getSharedState();
			if (sharedState != null) {
				if (txn == null) {
					// put dtos in ISharedStateContext
					dtoMappingContext.decreaseLevel();
					dtoMappingContext.flush();
				}
				for (Object obj : entityTxnObserver.affected) {
					// access with entity hash
					Object affectedDto = entityMappingContext
							.getMappingRoot(HashUtil.createObjectWithIdHash(
									obj.getClass(), obj));
					if (affectedDto != null) { // null for embeddable beans
						// access with dto hash
						removeFromDirtyState(
								HashUtil.createObjectWithIdHash(
										affectedDto.getClass(), affectedDto),
								affectedDto, sharedState);
					}
				}
			}
			entityTxnObserver.dispose();
			em.close();
		}
	}

	/**
	 * {@inherit doc}
	 */
	public DTO reload(final DTO dto) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		// find the entity
		boolean reloaded = false;
		try {
			ENTITY entity = em.find(getEntityClass(), getId(dto));
			if (entity != null) {
				MappingContext dtoMappingContext = new MappingContext(true);
				dtoMappingContext.setRefresh(true);
				dtoMappingContext.increaseLevel();

				// entity available -> Map to the given DTO
				IMapper<DTO, ENTITY> mapper = findToDtoMapper(getDtoClass(),
						(Class<ENTITY>) entity.getClass());
				dtoMappingContext.registerRefreshed(mapper.createDtoHash(dto),
						dto);
				mapper.mapToDTO(dto, entity, dtoMappingContext);

				// flush the changes to the shared state
				dtoMappingContext.decreaseLevel();
				dtoMappingContext.flush();

				reloaded = true;
			}
		} finally {
			em.close();
		}

		return reloaded ? null : createDto();
	}

	/**
	 * Removes the dto with the given key from the dirty state cache.
	 * 
	 * @param dtoKey
	 * @param affectedDto
	 * @param sharedState
	 */
	private void removeFromDirtyState(Object dtoKey, Object affectedDto,
			ISharedStateContext sharedState) {
		sharedState.makeUndirty(dtoKey, affectedDto);
	}

	/**
	 * Removes the dto with the given key from the dirty state cache.
	 * 
	 * @param dtoKey
	 * @param affectedDto
	 * @param sharedState
	 */
	private void removeFromSharedState(Object dtoKey, Object affectedDto,
			ISharedStateContext sharedState) {
		// try to dispose the dto. Will remove it from caches automatically.
		if (!DtoUtils.invokeDisposeMethod(affectedDto)) {
			sharedState.getDirtyState().invalidate(dtoKey);
			sharedState.getGlobalDataState().invalidate(dtoKey);
		}
	}

	/**
	 * {@inherit doc}
	 * 
	 */
	public void delete(final DTO dto) throws DtoServiceException {
		javax.persistence.EntityManager em = emf.createEntityManager();
		javax.persistence.EntityTransaction txn = em.getTransaction();

		// create a txn observer to get all deleted elements
		MappingContext entityMappingContext = new MappingContext(true);
		entityMappingContext.increaseLevel();
		TransactionObserver entityTxnObserver = new TransactionObserver(
				TransactionObserver.DELETE, em, entityMappingContext);

		try {
			txn.begin();

			// we need to do a mapping step first to get references from entity
			// to DTOs
			// then we know which dtos must be removed from shared context
			IMapper<DTO, ENTITY> mapper = findToEntityMapper(
					(Class<DTO>) dto.getClass(),
					(Class<ENTITY>) getEntityClass());
			// map dto to entity and persist
			ENTITY entity = mapper.createEntity();
			mapper.mapToEntity(dto, entity, entityMappingContext);

			entity = em.find(getEntityClass(), getId(dto));
			if (entity != null) {
				em.remove(entity);
			}

			try {
				txn.commit();
				txn = null;
			} catch (Exception e) {
				throw new ExceptionConverter().convertException(e);
			}
		} finally {
			if (txn == null) {
				// if using shared state, map the deleted entities to their dtos
				// and remove them from the shared state
				ISharedStateContext sharedState = entityMappingContext
						.getSharedState();
				if (sharedState != null) {
					for (Object obj : entityTxnObserver.affected) {
						// access with entity hash
						Object affectedDto = entityMappingContext
								.getMappingRoot(HashUtil
										.createObjectWithIdHash(obj.getClass(),
												obj));
						// access with dto hash
						removeFromSharedState(
								HashUtil.createObjectWithIdHash(
										affectedDto.getClass(), affectedDto),
								affectedDto, sharedState);
					}
				}
			}

			entityTxnObserver.dispose();
			em.close();
		}
	}

	/**
	 * Binds the service {@link IMapperAccess} to this component. <br>
	 * The cardinality is ONE_TO_ONE
	 * 
	 * @param mapper
	 *            the service
	 */
	protected void bindMapperAccess(final IMapperAccess mapperAccess) {
		this.mapperAccess = mapperAccess;
	}

	/**
	 * Unbinds the service from this component. <br>
	 * The cardinality is ONE_TO_ONE
	 * 
	 * @param mapper
	 *            the service
	 */
	protected void unbindMapperAccess(final IMapperAccess mapperAccess) {
		this.mapperAccess = null;
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

	/**
	 * @return the emf
	 */
	protected EntityManagerFactory getEmf() {
		return emf;
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
				IMapper<DTO, ENTITY> mapper = findToDtoMapper(getDtoClass(),
						(Class<ENTITY>) entity.getClass());
				MappingContext mappingContext = new MappingContext(true);
				mappingContext.increaseLevel();
				result = mapSingle(entity, mapper, mappingContext);
				mappingContext.decreaseLevel();
				mappingContext.flush();
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
				IMapper<DTO, ENTITY> mapper = findToDtoMapper(getDtoClass(),
						(Class<ENTITY>) entity.getClass());
				MappingContext mappingContext = new MappingContext(true);
				mappingContext.increaseLevel();
				result = mapSingle(entity, mapper, mappingContext);
				mappingContext.decreaseLevel();
				mappingContext.flush();
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
				IMapper<DTO, ENTITY> mapper = findToDtoMapper(getDtoClass(),
						(Class<ENTITY>) entity.getClass());
				MappingContext mappingContext = new MappingContext(true);
				mappingContext.increaseLevel();
				result = mapSingle(entity, mapper, mappingContext);
				mappingContext.decreaseLevel();
				mappingContext.flush();
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
				IMapper<DTO, ENTITY> mapper = findToDtoMapper(getDtoClass(),
						(Class<ENTITY>) entity.getClass());
				MappingContext mappingContext = new MappingContext(true);
				mappingContext.increaseLevel();
				result = mapSingle(entity, mapper, mappingContext);
				mappingContext.decreaseLevel();
				mappingContext.flush();
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
			MappingContext mappingContext = new MappingContext(true);
			mappingContext.increaseLevel();
			for (ENTITY entity : delegate.getAllEntities(query, index)) {
				IMapper<DTO, ENTITY> mapper = findToDtoMapper(getDtoClass(),
						(Class<ENTITY>) entity.getClass());
				result = mapSingle(entity, mapper, mappingContext);
				break;
			}
			mappingContext.decreaseLevel();
			mappingContext.flush();
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
			MappingContext mappingContext = new MappingContext(true);
			mappingContext.increaseLevel();
			for (ENTITY entity : delegate.getAllEntities(query, startIndex)) {
				IMapper<DTO, ENTITY> mapper = findToDtoMapper(getDtoClass(),
						(Class<ENTITY>) entity.getClass());
				result.add(mapSingle(entity, mapper, mappingContext));
			}
			mappingContext.decreaseLevel();
			mappingContext.flush();
		} finally {
			em.close();
		}

		return result;
	}

	private static class TransactionObserver extends SessionEventAdapter {

		private static final int UPDATE = 0;
		private static final int DELETE = 1;

		private List<Object> affected = new ArrayList<Object>();
		private EntityManager em;
		private MappingContext context;
		private int type;

		public TransactionObserver(int type, EntityManager em,
				MappingContext context) {
			this.type = type;
			this.em = em;
			this.context = context;
			((EntityManagerImpl) em).getActiveSession().getEventManager()
					.addListener(this);
		}

		@Override
		public void postCommitUnitOfWork(SessionEvent event) {
			RepeatableWriteUnitOfWork uow = (RepeatableWriteUnitOfWork) event
					.getSource();
			if (type == UPDATE) {
				for (Object object : uow.getCloneMapping().values()) {
					affected.add(object);
				}
			} else if (type == DELETE) {
				for (Object object : uow.getDeletedObjects().values()) {
					affected.add(object);
				}
			}
		}

		public void dispose() {
			((EntityManagerImpl) em).getActiveSession().getEventManager()
					.removeListener(this);
		}
	}
}
