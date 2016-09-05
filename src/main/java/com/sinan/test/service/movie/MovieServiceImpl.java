package com.sinan.test.service.movie;

import com.sinan.test.dao.entity.MovieEntity;
import com.sinan.test.dao.repository.MovieRepository;
import com.sinan.test.dao.specification.MovieSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	/**
	 * Given a parameter of "age", return the top 10 movies ordered by average rating.
	 */
	@Override
	public List<MovieEntity> topMovies(int limit) {
		Page<MovieEntity> movies = movieRepository.findAll(new PageRequest(0, limit, Sort.Direction.DESC, "avgRating"));
		return movies.getContent();
	}

	/**
	 * Given a userId, return all movies that user has watched and the total count, as well as the rating for that movie.
	 * @throws MovieServiceException if userId = null
	 */
	@Override
	public Page<MovieEntity> userMovies(Integer userId, Pageable pageable) throws MovieServiceException {
		if (userId == null) {
			throw new MovieServiceException("userId is required.");
		}

		return movieRepository.findAll(MovieSpecification.userMovies(userId), pageable);
	}

	@Override
	public List<MovieEntity> topLateNightMovies(int limit) {
		Page<MovieEntity> movies = movieRepository.findAll(
				MovieSpecification.lateNightMovies(),
				new PageRequest(0, limit, Sort.Direction.DESC, "avgRating"));
		return movies.getContent();
	}
}
