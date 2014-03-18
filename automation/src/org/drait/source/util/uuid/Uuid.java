package org.drait.source.util.uuid;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author DEEPAK
 * 
 */

public final class Uuid implements Serializable {
	/**
	 * Generated serial version uid.
	 */
	private static final long serialVersionUID = 5652403921414451918L;

	private String uuid;

	/**
	 * Constructor creates a Uuid from an input string. 
	 * 
	 * @param uuid
	 *            characters representing a 35 character Uuid.
	 */
	@JsonCreator
	public Uuid(@JsonProperty("uuid") final String uuid) {

		this.uuid = uuid;

	}

	/**
	 * @return the value of the Uuid as String.
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Validates a string against the Uuid format.
	 * 
	 * @param uuid
	 *            characters representing a 33 character Uuid.
	 * 
	 * @return True or false status of validity check of string against the
	 *         required Uuid format.
	 */

	@Override
	public String toString() {
		return uuid;
	}

	@Override
	public boolean equals(final Object object) {
		boolean isEqual = false;

		if (object instanceof Uuid) {
			Uuid rhs = (Uuid) object;
			isEqual = new EqualsBuilder().append(uuid, rhs.uuid).isEquals();
		}

		return isEqual;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(uuid).toHashCode();
	}
}
