package org.drait.source.util.uuid;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

/**
 * UuidGenerator generates 33 character UUID beginning with an acceptable
 * VALID_PREFIX_CHARACTER followed by a hexadecimal 32 character Java UUID which
 * has been converted to upper case with '-' characters removed.
 * 
 * If not otherwise specified, the standard DEFAULT_PREFIX character for the
 * generated Uuid will be 'I'.
 * 
 * Example of the "standard" Uuid: I0123456789ABCDEF0123456789ABCDEF
 * 
 * 
 * 
 * 
 */
public final class UuidGenerator {
	private static final char DEFAULT_PREFIX = 'I';
	private static final String INVALID_PREFIX_CHARACTER = "First character not valid for Uuid: ";
	private static final String VALID_PREFIX_CHARACTER = "[I|D|Q|W|T|N]";

	private UuidGenerator() {
	}

	/**
	 * Produce a 33 character UUID beginning with the specified prefix
	 * character. The prefix character must be a valid UUID prefix character or
	 * an IllegalArgumentException is thrown.
	 * 
	 * @param prefixCharacter
	 *            leading character for a 33 character UUID.
	 * 
	 * @return 33 character UUID string
	 */
	public static String generateId(final char prefixCharacter) {
		if (Character.toString(prefixCharacter).matches(VALID_PREFIX_CHARACTER)) {
			return prefixCharacter
					+ StringUtils.upperCase(StringUtils.remove(UUID
							.randomUUID().toString(), '-'));
		} else {
			throw new IllegalArgumentException(INVALID_PREFIX_CHARACTER
					+ prefixCharacter);
		}
	}

	/**
	 * Produce a 'standard' 33 character UUID with the default prefix character.
	 * 
	 * @return New Uuid object
	 * 
	 */
	public static String generateId() {
		return generateId(DEFAULT_PREFIX);
	}
}
