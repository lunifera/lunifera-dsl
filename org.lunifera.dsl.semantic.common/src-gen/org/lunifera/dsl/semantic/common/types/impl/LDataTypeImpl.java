/**
 */
package org.lunifera.dsl.semantic.common.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LDateType;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LData Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#getJvmTypeReference <em>Jvm Type Reference</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#isAsPrimitive <em>As Primitive</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#isDate <em>Date</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#getDateType <em>Date Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDataTypeImpl extends LScalarTypeImpl implements LDataType
{
  /**
   * The cached value of the '{@link #getJvmTypeReference() <em>Jvm Type Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJvmTypeReference()
   * @generated
   * @ordered
   */
  protected JvmTypeReference jvmTypeReference;

  /**
   * The default value of the '{@link #isAsPrimitive() <em>As Primitive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAsPrimitive()
   * @generated
   * @ordered
   */
  protected static final boolean AS_PRIMITIVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAsPrimitive() <em>As Primitive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAsPrimitive()
   * @generated
   * @ordered
   */
  protected boolean asPrimitive = AS_PRIMITIVE_EDEFAULT;

  /**
   * The default value of the '{@link #isDate() <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDate()
   * @generated
   * @ordered
   */
  protected static final boolean DATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDate() <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDate()
   * @generated
   * @ordered
   */
  protected boolean date = DATE_EDEFAULT;

  /**
   * The default value of the '{@link #getDateType() <em>Date Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateType()
   * @generated
   * @ordered
   */
  protected static final LDateType DATE_TYPE_EDEFAULT = LDateType.DATE;

  /**
   * The cached value of the '{@link #getDateType() <em>Date Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateType()
   * @generated
   * @ordered
   */
  protected LDateType dateType = DATE_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LDataTypeImpl()
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
    return LunTypesPackage.Literals.LDATA_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getJvmTypeReference()
  {
    return jvmTypeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetJvmTypeReference(JvmTypeReference newJvmTypeReference, NotificationChain msgs)
  {
    JvmTypeReference oldJvmTypeReference = jvmTypeReference;
    jvmTypeReference = newJvmTypeReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE, oldJvmTypeReference, newJvmTypeReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJvmTypeReference(JvmTypeReference newJvmTypeReference)
  {
    if (newJvmTypeReference != jvmTypeReference)
    {
      NotificationChain msgs = null;
      if (jvmTypeReference != null)
        msgs = ((InternalEObject)jvmTypeReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE, null, msgs);
      if (newJvmTypeReference != null)
        msgs = ((InternalEObject)newJvmTypeReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE, null, msgs);
      msgs = basicSetJvmTypeReference(newJvmTypeReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE, newJvmTypeReference, newJvmTypeReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAsPrimitive()
  {
    return asPrimitive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAsPrimitive(boolean newAsPrimitive)
  {
    boolean oldAsPrimitive = asPrimitive;
    asPrimitive = newAsPrimitive;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__AS_PRIMITIVE, oldAsPrimitive, asPrimitive));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDate()
  {
    return date;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDate(boolean newDate)
  {
    boolean oldDate = date;
    date = newDate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__DATE, oldDate, date));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDateType getDateType()
  {
    return dateType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDateType(LDateType newDateType)
  {
    LDateType oldDateType = dateType;
    dateType = newDateType == null ? DATE_TYPE_EDEFAULT : newDateType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__DATE_TYPE, oldDateType, dateType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE:
        return basicSetJvmTypeReference(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE:
        return getJvmTypeReference();
      case LunTypesPackage.LDATA_TYPE__AS_PRIMITIVE:
        return isAsPrimitive();
      case LunTypesPackage.LDATA_TYPE__DATE:
        return isDate();
      case LunTypesPackage.LDATA_TYPE__DATE_TYPE:
        return getDateType();
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
      case LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE:
        setJvmTypeReference((JvmTypeReference)newValue);
        return;
      case LunTypesPackage.LDATA_TYPE__AS_PRIMITIVE:
        setAsPrimitive((Boolean)newValue);
        return;
      case LunTypesPackage.LDATA_TYPE__DATE:
        setDate((Boolean)newValue);
        return;
      case LunTypesPackage.LDATA_TYPE__DATE_TYPE:
        setDateType((LDateType)newValue);
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
      case LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE:
        setJvmTypeReference((JvmTypeReference)null);
        return;
      case LunTypesPackage.LDATA_TYPE__AS_PRIMITIVE:
        setAsPrimitive(AS_PRIMITIVE_EDEFAULT);
        return;
      case LunTypesPackage.LDATA_TYPE__DATE:
        setDate(DATE_EDEFAULT);
        return;
      case LunTypesPackage.LDATA_TYPE__DATE_TYPE:
        setDateType(DATE_TYPE_EDEFAULT);
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
      case LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE:
        return jvmTypeReference != null;
      case LunTypesPackage.LDATA_TYPE__AS_PRIMITIVE:
        return asPrimitive != AS_PRIMITIVE_EDEFAULT;
      case LunTypesPackage.LDATA_TYPE__DATE:
        return date != DATE_EDEFAULT;
      case LunTypesPackage.LDATA_TYPE__DATE_TYPE:
        return dateType != DATE_TYPE_EDEFAULT;
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
    result.append(" (asPrimitive: ");
    result.append(asPrimitive);
    result.append(", date: ");
    result.append(date);
    result.append(", dateType: ");
    result.append(dateType);
    result.append(')');
    return result.toString();
  }

} //LDataTypeImpl
