package com.sinan.test.service;

/**
 * Created by Pezhman Jahanmard on 9/5/16.
 */
public interface BaseService<E> {
	E findById(Integer id);

	E addNew(E entity);

	E update(Integer id, E entity);

	void delete(Integer id);
}
