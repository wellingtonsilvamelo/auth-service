package com.wellington.applications.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBG_AUTHORITY")
public class Authority {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AUTHORITY_ID")
	private Long authorityId;
	
	@Column(name="AUTHORITY_DESCRIPTION")
	private String description;
	
	public Long getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
