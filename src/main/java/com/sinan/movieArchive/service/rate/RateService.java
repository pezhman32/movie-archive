package com.sinan.movieArchive.service.rate;

import com.sinan.movieArchive.dao.entity.RateEntity;
import com.sinan.movieArchive.service.BaseService;

import java.math.BigDecimal;

public interface RateService extends BaseService<RateEntity> {
	BigDecimal estimateAvgRatingForMovie(Integer movieId);
}
