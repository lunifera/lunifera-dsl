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
package org.lunifera.dsl.common.xtext.jvmmodel

import com.google.inject.Inject
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.util.Collections
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.lunifera.dsl.common.xtext.extensions.ModelExtensions
import org.lunifera.dsl.common.xtext.extensions.NamingExtensions
import org.lunifera.dsl.common.xtext.extensions.TreeAppendableExtensions
import org.lunifera.dsl.semantic.common.types.LAnnotationDef
import org.lunifera.dsl.semantic.common.types.LClass
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LOperation

class CommonTypesBuilder extends JvmTypesBuilder {
	@Inject extension IQualifiedNameProvider
	@Inject extension ModelExtensions
	@Inject extension NamingExtensions
	@Inject extension TreeAppendableExtensions

	@Inject AnnotationCompiler annotationCompiler
	@Inject TypesFactory typesFactory;
	@Inject TypeReferences references;

	/*
     * Methods delegating to JvmTypesBuilder. 
     * (Includes methods copied from JvmTypesBuilder because its visibility is protected.)
     */
	def JvmTypeReference newTypeRef(EObject ctx, QualifiedName qn, JvmTypeReference... typeArgs) {
		newTypeRef(ctx, qn.toString, typeArgs)
	}

	def override JvmTypeReference newTypeRef(EObject ctx, Class<?> typeClass, JvmTypeReference... typeArgs) {
		super.newTypeRef(ctx, typeClass.name, typeArgs)
	}

	def override JvmTypeReference newTypeRef(EObject ctx, String typeName, JvmTypeReference... typeArgs) {
		super.newTypeRef(ctx, typeName, typeArgs)
	}

	def setDocumentation(JvmIdentifiableElement jvmElement, CharSequence documentation) {
		super.setDocumentation(jvmElement, documentation?.toString)
	}

	def JvmField toField(LFeature prop) {
		val JvmField jvmField = typesFactory.createJvmField();
		jvmField.simpleName = prop.toName
		jvmField.visibility = JvmVisibility::PRIVATE
		jvmField.type = cloneWithProxies(prop.toTypeReference)

		annotationCompiler.processAnnotation(prop, jvmField);
		associate(prop, jvmField);
	}

	def JvmOperation toIsDisposed(LClass sourceElement) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = "isDisposed"
		op.returnType = references.getTypeForName(Boolean::TYPE, sourceElement, null)

