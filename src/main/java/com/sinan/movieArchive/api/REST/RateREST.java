package com.sinan.movieArchive.api.REST;

import com.sinan.movieArchive.dao.entity.RateEntity;
import com.sinan.movieArchive.service.rate.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pezhman Jahanmard
 */
@RestController
@RequestMapping("/rates")
public class RateREST extends BaseREST<RateEntity, RateService> {

	@Autowired
	private RateService rateService;

}
