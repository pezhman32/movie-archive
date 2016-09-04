package com.sinan.test.api.REST;

import com.sinan.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pezhman Jahanmard
 */
@RestController
@RequestMapping("/users")
public class UserREST extends BaseREST {

	@Autowired
	private UserService userService;

}
