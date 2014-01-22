package com.tr.errorandstatuscodes;

public class ErrorCodes {

	private static final int ECOMM_USER_LOGIN_ERROR = 1;
	private static final int ECOMM_PUB_LOGIN_ERROR = 2;
	private static final int ECOMM_USER_REG_ERROR = 3;
	private static final int ECOMM_PUB_REG_ERROR = 4;
	private static final int ECOMM_CART_PLACE_GUEST_ERROR = 5;
	private static final int ECOMM_FATAL_ERROR = 6;

	public static final int getEcommUserLoginError() {
		return ECOMM_USER_LOGIN_ERROR;
	}

	public static final int getEcommPubLoginError() {
		return ECOMM_PUB_LOGIN_ERROR;
	}

	public static final int getEcommUserRegError() {
		return ECOMM_USER_REG_ERROR;
	}

	public static final int getEcommCartPlaceGuestError() {
		return ECOMM_CART_PLACE_GUEST_ERROR;
	}

	public static final int getEcommPubRegError() {
		return ECOMM_PUB_REG_ERROR;
	}

	public static int getEcommFatalError() {
		return ECOMM_FATAL_ERROR;
	}

}
