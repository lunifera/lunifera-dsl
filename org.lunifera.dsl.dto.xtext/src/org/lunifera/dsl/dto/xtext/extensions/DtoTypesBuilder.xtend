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
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.lunifera.dsl.common.xtext.extensions.TreeAppendableExtensions
import org.lunifera.dsl.common.xtext.jvmmodel.CommonTypesBuilder
import org.lunifera.dsl.dto.lib.ICrossReference
import org.lunifera.dsl.dto.lib.IMapper
import org.lunifera.dsl.dto.lib.IMapperAccess
import org.lunifera.dsl.dto.lib.MappingContext
import org.lunifera.dsl.dto.xtext.jvmmodel.AnnotationCompiler
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LPackage
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
import org.lunifera.dsl.semantic.dto.LDtoAbstractReference
import org.lunifera.dsl.semantic.dto.LDtoFeature
import org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute
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
	 
	def JvmField toDiposeField(LDto sourceElement) {
		val JvmField field = sourceElement.toPrimitiveTypeField("disposed", Boolean::TYPE)
		associate(sourceElement, field)
		annotationCompiler.addDisposeFieldAnnotation(sourceElement, field)
		return field
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
		
		annotationCompiler.addDisposeFieldAnnotation(lClass, op)

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
					p >> "firePropertyChange(\"disposed\", this.disposed, this.disposed = true);"
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
		val typeRef = prop.toDtoTypeReferenceWithMultiplicity
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
			if(prop.toRawType.isBean) {
				setBody(op, '''
				// ensure that embedded beans will notify their parent about changes
				// so their dirty state can be handled properly
				if (this.«paramName» != null) {
					this.«paramName».removePropertyChangeListener(this);
				}
				
				firePropertyChange("«paramName»", this.«paramName», this.«paramName» = «paramName» );
				
				if (this.«paramName» != null) {
					this.«paramName».addPropertyChangeListener(this);
				}
				''')
			}else{
				setBody(op, '''firePropertyChange("«paramName»", this.«paramName», this.«paramName» = «paramName» );''')
			}
			
		} else {
			setBody(op,
			[ // ITreeAppendable
				if(it == null) return
				val p = it.trace(prop);
				p >> prop.toCheckDisposedCall()
				val fieldRef = "this." + prop.toName

				p >> "for (" +prop.toDtoTypeReference.simpleName  + " dto : " + prop.toCollectionInternalGetterName + "().toArray(new " + prop.toDtoTypeReference.simpleName + "[" + fieldRef + ".size()])) " >>> "{"
				
				p >> prop.toCollectionRemoverName + "(dto);"
				p <<< "}"
					
				p >> "if(" + paramName +" == null)" >>> "{"
					p >> "return;"
				p <<< "}"
						
				p >> "for (" +prop.toDtoTypeReference.simpleName  + " dto : " + paramName + ") " >>> "{"
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
		val typeRef = prop.toDtoTypeReferenceWithMultiplicity
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
		
		op.body = '''
		checkDisposed();
		«IF opposite == null»
			«IF !prop.toMany»
				firePropertyChange("«paramName»", this.«paramName», this.«paramName» = «paramName»);
			«ELSE»
				for («prop.toDtoTypeReference.simpleName» dto : «prop.toCollectionInternalGetterName»().toArray(new «prop.toDtoTypeReference.simpleName»[this.«prop.toName».size()])) {
					«prop.toCollectionRemoverName»(dto);
				}

				if(«paramName» == null) {
					return;
				}
				
				for («prop.toDtoTypeReference.simpleName» dto : «paramName») {
					«prop.toCollectionAdderName»(dto);
				}
			«ENDIF»
		«ELSE»
			«IF !prop.toMany»
				if (this.«prop.toName» != null) {
					«IF opposite.toMany»
						this.«prop.toName».«opposite.toCollectionInternalRemoverName»(this);
					«ELSE»
						this.«prop.toName».«opposite.toInternalSetterName»(null);
					«ENDIF»
				}
				
				«prop.toInternalSetterName»(«paramName»);
				
				if (this.«prop.toName» != null) {
					«IF opposite.toMany»
						this.«prop.toName».«opposite.toCollectionInternalAdderName»(this);
					«ELSE»
						this.«prop.toName».«opposite.toInternalSetterName»(this);
					«ENDIF»
				}
			«ELSE»
				for («prop.toDtoTypeReference.simpleName» dto : «prop.toCollectionInternalGetterName»().toArray(new «prop.toDtoTypeReference.simpleName»[this.«prop.toName».size()])) {
					«prop.toCollectionRemoverName»(dto);
				}

				if(«paramName» == null) {
					return;
				}
				
				for («prop.toDtoTypeReference.simpleName» dto : «paramName») {
					«prop.toCollectionAdderName»(dto);
				}
			«ENDIF»
		«ENDIF»
		'''
		return associate(prop, op);
	}
	
	// dispatch used by sub classes
	def dispatch JvmOperation toGetter(LDtoAbstractAttribute prop, String methodName) {
		val propertyName = prop.toName
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = methodName
		op.returnType = cloneWithProxies(prop.toDtoTypeReferenceWithMultiplicity)

		if (prop.derived) {
			val customDoc = prop.documentation
			if (customDoc != null) {
				op.documentation = customDoc
			} else {
				op.documentation = '''
				Calculates the value for the derived property «prop.name»
				 
				@return «prop.name» The derived property value'''
			}

			// set the domain description annotation
			if (prop.domainDescription) {
				op.annotations += prop.toAnnotation(typeof(DomainDescription))
			}

			setBody(op, prop.derivedGetterExpression)

		} else {
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
		}
		return associate(prop, op);
	}
	
		// dispatch used by sub classes
	def dispatch JvmOperation toGetter(LDtoAbstractReference prop, String methodName) {
		val propertyName = prop.toName
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = methodName
		op.returnType = cloneWithProxies(prop.toDtoTypeReferenceWithMultiplicity)
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
		if (prop.toDtoTypeReference != null) {
			op.parameters += prop.toParameter(paramName, prop.toDtoTypeReference)
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

		val opposite = prop.opposite
		op.body = '''
		checkDisposed();
		
		«IF opposite != null»
			«paramName».«prop.opposite.toSetterName»(this);
		«ELSE»
			if(!«prop.toCollectionInternalGetterName»().contains(«paramName»)){
				«prop.toCollectionInternalAdderName»(«paramName»);
			}
		«ENDIF»
		'''

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
		val typeRef = prop.toDtoTypeReference
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
		jvmField.type = (prop as LDtoFeature).toDtoTypeReferenceWithMultiplicity
		jvmField.transient = prop.transient

		// if uuid
		if (prop instanceof LAttribute && (prop as LAttribute).isCreateUuid) {
			jvmField.setInitializer [
				if(it == null) return
				val p = it.trace(prop)
				p >> '''java.util.UUID.randomUUID().toString()'''
			]
		}

		annotationCompiler.processAnnotation(prop, jvmField);
		associate(prop, jvmField);
	}
	
	def boolean isCreateUuid(LAttribute att) {
		if(att instanceof LDtoInheritedAttribute) {
			val iAtt = att as LDtoInheritedAttribute
			return iAtt.inheritedFeature.isUuid
		}else{
			att.isUuid
		}
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
		val typeRef = prop.toDtoTypeReference
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
		val typeRef = prop.toDtoTypeReference
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = getInternalMethodVisibility(prop)
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionInternalAdderName

		val param = prop.toParameter(paramName, typeRef);
		if (param != null) {
			op.parameters += param
		}

		op.documentation = '''For internal use only!'''

		op.body = '''
			«IF prop.toRawType.isBean»
			// add this as property change listener for embeddable beans
			«paramName».addPropertyChangeListener(this);
			«ENDIF»
			«prop.toCollectionInternalGetterName»().add(«paramName»);
		'''
		return associate(prop, op);
	}

	def dispatch JvmOperation toInternalAdder(LDtoAbstractAttribute prop) {
		val paramName = prop.toTypeName.toFirstLower
		val typeRef = prop.toDtoTypeReference
		val JvmOperation op = typesFactory.createJvmOperation();
		op.visibility = getInternalMethodVisibility(prop)
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionInternalAdderName

		val param = prop.toParameter(paramName, typeRef);
		if (param != null) {
			op.parameters += param
		}

		op.documentation = '''For internal use only!'''

		op.body = '''
			«IF prop.toRawType.isBean»
			// add this as property change listener for embeddable beans
			«paramName».addPropertyChangeListener(this);
			«ENDIF»
			«prop.toCollectionInternalGetterName»().add(«paramName»);
		'''
		
		return associate(prop, op);
	}

	def dispatch JvmOperation toInternalRemover(LDtoAbstractReference prop) {
		val paramName = prop.toTypeName.toFirstLower
		val typeRef = prop.toDtoTypeReference
		val op = typesFactory.createJvmOperation();
		op.visibility = getInternalMethodVisibility(prop)
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionInternalRemoverName

		val param = prop.toParameter(paramName, typeRef);
		if (param != null) {
			op.parameters += param
		}

		op.documentation = '''For internal use only!'''

		op.body = '''
			«IF prop.toRawType.isBean»
			// remove this as property change listener from the embeddable bean
			«paramName».removePropertyChangeListener(this);
			«ENDIF»
			«prop.toCollectionInternalGetterName»().remove(«paramName»);
		'''
		
		return associate(prop, op)
	}

	def dispatch JvmOperation toInternalRemover(LDtoAbstractAttribute prop) {
		val paramName = prop.toTypeName.toFirstLower
		val typeRef = prop.toDtoTypeReference
		val op = typesFactory.createJvmOperation();
		op.visibility = getInternalMethodVisibility(prop)
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = prop.toCollectionInternalRemoverName

		val param = prop.toParameter(paramName, typeRef);
		if (param != null) {
			op.parameters += param
		}

		op.documentation = '''For internal use only!'''

		op.body = '''
			«IF prop.toRawType.isBean»
			// remove this as property change listener from the embeddable bean
			«paramName».removePropertyChangeListener(this);
			«ENDIF»
			«prop.toCollectionInternalGetterName»().remove(«paramName»);
		'''
		return associate(prop, op)
	}

	def dispatch JvmOperation toInternalCollectionGetter(LDtoAbstractReference prop, String name) {
		val fieldName = name.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation()
		op.visibility = JvmVisibility::PRIVATE
		op.returnType = prop.toDtoTypeReferenceWithMultiplicity
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
		op.returnType = prop.toDtoTypeReferenceWithMultiplicity
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
					p >> fieldRef >> " = new java.util.ArrayList<" + prop.toDtoTypeReference.qualifiedName + ">();"
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
		if (prop.toDtoTypeReference != null) {
			op.parameters += prop.toParameter(paramName, prop.toDtoTypeReference)
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
		
		val opposite = prop.opposite
		val cascading = prop.isCascading
		op.body = '''
		checkDisposed();
		
		«IF opposite != null»
			«paramName».«prop.opposite.toSetterName»(null);
		«ELSE»
			«prop.toCollectionInternalRemoverName»(«paramName»);
		«ENDIF»
		'''
		
//		setBody(op,
//			[ // ITreeAppendable
//				if(it == null) return
//				val p = it.trace(prop);
//				p += prop.toCheckDisposedCall()
//				if (prop.opposite != null) {
//					p >> "if (isCopy())" >>> "{"
//						p >>> "// avoid opposite reference update"
//						p >> prop.toCollectionInternalGetterName + "().remove(" + paramName + ");"
//					p <<< "} else {" 
//					p >>> paramName + "." + prop.opposite.toSetterName + "(null);"
//					p <<< "}"
//				} else {
//					p >> prop.toCollectionInternalGetterName + "().remove(" + paramName + ");"
//				}
//			])
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
		if (prop.toDtoTypeReference != null) {
			op.parameters += prop.toParameter(paramName, prop.toDtoTypeReference)
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
		val opposite = prop.opposite
		val cascading = prop.isCascading
		op.body = '''
		checkDisposed();
		
		«IF opposite != null»
			«paramName».«prop.opposite.toSetterName»(null);
		«ELSE»
			«prop.toCollectionInternalRemoverName»(«paramName»);
		«ENDIF»
		'''
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

	def JvmField toMapperField(LDtoAbstractReference prop) {
		val JvmField jvmField = typesFactory.createJvmField();
		jvmField.simpleName = prop.toMapperFieldName
		jvmField.visibility = JvmVisibility::PRIVATE
		jvmField.type = cloneWithProxies(prop.type.toMapperTypeReference)

		annotationCompiler.processAnnotation(prop, jvmField);
		associate(prop, jvmField);
	}

	def JvmOperation toGetToDtoMapperAccess(LDto dto) {

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
		op.simpleName = "getToDtoMapper"
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
			return mapperAccess.getToDtoMapper(dtoClass, entityClass);
		'''
		return associate(dto, op);
	}
	
	def JvmOperation toGetToEntityMapperAccess(LDto dto) {

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
		op.simpleName = "getToEntityMapper"
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
			return mapperAccess.getToEntityMapper(dtoClass, entityClass);
		'''
		return associate(dto, op);
	}

	def JvmOperation toMapToDto(LDto dto) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, dto)
		op.simpleName = "mapToDTO"
		op.parameters += dto.toParameter("dto", dto.findDtoTypeReference)
		op.parameters += dto.toParameter("entity", dto.wrappedTypeJvm?.cloneWithProxies)
		op.parameters += dto.toParameter("context", references.getTypeForName(typeof(MappingContext), dto))
		op.documentation = '''
			Maps the entity {@link «dto.wrappedType.toName»} to the dto {@link «dto.toName»}.
			
			@param dto - The target dto
			@param entity - The source entity
			@param context - The context to get information about depth,...
		''';

		op.body = '''
			if(context == null){
				throw new IllegalArgumentException("Please pass a context!");
			}
			«IF !dto.wrappedType.isBean»
				context.register(createDtoHash(entity), dto);
				
			«ENDIF»
			«IF dto.superType != null»
				super.mapToDTO(dto, entity, context);
			«ENDIF»
			
			«FOR f : dto.features.filter[inherited || mapper?.toDTO != null]»
				«IF (!f.bounds.toMany)»
«««					// TODO PIF quickfix
					«IF !f.isContainerReference»
					dto.set«f.toName.toFirstUpper»(«f.toMapPropertyToDto»(entity, context));
					«ENDIF»
				«ELSE»
					for(«f.toDtoTypeReference.qualifiedName» _dtoValue : «f.toMapPropertyToDto»(entity, context)) {
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
		op.parameters += dto.toParameter("dto", dto.findDtoTypeReference)
		op.parameters += dto.toParameter("entity", dto.wrappedTypeJvm?.cloneWithProxies)
		op.parameters += dto.toParameter("context", references.getTypeForName(typeof(MappingContext), dto))
		op.documentation = '''
			Maps the dto {@link «dto.toName»} to the entity {@link «dto.wrappedType.toName»}.
			
			@param dto - The source dto
			@param entity - The target entity
			@param context - The context to get information about depth,...
		''';

		op.body = '''
			if(context == null){
				throw new IllegalArgumentException("Please pass a context!");
			}
			
			«IF !dto.wrappedType.isBean»
				context.register(createEntityHash(dto), entity);
				context.registerMappingRoot(createEntityHash(dto), dto);
			«ENDIF»
			«IF dto.superType != null»
				super.mapToEntity(dto, entity, context);
				
			«ENDIF»
			
			«FOR f : dto.features.filter[inherited || mapper?.fromDTO != null]»
				«IF (!f.bounds.toMany)»
«««					// TODO PIF quickfix
					«IF !f.isContainerReference»
					entity.set«f.toName.toFirstUpper»(«f.toMapPropertyToEntity»(dto, context));
					«ENDIF»
				«ELSE»
					List<«f.toRawTypeName»> «f.toName»_entities = new java.util.ArrayList<«f.toRawTypeName»>();
					for(«f.toRawTypeName» _entityValue : «f.toMapPropertyToEntity»(dto, context)) {
						«f.toName»_entities.add(_entityValue);
					}
					entity.«f.toSetterName»(«f.toName»_entities);
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
		op.returnType = prop.toDtoTypeReferenceWithMultiplicity
		op.simpleName = prop.toMapPropertyToDto

		associate(prop, op);

		initializeSafely(op) [
			parameters += prop.toParameter("in", dto.wrappedTypeJvm?.cloneWithProxies)
			parameters += prop.toParameter("context", references.getTypeForName(typeof(MappingContext), prop))
			documentation = '''
				Maps the property «prop.toName» from the given entity to dto property.
				
				@param in - The source entity
				@param context - The context to get information about depth,...
				@return the mapped value
			''';
			val XExpression mapExpression = prop.toMapToDtoExpression
			if (mapExpression != null) {
				body = mapExpression
			} else {
				if (prop.toRawType instanceof LBean) {
					if (prop.bounds.toMany) {
						body = '''
						org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»> mapper = getToDtoMapper(«prop.toRawType.toDTOBeanSimpleName».class, «prop.toRawType.toName».class);
						if(mapper == null) {
							throw new IllegalStateException("Mapper must not be null!");
						} 
						
						List<«prop.toRawType.toDTOBeanSimpleName»> results = new java.util.ArrayList<«prop.toRawType.toDTOBeanSimpleName»>();
						for («prop.toRawType.toName» _entity : in.«prop.toGetterName»()) {
							«prop.toDtoTypeReference.qualifiedName» _dto = context.get(mapper.createDtoHash(_entity));
							if (_dto == null) {
								_dto = mapper.createDto();
								mapper.mapToDTO(_dto, _entity, context);
							}
							results.add(_dto);
						}
						return results;'''
					} else {
						body = '''
						if(in.get«prop.toName.toFirstUpper»() != null) {
							// find a mapper that knows how to map the concrete input type.
							org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»> mapper = (org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»>) getToDtoMapper(«prop.toRawType.toDTOBeanSimpleName».class, in.get«prop.toName.toFirstUpper»().getClass());
							if(mapper == null) {
								throw new IllegalStateException("Mapper must not be null!");
							}
						
							«prop.toRawType.toDTOBeanSimpleName» dto = null;
						«IF !prop.toRawType.isBean»
							dto = context.get(mapper.createDtoHash(in.«prop.toGetterName»()));
							if(dto != null) {
								return dto;
							}
							
						«ENDIF»
							dto = mapper.createDto();
							mapper.mapToDTO(dto, in.«prop.toGetterName»(), context);
							return dto;
						} else {
							return null;
						}
						'''
					}
				} else {
					if (prop.typeIsBoolean) {
						body = '''return in.is«prop.toName.toFirstUpper»();'''
					} else if(prop.typeIsEnum) {
						body = '''
						if(in.get«prop.toName.toFirstUpper»() != null) {
							return «prop.toRawType.toDTOEnumFullyQualifiedName».valueOf(in.get«prop.toName.toFirstUpper»().name());
						} else {
							return null;
						}
						'''
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
		op.returnType = prop.toDtoTypeReferenceWithMultiplicity

		op.simpleName = prop.toMapPropertyToDto

		associate(prop, op);

		initializeSafely(op) [
			parameters += prop.toParameter("in", dto.wrappedTypeJvm?.cloneWithProxies)
			parameters += prop.toParameter("context", references.getTypeForName(typeof(MappingContext), prop))
			documentation = '''
				Maps the property «prop.toName» from the given entity to the dto.
				
				@param in - The source entity
				@param context - The context to get information about depth,...
				@return «IF (!prop.bounds.toMany)»the mapped dto«ELSE»A list of mapped dtos«ENDIF»
			''';
			val XExpression mapExpression = prop.toMapToDtoExpression
			if (mapExpression != null) {
				body = mapExpression
			} else {
				if (prop.bounds.toMany) {
					body = '''
					org.lunifera.dsl.dto.lib.IMapper<«prop.toTypeName», «prop.toRawType.toName»> mapper = getToDtoMapper(«prop.toTypeName».class, «prop.toRawType.toName».class);
					if(mapper == null) {
						throw new IllegalStateException("Mapper must not be null!");
					} 
					
					List<«prop.toTypeName»> results = new java.util.ArrayList<«prop.toTypeName»>();
					for («prop.toRawType.toName» _entity : in.get«prop.toName.toFirstUpper»()) {
						«prop.toTypeName» _dto = context.get(mapper.createDtoHash(_entity));
						if (_dto == null) {
							_dto = mapper.createDto();
							mapper.mapToDTO(_dto, _entity, context);
						}
						results.add(_dto);
					}
					return results;'''
				} else {
					body = '''
					if(in.get«prop.toName.toFirstUpper»() != null) {
						// find a mapper that knows how to map the concrete input type.
						org.lunifera.dsl.dto.lib.IMapper<«prop.toTypeName», «prop.toRawType.toName»> mapper = (org.lunifera.dsl.dto.lib.IMapper<«prop.toTypeName», «prop.toRawType.toName»>) getToDtoMapper(«prop.toTypeName».class, in.get«prop.toName.toFirstUpper»().getClass());
						if(mapper == null) {
							throw new IllegalStateException("Mapper must not be null!");
						}
						«prop.toTypeName» dto = null;
						«IF !prop.toRawType.isBean»
							dto = context.get(mapper.createDtoHash(in.get«prop.toName.toFirstUpper»()));
							if(dto != null) {
								return dto;
							}
							
						«ENDIF»
						dto = mapper.createDto();
						mapper.mapToDTO(dto, in.get«prop.toName.toFirstUpper»(), context);
						return dto;
					} else {
						return null;
					}
					'''
				}
			}
		]
	}
	
	def JvmGenericType findJvmType(LDto lDto){
		return (associator as IJvmModelAssociations).getPrimaryJvmElement(lDto) as JvmGenericType
	}

	def dispatch JvmOperation toMapToEntityProperty(LDtoAbstractAttribute prop) {
		val LDto dto = prop.eContainer as LDto
		
		// TODO change all stuff like this
		val JvmGenericType dtoJvmType =	dto.findJvmType
		
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PROTECTED
		op.returnType = prop.toRawTypeReferenceWithMultiplicity
		op.simpleName = prop.toMapPropertyToEntity

		associate(prop, op);

		initializeSafely(op) [
			// TODO find typeref in sames resource!
			parameters += prop.toParameter("in", dtoJvmType.newTypeRef(null))
			parameters += prop.toParameter("context", references.getTypeForName(typeof(MappingContext), prop))
			documentation = '''
				Maps the property «prop.toName» from the given entity to dto property.
				
				@param in - The source entity
				@param context - The context to get information about depth,...
				@return the mapped value
			''';
			val XExpression mapExpression = prop.toMapToEntityExpression
			if (mapExpression != null) {
				body = mapExpression
			} else {
				if (prop.toRawType instanceof LBean) {
					if (prop.bounds.toMany) {
						body = '''
						org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»> mapper = getToEntityMapper(«prop.toRawType.toDTOBeanSimpleName».class, «prop.toRawType.toName».class);
						if(mapper == null) {
							throw new IllegalStateException("Mapper must not be null!");
						}
						
						List<«prop.toRawType.toName»> results = new java.util.ArrayList<«prop.toRawType.toName»>();
						for («prop.toRawType.toDTOBeanSimpleName» _dto : in.«prop.toGetterName»()) {
							«prop.toRawType.toName» _entity = mapper.createEntity();
							mapper.mapToEntity(_dto, _entity, context);
							results.add(_entity);
						}
						return results;'''
					} else {
						body = '''
						if(in.get«prop.toName.toFirstUpper»() != null) {
							// find a mapper that knows how to map the concrete input type.
							org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»> mapper = (org.lunifera.dsl.dto.lib.IMapper<«prop.toRawType.toDTOBeanSimpleName», «prop.toRawType.toName»>) getToEntityMapper(in.get«prop.toName.toFirstUpper»().getClass(), «prop.toRawType.toName».class);
							if(mapper == null) {
								throw new IllegalStateException("Mapper must not be null!");
							}
						
							«prop.toRawType.toName» entity = mapper.createEntity();
							mapper.mapToEntity(in.«prop.toGetterName»(), entity, context);
							return entity;							
						} else {
							return null;
						}'''
					}
				} else {
					if (prop.typeIsBoolean) {
						body = '''return in.is«prop.toName.toFirstUpper»();'''
					} else if(prop.typeIsEnum) {
						body = '''
						if(in.get«prop.toName.toFirstUpper»() != null) {
							return «prop.toRawType.fullyQualifiedName.toString».valueOf(in.get«prop.toName.toFirstUpper»().name());
						} else {
							return null;
						}
						'''
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
			parameters += prop.toParameter("in", dto.findDtoTypeReference)
			parameters += prop.toParameter("context", references.getTypeForName(typeof(MappingContext), prop))
			documentation = '''
				Maps the property «prop.toName» from the given dto to the entity.
				
				@param in - The source dto
				@param context - The context to get information about depth,...
				@return «IF (!prop.bounds.toMany)»the mapped entity«ELSE»A list of mapped entities«ENDIF»
			''';
			val XExpression mapExpression = prop.toMapToEntityExpression
			if (mapExpression != null) {
				body = mapExpression
			} else {
				if (prop.bounds.toMany) {
					body = '''
					org.lunifera.dsl.dto.lib.IMapper<«prop.toTypeName», «prop.toRawType.toName»> mapper = getToEntityMapper(«prop.toTypeName».class, «prop.toRawType.toName».class);
					if(mapper == null) {
						throw new IllegalStateException("Mapper must not be null!");
					}
					
					List<«prop.toRawType.toName»> results = new java.util.ArrayList<«prop.toRawType.toName»>();
					for («prop.toTypeName» _dto : in.get«prop.toName.toFirstUpper»()) {
						«IF !prop.toRawType.isBean»
							«prop.toRawType.toName» _entity = context.get(mapper.createEntityHash(_dto));
							if(_entity == null) {
								_entity = mapper.createEntity();
								mapper.mapToEntity(_dto, _entity, context);
							}
							results.add(_entity);
						«ELSE»
							«prop.toRawType.toName» _entity = mapper.createEntity();
							mapper.mapToEntity(_dto, _entity, context);
							results.add(_entity);
						«ENDIF»
					}
					return results;'''
				} else {
					body = '''
					if(in.get«prop.toName.toFirstUpper»() != null) {
						// find a mapper that knows how to map the concrete input type.
						org.lunifera.dsl.dto.lib.IMapper<«prop.toTypeName», «prop.toRawType.toName»> mapper = (org.lunifera.dsl.dto.lib.IMapper<«prop.toTypeName», «prop.toRawType.toName»>) getToEntityMapper(in.get«prop.toName.toFirstUpper»().getClass(), «prop.toRawType.toName».class);
						if(mapper == null) {
							throw new IllegalStateException("Mapper must not be null!");
						}
					
						«prop.toRawType.toName» entity = null;
						«IF !prop.toRawType.isBean»
							entity = context.get(mapper.createEntityHash(in.get«prop.toName.toFirstUpper»()));
							if(entity != null) {
								return entity;
							}

						«ENDIF»
						entity = mapper.createEntity();
						mapper.mapToEntity(in.get«prop.toName.toFirstUpper»(), entity, context);	
						return entity;
					} else {
						return null;
					}	
					'''
				}
			}
		]
	}
	
	def findDtoTypeReference(LDto dto){
		return getBySelector(dto, "dto").newTypeRef(null)
	}
	
	def findDtoMapperTypeReference(LDto dto){
		return getBySelector(dto, "mapper").newTypeRef(null)
	}

	def findSuperDtoMapperType(LDto dto, JvmTypeReference dtoType, JvmTypeReference entityType){
		var type = getBySelector(dto.superType, "mapper")
		if(type == null) {
			val JvmParameterizedTypeReference ref = dto.superTypeMapperJvm.cloneWithProxies as JvmParameterizedTypeReference
			ref.arguments += dtoType
			ref.arguments += entityType
			return ref
		}else{
			val JvmParameterizedTypeReference ref =  type.newTypeRef(null) as JvmParameterizedTypeReference
			ref.arguments.clear
			ref.arguments += dtoType
			ref.arguments += entityType
			return ref
		}
	}
}
