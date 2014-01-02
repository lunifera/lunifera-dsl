/**
 */
package org.lunifera.dsl.semantic.entity.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.lunifera.dsl.semantic.entity.EntityPackage;
import org.lunifera.dsl.semantic.entity.LDiscriminatorType;
import org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LTable Per Subclass Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LTablePerSubclassStrategyImpl#getDiscriminatorColumn <em>Discriminator Column</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LTablePerSubclassStrategyImpl#getDiscriminatorType <em>Discriminator Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LTablePerSubclassStrategyImpl#getDiscriminatorValue <em>Discriminator Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LTablePerSubclassStrategyImpl extends MinimalEObjectImpl.Container implements LTablePerSubclassStrategy
{
  /**
   * The default value of the '{@link #getDiscriminatorColumn() <em>Discriminator Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiscriminatorColumn()
   * @generated
   * @ordered
   */
  protected static final String DISCRIMINATOR_COLUMN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDiscriminatorColumn() <em>Discriminator Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiscriminatorColumn()
   * @generated
   * @ordered
   */
  protected String discriminatorColumn = DISCRIMINATOR_COLUMN_EDEFAULT;

  /**
   * The default value of the '{@link #getDiscriminatorType() <em>Discriminator Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiscriminatorType()
   * @generated
   * @ordered
   */
  protected static final LDiscriminatorType DISCRIMINATOR_TYPE_EDEFAULT = LDiscriminatorType.INHERIT;

  /**
   * The cached value of the '{@link #getDiscriminatorType() <em>Discriminator Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiscriminatorType()
   * @generated
   * @ordered
   */
  protected LDiscriminatorType discriminatorType = DISCRIMINATOR_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getDiscriminatorValue() <em>Discriminator Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiscriminatorValue()
   * @generated
   * @ordered
   */
  protected static final String DISCRIMINATOR_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDiscriminatorValue() <em>Discriminator Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiscriminatorValue()
   * @generated
   * @ordered
   */
  protected String discriminatorValue = DISCRIMINATOR_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LTablePerSubclassStrategyImpl()
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
    return EntityPackage.Literals.LTABLE_PER_SUBCLASS_STRATEGY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDiscriminatorColumn()
  {
    return discriminatorColumn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDiscriminatorColumn(String newDiscriminatorColumn)
  {
    String oldDiscriminatorColumn = discriminatorColumn;
    discriminatorColumn = newDiscriminatorColumn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_COLUMN, oldDiscriminatorColumn, discriminatorColumn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDiscriminatorType getDiscriminatorType()
  {
    return discriminatorType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDiscriminatorType(LDiscriminatorType newDiscriminatorType)
  {
    LDiscriminatorType oldDiscriminatorType = discriminatorType;
    discriminatorType = newDiscriminatorType == null ? DISCRIMINATOR_TYPE_EDEFAULT : newDiscriminatorType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_TYPE, oldDiscriminatorType, discriminatorType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDiscriminatorValue()
  {
    return discriminatorValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDiscriminatorValue(String newDiscriminatorValue)
  {
    String oldDiscriminatorValue = discriminatorValue;
    discriminatorValue = newDiscriminatorValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_VALUE, oldDiscriminatorValue, discriminatorValue));
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
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_COLUMN:
        return getDiscriminatorColumn();
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_TYPE:
        return getDiscriminatorType();
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_VALUE:
        return getDiscriminatorValue();
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
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_COLUMN:
        setDiscriminatorColumn((String)newValue);
        return;
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_TYPE:
        setDiscriminatorType((LDiscriminatorType)newValue);
        return;
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_VALUE:
        setDiscriminatorValue((String)newValue);
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
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_COLUMN:
        setDiscriminatorColumn(DISCRIMINATOR_COLUMN_EDEFAULT);
        return;
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_TYPE:
        setDiscriminatorType(DISCRIMINATOR_TYPE_EDEFAULT);
        return;
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_VALUE:
        setDiscriminatorValue(DISCRIMINATOR_VALUE_EDEFAULT);
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
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_COLUMN:
        return DISCRIMINATOR_COLUMN_EDEFAULT == null ? discriminatorColumn != null : !DISCRIMINATOR_COLUMN_EDEFAULT.equals(discriminatorColumn);
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_TYPE:
        return discriminatorType != DISCRIMINATOR_TYPE_EDEFAULT;
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_VALUE:
        return DISCRIMINATOR_VALUE_EDEFAULT == null ? discriminatorValue != null : !DISCRIMINATOR_VALUE_EDEFAULT.equals(discriminatorValue);
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
    result.append(" (discriminatorColumn: ");
    result.append(discriminatorColumn);
    result.append(", discriminatorType: ");
    result.append(discriminatorType);
    result.append(", discriminatorValue: ");
    result.append(discriminatorValue);
    result.append(')');
    return result.toString();
  }

} //LTablePerSubclassStrategyImpl
