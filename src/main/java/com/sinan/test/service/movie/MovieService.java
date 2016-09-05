package com.sinan.test.service.movie;

import com.sinan.test.dao.entity.MovieEntity;
import com.sinan.test.dao.enums.GENRE;
import com.sinan.test.service.BaseService;
import com.sinan.test.service.user.UserServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface MovieService extends BaseService<MovieEntity> {

	List<MovieEntity> topMovies(int limit);

	Page<MovieEntity> userMovies(Integer userId, Pageable pageable) throws MovieServiceException;

	List<MovieEntity> topLateNightMovies(int limit);

	BigDecimal getAvgRatingForMovie(Integer movieId) throws MovieServiceException;

	void resetAvgRatingForAllMovies() throws MovieServiceException;

	List<MovieEntity> findByGenreAndUserAge(GENRE genre, Integer userId, int limit) throws UserServiceException;
}
