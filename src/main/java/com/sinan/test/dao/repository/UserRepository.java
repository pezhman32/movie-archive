package com.sinan.test.dao.repository;

import com.sinan.test.dao.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * UserRepository to manage operations regarding users table and UserEntity
 *
 * @author Pezhman Jahanmard
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity> {

}
