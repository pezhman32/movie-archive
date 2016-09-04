package com.sinan.test.service;

import com.sinan.test.dao.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This service handles operations related to MovieEntity
 *
 * @author Pezhman Jahanmard
 */
@Service
public class MovieService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

	@Autowired
	private MovieRepository movieRepository;


}
