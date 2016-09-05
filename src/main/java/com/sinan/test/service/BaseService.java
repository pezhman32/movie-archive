package com.sinan.test.service;

import com.sinan.test.service.movie.MovieServiceException;
import com.sinan.test.service.rate.RateServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<E> {
	E findById(Integer id);

	Page<E> findAll(Pageable pageable);

	E addNew(E entity) throws MovieServiceException, RateServiceException;

	E update(Integer id, E entity) throws MovieServiceException;

	void delete(Integer id) throws MovieServiceException;
}
