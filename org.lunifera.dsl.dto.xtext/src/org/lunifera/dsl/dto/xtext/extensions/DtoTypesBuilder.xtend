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

package org.lunifera.dsl.dto.xtext.extensions

import com.google.inject.Inject
import java.util.Collections
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.lunifera.dsl.common.xtext.extensions.TreeAppendableExtensions
import org.lunifera.dsl.common.xtext.jvmmodel.CommonTypesBuilder
import org.lunifera.dsl.dto.lib.ICrossReference
import org.lunifera.dsl.dto.lib.IMapper
import org.lunifera.dsl.dto.lib.IMapperAccess
import org.lunifera.dsl.dto.xtext.jvmmodel.AnnotationCompiler
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LPackage
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
import org.lunifera.dsl.semantic.dto.LDtoAbstractReference
import org.lunifera.dsl.semantic.dto.LDtoFeature
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LOperation
import org.lunifera.runtime.common.annotations.DomainDescription

class DtoTypesBuilder extends CommonTypesBuilder {

	@Inject extension DtoModelExtensions
	@Inject extension MethodNamingExtensions
	@Inject extension TreeAppendableExtensions
	@Inject extension IQualifiedNameProvider
	@Inject extension AnnotationExtension

	@Inject
	private IJvmModelAssociator associator;
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
						val typeName = prop.toTypeName
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

