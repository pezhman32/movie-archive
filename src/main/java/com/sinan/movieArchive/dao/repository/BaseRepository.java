package com.sinan.movieArchive.dao.repository;

import com.sinan.movieArchive.dao.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Our BaseRepository an abstract interface (NoRepositoryBean) extended form JpaRepository and JpaSpecificationExecutor so our repository will need less coding
 *
 * @author Pezhman Jahanmard
 */
@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Integer>, JpaSpecificationExecutor {

}
