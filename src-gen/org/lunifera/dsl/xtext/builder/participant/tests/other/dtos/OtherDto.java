package org.lunifera.dsl.xtext.builder.participant.tests.other.dtos;

@SuppressWarnings("all")
public class OtherDto implements org.lunifera.dsl.xtext.builder.participant.tests.dtos.SuperDto, java.io.Serializable {
  private org.lunifera.dsl.xtext.builder.participant.tests.dtos.MyEntityDto myEntity;
  
  private /*  */Object someValue;
  
  /**
   * Checks whether the object is disposed.
   * @throws RuntimeException if the object is disposed.
   */
  private void checkDisposed() {
    if (isDisposed()) {
      throw new RuntimeException("Object already disposed: " + this);
    }
  }
  
  /**
   * Calling dispose will destroy that instance. The internal state will be 
   * set to 'disposed' and methods of that object must not be used anymore. 
   * Each call will result in runtime exceptions.<br/>
   * If this object keeps composition containments, these will be disposed too. 
   * So the whole composition containment tree will be disposed on calling this method.
   */
  public void dispose() {
    if (isDisposed()) {
      return;
    }
    super.dispose();
  }
  
  /**
   * Returns the myEntity property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.xtext.builder.participant.tests.dtos.MyEntityDto getMyEntity() {
    checkDisposed();
    return this.myEntity;
  }
  
  /**
   * Sets the <code>myEntity</code> property to this instance.
   * 
   * @param myEntity - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setMyEntity(final org.lunifera.dsl.xtext.builder.participant.tests.dtos.MyEntityDto myEntity) {
    checkDisposed();
    firePropertyChange("myEntity", this.myEntity, this.myEntity = myEntity);
  }
  
  /**
   * Returns the someValue property or <code>null</code> if not present.
   */
  public /*  */Object getSomeValue() {
    checkDisposed();
    return this.someValue;
  }
  
  /**
   * Sets the <code>someValue</code> property to this instance.
   * 
   * @param someValue - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSomeValue(final /*  */Object someValue) {
    firePropertyChange("someValue", this.someValue, this.someValue = someValue );
  }
}
