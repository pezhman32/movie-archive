package com.sinan.movieArchive.service.user;

import com.sinan.movieArchive.dao.entity.UserEntity;
import com.sinan.movieArchive.service.BaseService;

public interface UserService extends BaseService<UserEntity> {
	UserEntity findUser(Integer userId) throws UserServiceException;
}
