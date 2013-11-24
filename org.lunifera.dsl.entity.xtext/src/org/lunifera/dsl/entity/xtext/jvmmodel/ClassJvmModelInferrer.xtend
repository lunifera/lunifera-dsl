/**************************************************************************
 * Copyright (c) 2011, 2012 Committers of lunifera.org - Lunifera.org.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 **************************************************************************/
package org.lunifera.dsl.entity.xtext.jvmmodel

import com.google.inject.Inject
import java.util.ArrayList
import java.util.Collections
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.util.Pair
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.eclipse.xtext.xbase.lib.StringExtensions
import org.lunifera.dsl.entity.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.entity.xtext.extensions.TreeAppendableExtensions
import org.lunifera.dsl.entity.xtext.jvmmodel.services.AnnotationCompiler
import org.lunifera.dsl.semantic.common.types.LAnnotationDef
import org.lunifera.dsl.semantic.common.types.LClass
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LPackage
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LBeanFeature
import org.lunifera.dsl.semantic.entity.LBeanReference
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityFeature
import org.lunifera.dsl.semantic.entity.LEntityModel
import org.lunifera.dsl.semantic.entity.LEntityReference
import org.lunifera.dsl.semantic.entity.LOperation

/**
 * Infers a JVM model from {@link LClass} model elements.
 * 
 * @author Robert Handschmann
 */
abstract class ClassJvmModelInferrer {

	@Inject extension IQualifiedNameProvider
	@Inject extension ModelExtensions
	@Inject extension MethodNamingExtensions
	@Inject extension TreeAppendableExtensions
	@Inject extension StringExtensions

	@Inject AnnotationCompiler annotationCompiler
	@Inject TypesFactory typesFactory;
	@Inject TypeReferences references;
	@Inject JvmTypesBuilder jvmTypes;

	def private htmlCode(CharSequence s) {
		"<code>".concat(String::valueOf(s)).concat("</code>")
	}

	/*
     * Methods delegating to JvmTypesBuilder. 
     * (Includes methods copied from JvmTypesBuilder because its visibility is protected.)
     */
	def protected JvmTypeReference newTypeRef(EObject ctx, QualifiedName qn, JvmTypeReference... typeArgs) {
		newTypeRef(ctx, qn.toString, typeArgs)
	}

	def protected JvmTypeReference newTypeRef(EObject ctx, Class<?> typeClass, JvmTypeReference... typeArgs) {
		jvmTypes.newTypeRef(ctx, typeClass.name, typeArgs)
	}

	def protected JvmTypeReference newTypeRef(EObject ctx, String typeName, JvmTypeReference... typeArgs) {
		jvmTypes.newTypeRef(ctx, typeName, typeArgs)
	}

	def protected <T extends EObject> T initializeSafely(T targetElement, Procedure1<? super T> initializer) {
		if (targetElement != null && initializer != null) {

			// need exception handling and logging like JvmTypesBuilder?
			initializer.apply(targetElement)
		}
		return targetElement
	}

	def protected JvmTypeReference cloneWithProxies(JvmTypeReference typeRef) {
		jvmTypes.cloneWithProxies(typeRef)
	}

	def <T extends JvmIdentifiableElement> T associate(EObject sourceElement, T target) {
		jvmTypes.associate(sourceElement, target)
	}

	def setDocumentation(JvmIdentifiableElement jvmElement, CharSequence documentation) {
		jvmTypes.setDocumentation(jvmElement, documentation?.toString)
	}

	def String getDocumentation(EObject source) {
		return jvmTypes.getDocumentation(source)
	}

	def setBody(JvmExecutable executable, Procedure1<ITreeAppendable> strategy) {
		jvmTypes.setBody(executable, strategy)
	}

	def setBody(JvmExecutable logicalContainer, XExpression expr) {
		jvmTypes.setBody(logicalContainer, expr)
	}

	def JvmGenericType createJvmGenericType(EObject sourceElement, String name) {
		if(sourceElement == null || name == null) return null

		val Pair<String, String> fullName = name.splitQualifiedName
		val JvmGenericType result = typesFactory.createJvmGenericType()
		result.simpleName = fullName.second
		if (fullName.first != null) {
			result.packageName = fullName.first
		}
		result.visibility = JvmVisibility::PUBLIC
		return result
	}

