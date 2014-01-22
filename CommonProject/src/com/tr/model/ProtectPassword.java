package com.tr.model;

import org.apache.commons.codec.digest.DigestUtils;

public class ProtectPassword {

	public String encrypt(String str) {

		return DigestUtils.md5Hex(str);
	}

}
