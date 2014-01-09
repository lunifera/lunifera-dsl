package org.lunifera.dsl.entity.xtext.extensions

import com.google.inject.Inject
import java.util.ArrayList
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.lunifera.dsl.common.xtext.extensions.TreeAppendableExtensions
import org.lunifera.dsl.common.xtext.jvmmodel.CommonTypesBuilder
import org.lunifera.dsl.entity.xtext.jvmmodel.AnnotationCompiler
import org.lunifera.dsl.semantic.common.types.LClass
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LPackage
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LBeanFeature
import org.lunifera.dsl.semantic.entity.LBeanReference
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityFeature
import org.lunifera.dsl.semantic.entity.LEntityReference
import org.lunifera.dsl.semantic.entity.LOperation

class EntityTypesBuilder extends CommonTypesBuilder {

	@Inject extension ModelExtensions
	@Inject extension NamingExtensions
	@Inject extension TreeAppendableExtensions

	@Inject AnnotationCompiler annotationCompiler
	@Inject TypesFactory typesFactory;
	@Inject TypeReferences references;

	JvmField field

	def htmlCode(CharSequence s) {
		"<code>".concat(String::valueOf(s)).concat("</code>")
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

	override JvmField toField(LFeature prop) {
		prop.internalToField
	}
	
	def dispatch JvmField internalToField(LBeanFeature prop) {
		val JvmField jvmField = typesFactory.createJvmField();
		jvmField.simpleName = prop.toName
		jvmField.visibility = JvmVisibility::PRIVATE
		jvmField.type = cloneWithProxies(prop.toTypeReference)

		annotationCompiler.processAnnotation(prop, jvmField);
		associate(prop, jvmField);
	}
	
	def dispatch JvmField internalToField(LEntityFeature prop) {
		val LEntity entity = prop.entity
		val JvmField jvmField = typesFactory.createJvmField();
		jvmField.simpleName = prop.toName
		jvmField.visibility = JvmVisibility::PRIVATE
		jvmField.type = cloneWithProxies(prop.toTypeReference)
		jvmField.documentation = prop.getDocumentation
		// if uuid or historized entity and property name == oid AND a uuid property is present too
		if (prop.isUUID || (entity.timedependent && prop.name.equals(Constants::PROP__OID) && entity.uuidPresent)) {
			jvmField.setInitializer [
				if(it == null) return
				val p = it.trace(prop)
				p >> '''java.util.UUID.randomUUID().toString()'''
			]
		}

		annotationCompiler.processAnnotation(prop, jvmField);
		associate(prop, jvmField);
	}
	
	def boolean uuidPresent(LEntity entity){
		entity.allAttributes.exists[it.uuid]
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

	def JvmOperation toSetter(LEntityFeature prop) {
		if (prop.toMany) {
			throw new RuntimeException("toMany-References not allowed for setters!");
		}
		val paramName = prop.toMethodParamName
		val typeRef = prop.toTypeReference
		val opposite = if(prop instanceof LEntityReference) (prop as LEntityReference).resolvedOpposite else null
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
				val fieldRef = "this." + prop.toName
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
		val opposite = if(prop instanceof LBeanReference) (prop as LBeanReference).resolvedOpposite else null
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
				val fieldRef = "this." + prop.toName
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
					p >> "if (!" + prop.toCollectionInternalGetterName + "().contains(" + paramName + "))" >>> "{"
					{
						p >> prop.toCollectionInternalGetterName + "().add(" + paramName + ");"
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

	override JvmOperation toIsDisposed(LClass lClass) {
		val op = super.toIsDisposed(lClass)
		annotationCompiler.addDisposeFieldAnnotation(lClass, op)
		return op
	}

	def JvmField toDiposeField(LType sourceElement) {
		val JvmField field = sourceElement.toPrimitiveTypeField("disposed", Boolean::TYPE)
		associate(sourceElement, field)
		annotationCompiler.addDisposeFieldAnnotation(sourceElement, field)
		return field
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

}
