package com.sinan.test.dao.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * UserEntity, entity based on users table
 *
 * @author Pezhman Jahanmard
 */
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
	@Column
	private String username;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	@Type(type = "date")
	private Date birthdate;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
}
