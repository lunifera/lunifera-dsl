package org.lunifera.dsl.services.xtext.extensions

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.jdt.annotation.Nullable
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
import org.lunifera.dsl.service.lib.IFilter
import org.lunifera.dsl.service.lib.ISortOrder
import org.eclipse.xtext.EcoreUtil2

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

		setBody(op, '''return null;''')

		return associate(service, op);
	}

	def JvmOperation toFindMethod(LDTOService service) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(typeof(Collection), service, service.getDto().toTypeReference)
		op.simpleName = 'find'
		op.parameters += service.toParameter('filter', references.getTypeForName(typeof(IFilter), service))
		op.parameters += service.toParameter('sortorder', references.getTypeForName(typeof(ISortOrder), service))
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
		op.parameters += service.toParameter('filter', references.getTypeForName(typeof(IFilter), service))
		op.parameters += service.toParameter('sortorder', references.getTypeForName(typeof(ISortOrder), service))
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

		setBody(op, '''''')

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

		setBody(op, '''''')

		return associate(service, op);
	}

	/**
	 * shorthand for <code>toSetter(sourceElement, name, name, typeRef)</code>
	 */
	def JvmOperation toBindService(LInjectedService sourceElement, String name, @Nullable JvmTypeReference typeRef) {
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
		result.visibility = JvmVisibility.PUBLIC;
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
	def JvmOperation toUnbindService(LInjectedService sourceElement, String name, @Nullable JvmTypeReference typeRef) {
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
		result.visibility = JvmVisibility.PUBLIC;
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
	def JvmOperation toAddService(LInjectedService sourceElement, String name, @Nullable JvmTypeReference typeRef) {
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
	def JvmOperation toAddService(LInjectedService sourceElement, String propertyName, String fieldName,
		JvmTypeReference typeRef) {
		if (sourceElement == null || propertyName == null || fieldName == null)
			return null;
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility.PUBLIC;
		result.returnType = references.getTypeForName(Void.TYPE, sourceElement)
		result.simpleName = "add" + Strings.toFirstUpper(propertyName)
		result.parameters += sourceElement.toParameter(propertyName, cloneWithProxies(typeRef));

		result.body = '''if(!this.«fieldName».contains(«propertyName»){
			this.«fieldName».add(«propertyName»);	
		} 
		'''

		result.documentation = '''
			Adds the service {@link «typeRef.qualifiedName.toString»} from this component. 
			<br>The cardinality is «sourceElement.cardinality.getName()»
			
			@param «propertyName» the service'''

		return associate(sourceElement, result);
	}

	/**
	 * shorthand for <code>toSetter(sourceElement, name, name, typeRef)</code>
	 */
	def JvmOperation toRemoveService(LInjectedService sourceElement, String name, @Nullable JvmTypeReference typeRef) {
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
	def JvmOperation toRemoveService(LInjectedService sourceElement, String propertyName, String fieldName,
		JvmTypeReference typeRef) {
		if (sourceElement == null || propertyName == null || fieldName == null)
			return null;
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility.PUBLIC;
		result.returnType = references.getTypeForName(Void.TYPE, sourceElement)
		result.simpleName = "remove" + Strings.toFirstUpper(propertyName)
		result.parameters += sourceElement.toParameter(propertyName, cloneWithProxies(typeRef));

		result.body = '''this.«fieldName».remove(«propertyName»);'''

		result.documentation = '''
			Removes the service {@link «typeRef.qualifiedName.toString»} from this component. 
			<br>The cardinality is «sourceElement.cardinality.getName()»
			
			@param «propertyName» the service'''

		return associate(sourceElement, result);
	}

}
