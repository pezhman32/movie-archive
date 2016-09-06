package com.sinan.movieArchive.service.rate;

import com.sinan.movieArchive.service.ServiceException;

public class RateServiceException extends ServiceException {
	RateServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	RateServiceException(String message) {
		super(message);
	}
}
