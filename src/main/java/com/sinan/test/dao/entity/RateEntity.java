package com.sinan.test.dao.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 * RateEntity, entity based on rates table
 *
 * @author Pezhman Jahanmard
 */
@Entity
@Table(name = "rates")
public class RateEntity extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "id")
	private MovieEntity movieEntity;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity userEntity;

	@Column
	@Digits(integer = 1, fraction = 2)
	@Min(0)
	@Max(5)
	private BigDecimal rate;

	@Column(name = "watched_date")
	@Type(type = "date")
	private Date watchedDate;

	@Column(name = "watched_time")
	@Type(type = "time")
	private Time watchedTime;

	public MovieEntity getMovieEntity() {
		return movieEntity;
	}

	public void setMovieEntity(MovieEntity movieEntity) {
		this.movieEntity = movieEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Date getWatchedDate() {
		return watchedDate;
	}

	public void setWatchedDate(Date watchedDate) {
		this.watchedDate = watchedDate;
	}

	public Time getWatchedTime() {
		return watchedTime;
	}

	public void setWatchedTime(Time watchedTime) {
		this.watchedTime = watchedTime;
	}
}
