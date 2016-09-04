package com.sinan.test.api.REST;

import com.sinan.test.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pezhman Jahanmard
 */
@RestController
@RequestMapping("/rates")
public class RateREST extends BaseREST {

	@Autowired
	private RateService rateService;

}
