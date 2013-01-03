/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Source partially based on org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.jvmmodel.services.entity

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmEnumerationType
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
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Procedures$Procedure1
import org.lunifera.dsl.entity.semantic.model.LAnnotationDef
import org.lunifera.dsl.entity.semantic.model.LContainer
import org.lunifera.dsl.entity.semantic.model.LContains
import org.lunifera.dsl.entity.semantic.model.LDataType
import org.lunifera.dsl.entity.semantic.model.LEntity
import org.lunifera.dsl.entity.semantic.model.LEntityMember
import org.lunifera.dsl.entity.semantic.model.LEntityModel
import org.lunifera.dsl.entity.semantic.model.LGenSettings
import org.lunifera.dsl.entity.semantic.model.LOperation
import org.lunifera.dsl.entity.semantic.model.LPackage
import org.lunifera.dsl.entity.semantic.model.LProperty
import org.lunifera.dsl.entity.semantic.model.LReference
import org.lunifera.dsl.entity.semantic.model.LRefers
import org.lunifera.dsl.entity.semantic.model.LType
import org.lunifera.dsl.entity.xtext.extensions.Constants
import org.lunifera.dsl.entity.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.entity.xtext.extensions.TreeAppendableExtensions
import org.lunifera.dsl.entity.xtext.jvmmodel.services.IAnnotationCompiler
import org.lunifera.dsl.entity.xtext.jvmmodel.services.IOperationContentCompiler

//import static extension org.lunifera.dsl.entity.xtext.extensions.TreeAppendableExtensions.*

class EntityTypesBuilder {

	@Inject extension IQualifiedNameProvider
	@Inject extension ModelExtensions
	@Inject extension MethodNamingExtensions
	@Inject extension TreeAppendableExtensions

	@Inject TypesFactory typesFactory;
	@Inject TypeReferences references;
	@Inject JvmTypesBuilder jvmTypes;
 
	@Inject
	@Named(Constants::DELEGATE)
	IOperationContentCompiler operationsGenerator;

	@Inject
	@Named(Constants::DELEGATE)
	IAnnotationCompiler annotationCompiler;

    def private htmlCode(CharSequence s) {
        "<code>" + s + "</code>"
    }

    /*
     * Methods delegating to JvmTypesBuilder. 
     * (Includes methods copied from JvmTypesBuilder because its visibility is protected.)
     */
    def JvmTypeReference newTypeRef(EObject ctx, QualifiedName qn, JvmTypeReference... typeArgs) {
        newTypeRef(ctx, qn.toString, typeArgs)
    }
    def JvmTypeReference newTypeRef(EObject ctx, Class<?> typeClass, JvmTypeReference... typeArgs) {
        jvmTypes.newTypeRef(ctx, typeClass.name, typeArgs)
    }
    def JvmTypeReference newTypeRef(EObject ctx, String typeName, JvmTypeReference... typeArgs) {
        jvmTypes.newTypeRef(ctx, typeName, typeArgs)
    }
    def <T extends EObject> T initializeSafely(T targetElement, Procedure1<? super T> initializer) {
        if(targetElement != null && initializer != null) {
            // need exception handling and logging like JvmTypesBuilder?
            initializer.apply(targetElement)
        }
        return targetElement
    }
    def JvmTypeReference cloneWithProxies(JvmTypeReference typeRef) {
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
        if (sourceElement == null || name == null) return null

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
        if(sourceElement == null || name == null)
            return null;
        val JvmFormalParameter result = typesFactory.createJvmFormalParameter()
        result.name = name
        result.parameterType = cloneWithProxies(typeRef)
        associate(sourceElement, result);
    }
    def JvmConstructor toConstructor(EObject sourceElement, Procedure1<? super JvmConstructor> initializer) {
        return jvmTypes.toConstructor(sourceElement, initializer)
    }
    def JvmEnumerationType toEnumerationType(EObject sourceElement, String name, 
                                             Procedure1<? super JvmEnumerationType> initializer) {
        jvmTypes.toEnumerationType(sourceElement, name, initializer)
    }
    def JvmEnumerationLiteral toEnumerationLiteral(EObject sourceElement, String name) {
        jvmTypes.toEnumerationLiteral(sourceElement, name, null)
    }
    def translateAnnotationsTo(Iterable<? extends XAnnotation> annotations, JvmAnnotationTarget target) {
        jvmTypes.translateAnnotationsTo(annotations, target)
    }
    def JvmAnnotationReference toAnnotation(EObject sourceElement, Class<?> annotationType) {
        jvmTypes.toAnnotation(sourceElement, annotationType)
    }
    /*
     * END Methods delegating to JvmTypesBuilder.
     */

