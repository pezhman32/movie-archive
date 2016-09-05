package com.sinan.test.service.movie;

import com.sinan.test.dao.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
	List<MovieEntity> topMovies(int limit);

	Page<MovieEntity> userMovies(Integer userId, Pageable pageable) throws MovieServiceException;

	List<MovieEntity> topLateNightMovies(int limit);
}
