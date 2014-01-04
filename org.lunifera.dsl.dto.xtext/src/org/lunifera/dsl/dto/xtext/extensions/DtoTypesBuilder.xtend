package org.lunifera.dsl.dto.xtext.extensions

import com.google.inject.Inject
import java.util.ArrayList
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.lunifera.dsl.common.xtext.extensions.TreeAppendableExtensions
import org.lunifera.dsl.common.xtext.jvmmodel.CommonTypesBuilder
import org.lunifera.dsl.dto.xtext.jvmmodel.AnnotationCompiler
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LPackage
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAttribute
import org.lunifera.dsl.semantic.dto.LDtoFeature
import org.lunifera.dsl.semantic.dto.LDtoReference
import org.lunifera.dsl.semantic.entity.LOperation

class DtoTypesBuilder extends CommonTypesBuilder {

	@Inject extension ModelExtensions
	@Inject extension MethodNamingExtensions
	@Inject extension TreeAppendableExtensions
	@Inject extension IQualifiedNameProvider

	@Inject AnnotationCompiler annotationCompiler
	@Inject TypesFactory typesFactory;
	@Inject TypeReferences references;

	def htmlCode(CharSequence s) {
		"<code>".concat(String::valueOf(s)).concat("</code>")
	}

	def JvmOperation toDispose(LDto lClass) {
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
						val fieldRef = "this.".concat(prop.toName.toFirstLower)
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

	def JvmOperation toSetter(LDtoFeature prop) {
		if (prop.toMany) {
			throw new RuntimeException("toMany-References not allowed for setters!");
		}
		val paramName = prop.toMethodParamName
		val typeRef = prop.toTypeReference
		val opposite = if(prop instanceof LDtoReference) prop.resolvedOpposite else null
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toSetterName
		op.parameters += prop.toParameter(paramName, typeRef)
		if (prop instanceof LDtoReference && !prop.cascading) {
			op.documentation = "Sets the " + paramName +
				" cross reference to this instance. The cross reference contains information how to resolve {@link " +
				prop.toType.fullyQualifiedName.toString + "} using the DTO service. \n" +
				"See {@link org.lunifera.dsl.dto.xtext.common.ICrossReferenceInfo}"
		} else {
			op.documentation = "Sets the " + paramName + " property to this instance." + if (opposite != null) {
				"\nSince the reference is a container reference, the opposite reference " + "(" + prop.typeName + "." +
					opposite.name.toFirstLower + ")\n" + "of the " + paramName +
					" will be handled automatically and no further coding is required to keep them in sync.\n" +
					"See {@link " + prop.typeName + "#" + opposite.toSetterName + "(" + prop.typeName + ")}."
			}
		}

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCheckDisposedCall()
				val fieldRef = "this." + prop.toName
				if (opposite == null || !prop.cascading) {
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
				}
			])

