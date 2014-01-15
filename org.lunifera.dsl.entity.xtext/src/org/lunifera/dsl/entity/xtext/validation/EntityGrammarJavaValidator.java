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
package org.lunifera.dsl.entity.xtext.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
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
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.semantic.common.helper.Bounds;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LPackage;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;
import org.lunifera.dsl.semantic.entity.EntityPackage;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LDiscriminatorType;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LEntityFeature;
import org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy;
import org.lunifera.dsl.semantic.entity.LEntityModel;
import org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo;
import org.lunifera.dsl.semantic.entity.LEntityReference;
import org.lunifera.dsl.semantic.entity.LTablePerClassStrategy;
import org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy;

import com.google.inject.Inject;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
public class EntityGrammarJavaValidator extends
		AbstractEntityGrammarJavaValidator {

	public static final String CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE = "104";
	public static final String CODE__INHERITANCE_PROPERTY_IGNORED = "105";
	public static final String CODE__INHERITANCE_DISCRIMINATOR_VALUE_NOT_UNIQUE = "106";
	public static final String CODE__DUPLICATE_PERSISTENCE = "106";
	public static final String CODE__DUPLICATE_ID = "107";
	public static final String CODE__DUPLICATE_VERSION = "108";
	public static final String CODE__MISSING_ID = "109";
	public static final String CODE__DUPLICATE_PROPERTY_NAME = "110";
	public static final String CODE__MISSING_OPPOSITE_REFERENCE = "111";
	public static final String CODE__BIDIRECTIONAL_CASCADE_INVALID = "112";
	public static final String CODE__CASCADE_DIRECTION_INVALID = "113";
	public static final String CODE__UUID_WRONG_TYPE = "114";
	public static final String CODE__OPPOSITE_WITHOUT_CASCADE = "115";
	public static final String CODE__MISSING_ID_FOR_VERSIONED = "116";
	public static final String CODE__HISTORIZED_IN_SUBCLASS = "117";

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
	public void checkDatatype_asPrimitive(LDataType dt) {
		super.checkDatatype_asPrimitive(dt);
	}

	@Check
	public void checkJPA_MultiHasOppositeReference(LEntityReference prop) {
		if (extensions.isToMany(prop) && prop.getOpposite() == null) {
			error("A 'to-many' association needs an opposite reference.",
					EntityPackage.Literals.LENTITY_REFERENCE__OPPOSITE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					CODE__MISSING_OPPOSITE_REFERENCE, (String[]) null);
		}
	}

	@Check
	public void checkBean_MultiHasOppositeReference(LBeanReference prop) {
		if (extensions.isToMany(prop) && prop.getOpposite() == null) {
			error("A bidirectional association needs an opposite reference.",
					EntityPackage.Literals.LBEAN_REFERENCE__OPPOSITE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					CODE__MISSING_OPPOSITE_REFERENCE, (String[]) null);
		}
	}

	@Check
	public void checkJPA_OppositeNotAlsoCascading(LEntityReference prop) {
		if (prop.getOpposite() != null) {
			if (prop.isCascading() && prop.getOpposite().isCascading()) {
				error("Only one opposite may be specified as cascade",
						LunTypesPackage.Literals.LREFERENCE__CASCADING,
						CODE__BIDIRECTIONAL_CASCADE_INVALID, (String[]) null);
			}

			if (extensions.isToMany(prop.getOpposite())) {
				if (prop.isCascading()) {
					error("Cascade must not affect the common parent in a many-to-one relation",
							prop,
							LunTypesPackage.Literals.LREFERENCE__CASCADING,
							CODE__CASCADE_DIRECTION_INVALID, new String[0]);
				}
			}
		}
	}

	@Check
	public void checkJPA_Opposite_OneIsCascading(LEntityReference prop) {
		Bounds propBound = extensions.getBounds(prop);
		Bounds oppositeBound = extensions.getBounds(prop.getOpposite());

		if (propBound.isToMany() || oppositeBound.isToMany()) {
			// no check required!
			return;
		}

		if (prop.getOpposite() != null) {
			if (!prop.isCascading() && !prop.getOpposite().isCascading()) {
				error("Opposite references may only defined for cascading relations.",
						prop, LunTypesPackage.Literals.LREFERENCE__CASCADING,
						CODE__OPPOSITE_WITHOUT_CASCADE, new String[0]);
			}
		}
	}

	@Check
	public void checkBean_OppositeNotAlsoCascading(LBeanReference prop) {
		if (prop.getOpposite() != null) {
			if (prop.isCascading() && prop.getOpposite().isCascading()) {
				error("Only one opposite may be specified as cascade",
						LunTypesPackage.Literals.LREFERENCE__CASCADING,
						CODE__BIDIRECTIONAL_CASCADE_INVALID, (String[]) null);
			}

			if (extensions.isToMany(prop.getOpposite())) {
				if (prop.isCascading()) {
					error("Cascade must not affect the common parent in a many-to-one relation",
							prop,
							LunTypesPackage.Literals.LREFERENCE__CASCADING,
							CODE__CASCADE_DIRECTION_INVALID, new String[0]);
				}
			}
		}
	}

	@Check
	public void checkProperties_JavaKeyWord(LFeature lprop) {
		super.checkProperties_JavaKeyWord(lprop);
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
		if (type instanceof LDataType) {
			return;
		}
		super.checkDuplicateType_InProject(type);
	}

	@Check(CheckType.NORMAL)
	public void checkDuplicateDatatypeInPackage(LTypedPackage pkg) {
		super.checkDuplicateDatatypeInPackage(pkg);
	}

	@Check(CheckType.NORMAL)
	public void checkDuplicatePackage_InProject(LPackage lPackage) {
		super.checkDuplicatePackage_InProject(lPackage);
	}

	@Check
	public void checkBeanManyToMany(LBeanReference prop) {
		ModelExtensions extension = new ModelExtensions();
		if (prop.getOpposite() != null && extension.isToMany(prop)
				&& extension.isToMany(prop.getOpposite())) {
			error(String.format("ManyToMany relations are not permitted!", qnp
					.getFullyQualifiedName(prop).toString()),
					EntityPackage.Literals.LBEAN_REFERENCE__OPPOSITE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					CODE__MANY_TO_MANY__NOT_SUPPORTED, (String[]) null);
		}
	}

	@Check
	public void checkManyToMany(LEntityReference prop) {
		ModelExtensions extension = new ModelExtensions();
		if (prop.getOpposite() != null && extension.isToMany(prop)
				&& extension.isToMany(prop.getOpposite())) {
			error(String.format("ManyToMany relations are not permitted!", qnp
					.getFullyQualifiedName(prop).toString()),
					EntityPackage.Literals.LENTITY_REFERENCE__OPPOSITE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					CODE__MANY_TO_MANY__NOT_SUPPORTED, (String[]) null);
		}
	}

	@Check(CheckType.NORMAL)
	public void checkJPA_ConsistentInheritanceStrategy(LEntity entity) {
		// no checks required - inheritance is inherited
		if (entity.getInheritanceStrategy() == null) {
			return;
		}

		LEntityInheritanceStrategy differingSuperStgy = searchDifferingSuperStrategy(
				entity.getInheritanceStrategy(), entity);
		if (differingSuperStgy != null) {
			LEntity superType = (LEntity) differingSuperStgy.eContainer();
			warning(String.format(
					"The supertype %s uses the inheritance strategy %s. The inheritance of this entity is ignored!",
					qnp.getFullyQualifiedName(superType).toString(),
					getStrategyName(differingSuperStgy)),
					EntityPackage.Literals.LENTITY__INHERITANCE_STRATEGY,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE, (String[]) null);
		}
	}

	@Check(CheckType.NORMAL)
	public void checkJPA_Features(LEntityAttribute prop) {
		if (prop.isUuid()) {
			boolean typeOK = false;
			if (prop.getType() instanceof LDataType) {
				LDataType type = (LDataType) prop.getType();
				String typename = type.getJvmTypeReference().getQualifiedName();
				if (typename.equals("java.lang.String")) {
					typeOK = true;
				}
			}

			if (!typeOK) {
				error("UUIDs must be of type String.",
						EntityPackage.Literals.LENTITY_ATTRIBUTE__UUID,
						CODE__UUID_WRONG_TYPE, new String[0]);
			}
		}
	}

	@Check(CheckType.NORMAL)
	public void checkJPA_Historized(LEntity entity) {
		if (entity.isHistorized()) {
			if (entity.getSuperType() != null
					&& !entity.getSuperType().isMappedSuperclass()) {
				error("Keyword historized may only be used in toplevel entities of inheritance hierarchy",
						EntityPackage.Literals.LENTITY__HISTORIZED,
						CODE__HISTORIZED_IN_SUBCLASS, new String[0]);
			}
		}

		if (entity.isTimedependent()) {
			if (entity.getSuperType() != null
					&& !entity.getSuperType().isMappedSuperclass()) {
				error("Keyword historized may only be used in toplevel entities of inheritance hierarchy",
						EntityPackage.Literals.LENTITY__TIMEDEPENDENT,
						CODE__HISTORIZED_IN_SUBCLASS, new String[0]);
			}
		}
	}

	@Check(CheckType.NORMAL)
	public void checkJPA_Features(LEntity entity) {

		int idCounter = 0;
		int versionCounter = 0;
		Map<String, Integer> attNames = new HashMap<String, Integer>();
		for (LEntityFeature feature : entity.getAllFeatures()) {
			if (feature instanceof LEntityAttribute) {
				LEntityAttribute att = (LEntityAttribute) feature;
				if (att.isId() || att.isUuid())
					idCounter++;
				if (att.isVersion())
					versionCounter++;
			}

			if (!attNames.containsKey(feature.getName())) {
				attNames.put(feature.getName(), 1);
			} else {
				int value = attNames.get(feature.getName());
				attNames.put(feature.getName(), ++value);
			}
		}

		if (idCounter == 0
				&& (entity.isHistorized() || entity.isTimedependent())) {
			error("An historized or timedependent entity must have an ID property",
					EntityPackage.Literals.LENTITY__FEATURES,
					CODE__MISSING_ID_FOR_VERSIONED);
		} else

		if (idCounter == 0) {
			warning("An entity should have an ID property",
					EntityPackage.Literals.LENTITY__FEATURES, CODE__MISSING_ID);
		} else if (idCounter > 1) {
			int i = 0;
			for (LEntityFeature feature : entity.getFeatures()) {
				if (feature instanceof LEntityAttribute) {
					if (((LEntityAttribute) feature).isId()
							|| ((LEntityAttribute) feature).isUuid()) {
						error("An entity must only have one ID property.",
								EntityPackage.Literals.LENTITY__FEATURES, i,
								CODE__DUPLICATE_ID, new String[0]);
						break;
					}
				}

				i++;
			}
		}
		if (versionCounter > 1) {
			int i = 0;
			for (LEntityFeature feature : entity.getFeatures()) {
				if (feature instanceof LEntityAttribute) {
					if (((LEntityAttribute) feature).isVersion()) {
						error("An entity must only have one Version property.",
								EntityPackage.Literals.LENTITY__FEATURES, i,
								CODE__DUPLICATE_VERSION, new String[0]);
						break;
					}
				}
				i++;
			}
		}

		for (Map.Entry<String, Integer> entry : attNames.entrySet()) {
			if (entry.getValue() > 1) {
				int i = 0;
				for (LEntityFeature feature : entity.getFeatures()) {
					if (feature.getName().equals(entry.getKey())) {
						error(String.format(
								"The property \"%s\" must only be defined once!",
								feature.getName()),
								EntityPackage.Literals.LENTITY__FEATURES, i,
								CODE__DUPLICATE_PROPERTY_NAME, new String[0]);
						break;
					}
					i++;
				}
			}
		}
	}

	protected String getStrategyName(LEntityInheritanceStrategy stgy) {
		if (LTablePerClassStrategy.class.isAssignableFrom(stgy.getClass())) {
			return "Table-Per-Class";
		} else {
			return "Table-Per-Subclass";
		}
	}

	protected LEntityInheritanceStrategy searchDifferingSuperStrategy(
			LEntityInheritanceStrategy stgy, LEntity entity) {
		LEntity superEntity = entity.getSuperType();
		if (superEntity == null) {
			return null;
		}

		LEntityInheritanceStrategy superStgy = superEntity
				.getInheritanceStrategy();
		if (superStgy == null) {
			return searchDifferingSuperStrategy(stgy, superEntity);
		}

		if (!stgy.getClass().getName().equals(superStgy.getClass().getName())) {
			return superStgy;
		}

		return searchDifferingSuperStrategy(stgy, superEntity);
	}

	@Check(CheckType.NORMAL)
	public void checkJPA_IgnoredInheritanceStrategyProperties(LEntity entity) {
		// no checks required - inheritance is inherited
		LEntityInheritanceStrategy stgy = entity.getInheritanceStrategy();
		if (stgy == null) {
			return;
		}

		if (entity.getSuperType() != null
				&& !extensions.checkIsMappedSuperclass(entity.getSuperType())) {
			if (LTablePerClassStrategy.class.isAssignableFrom(stgy.getClass())) {
				LTablePerClassStrategy castStgy = (LTablePerClassStrategy) stgy;
				if (castStgy.getDiscriminatorColumn() != null) {
					sendIgnoredInheritancePropertyWarning(
							stgy,
							EntityPackage.Literals.LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_COLUMN);
				}
				if (castStgy.getDiscriminatorType() != LDiscriminatorType.INHERIT) {
					sendIgnoredInheritancePropertyWarning(
							stgy,
							EntityPackage.Literals.LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_TYPE);
				}
			} else {
				LTablePerSubclassStrategy castStgy = (LTablePerSubclassStrategy) stgy;
				if (castStgy.getDiscriminatorColumn() != null) {
					sendIgnoredInheritancePropertyWarning(
							stgy,
							EntityPackage.Literals.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_COLUMN);
				}
				if (castStgy.getDiscriminatorType() != LDiscriminatorType.INHERIT) {
					sendIgnoredInheritancePropertyWarning(
							stgy,
							EntityPackage.Literals.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_TYPE);
				}
			}
		}
	}

	@Check(CheckType.NORMAL)
	public void checkJPA_InheritanceStrategy_NotUniqueDiscriminatorValue(
			LEntity entity) {
		if (entity.getSuperType() == null) {
			return;
		}

		String currentValue = extensions.toDiscriminatorValue(extensions
				.toInheritanceStrategy(entity));

		// collect all super type strategies
		List<LEntityInheritanceStrategy> stgies = extensions
				.collectAllInheritanceStrategies(entity.getSuperType());

		for (LEntityInheritanceStrategy stgy : stgies) {
			String value = extensions.toDiscriminatorValue(stgy);
			if (value.equals(currentValue)) {
				error(String.format(
						"The discrimator value %s is already used by supertype!",
						value), entity,
						EntityPackage.Literals.LENTITY__INHERITANCE_STRATEGY,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						CODE__INHERITANCE_DISCRIMINATOR_VALUE_NOT_UNIQUE,
						(String[]) null);
			}
		}
	}

	@Check(CheckType.NORMAL)
	public void checkDuplicatePersistentFQN_InProject(LEntity entity) {
		LEntityPersistenceInfo info = entity.getPersistenceInfo();
		if (info == null) {
			return;
		}
		Map<IContainer, List<LEntityPersistenceInfo>> lTypes = getAllPersistentFQNsFor(info);
		for (Map.Entry<IContainer, List<LEntityPersistenceInfo>> temp : lTypes
				.entrySet())
			if (temp.getValue().size() > 1) {
				error(String.format("Persistence type %s is already defined!",
						qnp.getFullyQualifiedName(info).toString()), entity,
						EntityPackage.Literals.LENTITY__PERSISTENCE_INFO,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						CODE__DUPLICATE_PERSISTENCE, (String[]) null);
			}
	}

	private void sendIgnoredInheritancePropertyWarning(
			LEntityInheritanceStrategy stgy, EAttribute att) {
		warning("Inherited from parent entity. Will be ignored.", stgy, att,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
				CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE, (String[]) null);
	}

	public Map<IContainer, List<LEntityPersistenceInfo>> getAllPersistentFQNsFor(
			LEntityPersistenceInfo info) {
		Map<IContainer, List<LEntityPersistenceInfo>> allEntities = new HashMap<IContainer, List<LEntityPersistenceInfo>>();
		IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider
				.getResourceDescriptions(info.eResource());
		IResourceDescription resourceDescription = resourceDescriptions
				.getResourceDescription(info.eResource().getURI());
		List<IContainer> visiblecontainers = containermanager
				.getVisibleContainers(resourceDescription, resourceDescriptions);
		for (IContainer container : visiblecontainers) {
			List<LEntityPersistenceInfo> types = new ArrayList<LEntityPersistenceInfo>();
			allEntities.put(container, types);
			for (IEObjectDescription eObjectDescription : container
					.getExportedObjects(
							EntityPackage.Literals.LENTITY_PERSISTENCE_INFO,
							qnp.getFullyQualifiedName(info), true)) {
				types.add((LEntityPersistenceInfo) eObjectDescription
						.getEObjectOrProxy());
			}
		}
		return allEntities;
	}
}