		op.documentation = '''
		Returns true, if the object is disposed. 
		Disposed means, that it is prepared for garbage collection and may not be used anymore. 
		Accessing objects that are already disposed will cause runtime exceptions.'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(sourceElement)
				p >> "return this.disposed;"
			])

		associate(sourceElement, op)
	}

	def JvmOperation toCheckDisposed(LClass sourceElement) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PRIVATE
		op.returnType = references.getTypeForName(Void::TYPE, sourceElement)
		op.simpleName = "checkDisposed"
		op.documentation = '''
		Checks whether the object is disposed.
		@throws RuntimeException if the object is disposed.'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(sourceElement)
				p >> '''
				if (isDisposed()) {
				  throw new RuntimeException("Object already disposed: " + this);
				}'''
			])

		associate(sourceElement, op)
	}

	def String toCheckDisposedCall(LFeature prop) {

		// TODO Retrieve the settings from the LFeature
		return "checkDisposed();\n"
	}

	def JvmOperation toMethod(LOperation sourceElement, String name, JvmTypeReference returnType,
		Procedure1<? super JvmOperation> initializer) {
		val op = typesFactory.createJvmOperation()
		op.simpleName = name
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = cloneWithProxies(returnType)

		annotationCompiler.processAnnotation(sourceElement, op);
		associate(sourceElement, op);
		initializeSafely(op, initializer);
	}

	def JvmOperation toGetter(LFeature prop) {
		prop.toGetter(prop.toGetterName)
	}

	def JvmOperation toGetter(LFeature prop, String methodName) {
		val typeRef = prop.toTypeReference
		val propertyName = prop.toName
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = methodName
		op.returnType = cloneWithProxies(typeRef)
		op.documentation = if (prop.toMany) {
			"Returns an unmodifiable list of " + propertyName + "."
		} else if (propertyName != null) {
			"Returns the ".concat((if(prop.bounds.required) "<em>required</em> " else "")).concat(propertyName).
				concat(" property").concat(
					(if(!prop.bounds.required) " or <code>null</code> if not present" else "")).concat(".")
		}

		setBody(op,
			[ // ITreeAppendable it |
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCheckDisposedCall()
				if (prop.toMany) {
					p >> "return " >> newTypeRef(prop, typeof(Collections)) >> ".unmodifiableList" >>
						"(" + prop.toCollectionInternalGetterName + "());"
				} else {
					p >> "return this." + propertyName + ";"
				}
			])

		return associate(prop, op);
	}

	/**
	 * The binary <code>+</code> operator that concatenates two strings.
	 * 
	 * @param a
	 *            a string.
	 * @param b
	 *            another string.
	 * @return <code>a + b</code>
	 */
	def static String operator_plus(String a, String b) {
		if (b == null) {
			return a
		}
		return a.concat(b);
	}

	def JvmField toPrimitiveTypeField(EObject sourceElement, String name, Class<?> primitiveType) {
		val typeRef = newTypeRef(sourceElement, primitiveType, null)
		val JvmField result = typesFactory.createJvmField();
		result.simpleName = name
		result.visibility = JvmVisibility::PRIVATE
		result.type = cloneWithProxies(typeRef)
		associate(sourceElement, result)
	}

	def JvmField toPropertyChangeSupportField(EObject sourceElement) {
		val typeRef = newTypeRef(sourceElement, typeof(PropertyChangeSupport), null)
		val JvmField result = typesFactory.createJvmField();
		result.simpleName = "propertyChangeSupport"
		result.visibility = JvmVisibility::PRIVATE
		result.type = cloneWithProxies(typeRef)
		result.setInitializer [ // ITreeAppendable
			if(it == null) return
			val p = it.trace(sourceElement)
			p >> '''new PropertyChangeSupport(this)'''
		]
		associate(sourceElement, result)
	}

	def JvmOperation toAddPropertyChangeListener(LClass sourceElement) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = "addPropertyChangeListener"
		op.returnType = references.getTypeForName(Void::TYPE, sourceElement, null)
		val parameterRef = references.getTypeForName(typeof(PropertyChangeListener), sourceElement, null)
		op.parameters += sourceElement.toParameter("listener", parameterRef)

		op.documentation = '''
		@see PropertyChangeSupport#addPropertyChangeListener(PropertyChangeListener)'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(sourceElement)
				p >> "propertyChangeSupport.addPropertyChangeListener(listener);"
			])

		associate(sourceElement, op)
	}

	def JvmOperation toAddPropertyChangeListenerWithProperty(LClass sourceElement) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = "addPropertyChangeListener"
		op.returnType = references.getTypeForName(Void::TYPE, sourceElement, null)
		op.parameters +=
			sourceElement.toParameter("propertyName", references.getTypeForName(typeof(String), sourceElement, null))
		op.parameters += sourceElement.toParameter("listener",
			references.getTypeForName(typeof(PropertyChangeListener), sourceElement, null))

		op.documentation = '''
		@see PropertyChangeSupport#addPropertyChangeListener(String, PropertyChangeListener)'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(sourceElement)
				p >> "propertyChangeSupport.addPropertyChangeListener(propertyName, listener);"
			])

		associate(sourceElement, op)
	}

	def JvmOperation toRemovePropertyChangeListener(LClass sourceElement) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = "removePropertyChangeListener"
		op.returnType = references.getTypeForName(Void::TYPE, sourceElement, null)
		val parameterRef = references.getTypeForName(typeof(PropertyChangeListener), sourceElement, null)
		op.parameters += sourceElement.toParameter("listener", parameterRef)

		op.documentation = '''
		@see PropertyChangeSupport#removePropertyChangeListener(PropertyChangeListener)'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(sourceElement)
				p >> "propertyChangeSupport.removePropertyChangeListener(listener);"
			])

		associate(sourceElement, op)
	}

	def JvmOperation toRemovePropertyChangeListenerWithProperty(LClass sourceElement) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = "removePropertyChangeListener"
		op.returnType = references.getTypeForName(Void::TYPE, sourceElement, null)
		op.parameters +=
			sourceElement.toParameter("propertyName", references.getTypeForName(typeof(String), sourceElement, null))
		op.parameters += sourceElement.toParameter("listener",
			references.getTypeForName(typeof(PropertyChangeListener), sourceElement, null))

		op.documentation = '''
		@see PropertyChangeSupport#removePropertyChangeListener(String, PropertyChangeListener)'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(sourceElement)
				p >> "propertyChangeSupport.removePropertyChangeListener(propertyName, listener);"
			])

		associate(sourceElement, op)
	}

	def JvmOperation toFirePropertyChange(LClass sourceElement) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = "firePropertyChange"
		op.returnType = references.getTypeForName(Void::TYPE, sourceElement, null)
		op.parameters +=
			sourceElement.toParameter("propertyName", references.getTypeForName(typeof(String), sourceElement, null))
		op.parameters += sourceElement.toParameter("oldValue",
			references.getTypeForName(typeof(Object), sourceElement, null))
		op.parameters += sourceElement.toParameter("newValue",
			references.getTypeForName(typeof(Object), sourceElement, null))

		op.documentation = '''
		@see PropertyChangeSupport#firePropertyChange(String, Object, Object)'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(sourceElement)
				p >> "propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);"
			])

		associate(sourceElement, op)
	}

	def void translateAnnotationDefTo(LAnnotationDef annotationDef, JvmAnnotationTarget target) {
		if (annotationDef == null || target == null)
			return
		val annotationReference = super.getJvmAnnotationReference(annotationDef.getAnnotation())
		if (annotationReference != null) {
			target.annotations += annotationReference
		}
	}

	def JvmGenericType toJvmType(LClass lClass) {
		val type = createJvmGenericType(lClass, lClass.fullyQualifiedName.toString)
		type.setAbstract(lClass.isAbstract());

		annotationCompiler.processAnnotation(lClass, type);

		associate(lClass, type)
	}
}
