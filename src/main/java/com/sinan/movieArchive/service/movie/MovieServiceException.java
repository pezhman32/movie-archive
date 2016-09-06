package com.sinan.movieArchive.service.movie;

import com.sinan.movieArchive.service.ServiceException;

public class MovieServiceException extends ServiceException {
	MovieServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	MovieServiceException(String message) {
		super(message);
	}
}
