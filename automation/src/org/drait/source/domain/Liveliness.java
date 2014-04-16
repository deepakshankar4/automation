/**
 * 
 */
package org.drait.source.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author DEEPAK
 * 
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Liveliness {

	/**
	 * Freezed component
	 */
	ALIVE("ALIVE", 1),
	/**
	 * Alive component
	 */
	FREEZED("FREEZED", 2),
	/**
	 * inactive component
	 */
	INACTIVE("INACTIVE", 3),
	/**
	 * Deleted component
	 */
	DELETED("DELETED", 4),
	/**
	 * duplicate component
	 */
	DUPLICATE("DUPLICATE", 5),
	/**
	 * Dead Component
	 */
	DEAD("DEAD", 6);

	private String displayName;

	private int id;

	private Liveliness(final String displayName, final int id) {
		this.displayName = displayName;
		this.id = id;

	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return Department name
	 */
	public String getName() {
		return this.name();
	}

}
