package com.sinan.test.service.movie;

import com.sinan.test.dao.entity.MovieEntity;
import com.sinan.test.dao.repository.MovieRepository;
import com.sinan.test.dao.specification.MovieSpecification;
import com.sinan.test.service.rate.RateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * This service handles operations related to MovieEntity
 *
 * @author Pezhman Jahanmard
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private RateService rateService;

	@Override
	public MovieEntity getMovie(Integer movieId) throws MovieServiceException {
		return get(movieId);
	}

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

	/**
	 * Given a parameter of "state", return the top 20 movies by average rating
	 * when that movie has been watched between 6pm and midnight, EST.
	 */
	@Override
	public List<MovieEntity> topLateNightMovies(int limit) {
		Page<MovieEntity> movies = movieRepository.findAll(
				MovieSpecification.lateNightMovies(),
				new PageRequest(0, limit, Sort.Direction.DESC, "avgRating"));
		return movies.getContent();
	}

	/**
	 * Given a parameter of "movieId", return its average rating.
	 * @throws MovieServiceException if movie not found
	 */
	@Override
	public BigDecimal getAvgRatingForMovie(Integer movieId) throws MovieServiceException {
		MovieEntity movieEntity = get(movieId);
		return resetAvgRating(movieEntity).getAvgRating();
	}

	@Override
	public void resetAvgRatingForAllMovies() throws MovieServiceException {
		List<MovieEntity> movieEntities = movieRepository.findAll();
		for (MovieEntity movieEntity : movieEntities) {
			resetAvgRating(movieEntity);
		}
	}

	/**
	 * Finds a movie by its id
	 * @throws MovieServiceException if movie not found
	 */
	private MovieEntity get(Integer movieId) throws MovieServiceException {
		MovieEntity movieEntity = movieRepository.findOne(movieId);
		if (movieEntity == null) {
			throw new MovieServiceException("Movie #" + movieId + " not found.");
		}

		return movieEntity;
	}

	/**
	 * Re-estimate avg rating for single movie
	 * because of @transactional it will be saved automatically
	 */
	private MovieEntity resetAvgRating(MovieEntity movieEntity) throws MovieServiceException {
		movieEntity.setAvgRating(
				rateService.estimateAvgRatingForMovie(movieEntity.getId()));
		return movieEntity;
	}
}
