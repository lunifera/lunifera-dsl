package org.lunifera.dsl.tests.carstore.entities.dtos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import org.lunifera.dsl.dto.lib.Context;
import org.lunifera.dsl.dto.lib.Copier;
import org.lunifera.dsl.tests.carstore.entities.Base;

@SuppressWarnings("all")
public class BaseDto implements Serializable {
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	private boolean disposed;

	private String uuid = java.util.UUID.randomUUID().toString();
	
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
	 * Returns the uuid property or <code>null</code> if not present.
	 */
	public String getUuid() {
		checkDisposed();
		return this.uuid;
	}

	/**
	 * Sets the <code>uuid</code> property to this instance.
	 * 
	 * @param uuid
	 *            - the property
	 * @throws RuntimeException
	 *             if instance is <code>disposed</code>
	 * 
	 */
	public void setUuid(final String uuid) {
		firePropertyChange("uuid", this.uuid, this.uuid = uuid);
	}

	// TODO Edler
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	// TODO Edler
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDto other = (BaseDto) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	public static class BaseCopier<A extends BaseDto> extends Copier<A> {

		@Override
		public A createDto() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void copyContainments(A dto, A newDto) {
			newDto.setUuid(dto.getUuid());
		}

		@Override
		public void copyCrossReferences(A dto, A newDto) {
			
		}
	}
}
