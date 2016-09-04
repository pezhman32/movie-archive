package com.sinan.test.service;

import com.sinan.test.dao.repository.RateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This service handles operations related to RateEntity
 *
 * @author Pezhman Jahanmard
 */
@Service
public class RateService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RateService.class);

	@Autowired
	private RateRepository rateRepository;


}
