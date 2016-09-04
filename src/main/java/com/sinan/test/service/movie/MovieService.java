package com.sinan.test.service.movie;

import com.sinan.test.dao.entity.MovieEntity;

import java.util.List;

public interface MovieService {
	List<MovieEntity> top10Movies();
}
