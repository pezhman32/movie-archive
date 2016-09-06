package com.sinan.movieArchive.dao.repository;

import com.sinan.movieArchive.dao.entity.MovieEntity;
import org.springframework.stereotype.Repository;

/**
 * MovieRepository to manage operations regarding movies table and MovieEntity
 *
 * @author Pezhman Jahanmard
 */
@Repository
public interface MovieRepository extends BaseRepository<MovieEntity> {

}
