package com.sinan.test.service;

import com.sinan.test.dao.entity.MovieEntity;

import java.util.List;

public interface MovieService {
	List<MovieEntity> top10Movies();
}
