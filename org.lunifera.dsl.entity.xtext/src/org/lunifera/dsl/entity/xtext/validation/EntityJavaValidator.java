/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.validation;

import java.util.ArrayList;
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
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.lunifera.dsl.entity.semantic.model.EntityPackage;
import org.lunifera.dsl.entity.semantic.model.LEntity;
import org.lunifera.dsl.entity.semantic.model.LEntityModel;
import org.lunifera.dsl.entity.semantic.model.LPackage;
import org.lunifera.dsl.entity.semantic.model.LProperty;
import org.lunifera.dsl.entity.semantic.model.LType;
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions;

import com.google.inject.Inject;

public class EntityJavaValidator extends AbstractEntityGrammarJavaValidator {

	private static final Set<String> javakeywords = new HashSet<String>();
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

	public static final String CODE__DUPLICATE_LPACKAGE_IN_PROJECT = "100";
	public static final String CODE__DUPLICATE_LTYPE_IN_PROJECT = "101";
	public static final String CODE__DUPLICATE_LPACKAGE_IN_FILE = "102";

	@Inject
	IQualifiedNameProvider qnp;
	@Inject
	ModelExtensions extensions;
	@Inject
	NamesAreUniqueValidator uniqueValidator;
	@Inject
	IContainer.Manager containermanager;
	@Inject
	ResourceDescriptionsProvider resourceDescriptionsProvider;

	@Check
	public void checkJPA_ContainsHasOppositeReference(LProperty prop) {
		if (extensions.isToMany(prop) && prop.getOpposite() == null) {
			error("A bidirectional association needs an opposite reference.",
					EntityPackage.Literals.LPROPERTY__OPPOSITE);
		}
	}

	// ### @Check
	// public void checkJPA_ContainsHasOppositeReference(LContainer container) {
	// if (container.getOpposite() == null) {
	// warning("A container reference should have an opposite reference too. Otherwise the annotation type (ManyToOne or OneToOne) can not be determined!",
	// EntityPackage.Literals.LCONTAINER__OPPOSITE);
	// }
	// }

	// @Check
	// public void checkJPA_NotNull_LRefernce_OneToMany_NotNull_NotAllowed(
	// LReference lReference) {
	//
	// if (lReference instanceof LRefers) {
	// LRefers lRefers = (LRefers) lReference;
	// if (lRefers.isNotnull()) {
	// EntityBounds bounds = EntityBounds.createFor(lRefers
	// .getMultiplicity());
	// if (bounds.isToMany()) {
	// error("Modifier 'notnull' is not allowed for references with upper bound GREATER ONE",
	// EntityPackage.Literals.LREFERS__NOTNULL);
	// }
	// }
	// } else if (lReference instanceof LContains) {
	// LContains lContains = (LContains) lReference;
	// if (lContains.isNotnull()) {
	// EntityBounds bounds = EntityBounds.createFor(lContains
	// .getMultiplicity());
	// if (bounds.isToMany()) {
	// error("Modifier 'notnull' is not allowed for containment references with upper bound GREATER ONE",
	// EntityPackage.Literals.LCONTAINS__NOTNULL);
	// }
	// }
	// }
	// }

	@Check
	public void checkJPA_ID_LEntityHasOnlyOneId(LEntity entity) {
		int idCount = 0;
		int memberIndex = -1;
		int firstIdIndex = -1;
		for (LProperty prop : entity.getProperties()) {
			memberIndex++;
			if (prop instanceof LProperty) {
				LProperty p = (LProperty) prop;
				if (p.isId()) {
					idCount++;
					if (firstIdIndex == -1) {
						firstIdIndex = memberIndex;
					}
				}
			}
		}

		if (idCount == 0) {
			if (entity.getSuperType() == null) {
				// only check jpa model
				if (extensions.compilesToJPAModel(entity)) {
					warning("An entity should have an ID property",
							EntityPackage.Literals.LENTITY__PROPERTIES);
				}
			}
		} else if (idCount > 1) {
			error("An entity must only have one ID property",
					EntityPackage.Literals.LENTITY__PROPERTIES, memberIndex);
		}
	}

