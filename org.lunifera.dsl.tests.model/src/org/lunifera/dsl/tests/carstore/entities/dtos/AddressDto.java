package org.lunifera.dsl.tests.carstore.entities.dtos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import org.lunifera.dsl.dto.lib.Context;

@SuppressWarnings("all")
public class AddressDto implements Serializable {
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	private boolean disposed;

	private String streetname;

	private String postalcode;

	private boolean isCopy;

	public AddressDto() {
		this(false);
	}

	public AddressDto(boolean isCopy) {
		this.isCopy = isCopy;
	}

	/**
	 * Returns true, if the object is disposed. Disposed means, that it is
	 * prepared for garbage collection and may not be used anymore. Accessing
	 * objects that are already disposed will cause runtime exceptions.
	 */
	public boolean isDisposed() {
		return this.disposed;
	}

	/**
	 * @see PropertyChangeSupport#addPropertyChangeListener(PropertyChangeListener)
	 */
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * @see PropertyChangeSupport#addPropertyChangeListener(String,
	 *      PropertyChangeListener)
	 */
	public void addPropertyChangeListener(final String propertyName,
			final PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	/**
	 * @see PropertyChangeSupport#removePropertyChangeListener(PropertyChangeListener)
	 */
	public void removePropertyChangeListener(
			final PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * @see PropertyChangeSupport#removePropertyChangeListener(String,
	 *      PropertyChangeListener)
	 */
	public void removePropertyChangeListener(final String propertyName,
			final PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName,
				listener);
	}

	/**
	 * @see PropertyChangeSupport#firePropertyChange(String, Object, Object)
	 */
	public void firePropertyChange(final String propertyName,
			final Object oldValue, final Object newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue,
				newValue);
	}

	/**
	 * Checks whether the object is disposed.
	 * 
	 * @throws RuntimeException
	 *             if the object is disposed.
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
	 * If this object keeps composition containments, these will be disposed
	 * too. So the whole composition containment tree will be disposed on
	 * calling this method.
	 */
	public void dispose() {
		if (isDisposed()) {
			return;
		}
		disposed = true;
	}

	/**
	 * Returns the streetname property or <code>null</code> if not present.
	 */
	public String getStreetname() {
		checkDisposed();
		return this.streetname;
	}

	/**
	 * Sets the <code>streetname</code> property to this instance.
	 * 
	 * @param streetname
	 *            - the property
	 * @throws RuntimeException
	 *             if instance is <code>disposed</code>
	 * 
	 */
	public void setStreetname(final String streetname) {
		firePropertyChange("streetname", this.streetname,
				this.streetname = streetname);
	}

	/**
	 * Returns the postalcode property or <code>null</code> if not present.
	 */
	public String getPostalcode() {
		checkDisposed();
		return this.postalcode;
	}

	/**
	 * Sets the <code>postalcode</code> property to this instance.
	 * 
	 * @param postalcode
	 *            - the property
	 * @throws RuntimeException
	 *             if instance is <code>disposed</code>
	 * 
	 */
	public void setPostalcode(final String postalcode) {
		firePropertyChange("postalcode", this.postalcode,
				this.postalcode = postalcode);
	}

	public AddressDto copy(Context context) {
		AddressDto newDto = new AddressDto(true);
		copyTo(newDto, context);
		return newDto;
	}

	public void copyTo(AddressDto newDto, Context context) {
		context.register(this, newDto);

		newDto.setPostalcode(getPostalcode());
		newDto.setStreetname(getStreetname());
	}
}
