package com.sinan.test.service.movie;

import com.sinan.test.dao.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
	List<MovieEntity> top10Movies();

	Page<MovieEntity> userMovies(Integer userId, Pageable pageable) throws MovieServiceException;
}
