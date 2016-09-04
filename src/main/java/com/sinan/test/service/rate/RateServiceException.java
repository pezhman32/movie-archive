package com.sinan.test.service.rate;

import com.sinan.test.service.ServiceException;

public class RateServiceException extends ServiceException {
	RateServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	RateServiceException(String message) {
		super(message);
	}
}
