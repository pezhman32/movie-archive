package com.sinan.test.service.movie;

import com.sinan.test.service.ServiceException;

public class MovieServiceException extends ServiceException {
	MovieServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	MovieServiceException(String message) {
		super(message);
	}
}
