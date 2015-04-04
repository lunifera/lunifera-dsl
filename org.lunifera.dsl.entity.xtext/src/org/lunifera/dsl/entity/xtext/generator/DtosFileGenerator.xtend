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
package org.lunifera.dsl.entity.xtext.generator

import com.google.inject.Inject
import java.util.Collections
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LDataType
import org.lunifera.dsl.semantic.common.types.LDateType
import org.lunifera.dsl.semantic.common.types.LEnum
import org.lunifera.dsl.semantic.common.types.LImport
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.common.types.LunTypesPackage
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LBeanFeature
import org.lunifera.dsl.semantic.entity.LBeanReference
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityAttribute
import org.lunifera.dsl.semantic.entity.LEntityFeature
import org.lunifera.dsl.semantic.entity.LEntityReference

/**
 *  This generator automatically creates a generic .dtos-file from a given entity model.
 * 	Imports, datatype declarations, enums and comments are carried over to the .dtos file, 
 * 	while bean and entity declarations are translated to DTO declarations with the
 *  appropriate inheritance information. Attributes and references are defined as inherited
 *  in this default conversion.
 */
class DtosFileGenerator {

	@Inject extension JvmTypesBuilder
	@Inject extension ModelExtensions
	@Inject extension IQualifiedNameConverter
	@Inject
	private ResourceDescriptionsProvider provider;

	IResourceDescriptions descriptions

	def getContent(LTypedPackage pkg) {

		descriptions = provider.getResourceDescriptions(pkg.eResource)

		return pkg.doGetContent
	}

	def doGetContent(LTypedPackage pkg) '''
		«pkg.toDocu»
		package «pkg.toDtoPackageName» {
			
			/* Imports the required artifacts */
			«pkg.toImports»
		
			«FOR LDataType lDatatype : pkg.datatypes»
				«lDatatype.toDocu»
				«lDatatype.toDataType»
			«ENDFOR»
		
			«FOR LEntity lEntity : pkg.entities»
				«lEntity.toDocu»
				«lEntity.toEntityDeclaration»
					«FOR LEntityFeature feature : lEntity.features.filter[
			(it instanceof LAttribute && !(it as LAttribute).derived) || (it instanceof LReference)]»
						«feature.toFeature»
					«ENDFOR»
					«FOR LEntityFeature feature : lEntity.features.filter[(it instanceof LAttribute && (it as LAttribute).derived)]»
						«(feature as LAttribute).toDerivedAttribute»
					«ENDFOR»
				}
				
			«ENDFOR»
			«FOR LBean lBean : pkg.beans»
				«lBean.toDocu»
				«lBean.toBeanDeclaration»
					«FOR LBeanFeature feature : lBean.features.filter[
			(it instanceof LAttribute && !(it as LAttribute).derived) || (it instanceof LReference)]»
						«feature.toFeature»
					«ENDFOR»
				}
				
			«ENDFOR»
			«FOR LEnum lEnum : pkg.enums»
				enum «lEnum.name» {
					«lEnum.toLiterals»
				}
				
			«ENDFOR»
		}
	'''

	def toEntityDeclaration(LEntity lEntity) {
		return '''
			«IF lEntity.abstract»abstract «ENDIF»autoDto «lEntity.name»Dto «IF lEntity.superType != null»extends «lEntity.
				superType.name»Dto «ENDIF»wraps «lEntity.name» {
		'''
	}

	def String toImports(LTypedPackage pkg) {
		val Set<String> imports = new HashSet()

		for (LImport lImport : pkg.imports) {
			imports += lImport.importedNamespace.findProper
		}

		for (EObject element : pkg.eAllContents.toIterable) {
			switch (element) {
				LEntity: {
					val LTypedPackage lPkg = element.eContainer as LTypedPackage;
					imports += lPkg.name + ".*"
					imports += lPkg.toDtoPackageName + ".*"
					imports += lPkg.toDtoPackageName + ".mapper.*"

					if (element.superType != null) {
						val LTypedPackage lSuperPkg = element.superType.eContainer as LTypedPackage;
						imports += lSuperPkg.toDtoPackageName + ".*"
						imports += lPkg.toDtoPackageName + ".mapper.*"
					}
				}
				LBean: {
					val LTypedPackage lPkg = element.eContainer as LTypedPackage;
					imports += lPkg.name + ".*"
					imports += lPkg.toDtoPackageName + ".*"
					imports += lPkg.toDtoPackageName + ".mapper.*"
					if (element.superType != null) {
						val LTypedPackage lSuperPkg = element.superType.eContainer as LTypedPackage;
						imports += lSuperPkg.toDtoPackageName + ".*"
						imports += lPkg.toDtoPackageName + ".mapper.*"
					}
				}
				LEnum: {
					val LTypedPackage lPkg = element.eContainer as LTypedPackage;
					imports += lPkg.name + ".*"
					imports += lPkg.toDtoPackageName + ".*"
					imports += lPkg.toDtoPackageName + ".mapper.*"
				}
				LEntityReference: {
					val LEntity lEntity = element.type
					val LTypedPackage lPkg = lEntity.eContainer as LTypedPackage;
					imports += lPkg.name + ".*"
					imports += lPkg.toDtoPackageName + ".*"
					imports += lPkg.toDtoPackageName + ".mapper.*"
				}
				LEntityAttribute: {
					if (element.type instanceof LBean) {
						val LBean lBean = element.type as LBean
						val LTypedPackage lPkg = lBean.eContainer as LTypedPackage;
						imports += lPkg.name + ".*"
						imports += lPkg.toDtoPackageName + ".*"
						imports += lPkg.toDtoPackageName + ".mapper.*"
					}
				}
			}
		}

		imports.remove(null)

		val List<String> sortable = newArrayList(imports)
		Collections.sort(sortable)

		val StringBuilder b = new StringBuilder
		for (String imported : sortable) {
			b.append("import ")
			b.append(imported)
			b.append(";")
			b.append("\n")
		}

		return b.toString
	}

