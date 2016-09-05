package com.sinan.test.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sinan.test.dao.enums.GENRE;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.util.List;

/**
 * MovieEntity, entity based on movies table
 *
 * @author Pezhman Jahanmard
 */
@Entity
@Table(name = "movies")
public class MovieEntity extends BaseEntity {
	@Column
	private String name;

	@Column(columnDefinition = "SMALLINT")
	private Integer year;

	@Column(name = "avg_rating")
	private BigDecimal avgRating;

	@Column
	@Enumerated(EnumType.STRING)
	private GENRE genre;

	@Column
	private String director;

	@OneToMany(mappedBy = "movieEntity")
	private List<RateEntity> rateEntities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(BigDecimal avgRating) {
		this.avgRating = avgRating;
	}

	public GENRE getGenre() {
		return genre;
	}

	public void setGenre(GENRE genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@JsonIgnore
	@XmlTransient
	public List<RateEntity> getRateEntities() {
		return rateEntities;
	}

	public void setRateEntities(List<RateEntity> rateEntities) {
		this.rateEntities = rateEntities;
	}
}
