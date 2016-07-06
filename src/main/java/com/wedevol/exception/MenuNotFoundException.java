package com.wedevol.exception;

import com.wedevol.util.Util;

/*
 * MenuNotFoundException
 */

public class MenuNotFoundException extends ErrorException {

	private static final long serialVersionUID = 1L;

	public MenuNotFoundException() {
		super(Util.NOT_FOUND_ERROR_CODE, Util.NOT_FOUND_ERROR_MESSAGE);
	}

	public MenuNotFoundException(String message) {
		super(Util.NOT_FOUND_ERROR_CODE, message);
	}

	public MenuNotFoundException(int code, String message) {
		super(code, message);
	}

}
