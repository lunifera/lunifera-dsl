package org.lunifera.dsl.tests.carstore.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.lunifera.dsl.dto.lib.Context;
import org.lunifera.dsl.dto.lib.CopyHelper;

@Entity
@Table(name = "CAR")
@SuppressWarnings("all")
public class Car extends Base {
	@Column(name = "NUMBER")
	private String number;

	@Column(name = "FINISHING_DATE")
	@Temporal(value = TemporalType.DATE)
	private Date finishingDate;

	@JoinColumn(name = "ADDONS")
	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Addon> addons;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OWNER")
	private Person owner;

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
			if (this.addons != null) {
				for (Addon addon : this.addons) {
					addon.dispose();
				}
				this.addons = null;
			}

		} finally {
			super.dispose();
		}

	}

	/**
	 * Returns the number property or <code>null</code> if not present.
	 */
	public String getNumber() {
		checkDisposed();
		return this.number;
	}

	/**
	 * Sets the number property to this instance.
	 */
	public void setNumber(final String number) {
		checkDisposed();
		this.number = number;
	}

	/**
	 * Returns the finishingDate property or <code>null</code> if not present.
	 */
	public Date getFinishingDate() {
		checkDisposed();
		return this.finishingDate;
	}

	/**
	 * Sets the finishingDate property to this instance.
	 */
	public void setFinishingDate(final Date finishingDate) {
		checkDisposed();
		this.finishingDate = finishingDate;
	}

	/**
	 * Returns an unmodifiable list of addons.
	 */
	public List<Addon> getAddons() {
		checkDisposed();
		return Collections.unmodifiableList(internalGetAddons());
	}

	/**
	 * Sets the given addons to the object. Currently contained addons instances
	 * will be removed.
	 * 
	 * @param addons
	 *            the list of new instances
	 */
	public void setAddons(final List<Addon> addons) {
		// remove the old addon
		for (Addon oldElement : new ArrayList<Addon>(this.internalGetAddons())) {
			removeFromAddons(oldElement);
		}

		// add the new addon
		for (Addon newElement : addons) {
			addToAddons(newElement);
		}
	}

	/**
	 * Returns the list of <code>Addon</code>s thereby lazy initializing it.
	 */
	private List<Addon> internalGetAddons() {
		if (this.addons == null) {
			this.addons = new ArrayList<Addon>();
		}
		return this.addons;
	}

	/**
	 * Adds the given addon to this object.
	 * <p>
	 * Since the reference is a composition reference, the opposite reference
	 * (Addon.car) of the addon will be handled automatically and no further
	 * coding is required to keep them in sync. See {@link Addon#setCar(Addon)}.
	 * 
	 */
	public void addToAddons(final Addon addon) {
		checkDisposed();
		addon.setCar(this);
	}

	/**
	 * Removes the given addon from this object.
	 * <p>
	 * Since the reference is a cascading reference, the opposite reference
	 * (Addon.car) of the addon will be handled automatically and no further
	 * coding is required to keep them in sync. See {@link Addon#setCar(Addon)}.
	 * 
	 */
	public void removeFromAddons(final Addon addon) {
		checkDisposed();
		addon.setCar(null);
	}

	void internalAddToAddons(final Addon addon) {
		internalGetAddons().add(addon);
	}

	void internalRemoveFromAddons(final Addon addon) {
		internalGetAddons().remove(addon);
	}

	/**
	 * Returns the owner property or <code>null</code> if not present.
	 */
	public Person getOwner() {
		checkDisposed();
		return this.owner;
	}

	/**
	 * Sets the owner property to this instance. Since the reference is a
	 * container reference, the opposite reference (Person.ownsCars) of the
	 * owner will be handled automatically and no further coding is required to
	 * keep them in sync. See {@link Person#setOwnsCars(Person)}.
	 */
	public void setOwner(final Person owner) {
		checkDisposed();
		if (this.owner != null) {
			this.owner.internalRemoveFromOwnsCars(this);
		}
		this.owner = owner;
		if (this.owner != null) {
			this.owner.internalAddToOwnsCars(this);
		}

	}
}
