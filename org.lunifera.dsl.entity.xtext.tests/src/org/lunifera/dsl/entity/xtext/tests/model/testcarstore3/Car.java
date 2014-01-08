package org.lunifera.dsl.entity.xtext.tests.model.testcarstore3;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(schema = "SCHEMA3", name = "CAR")
@DiscriminatorValue(value = "CAR")
@SuppressWarnings("all")
public class Car {
	@Transient
	private boolean disposed;

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "MODELNAME")
	private String modelname;

	@Column(name = "CONSTRUCTIONDATE")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date constructiondate;

	@Column(name = "PRICE")
	private int price;

	@ManyToOne(targetEntity = Manufacturer.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "MANUFACTURER", nullable = false)
	private Manufacturer manufacturer;

	/**
	 * Returns true, if the object is disposed. Disposed means, that it is
	 * prepared for garbage collection and may not be used anymore. Accessing
	 * objects that are already disposed will cause runtime exceptions.
	 */
	public boolean isDisposed() {
		return this.disposed;
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
		try {
			// Dispose all the composition references.
			if (this.manufacturer != null) {
				this.manufacturer.dispose();
				this.manufacturer = null;
			}

		} finally {
			disposed = true;
		}

	}

	/**
	 * Returns the id property or <code>null</code> if not present.
	 */
	public long getId() {
		checkDisposed();
		return this.id;
	}

	/**
	 * Sets the id property to this instance.
	 */
	public void setId(final long id) {
		checkDisposed();
		this.id = id;
	}

	/**
	 * Returns the modelname property or <code>null</code> if not present.
	 */
	public String getModelname() {
		checkDisposed();
		return this.modelname;
	}

	/**
	 * Sets the modelname property to this instance.
	 */
	public void setModelname(final String modelname) {
		checkDisposed();
		this.modelname = modelname;
	}

	/**
	 * Returns the constructiondate property or <code>null</code> if not
	 * present.
	 */
	public Date getConstructiondate() {
		checkDisposed();
		return this.constructiondate;
	}

	/**
	 * Sets the constructiondate property to this instance.
	 */
	public void setConstructiondate(final Date constructiondate) {
		checkDisposed();
		this.constructiondate = constructiondate;
	}

	/**
	 * Returns the price property or <code>null</code> if not present.
	 */
	public int getPrice() {
		checkDisposed();
		return this.price;
	}

	/**
	 * Sets the price property to this instance.
	 */
	public void setPrice(final int price) {
		checkDisposed();
		this.price = price;
	}

	/**
	 * Returns the <em>required</em> manufacturer property.
	 */
	public Manufacturer getManufacturer() {
		checkDisposed();
		return this.manufacturer;
	}

	/**
	 * Sets the manufacturer property to this instance. Since the reference is a
	 * container reference, the opposite reference (Manufacturer.cars) of the
	 * manufacturer will be handled automatically and no further coding is
	 * required to keep them in sync. See
	 * {@link Manufacturer#setCars(Manufacturer)}.
	 */
	public void setManufacturer(final Manufacturer manufacturer) {
		checkDisposed();
		if (this.manufacturer != null) {
			this.manufacturer.internalRemoveFromCars(this);
		}
		this.manufacturer = manufacturer;
		if (this.manufacturer != null) {
			this.manufacturer.internalAddToCars(this);
		}

	}

	void internalSetManufacturer(final Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
}