	def findProper(String value) {
		val fqn = value.toQualifiedName

		// is already a wildcard import
		if (value.endsWith(".*")) {
			return value
		}

		var expected = fqn;
		while (expected != QualifiedName.EMPTY) {
			if (isPackage(expected)) {
				return expected.toString + ".*"
			} else {
				expected = expected.skipLast(1)
			}
		}
		return null
	}

	def boolean isPackage(QualifiedName fqn) {
		val result = descriptions.getExportedObjects(LunTypesPackage.Literals.LTYPED_PACKAGE, fqn, false)
		return !result.empty
	}

	def toBeanDeclaration(LBean lBean) {
		return '''
			autoDto «lBean.name»Dto «IF lBean.superType != null»extends «lBean.superType.name»Dto «ENDIF»wraps «lBean.name» {
		'''
	}

	def toDocu(EObject element) {
		var docu = element.documentation
		if (!docu.nullOrEmpty) {
			var docus = docu.split('\n')
			if (docus.length > 1) {
				return '''
				/**
				«FOR line : docus»
					«" * "»«line»
				«ENDFOR»
				 */'''.toString
			} else if (docus.length == 1) {
				return '''/** «docu» */'''.toString
			}
		}
		return ""
	}

	def dispatch toFeature(LAttribute att) '''
		«att.toDocu»
		inherit var «att.name»;
	'''

	def dispatch toFeature(LReference att) '''
		«att.toDocu»
		inherit ref «att.name»;
	'''

	def dispatch toFeature(LEntityReference att) '''
		«att.toDocu»
		inherit ref «att.name» mapto «att.type.name»Dto;
	'''

	def dispatch toFeature(LBeanReference att) '''
		«att.toDocu»
		inherit ref «att.name» mapto «att.type.name»Dto;
	'''

	def toDerivedAttribute(LAttribute att) '''
		«att.toDocu»
		derived «IF att.domainDescription»domainDescription «ENDIF» «att.type.name» «att.name» «att.blockExpression»
	'''

	def toLiterals(LEnum lEnum) {
		var result = new StringBuilder
		for (lit : lEnum.literals) {
			result.append(lit.name);
			result.append(", ");
		}

		return result.substring(0, result.length - 2)
	}

	def toDataType(LDataType lDatatype) {
		'''
			datatype «lDatatype.name» «IF lDatatype.date»dateType «IF lDatatype.dateType == LDateType.DATE»date«ELSEIF lDatatype.
				dateType == LDateType.TIME»time«ELSE»timestamp«ENDIF»«ELSEIF lDatatype.asBlob»as blob«ELSE»jvmType «lDatatype.
				jvmTypeReference.type.qualifiedName»«IF lDatatype.asPrimitive» as primitive«ENDIF»«ENDIF»;
		'''
	}

	def String toPackageName(LTypedPackage pkg) {
		pkg.name + ".dtos"
	}

	def Iterable<LDataType> datatypes(LTypedPackage pkg) {
		pkg.types.filter[it instanceof LDataType].map[it as LDataType];
	}

	def Iterable<LEntity> entities(LTypedPackage pkg) {
		pkg.types.filter[it instanceof LEntity].map[it as LEntity];
	}

	def Iterable<LBean> beans(LTypedPackage pkg) {
		pkg.types.filter[it instanceof LBean].map[it as LBean];
	}

	def Iterable<LEnum> enums(LTypedPackage pkg) {
		pkg.types.filter[it instanceof LEnum].map[it as LEnum];
	}

	def String blockExpression(LAttribute attribute) {
		val resource = attribute.eResource as XtextResource
		return resource.serializer.serialize(attribute.derivedGetterExpression)
	}

}
