package com.sinan.test.service.movie;

import com.sinan.test.dao.entity.MovieEntity;
import com.sinan.test.dao.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service handles operations related to MovieEntity
 *
 * @author Pezhman Jahanmard
 */
@Service
public class MovieServiceImpl implements MovieService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<MovieEntity> top10Movies() {
		Page<MovieEntity> movies = movieRepository.findAll(new PageRequest(0, 10, Sort.Direction.DESC, "avgRating"));
		return movies.getContent();
	}
}
