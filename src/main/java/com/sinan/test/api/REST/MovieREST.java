package com.sinan.test.api.REST;

import com.sinan.test.dao.entity.MovieEntity;
import com.sinan.test.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
