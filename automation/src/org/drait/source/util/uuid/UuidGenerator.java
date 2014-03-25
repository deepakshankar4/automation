package org.drait.source.util.uuid;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author DEEPAK
 *
 */
public final class UuidGenerator {

	private UuidGenerator() {
	}

	public static String generateId() {

		return "AIT"
				+ StringUtils.upperCase(StringUtils.remove(UUID.randomUUID()
						.toString(), '-'));

	}

}
