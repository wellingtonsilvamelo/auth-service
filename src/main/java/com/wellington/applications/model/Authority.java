package com.wellington.applications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_autoriacao")
public class Authority {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_AUTORIZACAO")
	private Long authorityId;
	
	@Column(name="DS_AUTORIZACAO")
	private String name;
	
	public Long getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
