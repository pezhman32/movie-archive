package com.sinan.test.service.user;

import com.sinan.test.dao.entity.UserEntity;

public interface UserService {
	UserEntity findUser(Integer userId) throws UserServiceException;
}
