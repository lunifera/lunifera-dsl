

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



package org.lunifera.dsl.services.xtext.extensions

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator
import org.lunifera.dsl.common.xtext.extensions.TreeAppendableExtensions
import org.lunifera.dsl.common.xtext.jvmmodel.AnnotationCompiler
import org.lunifera.dsl.common.xtext.jvmmodel.CommonTypesBuilder
import org.lunifera.dsl.semantic.service.LDTOService
import org.lunifera.dsl.semantic.service.LInjectedService
import org.lunifera.dsl.dto.lib.services.IQuery

class ServicesTypesBuilder extends CommonTypesBuilder {

	@Inject extension ModelExtensions
	@Inject extension MethodNamingExtensions
	@Inject extension TreeAppendableExtensions
	@Inject extension IQualifiedNameProvider
	@Inject extension AnnotationExtension

	@Inject
	private IJvmModelAssociator associator;
	@Inject AnnotationCompiler annotationCompiler
	@Inject TypesFactory typesFactory;
	@Inject TypeReferences references;

	def dispatch JvmOperation toGetMethod(LDTOService service) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = service.getDto().toTypeReference
		op.simpleName = 'get'
		op.parameters += service.toParameter('id', references.getTypeForName(typeof(Object), service))
		op.documentation = '''
			{@inherit doc}
		'''

		if (service.dto.basedOnEntity) {
			op.body = '''
			javax.persistence.EntityManager em = emf.createEntityManager();
			javax.persistence.EntityTransaction txn = em.getTransaction();
			
			// find the entity
			«service.dto.wrappedEntity.toQualifiedName» entity = null;
			try {
				entity = em.find(«service.dto.wrappedEntity.toQualifiedName».class, id);
				txn.commit();
			   	txn = null;
			}finally{
			   	if(txn != null){
			   		txn.rollback();
			   	}
			   	em.close();
			}

			// map the entity to the dto
			«service.getDto().toTypeReference.simpleName» dto = new «service.getDto().toTypeReference.simpleName»();
			mapper.mapToDTO(dto, entity);
			return dto;
			'''
//		} else if(service.getExpression != null){
//			op.body = service.getExpression
		} else{
			op.body = '''throw new UnsupportedOperationException();'''
		}

