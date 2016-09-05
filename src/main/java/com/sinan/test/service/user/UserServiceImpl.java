package com.sinan.test.service.user;

import com.sinan.test.dao.entity.UserEntity;
import com.sinan.test.dao.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This service handles operations related to UserEntity
 *
 * @author Pezhman Jahanmard
 */
@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity findUser(Integer userId) throws UserServiceException {
		UserEntity userEntity = userRepository.findOne(userId);
		if (userEntity == null) {
			throw new UserServiceException("User #" + userId + " not found");
		}

		return userEntity;
	}
}
