package com.wedevol.exception;

import com.wedevol.util.Util;

/*
 * MenuServerErrorException
 */

public class MenuServerErrorException extends ErrorException {

	private static final long serialVersionUID = 1L;

	public MenuServerErrorException() {
		super(Util.SERVER_ERROR_CODE, Util.SERVER_ERROR_MESSAGE);
	}

	public MenuServerErrorException(String message) {
		super(Util.SERVER_ERROR_CODE, message);
	}

	public MenuServerErrorException(int code, String message) {
		super(code, message);
	}

}