		return associate(service, op);
	}

	def JvmOperation toFindMethod(LDTOService service) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(typeof(Collection), service, service.getDto().toTypeReference)
		op.simpleName = 'find'
		op.parameters += service.toParameter('query', references.getTypeForName(typeof(IQuery), service))
		op.documentation = '''
			{@inherit doc}
		'''

		setBody(op, '''return null;''')

		return associate(service, op);
	}

	def JvmOperation toFindMethodWithStartindex(LDTOService service) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(typeof(Collection), service, service.getDto().toTypeReference)
		op.simpleName = 'find'
		op.parameters += service.toParameter('query', references.getTypeForName(typeof(IQuery), service))
		op.parameters += service.toParameter('startindex', references.getTypeForName(Integer::TYPE, service))
		op.documentation = '''
			{@inherit doc}
		'''

		setBody(op, '''return null;''')

		return associate(service, op);
	}

	def JvmOperation toUpdateMethod(LDTOService service) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, service)
		op.simpleName = 'update'
		op.parameters += service.toParameter('dto', service.getDto().toTypeReference)
		op.documentation = '''
			{@inherit doc}
		'''

		if (service.dto.basedOnEntity) {
			op.body = '''
				javax.persistence.EntityManager em = emf.createEntityManager();
				javax.persistence.EntityTransaction txn = em.getTransaction();
				
				try {
					«service.dto.wrappedEntity.toQualifiedName» entity = em.find(«service.dto.wrappedEntity.toQualifiedName».class, dto.«service.dto.idAttribute?.toGetterName»());
					mapper.mapToEntity(dto, entity);
					em.persist(entity);
				
					txn.commit();
					txn = null;
				}finally{
					if(txn != null){
						txn.rollback();
					}
					em.close();
				}
			'''
//		} else if(service.updateExpression != null) {
//			op.body = service.updateExpression
		} else{
			op.body = '''throw new UnsupportedOperationException();'''
		}

		return associate(service, op);
	}

	def JvmOperation toDeleteMethod(LDTOService service) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, service)
		op.simpleName = 'delete'
		op.parameters += service.toParameter('dto', service.getDto().toTypeReference)
		op.documentation = '''
			{@inherit doc}
		'''

		if (service.dto.basedOnEntity) {
			op.body = '''
				javax.persistence.EntityManager em = emf.createEntityManager();
				javax.persistence.EntityTransaction txn = em.getTransaction();
				
				try {
					«service.dto.wrappedEntity.toQualifiedName» entity = em.find(«service.dto.wrappedEntity.toQualifiedName».class, dto.«service.dto.idAttribute?.toGetterName»());
					em.remove(entity);
				
					txn.commit();
					txn = null;
				}finally{
					if(txn != null){
						txn.rollback();
					}
					em.close();
				}
			'''
//		} else if(service.deleteExpression != null) {
//			op.body = service.deleteExpression
		} else{
			op.body = '''throw new UnsupportedOperationException();'''
		}

		return associate(service, op);
	}

	/**
	 * shorthand for <code>toSetter(sourceElement, name, name, typeRef)</code>
	 */
	def JvmOperation toBindService(LInjectedService sourceElement, String name, JvmTypeReference typeRef) {
		return toBindService(sourceElement, name, name, typeRef);
	}

	/**
	 * Creates a setter method for the given properties name with the standard implementation assigning the passed
	 * parameter to a similarly named field.
	 * 
	 * Example: <code>
	 * public void setFoo(String foo) {
	 *   this.foo = foo;
	 * }
	 * </code>
	 *
	 * @return a setter method for a JavaBeans property with the given name, <code>null</code> if sourceElement or name are <code>null</code>.
	 */
	def JvmOperation toBindService(LInjectedService sourceElement, String propertyName, String fieldName,
		JvmTypeReference typeRef) {
		if (sourceElement == null || propertyName == null || fieldName == null)
			return null;
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility.PROTECTED;
		result.returnType = references.getTypeForName(Void.TYPE, sourceElement)
		result.simpleName = "bind" + Strings.toFirstUpper(propertyName)
		result.parameters += sourceElement.toParameter(propertyName, cloneWithProxies(typeRef));

		result.body = '''this.«fieldName» = «propertyName»;'''
		result.documentation = '''
		Binds the service {@link «typeRef.qualifiedName.toString»} to this component. 
		<br>The cardinality is «sourceElement.cardinality.getName()»
		
		@param «propertyName» the service'''
		return associate(sourceElement, result);
	}

	/**
	 * shorthand for <code>toSetter(sourceElement, name, name, typeRef)</code>
	 */
	def JvmOperation toUnbindService(LInjectedService sourceElement, String name, JvmTypeReference typeRef) {
		return toUnbindService(sourceElement, name, name, typeRef);
	}

	/**
	 * Creates a setter method for the given properties name with the standard implementation assigning the passed
	 * parameter to a similarly named field.
	 * 
	 * Example: <code>
	 * public void setFoo(String foo) {
	 *   this.foo = foo;
	 * }
	 * </code>
	 *
	 * @return a setter method for a JavaBeans property with the given name, <code>null</code> if sourceElement or name are <code>null</code>.
	 */
	def JvmOperation toUnbindService(LInjectedService sourceElement, String propertyName, String fieldName,
		JvmTypeReference typeRef) {
		if (sourceElement == null || propertyName == null || fieldName == null)
			return null;
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility.PROTECTED;
		result.returnType = references.getTypeForName(Void.TYPE, sourceElement)
		result.simpleName = "unbind" + Strings.toFirstUpper(propertyName)
		result.parameters += sourceElement.toParameter(propertyName, cloneWithProxies(typeRef));

		result.body = '''this.«fieldName» = null;'''

		result.documentation = '''
		Unbinds the service from this component. 
		<br>The cardinality is «sourceElement.cardinality.getName()»
		
		@param «propertyName» the service'''

		return associate(sourceElement, result);
	}

	/**
	 * shorthand for <code>toSetter(sourceElement, name, name, typeRef)</code>
	 */
	def JvmOperation toAddService(LInjectedService sourceElement, String name, JvmTypeReference typeRef) {
		return toAddService(sourceElement, name, name, typeRef);
	}

	/**
	 * Creates a setter method for the given properties name with the standard implementation assigning the passed
	 * parameter to a similarly named field.
	 * 
	 * Example: <code>
	 * public void setFoo(String foo) {
	 *   this.foo = foo;
	 * }
	 * </code>
	 *
	 * @return a setter method for a JavaBeans property with the given name, <code>null</code> if sourceElement or name are <code>null</code>.
	 */
	def JvmOperation toAddService(LInjectedService sourceElement, String propertyName, String fieldName,
		JvmTypeReference typeRef) {
		if (sourceElement == null || propertyName == null || fieldName == null)
			return null;
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility.PROTECTED;
		result.returnType = references.getTypeForName(Void.TYPE, sourceElement)
		result.simpleName = "add" + Strings.toFirstUpper(propertyName)
		result.parameters += sourceElement.toParameter(propertyName, cloneWithProxies(typeRef));

		result.body = '''
			if(this.«fieldName» == null) {
				this.«fieldName» = new java.util.HashSet<>();
			}
			
			if(!this.«fieldName».contains(«propertyName»)) {
				this.«fieldName».add(«propertyName»);
			}
		'''

		result.documentation = '''
		Adds the service {@link «typeRef.qualifiedName.toString»} to this component. 
		<br>The cardinality is «sourceElement.cardinality.getName()»
		
		@param «propertyName» the service'''

		return associate(sourceElement, result);
	}

	/**
	 * shorthand for <code>toSetter(sourceElement, name, name, typeRef)</code>
	 */
	def JvmOperation toRemoveService(LInjectedService sourceElement, String name, JvmTypeReference typeRef) {
		return toRemoveService(sourceElement, name, name, typeRef);
	}

	/**
	 * Creates a setter method for the given properties name with the standard implementation assigning the passed
	 * parameter to a similarly named field.
	 * 
	 * Example: <code>
	 * public void setFoo(String foo) {
	 *   this.foo = foo;
	 * }
	 * </code>
	 *
	 * @return a setter method for a JavaBeans property with the given name, <code>null</code> if sourceElement or name are <code>null</code>.
	 */
	def JvmOperation toRemoveService(LInjectedService sourceElement, String propertyName, String fieldName,
		JvmTypeReference typeRef) {
		if (sourceElement == null || propertyName == null || fieldName == null)
			return null;
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility.PROTECTED;
		result.returnType = references.getTypeForName(Void.TYPE, sourceElement)
		result.simpleName = "remove" + Strings.toFirstUpper(propertyName)
		result.parameters += sourceElement.toParameter(propertyName, cloneWithProxies(typeRef));

		result.body = '''
		if(this.«fieldName»==null){
			return;
		}
		this.«fieldName».remove(«propertyName»);'''

		result.documentation = '''
		Removes the service {@link «cloneWithProxies(typeRef).qualifiedName»} from this component. 
		<br>The cardinality is «sourceElement.cardinality.getName()»
		
		@param «propertyName» the service'''

		return associate(sourceElement, result);
	}

}
