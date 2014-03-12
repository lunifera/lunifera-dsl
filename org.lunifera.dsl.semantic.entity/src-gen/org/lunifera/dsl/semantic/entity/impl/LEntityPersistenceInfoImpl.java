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
package org.lunifera.dsl.semantic.entity.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LEntity Persistence Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityPersistenceInfoImpl#getSchemaName <em>Schema Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityPersistenceInfoImpl#getTableName <em>Table Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LEntityPersistenceInfoImpl extends MinimalEObjectImpl.Container implements LEntityPersistenceInfo
{
  /**
   * The default value of the '{@link #getSchemaName() <em>Schema Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSchemaName()
   * @generated
   * @ordered
   */
  protected static final String SCHEMA_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSchemaName() <em>Schema Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSchemaName()
   * @generated
   * @ordered
   */
  protected String schemaName = SCHEMA_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTableName()
   * @generated
   * @ordered
   */
  protected static final String TABLE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTableName()
   * @generated
   * @ordered
   */
  protected String tableName = TABLE_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LEntityPersistenceInfoImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return LunEntityPackage.Literals.LENTITY_PERSISTENCE_INFO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSchemaName()
  {
    return schemaName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSchemaName(String newSchemaName)
  {
    String oldSchemaName = schemaName;
    schemaName = newSchemaName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY_PERSISTENCE_INFO__SCHEMA_NAME, oldSchemaName, schemaName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTableName()
  {
    return tableName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTableName(String newTableName)
  {
    String oldTableName = tableName;
    tableName = newTableName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY_PERSISTENCE_INFO__TABLE_NAME, oldTableName, tableName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case LunEntityPackage.LENTITY_PERSISTENCE_INFO__SCHEMA_NAME:
        return getSchemaName();
      case LunEntityPackage.LENTITY_PERSISTENCE_INFO__TABLE_NAME:
        return getTableName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LunEntityPackage.LENTITY_PERSISTENCE_INFO__SCHEMA_NAME:
        setSchemaName((String)newValue);
        return;
      case LunEntityPackage.LENTITY_PERSISTENCE_INFO__TABLE_NAME:
        setTableName((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case LunEntityPackage.LENTITY_PERSISTENCE_INFO__SCHEMA_NAME:
        setSchemaName(SCHEMA_NAME_EDEFAULT);
        return;
      case LunEntityPackage.LENTITY_PERSISTENCE_INFO__TABLE_NAME:
        setTableName(TABLE_NAME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case LunEntityPackage.LENTITY_PERSISTENCE_INFO__SCHEMA_NAME:
        return SCHEMA_NAME_EDEFAULT == null ? schemaName != null : !SCHEMA_NAME_EDEFAULT.equals(schemaName);
      case LunEntityPackage.LENTITY_PERSISTENCE_INFO__TABLE_NAME:
        return TABLE_NAME_EDEFAULT == null ? tableName != null : !TABLE_NAME_EDEFAULT.equals(tableName);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (schemaName: ");
    result.append(schemaName);
    result.append(", tableName: ");
    result.append(tableName);
    result.append(')');
    return result.toString();
  }

} //LEntityPersistenceInfoImpl
