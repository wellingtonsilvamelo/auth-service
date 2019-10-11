package com.wellington.applications.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBG_USER_AUTHORITY")
public class UserAuthority {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_AUTHORITY_ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	private UserEntity userEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="AUTHORITY_ID", nullable=false)
	private Authority authority;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}
