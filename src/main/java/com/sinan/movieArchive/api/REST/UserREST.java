package com.sinan.movieArchive.api.REST;

import com.sinan.movieArchive.dao.entity.UserEntity;
import com.sinan.movieArchive.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pezhman Jahanmard
 */
@RestController
@RequestMapping("/users")
public class UserREST extends BaseREST<UserEntity, UserService> {

	@Autowired
	private UserService userService;

}
