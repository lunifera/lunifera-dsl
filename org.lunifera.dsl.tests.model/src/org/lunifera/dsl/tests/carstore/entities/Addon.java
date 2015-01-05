package org.lunifera.dsl.tests.carstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.lunifera.dsl.dto.lib.Context;

@Entity
@Table(name = "ADDON")
@SuppressWarnings("all")
public class Addon extends Base {
	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CAR")
	private Car car;

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
		try {
			// Dispose all the composition references.
			if (this.car != null) {
				this.car.dispose();
				this.car = null;
			}

		} finally {
			super.dispose();
		}

	}

	/**
	 * Returns the description property or <code>null</code> if not present.
	 */
	public String getDescription() {
		checkDisposed();
		return this.description;
	}

	/**
	 * Sets the description property to this instance.
	 */
	public void setDescription(final String description) {
		checkDisposed();
		this.description = description;
	}

	/**
	 * Returns the car property or <code>null</code> if not present.
	 */
	public Car getCar() {
		checkDisposed();
		return this.car;
	}

	/**
	 * Sets the car property to this instance. Since the reference is a
	 * container reference, the opposite reference (Car.addons) of the car will
	 * be handled automatically and no further coding is required to keep them
	 * in sync. See {@link Car#setAddons(Car)}.
	 */
	public void setCar(final Car car) {
		checkDisposed();
		if (this.car != null) {
			this.car.internalRemoveFromAddons(this);
		}
		this.car = car;
		if (this.car != null) {
			this.car.internalAddToAddons(this);
		}
	}

}