    def dispatch JvmTypeReference toTypeReference(LType type) {
        return newTypeRef(type, type.fullyQualifiedName);
    }
    def dispatch JvmTypeReference toTypeReference(LDataType type) {
        return type.jvmTypeReference
    }
	def dispatch JvmTypeReference toTypeReference(LReference ref) {
		var jvmTypeRef = ref.type?.toTypeReference
		if (jvmTypeRef != null && ref.isToMany) {
			jvmTypeRef = newTypeRef(ref, typeof(List), jvmTypeRef);
		}
		return jvmTypeRef
	}
	def dispatch JvmTypeReference toTypeReference(LProperty prop) {
		var jvmTypeRef = prop.type?.toTypeReference
        if (jvmTypeRef != null && prop.isToMany) {
			jvmTypeRef = newTypeRef(prop, typeof(List), jvmTypeRef);
		}
		return jvmTypeRef
	}

	def JvmField toField(LEntityMember sourceElement, String name, JvmTypeReference typeRef) {
		val JvmField result = typesFactory.createJvmField();
		result.simpleName = name
		result.visibility = JvmVisibility::PRIVATE
		result.type = cloneWithProxies(typeRef)

		if (annotationCompiler != null) {
			val LEntity lEntity = sourceElement.eContainer() as LEntity
			val LEntityModel lModel = lEntity.getPackage().eContainer() as LEntityModel
			annotationCompiler.processAnnotation(sourceElement, result, lModel.getGenSettings());
		}

		associate(sourceElement, result);
	}
	
	def JvmOperation toGetter(LReference ref, String name, LGenSettings setting) {
		var JvmOperation op
		val JvmTypeReference entityTypeReference = newTypeRef(ref, ref.type.fullyQualifiedName)
		if (entityTypeReference != null && ref.isToMany) {
			val listType = newTypeRef(ref, typeof(List), entityTypeReference);
			op = toZeroToManyGetter(ref, name, listType, setting);
			op.documentation = 
			    operationsGenerator.get_toMany_Reference_Documentantion(ref, name, setting)
		} else {
			op = toGetter(ref, name, entityTypeReference, setting);
			op.documentation = 
			    operationsGenerator.get_toOne_Reference_Documentantion(ref, name, setting)
		}
		associate(ref, op);
	}

	def JvmOperation toGetter(LProperty prop, String name, LGenSettings setting) {
		var JvmOperation op
		if (prop.toMany) {
			op = toZeroToManyGetter(prop, name, prop.toTypeReference, setting);
		    op.documentation = 
		            operationsGenerator.get_toMany_Property_Documentantion(prop, name, setting)
		} else {
			op = toGetter(prop, name, prop.toTypeReference, setting);
			op.documentation = 
			        operationsGenerator.get_toOne_Property_Documentantion(prop, name, setting)
		}
		associate(prop, op);
	}

