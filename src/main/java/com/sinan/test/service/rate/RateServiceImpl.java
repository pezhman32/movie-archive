package com.sinan.test.service.rate;

import com.sinan.test.dao.entity.MovieEntity;
import com.sinan.test.dao.entity.RateEntity;
import com.sinan.test.dao.repository.RateRepository;
import com.sinan.test.service.BaseServiceImpl;
import com.sinan.test.service.movie.MovieService;
import com.sinan.test.service.movie.MovieServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private MovieService movieService;

	@Override
	public BigDecimal estimateAvgRatingForMovie(Integer movieId) {
		return repository.estimateAvgRating(movieId);
	}

	/**
	 * Adds new rateEntity and reset its movie avgRating field
	 */
	@Override
	public RateEntity addNew(RateEntity entity) throws MovieServiceException, RateServiceException {
		if (repository.countByMovieEntity_IdAndUserEntity_Id(entity.getMovieEntity().getId(), entity.getUserEntity().getId()) > 0) {
			throw new RateServiceException("You cannot rate more than one time for a movie.");
		}

		RateEntity rateEntity = super.addNew(entity);

		//reset avg rating for movie
		MovieEntity movieEntity = movieService.findById(entity.getMovieEntity().getId());
		movieService.resetAvgRating(movieEntity);
		return get(rateEntity.getId());
	}

	@Override
	public RateEntity update(Integer id, RateEntity entity) throws MovieServiceException {
		RateEntity rateEntity = super.update(id, entity);
		movieService.resetAvgRating(rateEntity.getMovieEntity());
		return entity;
	}

	@Override
	public void delete(Integer id) throws MovieServiceException {
		MovieEntity movieEntity = get(id).getMovieEntity();
		super.delete(id);

		movieService.resetAvgRating(movieEntity);
	}
}
