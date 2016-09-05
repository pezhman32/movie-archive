package com.sinan.test.dao.repository;

import com.sinan.test.dao.entity.RateEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * RateRepository to manage operations regarding rates table and RateEntity
 *
 * @author Pezhman Jahanmard
 */
@Repository
public interface RateRepository extends BaseRepository<RateEntity> {

	@Query("SELECT AVG(r.rate) FROM RateEntity r WHERE r.movieEntity.id = :movieId")
	BigDecimal estimateAvgRating(@Param("movieId") Integer movieId);
}
