package com.sinan.test.service;

import com.sinan.test.dao.entity.BaseEntity;
import com.sinan.test.dao.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import javax.persistence.MappedSuperclass;

/**
 * Contains some CRUD methods and autowired the repository. So extended services can do the rest more easily.
 *
 * @author Pezhman Jahanmard
 */
@MappedSuperclass
public abstract class BaseServiceImpl<E extends BaseEntity, R extends BaseRepository> implements BaseService<E> {
	@Autowired
	protected R repository;

	@Override
	public E findById(Integer id) {
		return get(id);
	}

	@Override
	public Page<E> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public E addNew(E entity) {
		return (E) repository.save(entity);
	}

	@Override
	public E update(Integer id, E entity) {
		get(id); //to ensure that entity exists, otherwise it will throw exception
		entity.setId(id);

		return (E) repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	protected E get(Integer id) {
		E entity = (E) repository.findOne(id);

		if (entity == null) {
			throw new EntityNotFoundException("Entity not found with id #" + id);
		}

		return entity;
	}
}
