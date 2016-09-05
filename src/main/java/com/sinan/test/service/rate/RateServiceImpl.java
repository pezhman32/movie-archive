package com.sinan.test.service.rate;

import com.sinan.test.dao.entity.RateEntity;
import com.sinan.test.dao.repository.RateRepository;
import com.sinan.test.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * This service handles operations related to RateEntity
 *
 * @author Pezhman Jahanmard
 */
@Service
@Transactional
public class RateServiceImpl extends BaseServiceImpl<RateEntity, RateRepository> implements RateService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RateServiceImpl.class);

	@Override
	public BigDecimal estimateAvgRatingForMovie(Integer movieId) {
		return repository.estimateAvgRating(movieId);
	}
}
