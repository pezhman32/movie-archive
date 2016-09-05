package com.sinan.test.service.rate;

import com.sinan.test.dao.entity.RateEntity;
import com.sinan.test.service.BaseService;

import java.math.BigDecimal;

public interface RateService extends BaseService<RateEntity> {
	BigDecimal estimateAvgRatingForMovie(Integer movieId);
}
