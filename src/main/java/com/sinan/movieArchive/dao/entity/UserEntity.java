package com.sinan.movieArchive.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.List;

/**
 * UserEntity, entity based on users table
 *
 * @author Pezhman Jahanmard
 */
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
	@NotNull
	@Column
	private String username;

	@NotNull
	@Column
	private String email;

	@NotNull
	@Column
	private String password;

	@NotNull
	@Column
	@Type(type = "date")
	private Date birthdate;

	@OneToMany(mappedBy = "userEntity")
	private List<RateEntity> rateEntities;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlTransient
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@XmlTransient
	@JsonIgnore
	public List<RateEntity> getRateEntities() {
		return rateEntities;
	}

	public void setRateEntities(List<RateEntity> rateEntities) {
		this.rateEntities = rateEntities;
	}
}
