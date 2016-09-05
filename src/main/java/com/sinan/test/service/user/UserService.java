package com.sinan.test.service.user;

import com.sinan.test.dao.entity.UserEntity;
import com.sinan.test.service.BaseService;

public interface UserService extends BaseService<UserEntity> {
	UserEntity findUser(Integer userId) throws UserServiceException;
}