		return associate(prop, op);
	}

	override JvmOperation toGetter(LFeature prop, String methodName) {
		val JvmOperation op = super.toGetter(prop, methodName)

		if (prop instanceof LDtoReference && !prop.cascading) {

			// remove documentation adapters
			op.eAdapters.removeAll(op.eAdapters.filter(typeof(DocumentationAdapter)).toList)

			val LDtoReference ref = prop as LDtoReference
			op.documentation = "Returns the " + prop.toName +
				" cross reference for this instance or <code>null</code> if not available. The cross reference contains information how to resolve {@link " +
				ref.toType.fullyQualifiedName.toString + "} using the DTO service. \n" +
				"See {@link org.lunifera.dsl.dto.xtext.common.ICrossReferenceInfo}"
		}

		return op
	}

	/**
     * Builds an adder method for a *toMany relation like
     * <code>Order.addToOrderLines(OrderLine orderLine)</code>.
     */
	def JvmOperation toAdder(
		LDtoFeature prop,
		String propertyName
	) {

		val paramName = prop.typeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionAdderName
		if (prop.toTypeReference != null) {
			op.parameters += prop.toParameter(paramName, prop.toTypeParameterReference)
		}

		op.documentation = '''
		
		«IF prop.crossReference»
			Adds the cross reference to this object. The cross reference contains information how to resolve {@link 
			«prop.toType.fullyQualifiedName.toString»} using the DTO service.<p>
			See {@link org.lunifera.dsl.dto.xtext.common.ICrossReferenceInfo}
		«ELSE»
			Adds the given «paramName» to this object. <p>
			«IF prop.opposite != null && !prop.crossReference»
				Since the reference is a composition reference, the opposite reference («prop.typeName».«prop.opposite.name.
			toFirstLower»)
				of the «paramName» will be handled automatically and no further coding is required to keep them in sync. 
				See {@link «prop.typeName»#«prop.opposite.toSetterName»(«prop.typeName»)}.
			«ELSE»
				ATTENTION:<br>
				The reference is a composition reference, but no opposite is available.
				So the opposite will NOT be handled. Therefore you have to ensure that the parent of the reference
				is set properly.
			«ENDIF»
		«ENDIF»'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p += prop.toCheckDisposedCall()
				if (prop.opposite != null && !prop.crossReference) {
					p >> paramName + "." + prop.opposite.toSetterName + "(this);"
				} else if (prop.crossReference) {
					p >> "if (!" + prop.toCollectionInternalGetterName + "().contains(" + paramName + "))" >>> "{"
					{
						p >> prop.toCollectionInternalGetterName + "().add(" + paramName + ");"
					}
					p <<< "}"
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

	def JvmVisibility getInternalMethodVisibility(LDtoFeature ref) {
		val LPackage ownerPackage = (ref.eContainer() as LType).package;
		val LPackage refPackage = ref.toType.package;
		if (ownerPackage.equals(refPackage)) {
			null // package visibility
		} else {
			JvmVisibility::PUBLIC
		}
	}

	def dispatch JvmOperation toInternalSetter(LDtoReference prop) {
		val paramName = prop.toMethodParamName
		val typeRef = prop.toTypeReference
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = getInternalMethodVisibility(prop)
		result.returnType = references.getTypeForName(Void::TYPE, prop)
		result.simpleName = prop.toInternalSetterName
		result.parameters += prop.toParameter(paramName, typeRef)

		setBody(result,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop)
				p >> "this." + prop.toName + " = " + paramName + ";"
			])
		return associate(prop, result);
	}

	def dispatch JvmOperation toInternalSetter(LDtoAttribute prop) {
		val paramName = prop.toMethodParamName
		val typeRef = prop.toTypeReference
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = getInternalMethodVisibility(prop)
		result.returnType = references.getTypeForName(Void::TYPE, prop)
		result.simpleName = prop.toInternalSetterName
		result.parameters += prop.toParameter(paramName, typeRef)

		setBody(result,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop)
				p >> "this." + prop.toName + " = " + paramName + ";"
			])
		return associate(prop, result);
	}

	def dispatch JvmOperation toInternalAdder(LDtoReference prop) {
		val paramName = prop.typeName.toFirstLower
		val typeRef = prop.toTypeParameterReference
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

	def dispatch JvmOperation toInternalAdder(LDtoAttribute prop) {
		val paramName = prop.typeName.toFirstLower
		val typeRef = prop.toTypeReference
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

	def dispatch JvmOperation toInternalRemover(LDtoReference prop) {
		val paramName = prop.typeName.toFirstLower
		val typeRef = prop.toTypeParameterReference
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

	def dispatch JvmOperation toInternalRemover(LDtoAttribute prop) {
		val paramName = prop.typeName.toFirstLower
		val typeRef = prop.toTypeParameterReference
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

	def dispatch JvmOperation toInternalCollectionGetter(LDtoReference prop, String name) {
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
					p >> fieldRef >> " = new " >> newTypeRef(prop, typeof(ArrayList), prop.toTypeParameterReference) >>
						"();"
				}
				p <<< "}"
				p >> "return " + fieldRef + ";"
			])
		prop.associate(op)
	}

	def dispatch JvmOperation toInternalCollectionGetter(LDtoAttribute prop, String name) {
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
					p >> fieldRef >> " = new " >> newTypeRef(prop, typeof(ArrayList), prop.toTypeParameterReference) >>
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
	def dispatch JvmOperation toRemover(LDtoReference prop, String propertyName) {
		val paramName = prop.typeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionRemoverName
		if (prop.toTypeReference != null) {
			op.parameters += prop.toParameter(paramName, prop.toTypeParameterReference)
		}
		if (prop.opposite != null) {
			op.documentation = '''
				
				«IF prop.crossReference»
					Removes the cross reference to this object. The cross reference contains information how to resolve {@link 
					«prop.toType.fullyQualifiedName.toString»} using the DTO service. <p>
					See {@link org.lunifera.dsl.dto.xtext.common.ICrossReferenceInfo}
				«ELSE»
					Removes the given «paramName» from this object. <p>
					«IF prop.cascading»
						Since the reference is a cascading reference, the opposite reference («prop.typeName».«prop.opposite.name.
					toFirstLower»)
						of the «paramName» will be handled automatically and no further coding is required to keep them in sync. 
						See {@link «prop.typeName»#«prop.opposite.toSetterName»(«prop.typeName»)}.
					«ENDIF»
				«ENDIF»
			'''
		}
		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p += prop.toCheckDisposedCall()
				if (prop.opposite != null && !prop.crossReference) {
					p >> paramName + "." + prop.opposite.toSetterName + "(null);"
				} else if (prop.crossReference) {
					p >> prop.toCollectionInternalRemoverName + "(" + paramName + ");"
				} else {
					p >> prop.toGetterName + "().remove(" + paramName + ");"
				}
			])
		return associate(prop, op);
	}

	/**
     * Builds a remover method for a *toMany relation like
     * <code>Order.removeFromOrderLines(OrderLine orderLine)</code>.
     */
	def dispatch JvmOperation toRemover(LDtoAttribute prop, String propertyName) {
		val paramName = prop.typeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionRemoverName
		if (prop.toTypeReference != null) {
			op.parameters += prop.toParameter(paramName, prop.toTypeParameterReference)
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