	def dispatch JvmOperation toSetter(LDtoAbstractAttribute prop) {
//		if (prop.toMany) {
//			throw new RuntimeException("toMany-References not allowed for setters!");
//		}
		val paramName = prop.toMethodParamName
		val typeRef = prop.toDtoTypeParameterReferenceWithMultiplicity
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toSetterName
		op.parameters += prop.toParameter(paramName, typeRef)
		op.documentation = '''
			Sets the <code>«paramName»</code> property to this instance.
			
			@param «paramName» - the property
			@throws RuntimeException if instance is <code>disposed</code>
		'''

		if (!prop.toMany) {
			setBody(op, '''firePropertyChange("«paramName»", this.«paramName», this.«paramName» = «paramName» );''')
		} else {
			setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCheckDisposedCall()
				val fieldRef = "this." + prop.toName

				p >> "for (" +prop.toDtoTypeParameterReference.simpleName  + " dto : " + prop.toCollectionInternalGetterName + "().toArray(new " + prop.toDtoTypeParameterReference.simpleName + "[" + fieldRef + ".size()])) " >>> "{"
				
				p >> prop.toCollectionRemoverName + "(dto);"
				p <<< "}"
					
				p >> "if(" + paramName +" == null)" >>> "{"
					p >> "return;"
				p <<< "}"
						
				p >> "for (" +prop.toDtoTypeParameterReference.simpleName  + " dto : " + paramName + ") " >>> "{"
						p >> prop.toCollectionAdderName + "(dto);"
				p <<< "}"
				])
			}

		return associate(prop, op);
	}

	def dispatch JvmOperation toSetter(LDtoAbstractReference prop) {
//		if (prop.toMany) {
//			throw new RuntimeException("toMany-References not allowed for setters!");
//		}
		val paramName = prop.toMethodParamName
		val typeRef = prop.toDtoTypeParameterReferenceWithMultiplicity
		val opposite = prop.opposite
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toSetterName
		op.parameters += prop.toParameter(paramName, typeRef)
		op.documentation = '''
			Sets the <code>«paramName»</code> property to this instance.
			«IF (opposite != null)»
				Since the reference has an opposite reference, the opposite <code>«prop.toTypeName»#
				«opposite.name.toFirstLower»</code> of the <code>«paramName»</code> will be handled automatically and no 
				further coding is required to keep them in sync.<p>
				See {@link «prop.toTypeName»#«opposite.toSetterName»(«prop.toTypeName»)
			«ENDIF»
			
			@param «paramName» - the property
			@throws RuntimeException if instance is <code>disposed</code>
		'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCheckDisposedCall()
				val fieldRef = "this." + prop.toName
				if (opposite == null) {
					p >> "firePropertyChange(\"" + paramName + "\", this." + paramName + ", this." + paramName + " = " +
						paramName + ");"
				} else {
					if(!prop.toMany) {
						p >> "if (" + fieldRef + " != null) " >>> "{"
						if (opposite.toMany) {
							p >> fieldRef + "." + opposite.toCollectionInternalRemoverName + "(this);"
						} else {
							p >> fieldRef + "." + opposite.toInternalSetterName + "(null);"
						}
						p <<< "}"
						p >> prop.toInternalSetterName + "(" + paramName + ");\n"
						p >> "if (" + fieldRef + " != null) " >>> "{"
						if (opposite.toMany) {
							p >> fieldRef + "." + opposite.toCollectionInternalAdderName + "(this);"
						} else {
							p >> fieldRef + "." + opposite.toInternalSetterName + "(this);"
						}
						p <<< "}"
					} else {
						
						p >> "for (" +prop.toDtoTypeParameterReference.simpleName  + " dto : " + prop.toCollectionInternalGetterName + "().toArray(new " + prop.toDtoTypeParameterReference.simpleName + "[" + fieldRef + ".size()])) " >>> "{"
							p >> prop.toCollectionRemoverName + "(dto);"
						p <<< "}"
						
						p >> "if(" + paramName +" == null)" >>> "{"
							p >> "return;"
						p <<< "}"
						
						p >> "for (" +prop.toDtoTypeParameterReference.simpleName  + " dto : " + paramName + ") " >>> "{"
							p >> prop.toCollectionAdderName + "(dto);"
						p <<< "}"
					}
				}
			])

		return associate(prop, op);
	}

//	def dispatch JvmOperation toGetter(LDtoFeature prop, String methodName) {
//		val typeRef = prop.toDtoTypeParameterReferenceWithMultiplicity
//		val propertyName = prop.toName
//		val op = typesFactory.createJvmOperation();
//		op.visibility = JvmVisibility::PUBLIC
//		op.simpleName = methodName
//		op.returnType = cloneWithProxies(typeRef)
//		op.documentation = if (prop.toMany) {
//			"Returns an unmodifiable list of " + propertyName + "."
//		} else if (propertyName != null) {
//			"Returns the ".concat((if(prop.bounds.required) "<em>required</em> " else "")).concat(propertyName).
//				concat(" property").concat(
//					(if(!prop.bounds.required) " or <code>null</code> if not present" else "")).concat(".")
//		}
//		
//		setBody(op,
//			[ // ITreeAppendable it |
//				if(it == null) return
//				val p = it.trace(prop);
//				p >> prop.toCheckDisposedCall()
//				if (prop.toMany) {
//					p >> "return " >> newTypeRef(prop, typeof(Collections)) >> ".unmodifiableList" >>
//						"(" + prop.toCollectionInternalGetterName + "());"
//				} else {
//					p >> "return this." + propertyName + ";"
//				}
//			])
//
//		return associate(prop, op);
//	}

	def JvmOperation toProxySetter(LDtoAbstractReference prop) {
		if (prop.toMany) {
			throw new RuntimeException("toMany-References not allowed for setters!");
		}
		val paramName = prop.toMethodParamName
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toSetterName
		op.parameters += prop.toParameter(paramName, references.getTypeForName(typeof(ICrossReference), prop))
		op.documentation = '''
			Sets the proxy of the <code>«paramName»</code> property for lazy cross reference loading.
		'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCheckDisposedCall()
				p >> "firePropertyChange(\"" + paramName + "\", this." + paramName + ", this." + paramName + " = " +
					paramName + ");"
			])

		return associate(prop, op);
	}

	def JvmOperation toProxyGetter(LDtoAbstractReference prop) {
		if (prop.toMany) {
			throw new RuntimeException("toMany-References not allowed for setters!");
		}
		val paramName = prop.toMethodParamName
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(typeof(ICrossReference), prop)
		op.simpleName = prop.toGetterName
		op.documentation = '''
			Returns the proxy of the <code>«paramName»</code>.
		'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCheckDisposedCall()
				p >> "return " + paramName + ";"
			])

		return associate(prop, op);
	}

	/**
     * Builds an adder method for a *toMany relation like
     * <code>Order.addToOrderLines(OrderLine orderLine)</code>.
     */
	def JvmOperation toAdder(LDtoFeature prop, String propertyName) {
		val paramName = prop.toTypeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionAdderName
		if (prop.toDtoTypeParameterReference != null) {
			op.parameters += prop.toParameter(paramName, prop.toDtoTypeParameterReference)
		}

		op.documentation = '''
			Adds the given «paramName» to this object. <p>
			«IF prop.opposite != null»
				Since the reference is a composition reference, the opposite reference <code>«prop.toTypeName»#«prop.opposite.name.
				toFirstLower»</code> of the <code>«paramName»</code> will be handled automatically and no further coding is required to keep them in sync.<p>
				See {@link «prop.toTypeName»#«prop.opposite.toSetterName»(«prop.toTypeName»)}.
			«ENDIF»
			
			@param «paramName» - the property
			@throws RuntimeException if instance is <code>disposed</code>
		'''

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
	def JvmOperation toProxyAdder(LDtoAbstractReference prop, String propertyName) {
		val paramName = prop.toTypeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionAdderName
		op.parameters += prop.toParameter(paramName, references.getTypeForName(typeof(ICrossReference), prop))

		op.documentation = '''
		Adds the cross reference proxy «paramName». <p>'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p += prop.toCheckDisposedCall()
				p >> "if (!" + prop.toGetterName + "().contains(" + paramName + "))" >>> "{"
				{
					p >> prop.toGetterName + "().add(" + paramName + ");"
				}
				p <<< "}"
			])
		return associate(prop, op);
	}

	def JvmVisibility getInternalMethodVisibility(LDtoFeature ref) {
		val LPackage ownerPackage = (ref.eContainer() as LType).package;
		val LPackage refPackage = ref.toRawType.package;
		if (ownerPackage.equals(refPackage)) {
			null // package visibility
		} else {
			JvmVisibility::PUBLIC
		}
	}

	def dispatch JvmOperation toInternalSetter(LDtoAbstractReference prop) {
		val paramName = prop.toMethodParamName
		val typeRef = prop.toDtoTypeParameterReference
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = getInternalMethodVisibility(prop)
		result.returnType = references.getTypeForName(Void::TYPE, prop)
		result.simpleName = prop.toInternalSetterName
		result.parameters += prop.toParameter(paramName, typeRef)

		result.documentation = '''For internal use only!'''

		setBody(result,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop)
				p >> "firePropertyChange(\"" + paramName + "\", this." + paramName + ", this." + paramName + " = " +
					paramName + ");"
			])
		return associate(prop, result);
	}

	override JvmField toField(LFeature prop) {
		val JvmField jvmField = typesFactory.createJvmField();
		jvmField.simpleName = prop.toName
		jvmField.visibility = JvmVisibility::PRIVATE
		jvmField.type = cloneWithProxies((prop as LDtoFeature).toDtoTypeParameterReferenceWithMultiplicity)
		jvmField.transient = prop.transient

		// if uuid
		if (prop instanceof LAttribute && (prop as LAttribute).uuid) {
			jvmField.setInitializer [
				if(it == null) return
				val p = it.trace(prop)
				p >> '''java.util.UUID.randomUUID().toString()'''
			]
		}

		annotationCompiler.processAnnotation(prop, jvmField);
		associate(prop, jvmField);
	}

	def JvmField toProxyField(LFeature prop) {
		val JvmField jvmField = typesFactory.createJvmField();
		jvmField.simpleName = prop.toName
		jvmField.visibility = JvmVisibility::PRIVATE
		jvmField.type = references.getTypeForName(typeof(ICrossReference), prop)

		annotationCompiler.processAnnotation(prop, jvmField);
		associate(prop, jvmField);
	}

	def dispatch JvmOperation toInternalSetter(LDtoAbstractAttribute prop) {
		val paramName = prop.toMethodParamName
		val typeRef = prop.toDtoTypeParameterReference
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = getInternalMethodVisibility(prop)
		result.returnType = references.getTypeForName(Void::TYPE, prop)
		result.simpleName = prop.toInternalSetterName
		result.parameters += prop.toParameter(paramName, typeRef)

		result.documentation = '''For internal use only!'''

		setBody(result,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop)
				p >> "firePropertyChange(\"" + paramName + "\", this." + paramName + ", this." + paramName + " = " +
					paramName + ");"
			])
		return associate(prop, result);
	}

	def dispatch JvmOperation toInternalAdder(LDtoAbstractReference prop) {
		val paramName = prop.toTypeName.toFirstLower
		val typeRef = prop.toDtoTypeParameterReference
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = getInternalMethodVisibility(prop)
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionInternalAdderName

		val param = prop.toParameter(paramName, typeRef);
		if (param != null) {
			op.parameters += param
		}

		op.documentation = '''For internal use only!'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCollectionInternalGetterName + "()" + ".add(" + paramName + ");"
			])
		return associate(prop, op);
	}

	def dispatch JvmOperation toInternalAdder(LDtoAbstractAttribute prop) {
		val paramName = prop.toTypeName.toFirstLower
		val typeRef = prop.toDtoTypeParameterReference
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = getInternalMethodVisibility(prop)
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionInternalAdderName

		val param = prop.toParameter(paramName, typeRef);
		if (param != null) {
			op.parameters += param
		}

		op.documentation = '''For internal use only!'''

		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCollectionInternalGetterName + "()" + ".add(" + paramName + ");"
			])
		return associate(prop, op);
	}

	def dispatch JvmOperation toInternalRemover(LDtoAbstractReference prop) {
		val paramName = prop.toTypeName.toFirstLower
		val typeRef = prop.toDtoTypeParameterReference
		val op = typesFactory.createJvmOperation();
		op.visibility = getInternalMethodVisibility(prop)
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionInternalRemoverName

		val param = prop.toParameter(paramName, typeRef);
		if (param != null) {
			op.parameters += param
		}

		op.documentation = '''For internal use only!'''

		setBody(op,
			[ //ITreeAppendable
				if(it == null) return
				val p = it.trace(prop)
				p >> prop.toCollectionInternalGetterName + "()" + ".remove(" + paramName + ");"
			])
		return associate(prop, op)
	}

	def dispatch JvmOperation toInternalRemover(LDtoAbstractAttribute prop) {
		val paramName = prop.toTypeName.toFirstLower
		val typeRef = prop.toDtoTypeParameterReference
		val op = typesFactory.createJvmOperation();
		op.visibility = getInternalMethodVisibility(prop)
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionInternalRemoverName

		val param = prop.toParameter(paramName, typeRef);
		if (param != null) {
			op.parameters += param
		}

		op.documentation = '''For internal use only!'''

		setBody(op,
			[ //ITreeAppendable
				if(it == null) return
				val p = it.trace(prop)
				p >> prop.toCollectionInternalGetterName + "()" + ".remove(" + paramName + ");"
			])
		return associate(prop, op)
	}

	def dispatch JvmOperation toInternalCollectionGetter(LDtoAbstractReference prop, String name) {
		val fieldName = name.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation()
		op.visibility = JvmVisibility::PRIVATE
		op.returnType = prop.toDtoTypeParameterReferenceWithMultiplicity
		op.simpleName = prop.toCollectionInternalGetterName
		op.documentation = '''
			Returns the list of «htmlCode(prop.toTypeName)»s thereby lazy initializing it. For internal use only!
			
			@return list - the resulting list
		'''
		setBody(op,
			[ // ITreeAppendable
				if(it == null) return;
				var p = it.trace(prop);
				val fieldRef = "this." + fieldName
				p >> "if (" + fieldRef + " == null)" >>> " {"
				{
					p >> fieldRef >> " = new java.util.ArrayList<" + prop.toTypeName + ">();"
				}
				p <<< "}"
				p >> "return " + fieldRef + ";"
			])
		prop.associate(op)
	}

	def dispatch JvmOperation toInternalCollectionGetter(LDtoAbstractAttribute prop, String name) {
		val fieldName = name.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation()
		op.visibility = JvmVisibility::PRIVATE
		op.returnType = prop.toDtoTypeParameterReferenceWithMultiplicity
		op.simpleName = prop.toCollectionInternalGetterName
		op.documentation = '''
			Returns the list of «htmlCode(prop.toTypeName)»s thereby lazy initializing it. For internal use only!
			
			@return list - the resulting list
		'''
		setBody(op,
			[ // ITreeAppendable
				if(it == null) return;
				var p = it.trace(prop);
				val fieldRef = "this." + fieldName
				p >> "if (" + fieldRef + " == null)" >>> " {"
				{
					p >> fieldRef >> " = new java.util.ArrayList<" + prop.toDtoTypeParameterReference.qualifiedName + ">();"
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
	def dispatch JvmOperation toRemover(LDtoAbstractReference prop, String propertyName) {
		val paramName = prop.toTypeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionRemoverName
		if (prop.toDtoTypeParameterReference != null) {
			op.parameters += prop.toParameter(paramName, prop.toDtoTypeParameterReference)
		}
		if (prop.opposite != null) {
			op.documentation = '''
				Removes the given «paramName» from this object. <p>
				«IF prop.cascading»
					Since the reference is a cascading reference, the opposite reference («prop.toTypeName».«prop.opposite.name.
					toFirstLower»)
					of the «paramName» will be handled automatically and no further coding is required to keep them in sync. 
					See {@link «prop.toTypeName»#«prop.opposite.toSetterName»(«prop.toTypeName»)}.
				«ENDIF»
				
				@param «paramName» - the property
				@throws RuntimeException if instance is <code>disposed</code>
			'''
		}
		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p += prop.toCheckDisposedCall()
				if (prop.opposite != null) {
					p >> paramName + "." + prop.opposite.toSetterName + "(null);"
				} else {
					p >> prop.toCollectionInternalGetterName + "().remove(" + paramName + ");"
				}
			])
		return associate(prop, op);
	}

	def JvmOperation toProxyRemover(LDtoAbstractReference prop, String propertyName) {
		val paramName = prop.toTypeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionRemoverName
		op.parameters += prop.toParameter(paramName, references.getTypeForName(typeof(ICrossReference), prop))
		op.documentation = '''
			Removes the proxy cross reference «paramName» from this object. <p>
		'''
		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p += prop.toCheckDisposedCall()
				p >> prop.toGetterName + "().remove(" + paramName + ");"
			])
		return associate(prop, op);
	}

	/**
     * Builds a remover method for a *toMany relation like
     * <code>Order.removeFromOrderLines(OrderLine orderLine)</code>.
     */
	def dispatch JvmOperation toRemover(LDtoAbstractAttribute prop, String propertyName) {
		val paramName = prop.toTypeName.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionRemoverName
		if (prop.toDtoTypeParameterReference != null) {
			op.parameters += prop.toParameter(paramName, prop.toDtoTypeParameterReference)
		}
		if (prop.opposite != null) {
			op.documentation = '''
				Removes the given «paramName» from this object. <p>
				«IF prop.cascading»
					Since the reference is a cascading reference, the opposite reference <code>«prop.toTypeName».«prop.opposite.name.
					toFirstLower»</code> of the <code>«paramName»</code> will be handled automatically and no further coding is required to keep them in sync. 
					See {@link «prop.toTypeName»#«prop.opposite.toSetterName»(«prop.toTypeName»)}.
				«ENDIF»
				
				@param «paramName» - the property
				@throws RuntimeException if instance is <code>disposed</code>
			'''
		} else {
		}
		setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p += prop.toCheckDisposedCall()
				if (prop.opposite != null) {
					p >> paramName + "." + prop.opposite.toSetterName + "(null);"
				} else {
					p >> prop.toCollectionInternalGetterName + "().remove(" + paramName + ");"
				}
			])
		return associate(prop, op);
	}

	def JvmOperation toMapperBindMethod(LDto dto) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PROTECTED
		op.returnType = references.getTypeForName(Void::TYPE, dto)
		op.simpleName = "bindMapperAccess"
		op.parameters += dto.toParameter("mapperAccess", references.getTypeForName(typeof(IMapperAccess), dto, null))
		op.documentation = '''
			Called by OSGi-DS. Binds the mapper access service.
			
			@param service - The mapper access service
		''';

		op.body = '''
			this.mapperAccess = mapperAccess;
		'''
		return associate(dto, op);
	}

	def JvmOperation toMapperUnbindMethod(LDto dto) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PROTECTED
		op.returnType = references.getTypeForName(Void::TYPE, dto)
		op.simpleName = "unbindMapperAccess"
		op.parameters += dto.toParameter("mapperAccess", references.getTypeForName(typeof(IMapperAccess), dto, null))
		op.documentation = '''
			Called by OSGi-DS. Binds the mapper access service.
			
			@param service - The mapper access service
		''';

		op.body = '''
			this.mapperAccess = null;
		'''
		return associate(dto, op);
	}

	//	protected <D, E> IMapper<D, E> getMapper(Class<D> dtoClass,
	//			Class<E> entityClass) {
	//		return mapperAccess.getMapper(dtoClass, entityClass);
	//	}
	def JvmField toMapperField(LDtoAbstractReference prop) {
		val JvmField jvmField = typesFactory.createJvmField();
		jvmField.simpleName = prop.toMapperFieldName
		jvmField.visibility = JvmVisibility::PRIVATE
		jvmField.type = cloneWithProxies(prop.type.toMapperTypeReference)

		annotationCompiler.processAnnotation(prop, jvmField);
		associate(prop, jvmField);
	}

	def JvmOperation toGetMapperAccess(LDto dto) {

		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PROTECTED

		val dTypeParam = typesFactory.createJvmTypeParameter
		dTypeParam.setName("D")
		op.typeParameters += dTypeParam
		val eTypeParam = typesFactory.createJvmTypeParameter
		eTypeParam.name = "E"
		op.typeParameters += eTypeParam

		val dType = typesFactory.createJvmGenericType("D")
		val dTypeRef = typesFactory.createJvmParameterizedTypeReference()
		dTypeRef.type = dType
		val eType = typesFactory.createJvmGenericType("E")
		val eTypeRef = typesFactory.createJvmParameterizedTypeReference()
		eTypeRef.type = eType

		op.returnType = references.getTypeForName(typeof(IMapper), dto, dTypeRef.cloneWithProxies,
			eTypeRef.cloneWithProxies)
		op.simpleName = "getMapper"
		op.parameters +=
			dto.toParameter("dtoClass", references.getTypeForName(typeof(Class), dto, dTypeRef.cloneWithProxies))
		op.parameters +=
			dto.toParameter("entityClass", references.getTypeForName(typeof(Class), dto, eTypeRef.cloneWithProxies))

		op.documentation = '''
		Returns the mapper instance that may map between the given dto and entity. Or <code>null</code> if no mapper is available.
		
		@param dtoClass - the class of the dto that should be mapped
		@param entityClass - the class of the entity that should be mapped
		@return the mapper instance or <code>null</code>'''

		op.body = '''
			return mapperAccess.getMapper(dtoClass, entityClass);
		'''
		return associate(dto, op);
	}

	def JvmOperation toMapToDto(LDto dto) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, dto)
		op.simpleName = "mapToDTO"
		op.parameters += dto.toParameter("dto", dto.toTypeReference)
		op.parameters += dto.toParameter("entity", dto.wrappedType.toTypeReference)
		op.documentation = '''
			Maps the entity {@link «dto.wrappedType.toName»} to the dto {@link «dto.toName»}.
			
			@param dto - The target dto
			@param entity - The source entity
		''';

		op.body = '''
			«IF dto.superType != null»
				super.mapToDTO(dto, entity);
				
			«ENDIF»
			
			«FOR f : dto.features.filter[inherited || mapper?.toDTO != null]»
				«IF (!f.bounds.toMany)»
					dto.set«f.toName.toFirstUpper»(«f.toMapPropertyToDto»(entity));
				«ELSE»
					for(«f.toDtoTypeParameterReference.qualifiedName» _dtoValue : «f.toMapPropertyToDto»(entity)) {
						dto.«f.toCollectionAdderName»(_dtoValue);
					}
				«ENDIF»
			«ENDFOR»
		'''
		return associate(dto, op);
	}

	def JvmOperation toMapToEntity(LDto dto) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, dto)
		op.simpleName = "mapToEntity"
		op.parameters += dto.toParameter("dto", dto.toTypeReference)
		op.parameters += dto.toParameter("entity", dto.wrappedType.toTypeReference)
		op.documentation = '''
			Maps the dto {@link «dto.toName»} to the entity {@link «dto.wrappedType.toName»}.
			
			@param dto - The source dto
			@param entity - The target entity
		''';

		op.body = '''
			«IF dto.superType != null»
				super.mapToEntity(dto, entity);
				
			«ENDIF»
			
			«FOR f : dto.features.filter[inherited || mapper?.fromDTO != null]»
				«IF (!f.bounds.toMany)»
					entity.set«f.toName.toFirstUpper»(«f.toMapPropertyToEntity»(dto));
				«ELSE»
					for(«f.toRawTypeName» _entityValue : «f.toMapPropertyToEntity»(dto)) {
						entity.«f.toCollectionAdderName»(_entityValue);
					}
				«ENDIF»
				
			«ENDFOR»
		'''

		return associate(dto, op);
	}

	//	def JvmOperation toMapToDtoProperty(LDtoFeature prop) {
	//		val LDto dto = prop.eContainer as LDto
	//		val op = typesFactory.createJvmOperation();
	//		op.visibility = JvmVisibility::PROTECTED
	//		op.returnType = references.getTypeForName(Void::TYPE, prop)
	//		op.simpleName = prop.toMapPropertyToDto
	//
	//		associate(prop, op);
	//  
	//		initializeSafely(op) [
	//			parameters += prop.toParameter("dto", dto.wrappedType.toTypeReference)
	//			parameters += prop.toParameter("entity", dto.toTypeReference)
	//			documentation = '''
	//				Maps the property «prop.toName» to the given entity to the given dto.
	//				
	//				@param dto - The target dto
	//				@param entity - The source entity
	//			''';
	//			val XExpression mapExpression = prop.toMapToDtoExpression
	//			if (mapExpression != null) {
	//				body = mapExpression
	//			} else {
	//				body = []
	//			}
	//		]
	//	}
	//
	//	def JvmOperation toMapToEntityProperty(LDtoFeature prop) {
	//		val LDto dto = prop.eContainer as LDto
	//		
	//		val op = typesFactory.createJvmOperation();
	//		op.visibility = JvmVisibility::PROTECTED
	//		op.returnType = references.getTypeForName(Void::TYPE, prop)
	//		op.simpleName = prop.toMapPropertyToEntity
	//
	//		associate(prop, op);
	//
	//		initializeSafely(op) [
	//			parameters += op.toParameter("in", dto.toTypeReference)
	//			parameters += op.toParameter("out", dto.wrappedType.toTypeReference)
	//			documentation = '''
	//				Maps the property «prop.toName» from the given dto to the given entity.
	//				
	//				@param dto - The source dto
	//				@param entity - The target entity
	//			'''
	//			val mapExpression = prop.toMapToEntityExpression
	//			associate(prop, mapExpression)
	//			if (mapExpression != null) {
	//				body = mapExpression
	//			} else {
	//				body = []
	//			}
	//		]
	//
	//	}
	/**
	 * returns the mapper class type
	 */
	def JvmGenericType toMapperJvmType(LDto lDto) {
		val type = createJvmGenericType(lDto, lDto.toFqnMapperName)
		associate(lDto, type)
	}

	def dispatch JvmOperation toMapToDtoProperty(LDtoAbstractAttribute prop) {
		val LDto dto = prop.eContainer as LDto
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PROTECTED
		op.returnType = prop.toDtoTypeParameterReferenceWithMultiplicity
		op.simpleName = prop.toMapPropertyToDto

		associate(prop, op);

		initializeSafely(op) [
			parameters += prop.toParameter("in", dto.wrappedType.toTypeReference)
			documentation = '''
				Maps the property «prop.toName» from the given entity to dto property.
				
				@param in - The source entity
				@return the mapped value
			''';
			val XExpression mapExpression = prop.toMapToDtoExpression
			if (mapExpression != null) {
				body = mapExpression
			} else {
				if (prop.toRawType instanceof LBean) {
					if (prop.bounds.toMany) {
						body = '''
						org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»> mapper = getMapper(«prop.toRawType.toDTOBeanSimpleName».class, «prop.toRawType.toName».class);
						if(mapper == null) {
							throw new IllegalStateException("Mapper must not be null!");
						} 
						
						List<«prop.toRawType.toDTOBeanSimpleName»> results = new java.util.ArrayList<«prop.toRawType.toDTOBeanSimpleName»>();
						for («prop.toRawType.toName» _entity : in.«prop.toGetterName»()) {
							«prop.toDtoTypeParameterReference.qualifiedName» _dto = new «prop.toDtoTypeParameterReference.qualifiedName»();
							mapper.mapToDTO(_dto, _entity);
							results.add(_dto);
						}
						return results;'''
					} else {
						body = '''
						org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»> mapper = getMapper(«prop.toRawType.toDTOBeanSimpleName».class, «prop.toRawType.toName».class);
						if(mapper == null) {
							throw new IllegalStateException("Mapper must not be null!");
						}
						 
						if(in.get«prop.toName.toFirstUpper»() != null) {
							«prop.toRawType.toDTOBeanSimpleName» dto = new «prop.toRawType.toDTOBeanSimpleName»();
							mapper.mapToDTO(dto, in.«prop.toGetterName»());
							return dto;
						} else {
							return null;
						}
						'''
					}
				} else {
					if (prop.typeIsBoolean) {
						body = '''return in.is«prop.toName.toFirstUpper»();'''
					} else {
						body = '''return in.get«prop.toName.toFirstUpper»();'''
					}
				}
			}
		]
	}

	def dispatch JvmOperation toMapToDtoProperty(LDtoAbstractReference prop) {
		val LDto dto = prop.eContainer as LDto
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PROTECTED
		op.returnType = prop.toDtoTypeParameterReferenceWithMultiplicity

		op.simpleName = prop.toMapPropertyToDto

		associate(prop, op);

		initializeSafely(op) [
			parameters += prop.toParameter("in", dto.wrappedType.toTypeReference)
			documentation = '''
				Maps the property «prop.toName» from the given entity to the dto.
				
				@param in - The source entity
				@return «IF (!prop.bounds.toMany)»the mapped dto«ELSE»A list of mapped dtos«ENDIF»
			''';
			val XExpression mapExpression = prop.toMapToDtoExpression
			if (mapExpression != null) {
				body = mapExpression
			} else {
				if (prop.bounds.toMany) {
					body = '''
					org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»> mapper = getMapper(«prop.toRawType.toDTOBeanSimpleName».class, «prop.toRawType.toName».class);
					if(mapper == null) {
						throw new IllegalStateException("Mapper must not be null!");
					} 
					
					List<«prop.toRawType.toDTOBeanSimpleName»> results = new java.util.ArrayList<«prop.toRawType.toDTOBeanSimpleName»>();
					for («prop.toRawType.toName» _entity : in.get«prop.toName.toFirstUpper»()) {
						«prop.toRawType.toDTOBeanSimpleName» _dto = new «prop.toRawType.toDTOBeanSimpleName»();
						mapper.mapToDTO(_dto, _entity);
						results.add(_dto);
					}
					return results;'''
				} else {
					body = '''
					org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»> mapper = getMapper(«prop.toRawType.toDTOBeanSimpleName».class, «prop.toRawType.toName».class);
					if(mapper == null) {
						throw new IllegalStateException("Mapper must not be null!");
					}
					
					if(in.get«prop.toName.toFirstUpper»() != null) {
						«prop.toRawType.toDTOBeanSimpleName» dto = new «prop.toRawType.toDTOBeanSimpleName»();
						mapper.mapToDTO(dto, in.get«prop.toName.toFirstUpper»());
						return dto;
					} else {
						return null;
					}
					'''
				}
			}
		]
	}

	def dispatch JvmOperation toMapToEntityProperty(LDtoAbstractAttribute prop) {
		val LDto dto = prop.eContainer as LDto
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PROTECTED
		op.returnType = prop.toRawTypeReferenceWithMultiplicity
		op.simpleName = prop.toMapPropertyToEntity

		associate(prop, op);

		initializeSafely(op) [
			parameters += prop.toParameter("in", dto.toTypeReference)
			documentation = '''
				Maps the property «prop.toName» from the given entity to dto property.
				
				@param in - The source entity
				@return the mapped value
			''';
			val XExpression mapExpression = prop.toMapToEntityExpression
			if (mapExpression != null) {
				body = mapExpression
			} else {
				if (prop.toRawType instanceof LBean) {
					if (prop.bounds.toMany) {
						body = '''
						org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»> mapper = getMapper(«prop.toRawType.toDTOBeanSimpleName».class, «prop.toRawType.toName».class);
						if(mapper == null) {
							throw new IllegalStateException("Mapper must not be null!");
						}
						
						List<«prop.toRawType.toName»> results = new java.util.ArrayList<«prop.toRawType.toName»>();
						for («prop.toRawType.toDTOBeanSimpleName» _dto : in.«prop.toGetterName»()) {
							«prop.toRawType.toName» _entity = new «prop.toRawType.toName»();
							mapper.mapToEntity(_dto, _entity);
							results.add(_entity);
						}
						return results;'''
					} else {
						body = '''
						org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»> mapper = getMapper(«prop.toRawType.toDTOBeanSimpleName».class, «prop.toRawType.toName».class);
						if(mapper == null) {
							throw new IllegalStateException("Mapper must not be null!");
						}
						
						if(in.get«prop.toName.toFirstUpper»() != null) {
							«prop.toRawType.toName» entity = new «prop.toRawType.name»();
							mapper.mapToEntity(in.«prop.toGetterName»(), entity);
							return entity;							
						} else {
							return null;
						}'''
					}
				} else {
					if (prop.typeIsBoolean) {
						body = '''return in.is«prop.toName.toFirstUpper»();'''
					} else {
						body = '''return in.get«prop.toName.toFirstUpper»();'''
					}
				}
			}
		]
	}

	def dispatch JvmOperation toMapToEntityProperty(LDtoAbstractReference prop) {
		val LDto dto = prop.eContainer as LDto
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PROTECTED
		op.returnType = prop.toRawTypeReferenceWithMultiplicity
		op.simpleName = prop.toMapPropertyToEntity

		associate(prop, op);

		initializeSafely(op) [
			parameters += prop.toParameter("in", dto.toTypeReference)
			documentation = '''
				Maps the property «prop.toName» from the given dto to the entity.
				
				@param in - The source dto
				@return «IF (!prop.bounds.toMany)»the mapped entity«ELSE»A list of mapped entities«ENDIF»
			''';
			val XExpression mapExpression = prop.toMapToEntityExpression
			if (mapExpression != null) {
				body = mapExpression
			} else {
				if (prop.bounds.toMany) {
					body = '''
					org.lunifera.dsl.dto.lib.IMapper<«prop.type.toName», «prop.toRawType.toName»> mapper = getMapper(«prop.
						type.toName».class, «prop.toRawType.toName».class);
					if(mapper == null) {
						throw new IllegalStateException("Mapper must not be null!");
					}
					
					List<«prop.toRawType.toName»> results = new java.util.ArrayList<«prop.toRawType.toName»>();
					for («prop.type.toName» _dto : in.get«prop.toName.toFirstUpper»()) {
						«prop.toRawType.toName» _entity = new «prop.toRawType.toName»();
						mapper.mapToEntity(_dto, _entity);
						results.add(_entity);
					}
					return results;'''
				} else {
					body = '''
					org.lunifera.dsl.dto.lib.IMapper<«prop.type.toName», «prop.toRawType.toName»> mapper = getMapper(«prop.
						type.toName».class, «prop.toRawType.toName».class);
					if(mapper == null) {
						throw new IllegalStateException("Mapper must not be null!");
					}
					
					if(in.get«prop.toName.toFirstUpper»() != null) {
						«prop.toRawType.toName» entity = new «prop.toRawType.name»();
						mapper.mapToEntity(in.get«prop.toName.toFirstUpper»(), entity);	
						return entity;
					} else {
						return null;
					}	
					'''
				}
			}
		]
	}
}
