package com.sinan.test.api.REST;

import com.sinan.test.dao.entity.MovieEntity;
import com.sinan.test.service.movie.MovieService;
import com.sinan.test.service.movie.MovieServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Pezhman Jahanmard
 */
@RestController
@RequestMapping("/movies")
public class MovieREST extends BaseREST {

	@Autowired
	private MovieService movieService;

	/**
	 * Given a parameter of "age", return the top 10 movies ordered by average rating.
	 */
	@RequestMapping(value = "age", method = RequestMethod.GET)
	public List<MovieEntity> age() {
		return movieService.topMovies(10);
	}

	/**
	 * Given a userId, return all movies that user has watched and the total count, as well as the rating for that movie.
	 */
	@RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
	public Page<MovieEntity> age(@PathVariable("userId") Integer userId,
	                             Pageable pageable) throws MovieServiceException {
		return movieService.userMovies(userId, pageable);
	}

	/**
	 * Given a parameter of "state", return the top 20 movies by average rating
	 * when that movie has been watched between 6pm and midnight, EST.
	 */
	@RequestMapping(value = "state", method = RequestMethod.GET)
	public List<MovieEntity> state() {
		return movieService.topLateNightMovies(20);
	}

	/**
	 * Given a parameter of "movieId", return its average rating.
	 */
	@RequestMapping(value = "{movieId}/avgRating", method = RequestMethod.GET)
	public BigDecimal avgRating(@PathVariable("movieId") Integer movieId) throws MovieServiceException {
		return movieService.getAvgRatingForMovie(movieId);
	}
}
