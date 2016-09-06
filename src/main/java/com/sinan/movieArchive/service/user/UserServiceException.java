package com.sinan.movieArchive.service.user;

import com.sinan.movieArchive.service.ServiceException;

public class UserServiceException extends ServiceException {
	UserServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	UserServiceException(String message) {
		super(message);
	}
}