	def JvmOperation toGetter(LEntityMember sourceElement,
			String propertyName,
			JvmTypeReference typeRef,
			LGenSettings setting) {

		var JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility::PUBLIC
		var prefix = "get";
		if (typeRef != null && !typeRef.eIsProxy() && typeRef.getType() != null
				&& !typeRef.getType().eIsProxy()
				&& "boolean".equals(typeRef.getType().getIdentifier())) {
			prefix = "is";
		}
		result.simpleName = prefix + propertyName.toFirstUpper
		result.returnType = cloneWithProxies(typeRef)
		setBody(result, [ // ITreeAppendable it |
			if (it == null) return
			val p = it.trace(sourceElement);
			if (sourceElement instanceof LProperty) {
				p.append(operationsGenerator
						.get_toOne_Property_OperationContent(
								sourceElement as LProperty,
								propertyName, setting));
			} else if (sourceElement instanceof LReference) {
				p.append(operationsGenerator
						.get_toOne_Reference_OperationContent(
								sourceElement as LReference,
								propertyName, setting));
			}
		])

		if (sourceElement instanceof LProperty) {
			setDocumentation(
					result,
					operationsGenerator.get_toOne_Property_Documentantion(
							sourceElement as LProperty, propertyName, setting).toString());
		} else if (sourceElement instanceof LReference) {
			setDocumentation(
					result,
					operationsGenerator.get_toOne_Reference_Documentantion(
							sourceElement as LReference, propertyName, setting).toString());
		}

		return associate(sourceElement, result);
	}

	
	def JvmOperation toIsDisposed(LEntity sourceElement) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.simpleName = "isDisposed"
		op.returnType = references.getTypeForName(Boolean::TYPE, sourceElement, null)
		setBody(op, [ // ITreeAppendable
			if (it == null) return
			val p = it.trace(sourceElement)
			p.append(operationsGenerator.isDisposed_OperationContent(sourceElement))
		])
		setDocumentation(op,
				operationsGenerator.isDisposed_Documentantion(sourceElement)
						.toString());
		return associate(sourceElement, op);
	}

	def JvmOperation toCheckDisposed(LEntity sourceElement) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PRIVATE
		op.returnType = references.getTypeForName(Void::TYPE, sourceElement)
		op.simpleName = "checkDisposed"
		setBody(op, [// ITreeAppendable
			if (it == null) return
			val p = it.trace(sourceElement)
			p.append(operationsGenerator.checkDisposed_OperationContent(sourceElement))
		])
		setDocumentation(op, operationsGenerator
				.checkDisposed_Documentantion(sourceElement).toString());
		return associate(sourceElement, op);
	}
	
	def JvmOperation toDispose(LEntity sourceElement) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, sourceElement)
		op.simpleName = "dispose"
		setBody(op, [ // ITreeAppendable
			if (it == null) return
			val p = it.trace(sourceElement)
			p.append(operationsGenerator.dispose_OperationContent(sourceElement));
		]);
		setDocumentation(op,
		                 operationsGenerator.dispose_Documentantion(sourceElement).toString())
	
		return associate(sourceElement, op);
	}

	def JvmOperation toMethod(LOperation sourceElement,
			                  String name, 
			                  JvmTypeReference returnType,
			                  Procedure1<? super JvmOperation> initializer) {
		val op = typesFactory.createJvmOperation()
		op.simpleName = name
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = cloneWithProxies(returnType)

		if (annotationCompiler != null) {
			val LEntity lEntity = sourceElement.eContainer() as LEntity
			val LEntityModel lModel = lEntity.getPackage().eContainer() as LEntityModel
			annotationCompiler.processAnnotation(sourceElement, op, lModel.getGenSettings());
		}

		associate(sourceElement, op);
		initializeSafely(op, initializer);
	}

	
	def JvmOperation toZeroToManyGetter(LReference sourceElement,
			                            String propertyName,
			                            JvmTypeReference typeRef,
			                            LGenSettings setting) {
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		var prefix = "get";
		if (typeRef != null && !typeRef.eIsProxy()
				&& !typeRef.getType().eIsProxy()
				&& "boolean".equals(typeRef.getType().getIdentifier())) {
			prefix = "is";
		}
		op.simpleName = prefix + propertyName.toFirstUpper
		op.returnType = cloneWithProxies(typeRef)
		setBody(op, [ // ITreeAppendable
			if (it == null) return
			val p = it.trace(sourceElement)
			p.append(operationsGenerator.get_toMany_Reference_OperationContent(
							sourceElement, propertyName, typeRef, setting));
		])
		return associate(sourceElement, op);
	}

	
	def JvmOperation toZeroToManyGetter(LProperty sourceElement,
	                                    String fieldName,
	                                    JvmTypeReference typeRef,
	                                    LGenSettings setting) {
		val result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility::PUBLIC
		var prefix = "get";
		if (typeRef != null && !typeRef.eIsProxy()
				&& !typeRef.getType().eIsProxy()
				&& "boolean".equals(typeRef.getType().getIdentifier())) {
			prefix = "is";
		}
		result.simpleName = prefix + fieldName.toFirstUpper
		result.returnType = cloneWithProxies(typeRef)
		setBody(result, [ // ITreeAppendable
			if (it == null) return
			val p = it.trace(sourceElement);
			p.append(operationsGenerator.get_toMany_Property_OperationContent(
							sourceElement, fieldName, typeRef, setting));
		])
		return associate(sourceElement, result);
	}

	def JvmGenericType toEntityClass(LEntity entity,
			                         QualifiedName name, 
			                         LGenSettings lSettings) {
		val result = createJvmGenericType(entity, name.toString)
		result.setAbstract(entity.isAbstract());

		annotationCompiler.processAnnotation(entity, result, lSettings);

		associate(entity, result)
	}

	def JvmOperation toSetter(LReference ref, String propertyName, LGenSettings setting) {
		if (ref.isToMany) {
			throw new RuntimeException("toMany-References not allowed for setters!");
		}
		val JvmOperation op = typesFactory.createJvmOperation()
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, ref)
		op.simpleName = "set" + propertyName.toFirstUpper
		op.parameters += ref.toParameter(ref.toMethodParamName, ref.toTypeReference)
		
		val localVarName = ref.toMethodParamName
		val typeRef = ref.toTypeReference

		switch ref {
			LContainer: {
				op.documentation = operationsGenerator.set_toOne_Container_Documentantion(
										ref, localVarName, propertyName, typeRef, setting)
			} 
			LContains: {
				op.documentation = operationsGenerator.set_toOne_Containment_Documentantion(
										ref, localVarName, propertyName, typeRef, setting)
			}
			LRefers: {
				op.documentation = operationsGenerator.set_toOne_Refers_Documentantion(
										ref, localVarName, propertyName, typeRef, setting)
			}
		}

		setBody(op, [// ITreeAppendable
			if (it == null) return
			val p = it.trace(ref);
			switch ref {
				LContainer: {
					p.append(operationsGenerator.set_toOne_Container_OperationContent(
										ref, localVarName, propertyName, typeRef, setting)).toString()
				}
				LContains: {
					p.append(operationsGenerator.set_toOne_Containment_OperationContent(
										ref, localVarName, propertyName, typeRef, setting)).toString();
				}
				LRefers: {
					p.append(operationsGenerator.set_toOne_Refers_OperationContent(
										ref, localVarName, propertyName, typeRef, setting)).toString();
				}
			}
		])

		return associate(ref, op);
	}

	def JvmOperation toSetter(LProperty sourceElement, String name, LGenSettings setting) {

		if (sourceElement.toMany) {
			throw new RuntimeException("toMany-References not allowed for setters!");
		}

		val result = toSetter(sourceElement, name, name,
				sourceElement.toMethodParamName,
				sourceElement.toTypeReference, 
				setting);

		associate(sourceElement, result);
	}

	
	def JvmOperation toSetter(LProperty sourceElement,
			String propertyName,
			String fieldName,
			String localVarName,
			JvmTypeReference typeRef,
			LGenSettings setting) {
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility::PUBLIC
		result.returnType = references.getTypeForName(Void::TYPE, sourceElement)
		result.simpleName = "set" + propertyName.toFirstUpper
		result.parameters += sourceElement.toParameter(localVarName, typeRef)
		setDocumentation(
				result,
				operationsGenerator.set_toOne_Property_Documentantion(
						sourceElement, localVarName, fieldName, typeRef,
						setting).toString());

		setBody(result, [ // ITreeAppendable
			if (it == null) return
			val p = it.trace(sourceElement);
			p.append(operationsGenerator.set_toOne_Property_OperationContent(
                        sourceElement, localVarName, fieldName, typeRef, setting)).toString();
		])

		return associate(sourceElement, result);
	}

	def JvmOperation toAdder(LReference ref, String propertyName, LGenSettings setting) {
        val localVarName = ref.toMethodParamName
        val typeRef = ref.type.toTypeReference
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility::PUBLIC
		result.returnType = references.getTypeForName(Void::TYPE, ref)
		result.simpleName = ref.toCollectionAdderName
        result.parameters += ref.toParameter(localVarName, typeRef)
		
		switch ref {
		    LContains: {
			    result.documentation = operationsGenerator.add_toMany_Containmant_Documentantion(
							             ref, localVarName, propertyName, typeRef, setting)
    	    } 
    	    LRefers: {
    		    result.documentation = operationsGenerator.add_toMany_Refers_Documentantion(
    							         ref, localVarName, propertyName, typeRef, setting)
            }
		}
		setBody(result, [ // ITreeAppendable
		    if (it == null) return
			val p = it.trace(ref);
            switch ref {
                LContains: {
				    p.append(operationsGenerator.add_toMany_Containmant_OperationContent(
								ref, localVarName, propertyName, typeRef, setting)).toString();
			    }
                LRefers: {
				    p.append(operationsGenerator.add_toMany_Refers_OperationContent(
								ref, localVarName, propertyName, typeRef, setting)).toString();
    			}
			}
		]);
		return associate(ref, result);
	}

    def JvmVisibility getInternalMethodVisibility(LReference ref) {
        val LPackage ownerPackage = (ref.eContainer() as LType).getPackage();
        val LPackage refPackage = ref.getType().getPackage();
        if (ownerPackage.equals(refPackage)) {
            null // package visibility
        } else { 
            JvmVisibility::PUBLIC 
        }
    }

	def JvmOperation toInternalSetter(LReference ref) {
        val paramName = ref.toMethodParamName
        val typeRef = ref.type.toTypeReference
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = getInternalMethodVisibility(ref)
		result.returnType = references.getTypeForName(Void::TYPE, ref)
		result.simpleName = ref.toInternalSetterName
		result.parameters += ref.toParameter(paramName, typeRef)

		setBody(result, [ // ITreeAppendable
			if (it == null) return
			val p = it.trace(ref)
			p.append("this." + ref.name + " = " + paramName  + ";")
		])
		return associate(ref, result);
	}
	
	def JvmOperation toInternalAdder(LReference ref, String propertyName, LGenSettings setting) {
        val paramName = ref.toMethodParamName
        val typeRef = ref.type.toTypeReference
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = getInternalMethodVisibility(ref)
		result.returnType = references.getTypeForName(Void::TYPE, ref)
		result.simpleName = ref.toCollectionInternalAdderName
		result.parameters += ref.toParameter(paramName, typeRef)

		setBody(result, [ // ITreeAppendable
			if (it == null) return
			val p = it.trace(ref);
			p.append(ref.toCollectionInternalGetterName + "()" + 
				     ".add(" + ref.toMethodParamName  + ");");
		])
		return associate(ref, result);
	}
	
	def JvmOperation toInternalRemover(LReference ref, String propertyName, LGenSettings setting) {
        val paramName = ref.toMethodParamName
        val typeRef = ref.type.toTypeReference
		val result = typesFactory.createJvmOperation();
		result.visibility = getInternalMethodVisibility(ref)
		result.returnType = references.getTypeForName(Void::TYPE, ref)
		result.simpleName = ref.toCollectionInternalRemoverName
		result.parameters += ref.toParameter(paramName, typeRef)
		
		setBody(result, [ //ITreeAppendable
			if (it == null) return
			val p = it.trace(ref)
			p.append(ref.toCollectionInternalGetterName + "()" + 
				     ".remove(" + ref.toMethodParamName  + ");");
		])
		return associate(ref, result)
	}
	
	def JvmOperation toAdder(LProperty prop, String propertyName, LGenSettings setting) {
		val JvmTypeReference typeRef = prop.toTypeReference
		val paramName = prop.toMethodParamName
		val JvmOperation result = typesFactory.createJvmOperation();
		result.visibility = JvmVisibility::PUBLIC
		result.returnType = references.getTypeForName(Void::TYPE, prop)
		result.simpleName = prop.toCollectionAdderName
		result.parameters += toParameter(prop, paramName, prop.type.toTypeReference)
    	result.documentation =
				operationsGenerator.add_toMany_Property_Documentantion(
						prop, paramName, propertyName, typeRef, setting)
		setBody(result, [ // ITreeAppendable
		    if (it == null) return
			val p = it.trace(prop);
			p += operationsGenerator.add_toMany_Property_OperationContent(
                                        prop, paramName, propertyName, typeRef, setting)
		])
		return associate(prop, result);
	}
	
	// Same as toInternalCollectionGetter(LProperty prop)
	// TODO Can be removed as soon as LReference extends LProperty
	def JvmOperation toInternalCollectionGetter(LReference ref, String name) {
		val String fieldName = name.toFirstLower
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PRIVATE
		op.returnType = ref.toTypeReference
		op.simpleName = ref.toCollectionInternalGetterName
		op.documentation = 
		    "Returns the list of " + htmlCode(ref.type.name) +  "s thereby lazy initializing it."
		setBody(op, [ // ITreeAppendable
            if (it == null) return;
            var p = it.trace(ref);
            val fieldRef = "this." + fieldName
            p >> "if (" + fieldRef + " == null)" >>> " {" 
            {
                p >> fieldRef >> " = new "
                  >> newTypeRef(ref, typeof(ArrayList), ref.type.toTypeReference)
                  >> "();"
            }
            p <<< "}"
            p >> "return " + fieldRef + ";"
		])
        ref.associate(op)
	}

	def JvmOperation toInternalCollectionGetter(LProperty prop, String name) {
		val fieldName = name.toFirstLower
		val JvmOperation op = typesFactory.createJvmOperation()
		op.visibility = JvmVisibility::PRIVATE
		op.returnType = prop.toTypeReference
		op.simpleName = prop.toCollectionInternalGetterName
		op.documentation =
		  "Returns the list of " + htmlCode(prop.type.name) + "s thereby lazy initializing it."
        setBody(op, [ // ITreeAppendable
            if (it == null) return;
            var p = it.trace(prop);
            val fieldRef = "this." + fieldName
            p >> "if (" + fieldRef + " == null)" >>> " {" 
            {
                p >> fieldRef >> " = new "
                  >> newTypeRef(prop, typeof(ArrayList), prop.type.toTypeReference)
                  >> "();"
            }
            p <<< "}"
            p >> "return " + fieldRef + ";"
        ])
		prop.associate(op)
	}

	def JvmOperation toRemover(LReference ref, String propertyName, LGenSettings setting) {
        val paramName = ref.toMethodParamName
        val typeRef = ref.type.toTypeReference
		val JvmOperation result = typesFactory.createJvmOperation()
		result.visibility = JvmVisibility::PUBLIC
		result.returnType = references.getTypeForName(Void::TYPE, ref)
		result.simpleName = "removeFrom" + propertyName.toFirstUpper
		result.parameters += ref.toParameter(paramName, typeRef)
		if (ref instanceof LContains) {
			setDocumentation(
					result,
					operationsGenerator
							.remove_toMany_Containmant_Documentantion(
									ref as LContains, paramName,
									propertyName, typeRef, setting).toString());
		} else if (ref instanceof LRefers) {
			setDocumentation(
					result,
					operationsGenerator.remove_toMany_Refers_Documentantion(
							ref as LRefers, paramName, propertyName,
							typeRef, setting).toString());
		}
		setBody(result, [ //ITreeAppendable
		    if (it == null) return
			val p = it.trace(ref);
			if (ref instanceof LContains) {
				p.append(operationsGenerator.remove_toMany_Containmant_OperationContent(
										ref as LContains,
										paramName, propertyName,
										typeRef, setting)).toString();
			} else if (ref instanceof LRefers) {
				p.append(operationsGenerator.remove_toMany_Refers_OperationContent(
										ref as LRefers,
										paramName, propertyName,
										typeRef, setting)).toString();
			}
		])
		return associate(ref, result);
	}

	def JvmOperation toRemover(LProperty prop,
                			   String propertyName,
                			   LGenSettings setting) {
        val paramName = prop.toMethodParamName
        val typeRef = prop.toTypeReference
		val op = typesFactory.createJvmOperation();
		op.visibility = JvmVisibility::PUBLIC
		op.returnType = references.getTypeForName(Void::TYPE, prop)
		op.simpleName = "removeFrom" + propertyName.toFirstUpper
		op.parameters += prop.toParameter(paramName, prop.type.toTypeReference)

		op.setDocumentation(operationsGenerator.remove_toMany_Property_Documentantion(
						prop, paramName, propertyName, typeRef,
						setting).toString())

        op.setBody([
		    if (it == null) return
			val p = it.trace(prop)
			p.append(operationsGenerator.remove_toMany_Property_OperationContent(
						prop, paramName, propertyName, typeRef, setting)).toString()
		])
		associate(prop, op);
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
}
