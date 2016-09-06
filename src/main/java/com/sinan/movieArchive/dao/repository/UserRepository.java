package com.sinan.movieArchive.dao.repository;

import com.sinan.movieArchive.dao.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * UserRepository to manage operations regarding users table and UserEntity
 *
 * @author Pezhman Jahanmard
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity> {

}
