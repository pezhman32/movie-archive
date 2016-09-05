package com.sinan.test.service.rate;

import java.math.BigDecimal;

public interface RateService {
	BigDecimal estimateAvgRatingForMovie(Integer movieId);
}
