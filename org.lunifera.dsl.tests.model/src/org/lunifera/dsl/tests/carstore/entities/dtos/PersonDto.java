package org.lunifera.dsl.tests.carstore.entities.dtos;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.lunifera.dsl.dto.lib.Context;
import org.lunifera.dsl.dto.lib.Copier;
import org.lunifera.dsl.dto.lib.ICopyable;
import org.lunifera.runtime.common.annotations.DomainReference;

@SuppressWarnings("all")
public class PersonDto extends BaseDto implements Serializable,
		ICopyable<PersonDto> {
	private String firstname;

	private String lastname;

	@DomainReference
	private List<CarDto> ownsCars;

	private AddressDto homeAddress;

	private AddressDto workAddress;

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
		super.dispose();
	}

	/**
	 * Returns the firstname property or <code>null</code> if not present.
	 */
	public String getFirstname() {
		checkDisposed();
		return this.firstname;
	}

	/**
	 * Sets the <code>firstname</code> property to this instance.
	 * 
	 * @param firstname
	 *            - the property
	 * @throws RuntimeException
	 *             if instance is <code>disposed</code>
	 * 
	 */
	public void setFirstname(final String firstname) {
		firePropertyChange("firstname", this.firstname,
				this.firstname = firstname);
	}

	/**
	 * Returns the lastname property or <code>null</code> if not present.
	 */
	public String getLastname() {
		checkDisposed();
		return this.lastname;
	}

	/**
	 * Sets the <code>lastname</code> property to this instance.
	 * 
	 * @param lastname
	 *            - the property
	 * @throws RuntimeException
	 *             if instance is <code>disposed</code>
	 * 
	 */
	public void setLastname(final String lastname) {
		firePropertyChange("lastname", this.lastname, this.lastname = lastname);
	}

	/**
	 * Returns an unmodifiable list of ownsCars.
	 */
	public List<CarDto> getOwnsCars() {
		checkDisposed();
		return Collections.unmodifiableList(internalGetOwnsCars());
	}

	/**
	 * Returns the list of <code>CarDto</code>s thereby lazy initializing it.
	 * For internal use only!
	 * 
	 * @return list - the resulting list
	 * 
	 */
	private List<CarDto> internalGetOwnsCars() {
		if (this.ownsCars == null) {
			this.ownsCars = new java.util.ArrayList<CarDto>();
		}
		return this.ownsCars;
	}

	/**
	 * Adds the given carDto to this object.
	 * <p>
	 * Since the reference is a composition reference, the opposite reference
	 * <code>CarDto#owner</code> of the <code>carDto</code> will be handled
	 * automatically and no further coding is required to keep them in sync.
	 * <p>
	 * See {@link CarDto#setOwner(CarDto)}.
	 * 
	 * @param carDto
	 *            - the property
	 * @throws RuntimeException
	 *             if instance is <code>disposed</code>
	 * 
	 */
	public void addToOwnsCars(final CarDto carDto) {
		checkDisposed();
		carDto.setOwner(this);
	}

	/**
	 * Removes the given carDto from this object.
	 * <p>
	 * 
	 * @param carDto
	 *            - the property
	 * @throws RuntimeException
	 *             if instance is <code>disposed</code>
	 * 
	 */
	public void removeFromOwnsCars(final CarDto carDto) {
		checkDisposed();

		carDto.setOwner(null);
	}

	/**
	 * For internal use only!
	 */
	public void internalAddToOwnsCars(final CarDto carDto) {
		internalGetOwnsCars().add(carDto);
	}

	/**
	 * For internal use only!
	 */
	public void internalRemoveFromOwnsCars(final CarDto carDto) {
		internalGetOwnsCars().remove(carDto);
	}

/**
   * Sets the <code>ownsCars</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>CarDto#
   * owner</code> of the <code>ownsCars</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link CarDto#setOwner(CarDto)
   * 
   * @param ownsCars - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
	public void setOwnsCars(final List<CarDto> ownsCars) {
		checkDisposed();
		for (CarDto dto : internalGetOwnsCars().toArray(
				new CarDto[this.ownsCars.size()])) {
			removeFromOwnsCars(dto);
		}
		if (ownsCars == null) {
			return;
		}
		for (CarDto dto : ownsCars) {
			addToOwnsCars(dto);
		}

	}

	/**
	 * Returns the homeAddress property or <code>null</code> if not present.
	 */
	public AddressDto getHomeAddress() {
		checkDisposed();
		return this.homeAddress;
	}

	/**
	 * Sets the <code>homeAddress</code> property to this instance.
	 * 
	 * @param homeAddress
	 *            - the property
	 * @throws RuntimeException
	 *             if instance is <code>disposed</code>
	 * 
	 */
	public void setHomeAddress(final AddressDto homeAddress) {
		firePropertyChange("homeAddress", this.homeAddress,
				this.homeAddress = homeAddress);
	}

	/**
	 * Returns the workAddress property or <code>null</code> if not present.
	 */
	public AddressDto getWorkAddress() {
		checkDisposed();
		return this.workAddress;
	}

	/**
	 * Sets the <code>workAddress</code> property to this instance.
	 * 
	 * @param workAddress
	 *            - the property
	 * @throws RuntimeException
	 *             if instance is <code>disposed</code>
	 * 
	 */
	public void setWorkAddress(final AddressDto workAddress) {
		firePropertyChange("workAddress", this.workAddress,
				this.workAddress = workAddress);
	}

	public PersonDto copy(Context context) {
		PersonDto copy = context.getTarget(this);
		if (copy != null) {
			return copy;
		}

		return newCopier().copy(this, context);
	}

	protected Copier<PersonDto> newCopier() {
		return new PersonDtoCopier();
	}

	public static class PersonDtoCopier extends BaseDto.BaseCopier<PersonDto> {

		@Override
		public PersonDto createDto() {
			return new PersonDto();
		}

		@Override
		public void copyContainments(PersonDto dto, PersonDto newDto) {
			super.copyContainments(dto, newDto);

			newDto.setFirstname(dto.getFirstname());
			newDto.setLastname(dto.getLastname());

			if (dto.getHomeAddress() != null)
				newDto.setHomeAddress(dto.getHomeAddress().copy(context));

			if (dto.getWorkAddress() != null)
				newDto.setWorkAddress(dto.getWorkAddress().copy(context));
		}

		/**
		 * Skipping:<br>
		 * <ul>
		 * <li><b>ownsCars</b>: a crossreference with opposite and CarDto not
		 * part of containment tree</li>
		 * </ul>
		 */
		@Override
		public void copyCrossReferences(PersonDto dto, PersonDto newDto) {

		}
	}
}