	// @Check
	// public void checkJPA_ID_SpecifiedBySuperclass(LEntity entity) {
	// // only check jpa model
	// if (!extensions.compilesToJPAModel(entity)) {
	// return;
	// }
	//
	// LClass superType = entity.getSuperType();
	// if (superType == null) {
	// return;
	// }
	//
	// boolean idFoundForSuperType = doesSupertypeContainIdProperty(entity);
	//
	// // lookup if an id property exists in the entity
	// int memberIndex = -1;
	// boolean idFound = false;
	// for (LProperty prop : entity.getProperties()) {
	// memberIndex++;
	// if (prop instanceof LProperty) {
	// LProperty p = (LProperty) prop;
	// if (p.isId()) {
	// idFound = true;
	// break;
	// }
	// }
	// }
	//
	// if (idFoundForSuperType && !idFound) {
	// // nothing to do!
	// }
	//
	// if (idFoundForSuperType && idFound) {
	// warning("A id property was already defined by the super type. You should remove it here.",
	// EntityPackage.Literals.LENTITY__PROPERTIES,
	// memberIndex);
	// }
	//
	// if (!idFoundForSuperType && !idFound) {
	// warning("Nor the entity or one of its super types define an id property. Check the type hierarchy.",
	// EntityPackage.Literals.LENTITY__PROPERTIES);
	// }
	// }
	//
	// /**
	// * Returns true, if any of the supertypes contains an id property.
	// *
	// * @param superType
	// * @return
	// */
	// private boolean doesSupertypeContainIdProperty(LEntity entity) {
	// LEntity superType = entity.getSuperType();
	// if (superType == null) {
	// return false;
	// }
	// boolean idFoundForSuperType = false;
	// for (LProperty prop : superType.getProperties()) {
	// if (prop instanceof LProperty) {
	// LProperty p = (LProperty) prop;
	// if (p.isId()) {
	// idFoundForSuperType = true;
	// break;
	// }
	// }
	// }
	//
	// if (!idFoundForSuperType) {
	// idFoundForSuperType = doesSupertypeContainIdProperty(superType);
	// }
	//
	// return idFoundForSuperType;
	// }
	//
	// /**
	// * Returns true, if any of the supertypes contains an id property.
	// *
	// * @param superType
	// * @return
	// */
	// private boolean doesSupertypeContainVersionProperty(LEntity entity) {
	// LEntity superType = entity.getSuperType();
	// if (superType == null) {
	// return false;
	// }
	// boolean versionFoundForSuperType = false;
	// for (LProperty prop : superType.getProperties()) {
	// if (prop instanceof LProperty) {
	// LProperty p = (LProperty) prop;
	// if (p.isVersion()) {
	// versionFoundForSuperType = true;
	// break;
	// }
	// }
	// }
	//
	// if (!versionFoundForSuperType) {
	// versionFoundForSuperType =
	// doesSupertypeContainVersionProperty(superType);
	// }
	//
	// return versionFoundForSuperType;
	// }
	//
	// @Check
	// public void checkJPA_Version_SpecifiedBySuperclass(LEntity entity) {
	// if (entity.getSuperType() == null) {
	// return;
	// }
	//
	// boolean versionContainedInSuperType =
	// doesSupertypeContainVersionProperty(entity);
	//
	// int memberIndex = -1;
	// boolean versionFound = false;
	// for (LProperty prop : entity.getProperties()) {
	// memberIndex++;
	// if (prop instanceof LProperty) {
	// LProperty p = (LProperty) prop;
	// if (p.isVersion()) {
	// versionFound = true;
	// break;
	// }
	// }
	// }
	//
	// if (versionContainedInSuperType && versionFound) {
	// warning("A version property was already defined in one of the super types.",
	// EntityPackage.Literals.LENTITY__PROPERTIES,
	// memberIndex);
	// }
	// }
	//
	// @Check
	// public void checkJPA_Version_LEntityHasOnlyOneVersion(LEntity entity) {
	// int versionCount = 0;
	// int memberIndex = -1;
	// for (LProperty prop : entity.getProperties()) {
	// memberIndex++;
	// if (prop instanceof LProperty) {
	// LProperty p = (LProperty) prop;
	// if (p.isVersion()) {
	// versionCount++;
	// }
	// }
	// }
	//
	// if (versionCount > 1) {
	// error("An entity must only have one version property",
	// EntityPackage.Literals.LENTITY__PROPERTIES,
	// memberIndex);
	// }
	// }
	//
	// private boolean isStringValid(String value) {
	// return value != null && !value.equals("");
	// }

	@Check
	public void checkProperties_JavaKeyWord(LProperty lprop) {
		if (javakeywords.contains(lprop.getName())) {
			error("The name of the property is an java keyword and not allowed!",
					EntityPackage.Literals.LPROPERTY__NAME);
		}
	}

	@Check
	public void checkDuplicatePackages_InFile(LEntityModel lmodel) {
		Set<String> names = new HashSet<String>();
		int counter = -1;
		for (LPackage pkg : lmodel.getPackages()) {
			counter++;
			String pkgName = qnp.getFullyQualifiedName(pkg).toString();
			if (names.contains(pkgName)) {
				error(String.format("Package %s must not be defined twice!",
						pkgName),
						EntityPackage.Literals.LENTITY_MODEL__PACKAGES,
						counter, CODE__DUPLICATE_LPACKAGE_IN_FILE,
						(String[]) null);
			}
			names.add(pkgName);
		}
	}

	@Check(CheckType.NORMAL)
	public void checkDuplicateType_InProject(LType type) {
		Map<IContainer, List<LType>> lTypes = getAllFor(type);
		for (Map.Entry<IContainer, List<LType>> temp : lTypes.entrySet())
			if (temp.getValue().size() > 1) {
				error(String.format("Duplicate type %s in container", qnp
						.getFullyQualifiedName(type).toString()), type,
						EntityPackage.Literals.LTYPE__NAME,
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
			for (IEObjectDescription eobjectDescription : container
					.getExportedObjects(EntityPackage.Literals.LTYPE,
							qnp.getFullyQualifiedName(lType), true)) {
				types.add((LType) eobjectDescription.getEObjectOrProxy());
			}
		}
		return allEntities;
	}

	@Check(CheckType.NORMAL)
	public void checkDuplicatePackage_InProject(LPackage lPackage) {
		Map<IContainer, List<LPackage>> packages = getAllFor(lPackage);
		for (Map.Entry<IContainer, List<LPackage>> temp : packages.entrySet())
			if (temp.getValue().size() > 1) {
				warning(String.format("Duplicate package %s in container ", qnp
						.getFullyQualifiedName(lPackage).toString()), lPackage,
						EntityPackage.Literals.LPACKAGE__NAME,
						CODE__DUPLICATE_LTYPE_IN_PROJECT, (String[]) null);
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
					.getExportedObjects(EntityPackage.Literals.LPACKAGE,
							qnp.getFullyQualifiedName(lPackage), true)) {
				packages.add((LPackage) eobjectDescription.getEObjectOrProxy());
			}
		}
		return allEntities;
	}
}
