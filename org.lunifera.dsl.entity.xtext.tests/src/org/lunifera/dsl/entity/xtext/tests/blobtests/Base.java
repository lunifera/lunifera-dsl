package org.lunifera.dsl.entity.xtext.tests.blobtests;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import org.lunifera.dsl.entity.xtext.tests.blobtests.Bean;

@Entity
@Table(name = "BASE")
@DiscriminatorValue(value = "BASE")
@SuppressWarnings("all")
public class Base {
	@Transient
	private boolean disposed;

	@Id
	@GeneratedValue
	private long id;

	@Version
	private long version;

	@Column(name = "NAME")
	private String name;

	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name = "name", column = @Column(name = "OTHER_NAME")),
			@AttributeOverride(name = "info.name", column = @Column(name = "OTHER_INFO_NAME")),
			@AttributeOverride(name = "info.addon.name", column = @Column(name = "OTHER_INFO_ADDON_NAME")),
			@AttributeOverride(name = "info.addon.huhu", column = @Column(name = "OTHER_INFO_ADDON_HUHU")),
			@AttributeOverride(name = "info.huhu", column = @Column(name = "OTHER_INFO_HUHU")),
			@AttributeOverride(name = "huhu", column = @Column(name = "OTHER_HUHU")) })
	@Column(name = "OTHER")
	private Bean other;

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
		disposed = true;
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
	 * Returns the version property or <code>null</code> if not present.
	 */
	public long getVersion() {
		checkDisposed();
		return this.version;
	}

	/**
	 * Sets the version property to this instance.
	 */
	public void setVersion(final long version) {
		checkDisposed();
		this.version = version;
	}

	/**
	 * Returns the name property or <code>null</code> if not present.
	 */
	public String getName() {
		checkDisposed();
		return this.name;
	}

	/**
	 * Sets the name property to this instance.
	 */
	public void setName(final String name) {
		checkDisposed();
		this.name = name;
	}

	/**
	 * Returns the other property or <code>null</code> if not present.
	 */
	public Bean getOther() {
		checkDisposed();
		return this.other;
	}

	/**
	 * Sets the other property to this instance.
	 */
	public void setOther(final Bean other) {
		checkDisposed();
		this.other = other;
	}
}
