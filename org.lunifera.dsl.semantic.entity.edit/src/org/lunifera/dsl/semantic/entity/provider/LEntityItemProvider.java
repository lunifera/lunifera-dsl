/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 *  All rights reserved. This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html 
 * 
 *  Based on ideas from Xtext, Xtend, Xcore
 *    
 *  Contributors:  
 *  		Florian Pirchner - Initial implementation 
 *  
 */
package org.lunifera.dsl.semantic.entity.provider;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;
import org.lunifera.dsl.semantic.common.types.provider.LClassItemProvider;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LunEntityFactory;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

/**
 * This is the item provider adapter for a {@link org.lunifera.dsl.semantic.entity.LEntity} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class LEntityItemProvider extends LClassItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LEntityItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCacheablePropertyDescriptor(object);
			addHistorizedPropertyDescriptor(object);
			addTimedependentPropertyDescriptor(object);
			addTimedependentDateTypePropertyDescriptor(object);
			addMappedSuperclassPropertyDescriptor(object);
			addSuperTypePropertyDescriptor(object);
			addSubTypesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Cacheable feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCacheablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LEntity_cacheable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LEntity_cacheable_feature", "_UI_LEntity_type"),
				 LunEntityPackage.Literals.LENTITY__CACHEABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Historized feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHistorizedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LEntity_historized_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LEntity_historized_feature", "_UI_LEntity_type"),
				 LunEntityPackage.Literals.LENTITY__HISTORIZED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Timedependent feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTimedependentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LEntity_timedependent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LEntity_timedependent_feature", "_UI_LEntity_type"),
				 LunEntityPackage.Literals.LENTITY__TIMEDEPENDENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Timedependent Date Type feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimedependentDateTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LEntity_timedependentDateType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LEntity_timedependentDateType_feature", "_UI_LEntity_type"),
				 LunEntityPackage.Literals.LENTITY__TIMEDEPENDENT_DATE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mapped Superclass feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMappedSuperclassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LEntity_mappedSuperclass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LEntity_mappedSuperclass_feature", "_UI_LEntity_type"),
				 LunEntityPackage.Literals.LENTITY__MAPPED_SUPERCLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Super Type feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSuperTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LEntity_superType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LEntity_superType_feature", "_UI_LEntity_type"),
				 LunEntityPackage.Literals.LENTITY__SUPER_TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sub Types feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSubTypesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LEntity_subTypes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LEntity_subTypes_feature", "_UI_LEntity_type"),
				 LunEntityPackage.Literals.LENTITY__SUB_TYPES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(LunEntityPackage.Literals.LENTITY__PERSISTENCE_INFO);
			childrenFeatures.add(LunEntityPackage.Literals.LENTITY__INHERITANCE_STRATEGY);
			childrenFeatures.add(LunEntityPackage.Literals.LENTITY__FEATURES);
			childrenFeatures.add(LunEntityPackage.Literals.LENTITY__INDEXES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns LEntity.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return composeImage(getResourceLocator()
				.getImage("full/obj16/LEntity.gif"), getOverlay((LEntity) object));
	}

	private Object getOverlay(LEntity object) {
		if (object.isAbstract()) {
			return getResourceLocator().getImage("full/ovr/abstract.gif");
		} else if (object.isTimedependent()) {
			return getResourceLocator().getImage("full/ovr/timedependent.gif");
		}
		return null;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((LEntity)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_LEntity_type") :
			getString("_UI_LEntity_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(LEntity.class)) {
			case LunEntityPackage.LENTITY__CACHEABLE:
			case LunEntityPackage.LENTITY__HISTORIZED:
			case LunEntityPackage.LENTITY__TIMEDEPENDENT:
			case LunEntityPackage.LENTITY__TIMEDEPENDENT_DATE_TYPE:
			case LunEntityPackage.LENTITY__MAPPED_SUPERCLASS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case LunEntityPackage.LENTITY__PERSISTENCE_INFO:
			case LunEntityPackage.LENTITY__INHERITANCE_STRATEGY:
			case LunEntityPackage.LENTITY__FEATURES:
			case LunEntityPackage.LENTITY__INDEXES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LTYPE__ANNOTATION_INFO,
				 LunEntityFactory.eINSTANCE.createLBean()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LTYPE__ANNOTATION_INFO,
				 LunEntityFactory.eINSTANCE.createLEntity()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LTYPE__ANNOTATION_INFO,
				 LunEntityFactory.eINSTANCE.createLEntityFeature()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LTYPE__ANNOTATION_INFO,
				 LunEntityFactory.eINSTANCE.createLEntityAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LTYPE__ANNOTATION_INFO,
				 LunEntityFactory.eINSTANCE.createLEntityReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LTYPE__ANNOTATION_INFO,
				 LunEntityFactory.eINSTANCE.createLBeanFeature()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LTYPE__ANNOTATION_INFO,
				 LunEntityFactory.eINSTANCE.createLBeanAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LTYPE__ANNOTATION_INFO,
				 LunEntityFactory.eINSTANCE.createLBeanReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LTYPE__ANNOTATION_INFO,
				 LunEntityFactory.eINSTANCE.createLOperation()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LENTITY__PERSISTENCE_INFO,
				 LunEntityFactory.eINSTANCE.createLEntityPersistenceInfo()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LENTITY__INHERITANCE_STRATEGY,
				 LunEntityFactory.eINSTANCE.createLTablePerClassStrategy()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LENTITY__INHERITANCE_STRATEGY,
				 LunEntityFactory.eINSTANCE.createLTablePerSubclassStrategy()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LENTITY__FEATURES,
				 LunEntityFactory.eINSTANCE.createLEntityFeature()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LENTITY__FEATURES,
				 LunEntityFactory.eINSTANCE.createLEntityAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LENTITY__FEATURES,
				 LunEntityFactory.eINSTANCE.createLEntityReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LENTITY__FEATURES,
				 LunEntityFactory.eINSTANCE.createLOperation()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LENTITY__INDEXES,
				 LunEntityFactory.eINSTANCE.createLIndex()));
	}

	/**
	 * This returns the label text for
	 * {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == LunTypesPackage.Literals.LTYPE__ANNOTATION_INFO ||
			childFeature == LunEntityPackage.Literals.LENTITY__FEATURES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EntityEditPlugin.INSTANCE;
	}

}
