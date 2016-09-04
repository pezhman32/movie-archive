package com.sinan.test.service.user;

import com.sinan.test.service.ServiceException;

public class UserServiceException extends ServiceException {
	UserServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	UserServiceException(String message) {
		super(message);
	}
}
