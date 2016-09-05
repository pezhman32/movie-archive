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

import java.util.List;

/**
 * @author Pezhman Jahanmard
 */
@RestController
@RequestMapping("/movies")
public class MovieREST extends BaseREST {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "age", method = RequestMethod.GET)
	public List<MovieEntity> age() {
		return movieService.top10Movies();
	}

	@RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
	public Page<MovieEntity> age(@PathVariable("userId") Integer userId,
	                             Pageable pageable) throws MovieServiceException {
		return movieService.userMovies(userId, pageable);
	}
}
