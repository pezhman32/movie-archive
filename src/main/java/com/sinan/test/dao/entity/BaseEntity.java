package com.sinan.test.dao.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Abstract BaseEntity contains some shared fields like id, created and updated.
 *
 * @author Pezhman Jahanmard
 */
@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@Column(name = "id", unique = true, columnDefinition = "INTEGER")
	@GeneratedValue(strategy= GenerationType.AUTO)
	protected Integer id;

	@Column(name = "dao_created")
	@Type(type = "timestamp")
	protected Date created;

	@Column(name = "dao_updated")
	@Type(type = "timestamp")
	protected Date updated;

	@PreUpdate
	public void updateVersion() {
		updated = new Date();
	}

	@PrePersist
	public void createVersion() {
		created = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
