package org.lunifera.dsl.service.lib;

public interface ISortOrder {

	/**
	 * Adds a property for the sort order. The result will become ordered in the
	 * order the properties are added to this instance.
	 * 
	 * @param propery
	 * @param descending
	 */
	void addProperty(String propery, boolean descending);

	/**
	 * Removes a sort order property.
	 * @param propery
	 * @param descending
	 */
	void removeProperty(String propery, boolean descending);

}
