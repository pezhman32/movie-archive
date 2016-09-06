package com.sinan.movieArchive.service.movie;

import com.sinan.movieArchive.dao.entity.MovieEntity;
import com.sinan.movieArchive.dao.enums.GENRE;
import com.sinan.movieArchive.service.BaseService;
import com.sinan.movieArchive.service.user.UserServiceException;
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

	MovieEntity resetAvgRating(MovieEntity movieEntity) throws MovieServiceException;
}
