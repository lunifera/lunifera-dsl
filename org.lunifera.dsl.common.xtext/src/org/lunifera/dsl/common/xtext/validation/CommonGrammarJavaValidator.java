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
package org.lunifera.dsl.common.xtext.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.lunifera.dsl.common.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LPackage;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

import com.google.inject.Inject;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
public class CommonGrammarJavaValidator
		extends
		org.lunifera.dsl.common.xtext.validation.AbstractCommonGrammarJavaValidator {

	public static final String CODE__DUPLICATE_LPACKAGE_IN_PROJECT = "0_100";
	public static final String CODE__DUPLICATE_LTYPE_IN_PROJECT = "0_101";
	public static final String CODE__DUPLICATE_LPACKAGE_IN_FILE = "0_102";
	public static final String CODE__MANY_TO_MANY__NOT_SUPPORTED = "0_103";
	public static final String CODE__NOT_A_VALID_PRIMITIVE = "0_104";
	public static final String CODE__FORBIDDEN_JAVA_KEYWORD = "0_105";
	public static final String CODE__DUPLICATE_LDATATYPE_IN_PACKAGE = "0_106";

	@Inject
	private IQualifiedNameProvider qnp;
	@Inject
	private ModelExtensions extensions;
	@Inject
	private NamesAreUniqueValidator uniqueValidator;
	@Inject
	private IContainer.Manager containermanager;
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;

	public static final Set<String> javakeywords = new HashSet<String>();
	static {
		javakeywords.add("abstract");
		javakeywords.add("assert");
		javakeywords.add("boolean");
		javakeywords.add("break");
		javakeywords.add("byte");
		javakeywords.add("case");
		javakeywords.add("catch");
		javakeywords.add("char");
		javakeywords.add("class");
		javakeywords.add("const");
		javakeywords.add("continue");
		javakeywords.add("default");
		javakeywords.add("double");
		javakeywords.add("do");
		javakeywords.add("else");
		javakeywords.add("enum");
		javakeywords.add("extends");
		javakeywords.add("false");
		javakeywords.add("final");
		javakeywords.add("finally");
		javakeywords.add("float");
		javakeywords.add("for");
		javakeywords.add("goto");
		javakeywords.add("if");
		javakeywords.add("implements");
		javakeywords.add("import");
		javakeywords.add("instanceof");
		javakeywords.add("int");
		javakeywords.add("interface");
		javakeywords.add("native");
		javakeywords.add("new");
		javakeywords.add("null");
		javakeywords.add("package");
		javakeywords.add("private");
		javakeywords.add("protected");
		javakeywords.add("public");
		javakeywords.add("return");
		javakeywords.add("short");
		javakeywords.add("static");
		javakeywords.add("strictfp");
		javakeywords.add("super");
		javakeywords.add("switch");
		javakeywords.add("synchronized");
		javakeywords.add("this");
		javakeywords.add("throw");
		javakeywords.add("throws");
		javakeywords.add("transient");
		javakeywords.add("true");
		javakeywords.add("try");
		javakeywords.add("void");
		javakeywords.add("volatile");
		javakeywords.add("while");
	}

	private static final Set<String> primitiveWrappers = new HashSet<String>();
	static {
		primitiveWrappers.add("java.lang.Integer");
		primitiveWrappers.add("java.lang.Long");
		primitiveWrappers.add("java.lang.Short");
		primitiveWrappers.add("java.lang.Double");
		primitiveWrappers.add("java.lang.Float");
		primitiveWrappers.add("java.lang.Character");
		primitiveWrappers.add("java.lang.Byte");
		primitiveWrappers.add("java.lang.Boolean");
	}

	public Set<String> getKeywords() {
		return Collections.unmodifiableSet(javakeywords);
	}

	public void checkDatatype_asPrimitive(LDataType dt) {
		if (dt.isAsPrimitive()) {
			if (!primitiveWrappers.contains(dt.getJvmTypeReference()
					.getQualifiedName())) {
				error("The type is not a wrapper from a primitive type!", dt,
						LunTypesPackage.Literals.LDATA_TYPE__AS_PRIMITIVE,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						CODE__NOT_A_VALID_PRIMITIVE, (String[]) null);
			}
		}
	}

	public void checkProperties_JavaKeyWord(LFeature lprop) {
		if (lprop.getName() == null) {
			return;
		}
		if (javakeywords.contains(lprop.getName())) {
			error("The name of the property is a java keyword and not allowed!",
					LunTypesPackage.Literals.LFEATURE__NAME,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					CODE__FORBIDDEN_JAVA_KEYWORD, (String[]) null);
		}
	}

	public void checkDuplicateType_InProject(LType type) {
		Map<IContainer, List<LType>> lTypes = getAllFor(type);
		for (Map.Entry<IContainer, List<LType>> temp : lTypes.entrySet())
			if (temp.getValue().size() > 1) {
				error(String.format("Duplicate type %s in container", qnp
						.getFullyQualifiedName(type).toString()), type,
						LunTypesPackage.Literals.LTYPE__NAME,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						CODE__DUPLICATE_LTYPE_IN_PROJECT, (String[]) null);
			}
	}

	/**
	 * Returns a map with the container (class path entry) as key and a
	 * collection with the found types.
	 * 
	 * @param type
	 * @return
	 */
	public Map<IContainer, List<LType>> getAllFor(LType lType) {
		Map<IContainer, List<LType>> allEntities = new HashMap<IContainer, List<LType>>();
		IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider
				.getResourceDescriptions(lType.eResource());
		IResourceDescription resourceDescription = resourceDescriptions
				.getResourceDescription(lType.eResource().getURI());
		List<IContainer> visiblecontainers = containermanager
				.getVisibleContainers(resourceDescription, resourceDescriptions);
		for (IContainer container : visiblecontainers) {
			List<LType> types = new ArrayList<LType>();
			allEntities.put(container, types);
			if (lType.getName() == null) {
				continue;
			}
			for (IEObjectDescription eobjectDescription : container
					.getExportedObjects(LunTypesPackage.Literals.LTYPE,
							qnp.getFullyQualifiedName(lType), false)) {
				types.add((LType) eobjectDescription.getEObjectOrProxy());
			}
		}
		return allEntities;
	}

	public void checkDuplicatePackage_InProject(LPackage lPackage) {
		Map<IContainer, List<LPackage>> packages = getAllFor(lPackage);
		for (Map.Entry<IContainer, List<LPackage>> temp : packages.entrySet())
			if (temp.getValue().size() > 1) {
				warning(String.format("Duplicate package %s in container ", qnp
						.getFullyQualifiedName(lPackage).toString()), lPackage,
						LunTypesPackage.Literals.LPACKAGE__NAME,
						CODE__DUPLICATE_LPACKAGE_IN_PROJECT, (String[]) null);
			}
	}

	/**
	 * Returns a map with the container (class path entry) as key and a
	 * collection with the found packages.
	 * 
	 * @param type
	 * @return
	 */
	public Map<IContainer, List<LPackage>> getAllFor(LPackage lPackage) {
		Map<IContainer, List<LPackage>> allEntities = new HashMap<IContainer, List<LPackage>>();
		IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider
				.getResourceDescriptions(lPackage.eResource());
		IResourceDescription resourceDescription = resourceDescriptions
				.getResourceDescription(lPackage.eResource().getURI());
		List<IContainer> visiblecontainers = containermanager
				.getVisibleContainers(resourceDescription, resourceDescriptions);
		for (IContainer container : visiblecontainers) {
			List<LPackage> packages = new ArrayList<LPackage>();
			allEntities.put(container, packages);
			for (IEObjectDescription eobjectDescription : container
					.getExportedObjects(LunTypesPackage.Literals.LPACKAGE,
							qnp.getFullyQualifiedName(lPackage), false)) {
				packages.add((LPackage) eobjectDescription.getEObjectOrProxy());
			}
		}
		return allEntities;
	}

	public void checkDuplicateDatatypeInPackage(LTypedPackage pkg) {
		Set<String> names = new HashSet<String>();
		int counter = 0;
		for (LType type : pkg.getTypes()) {
			if (type instanceof LDataType) {
				String name = ((LDataType) type).getName();
				if (!names.add(name)) {
					error(String.format(
							"Datatype %s must be unique in package %s!", name,
							pkg.getName()),
							LunTypesPackage.Literals.LTYPED_PACKAGE__TYPES,
							counter, CODE__DUPLICATE_LDATATYPE_IN_PACKAGE,
							(String[]) null);
					break;
				}
			}
			counter++;
		}
	}

}
