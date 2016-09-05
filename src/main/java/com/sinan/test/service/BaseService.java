package com.sinan.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<E> {
	E findById(Integer id);

	Page<E> findAll(Pageable pageable);

	E addNew(E entity);

	E update(Integer id, E entity);

	void delete(Integer id);
}