	def Pair<String, String> splitQualifiedName(String name) {
		var String simpleName = name
		var String packageName = null
		val int dotIdx = name.lastIndexOf('.');
		if (dotIdx != -1) {
			simpleName = name.substring(dotIdx + 1)
			packageName = name.substring(0, dotIdx)
		}
		return Tuples::create(packageName, simpleName)
	}

	def JvmFormalParameter toParameter(EObject sourceElement, String name, JvmTypeReference typeRef) {
		if (sourceElement == null || name == null)
			return null;
		val JvmFormalParameter result = typesFactory.createJvmFormalParameter()
		result.name = name
		result.parameterType = cloneWithProxies(typeRef)
		associate(sourceElement, result);
	}

	def JvmConstructor toConstructor(EObject sourceElement, Procedure1<? super JvmConstructor> initializer) {
		return jvmTypes.toConstructor(sourceElement, initializer)
	}

	/*
     * END Methods delegating to JvmTypesBuilder.
     */
	def JvmField toField(LFeature prop) {
		val JvmField jvmField = typesFactory.createJvmField();
		jvmField.simpleName = prop.name
		jvmField.visibility = JvmVisibility::PRIVATE
		jvmField.type = cloneWithProxies(prop.toTypeReference)

		val LClass lEntity = prop.eContainer() as LClass
		val LEntityModel lModel = lEntity.getPackage().eContainer() as LEntityModel
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

	def dispatch JvmOperation toDispose(LEntity lClass) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, lClass)
		op.simpleName = "dispose"
		op.documentation = '''
		Calling dispose will destroy that instance. The internal state will be 
		set to 'disposed' and methods of that object must not be used anymore. 
		Each call will result in runtime exceptions.<br/>
		If this object keeps composition containments, these will be disposed too. 
		So the whole composition containment tree will be disposed on calling this method.'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(lClass)
				p >> '''
					if (isDisposed()) {
					  return;
					}
				'''
				val compositionContainmentProps = lClass.features.filter[cascading]
				if (!compositionContainmentProps.empty) {
					p >> "try " >>> "{"
					p >> "// Dispose all the composition references.\n"
					for (prop : compositionContainmentProps) {
						val fieldRef = "this.".concat(prop.name.toFirstLower)
						val typeName = prop.typeName
						val typeVar = typeName.toFirstLower
						if (prop.toMany) {
							p >> '''
								if («fieldRef» != null) {
								  for («typeName» «typeVar» : «fieldRef») {
								    «typeVar».dispose();
								  }
								  «fieldRef» = null;
								}
							'''
						} else {
							p >> '''
								if («fieldRef» != null) {
								  «fieldRef».dispose();
								  «fieldRef» = null;
								}
							'''
						}
					}
					p <<< "}"
					p >>> "finally {"

				//p.increaseIndentation
				}
				if (lClass.superType != null) {
					p >> "super.dispose();"
				} else {
					p >> "disposed = true;"
				}
				if (!compositionContainmentProps.empty) {
					p <<< "}"
				}
			])

		associate(lClass, op)
	}

	def dispatch JvmOperation toDispose(LBean lClass) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, lClass)
		op.simpleName = "dispose"
		op.documentation = '''
		Calling dispose will destroy that instance. The internal state will be 
		set to 'disposed' and methods of that object must not be used anymore. 
		Each call will result in runtime exceptions.<br/>
		If this object keeps composition containments, these will be disposed too. 
		So the whole composition containment tree will be disposed on calling this method.'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(lClass)
				p >> '''
					if (isDisposed()) {
					  return;
					}
				'''
				val compositionContainmentProps = lClass.features.filter[cascading]
				if (!compositionContainmentProps.empty) {
					p >> "try " >>> "{"
					p >> "// Dispose all the composition references.\n"
					for (prop : compositionContainmentProps) {
						val fieldRef = "this.".concat(prop.name.toFirstLower)
						val typeName = prop.typeName
						val typeVar = typeName.toFirstLower
						if (prop.toMany) {
							p >> '''
								if («fieldRef» != null) {
								  for («typeName» «typeVar» : «fieldRef») {
								    «typeVar».dispose();
								  }
								  «fieldRef» = null;
								}
							'''
						} else {
							p >> '''
								if («fieldRef» != null) {
								  «fieldRef».dispose();
								  «fieldRef» = null;
								}
							'''
						}
					}
					p <<< "}"
					p >>> "finally {"

				//p.increaseIndentation
				}
				if (lClass.superType != null) {
					p >> "super.dispose();"
				} else {
					p >> "disposed = true;"
				}
				if (!compositionContainmentProps.empty) {
					p <<< "}"
				}
			])

		associate(lClass, op)
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
		val propertyName = prop.name
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = methodName
		op.returnType = cloneWithProxies(typeRef)
		op.documentation = if (prop.toMany) {
			"Returns an unmodifiable list of " + propertyName + "."
		} else {
			"Returns the ".concat((if(prop.entityBounds.required) "<em>required</em> " else "")).concat(propertyName).
				concat(" property").concat(
					(if(!prop.entityBounds.required) " or <code>null</code> if not present" else "")).concat(".")
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
		return a.concat(b);
	}

	def JvmOperation toSetter(LEntityFeature prop) {
		if (prop.toMany) {
			throw new RuntimeException("toMany-References not allowed for setters!");
		}
		val paramName = prop.toMethodParamName
		val typeRef = prop.toTypeReference
		val opposite = if(prop instanceof LEntityReference) prop.resolvedOpposite else null
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toSetterName
		op.parameters += prop.toParameter(paramName, typeRef)
		op.documentation = "Sets the " + paramName + " property to this instance." + if (opposite != null) {
			"\nSince the reference is a container reference, the opposite reference " + "(" + prop.typeName + "." +
				opposite.name.toFirstLower + ")\n" + "of the " + paramName +
				" will be handled automatically and no further coding is required to keep them in sync.\n" +
				"See {@link " + prop.typeName + "#" + opposite.toSetterName + "(" + prop.typeName + ")}."
		} else
			""

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCheckDisposedCall()
				val fieldRef = "this." + prop.name
				if (opposite == null) {
					p >> fieldRef + " = " + paramName + ";"
				} else {
					p >> "if (" + fieldRef + " != null) " >>> "{"
					if (opposite.toMany) {
						p >> fieldRef + "." + opposite.toCollectionInternalRemoverName + "(this);"
					} else {
						p >> fieldRef + "." + opposite.toInternalSetterName + "(null);"
					}
					p <<< "}"
					p >> fieldRef + " = " + paramName + ";\n"
					p >> "if (" + fieldRef + " != null) " >>> "{"
					if (opposite.toMany) {
						p >> fieldRef + "." + opposite.toCollectionInternalAdderName + "(this);"
					} else {
						p >> fieldRef + "." + opposite.toInternalSetterName + "(this);"
					}
					p <<< "}"

				//                if (this.«fieldName» != null) {
				//                  «IF ref.opposite.toMany»
				//                    this.«fieldName».«ref.opposite.toCollectionInternalRemoverName»(this);
				//                  «ELSE»
				//                    this.«fieldName».«ref.opposite.toInternalSetterName»(null);
				//                  «ENDIF»
				//                }
				//                this.«fieldName» = «localVarName»;
				//                if (this.«fieldName» != null) {
				//                  «IF ref.opposite.toMany»
				//                    this.«fieldName».«ref.opposite.toCollectionInternalAdderName»(this);
				//                  «ELSE»
				//                    this.«fieldName».«ref.opposite.toInternalSetterName»(this);
				//                  «ENDIF»
				//                }
				}
			])

		return associate(prop, op);
	}

	def JvmOperation toSetter(LBeanFeature prop) {
		if (prop.toMany) {
			throw new RuntimeException("toMany-References not allowed for setters!");
		}
		val paramName = prop.toMethodParamName
		val typeRef = prop.toTypeReference
		val opposite = if(prop instanceof LBeanReference) prop.resolvedOpposite else null
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toSetterName
		op.parameters += prop.toParameter(paramName, typeRef)
		op.documentation = "Sets the " + paramName + " property to this instance." + if (opposite != null) {
			"\nSince the reference is a container reference, the opposite reference " + "(" + prop.typeName + "." +
				opposite.name.toFirstLower + ")\n" + "of the " + paramName +
				" will be handled automatically and no further coding is required to keep them in sync.\n" +
				"See {@link " + prop.typeName + "#" + opposite.toSetterName + "(" + prop.typeName + ")}."
		} else
			""

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCheckDisposedCall()
				val fieldRef = "this." + prop.name
				if (opposite == null) {
					p >> fieldRef + " = " + paramName + ";"
				} else {
					p >> "if (" + fieldRef + " != null) " >>> "{"
					if (opposite.toMany) {
						p >> fieldRef + "." + opposite.toCollectionInternalRemoverName + "(this);"
					} else {
						p >> fieldRef + "." + opposite.toInternalSetterName + "(null);"
					}
					p <<< "}"
					p >> fieldRef + " = " + paramName + ";\n"
					p >> "if (" + fieldRef + " != null) " >>> "{"
					if (opposite.toMany) {
						p >> fieldRef + "." + opposite.toCollectionInternalAdderName + "(this);"
					} else {
						p >> fieldRef + "." + opposite.toInternalSetterName + "(this);"
					}
					p <<< "}"

				//                if (this.«fieldName» != null) {
				//                  «IF ref.opposite.toMany»
				//                    this.«fieldName».«ref.opposite.toCollectionInternalRemoverName»(this);
				//                  «ELSE»
				//                    this.«fieldName».«ref.opposite.toInternalSetterName»(null);
				//                  «ENDIF»
				//                }
				//                this.«fieldName» = «localVarName»;
				//                if (this.«fieldName» != null) {
				//                  «IF ref.opposite.toMany»
				//                    this.«fieldName».«ref.opposite.toCollectionInternalAdderName»(this);
				//                  «ELSE»
				//                    this.«fieldName».«ref.opposite.toInternalSetterName»(this);
				//                  «ENDIF»
				//                }
				}
			])

		return associate(prop, op);
	}

	/**
     * Builds an adder method for a *toMany relation like
     * <code>Order.addToOrderLines(OrderLine orderLine)</code>.
     */
	def dispatch JvmOperation toAdder(LEntityFeature prop, String propertyName) {
		val paramName = prop.typeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionAdderName
		if (prop.type.toTypeReference != null) {
			op.parameters += prop.toParameter(paramName, prop.type.toTypeReference)
		}

		op.documentation = '''
		Adds the given «paramName» to this object. <p>
		«IF prop.opposite != null»
			Since the reference is a composition reference, the opposite reference («prop.typeName».«prop.opposite.name.
			toFirstLower»)
			of the «paramName» will be handled automatically and no further coding is required to keep them in sync. 
			See {@link «prop.typeName»#«prop.opposite.toSetterName»(«prop.typeName»)}.
		«ELSE»
			ATTENTION:<br>
			The reference is a composition reference, but no opposite is available.
			So the opposite will NOT be handled. Therefore you have to ensure that the parent of the reference
			is set properly.
		«ENDIF»'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p += prop.toCheckDisposedCall()
				if (prop.opposite != null) {
					p >> paramName + "." + prop.opposite.toSetterName + "(this);"
				} else {
					p >> "if (!" + prop.toGetterName + "().contains(" + paramName + "))" >>> "{"
					{
						p >> prop.toGetterName + "().add(" + paramName + ");"
					}
					p <<< "}"
				}
			])
		return associate(prop, op);
	}

	/**
     * Builds an adder method for a *toMany relation like
     * <code>Order.addToOrderLines(OrderLine orderLine)</code>.
     */
	def dispatch JvmOperation toAdder(LBeanFeature prop, String propertyName) {
		val paramName = prop.typeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionAdderName
		if (prop.type.toTypeReference != null) {
			op.parameters += prop.toParameter(paramName, prop.type.toTypeReference)
		}

		op.documentation = '''
		Adds the given «paramName» to this object. <p>
		«IF prop.opposite != null»
			Since the reference is a composition reference, the opposite reference («prop.typeName».«prop.opposite.name.
			toFirstLower»)
			of the «paramName» will be handled automatically and no further coding is required to keep them in sync. 
			See {@link «prop.typeName»#«prop.opposite.toSetterName»(«prop.typeName»)}.
		«ELSE»
			ATTENTION:<br>
			The reference is a composition reference, but no opposite is available.
			So the opposite will NOT be handled. Therefore you have to ensure that the parent of the reference
			is set properly.
		«ENDIF»'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p += prop.toCheckDisposedCall()
				if (prop.opposite != null) {
					p >> paramName + "." + prop.opposite.toSetterName + "(this);"
				} else {
					p >> "if (!" + prop.toGetterName + "().contains(" + paramName + "))" >>> "{"
					{
						p >> prop.toGetterName + "().add(" + paramName + ");"
					}
					p <<< "}"
				}
			])
		return associate(prop, op);
	}

	def JvmVisibility getInternalMethodVisibility(LFeature ref) {
		val LPackage ownerPackage = (ref.eContainer() as LType).package;
		val LPackage refPackage = ref.type.package;
		if (ownerPackage.equals(refPackage)) {
			null // package visibility
		} else {
			JvmVisibility::PUBLIC
		}
	}

	def JvmOperation toInternalSetter(LFeature prop) {
		val paramName = prop.toMethodParamName
		val typeRef = prop.type.toTypeReference
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = getInternalMethodVisibility(prop)
		result.returnType = references.getTypeForName(Void::TYPE, prop)
		result.simpleName = prop.toInternalSetterName
		result.parameters += prop.toParameter(paramName, typeRef)

		setBody(result,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop)
				p >> "this." + prop.name + " = " + paramName + ";"
			])
		return associate(prop, result);
	}

	def JvmOperation toInternalAdder(LFeature prop) {
		val paramName = prop.typeName.toFirstLower
		val typeRef = prop.type.toTypeReference
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = getInternalMethodVisibility(prop)
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionInternalAdderName

		val param = prop.toParameter(paramName, typeRef);
		if (param != null) {
			op.parameters += param
		}

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCollectionInternalGetterName + "()" + ".add(" + paramName + ");"
			])
		return associate(prop, op);
	}

	def JvmOperation toInternalRemover(LFeature prop) {
		val paramName = prop.typeName.toFirstLower
		val typeRef = prop.type.toTypeReference
		val op = typesFactory.createJvmOperation();
		op.visibility = getInternalMethodVisibility(prop)
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionInternalRemoverName

		val param = prop.toParameter(paramName, typeRef);
		if (param != null) {
			op.parameters += param
		}

		setBody(op,
			[ //ITreeAppendable
				if(it == null) return
				val p = it.trace(prop)
				p >> prop.toCollectionInternalGetterName + "()" + ".remove(" + paramName + ");"
			])
		return associate(prop, op)
	}

	def JvmOperation toInternalCollectionGetter(LFeature prop, String name) {
		val fieldName = name.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation()
		op.visibility = JvmVisibility::PRIVATE
		op.returnType = prop.toTypeReference
		op.simpleName = prop.toCollectionInternalGetterName
		op.documentation = "Returns the list of " + htmlCode(prop.typeName) + "s thereby lazy initializing it."
		setBody(op,
			[ // ITreeAppendable
				if(it == null) return;
				var p = it.trace(prop);
				val fieldRef = "this." + fieldName
				p >> "if (" + fieldRef + " == null)" >>> " {"
				{
					p >> fieldRef >> " = new " >> newTypeRef(prop, typeof(ArrayList), prop.type.toTypeReference) >>
						"();"
				}
				p <<< "}"
				p >> "return " + fieldRef + ";"
			])
		prop.associate(op)
	}

	/**
     * Builds a remover method for a *toMany relation like
     * <code>Order.removeFromOrderLines(OrderLine orderLine)</code>.
     */
	def JvmOperation toRemover(LFeature prop, String propertyName) {
		val paramName = prop.typeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionRemoverName
		if (prop.type.toTypeReference != null) {
			op.parameters += prop.toParameter(paramName, prop.type.toTypeReference)
		}
		if (prop.opposite != null) {
			op.documentation = '''
			Removes the given «paramName» from this object. <p>
			«IF prop.cascading»
				Since the reference is a cascading reference, the opposite reference («prop.typeName».«prop.opposite.name.
				toFirstLower»)
				of the «paramName» will be handled automatically and no further coding is required to keep them in sync. 
				See {@link «prop.typeName»#«prop.opposite.toSetterName»(«prop.typeName»)}.
			«ENDIF»'''
		}
		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p += prop.toCheckDisposedCall()
				if (prop.opposite != null) {
					p >> paramName + "." + prop.opposite.toSetterName + "(null);"
				} else {
					p >> prop.toGetterName + "().remove(" + paramName + ");"
				}
			])
		return associate(prop, op);
	}

	def JvmField toPrimitiveTypeField(EObject sourceElement, String name, Class<?> primitiveType) {
		val typeRef = newTypeRef(sourceElement, primitiveType, null)
		val JvmField result = typesFactory.createJvmField();
		result.simpleName = name
		result.visibility = JvmVisibility::PRIVATE
		result.type = cloneWithProxies(typeRef)
		associate(sourceElement, result)
	}

	def void translateAnnotationDefTo(LAnnotationDef annotationDef, JvmAnnotationTarget target) {
		if (annotationDef == null || target == null)
			return
		val annotationReference = jvmTypes.getJvmAnnotationReference(annotationDef.getAnnotation())
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
