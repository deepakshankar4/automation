package org.drait.source.util.uuid;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Uuid represents an immutable 33 character UUID beginning with an upper case
 * prefix character (normally "I") followed by 32 upper case Hex characters.
 * 
 * Example of a valid Uuid: I0123456789ABCDEF0123456789ABCDEF
 * 
 * @author U0172254
 * 
 */

public final class Uuid implements Serializable {
	/**
	 * Generated serial version uid.
	 */
	private static final long serialVersionUID = 5652403921414451918L;

	private static final String VALID_UUID = "[I|D|Q|W|T|N][0-9A-F]{32}";
	private static final String INVALID_UUID_FORMAT = "String does not conform to Uuid format: ";

	private String uuid;

	/**
	 * Constructor creates a Uuid from an input string. The string is validated
	 * against the specified Uuid format.
	 * 
	 * @param uuid
	 *            characters representing a 33 character Uuid.
	 */
	@JsonCreator
	public Uuid(@JsonProperty("uuid") final String uuid) {
		if (isValidUuid(uuid)) {
			this.uuid = uuid;
		} else {
			throw new IllegalArgumentException(INVALID_UUID_FORMAT + uuid);
		}
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
	public static boolean isValidUuid(final String uuid) {
		return (uuid.matches(VALID_UUID));
	}

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
