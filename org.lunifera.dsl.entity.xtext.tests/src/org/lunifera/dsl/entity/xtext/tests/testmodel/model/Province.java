package org.lunifera.dsl.entity.xtext.tests.testmodel.model;

import org.lunifera.dsl.entity.xtext.tests.testmodel.model.Country;

public class Province {
  private boolean disposed;
  
  private boolean settingCountry;
  
  private Country country;
  
  private String info_shortText;
  
  private String info_longText;
  
  /**
   * Returns true, if the object is disposed. Disposed means, that it is
   * prepared for garbage collection and may not be used anymore. Accessing
   * objects that are already disposed will cause runtime exceptions.
   * 
   * @return true if the object is disposed and false otherwise
   */
  public boolean isDisposed() {
    return this.disposed;
  }
  
  /**
   * Checks whether the object is disposed.
   * 
   * @throws RuntimeException if the object is disposed.
   * 
   */
  private void checkDisposed() {
    if (isDisposed()) {
    	throw new RuntimeException(String.format(
    			"Object already disposed: {}", this.toString()));
    }
    
  }
  
  /**
   * Calling dispose will destroy that instance. The internal state will be 
   * set to 'disposed' and methods of that object must not be used anymore. 
   * Each call will result in runtime exceptions.<br>
   * If this object keeps containment references, these will be disposed too. 
   * So the whole containment tree will be disposed on calling this method.
   * 
   */
  public void dispose() {
    if(isDisposed()){
    	return;
    }
    
    disposed = true;
    
  }
  
  /**
   * Returns the country reference or <code>null</code> if not present.
   * 
   * @return country
   */
  public Country getCountry() {
    checkDisposed();
    
    return this.country;
  }
  
  /**
   * Sets the country reference to this instance.
   * 
   * Since the reference is a container reference, the opposite reference (Country.provinces) 
   * of the country will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Country#setProvinces(Country)}.
   * 
   * @param country
   */
  public void setCountry(final Country country) {
    checkDisposed();
    
    if (settingCountry) {
    	// avoid loops
    	return;
    }
    
    Country oldCountry = this.country;
    
    // if the parent does not change, we can leave
    if (oldCountry == country) {
    	return;
    }
    
    try {
    // avoid loops
    settingCountry = true;
    	// First remove the element
    	if (oldCountry != null) {
    		oldCountry.removeProvinces(this);
    	}
    	
    	// Then assign the new value
    	this.country = country;
    	
    	// Then add 'this' to the new value
    	if (this.country != null) {
    		this.country.addProvinces(this);
    	}
    } finally {
    	settingCountry = false;
    }
    
  }
  
  /**
   * Returns the info_shortText property or <code>null</code> if not present.
   * 
   * @return info_shortText
   */
  public String getInfo_shortText() {
    checkDisposed();
    
    return this.info_shortText;
  }
  
  /**
   * Sets the shortText property to this instance.
   * 
   * @param shortText
   */
  public void setInfo_shortText(final String shortText) {
    checkDisposed();
    
    this.info_shortText = shortText;
  }
  
  /**
   * Returns the info_longText property or <code>null</code> if not present.
   * 
   * @return info_longText
   */
  public String getInfo_longText() {
    checkDisposed();
    
    return this.info_longText;
  }
  
  /**
   * Sets the longText property to this instance.
   * 
   * @param longText
   */
  public void setInfo_longText(final String longText) {
    checkDisposed();
    
    this.info_longText = longText;
  }
}
