package com.wellington.applications.model;

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
@Table(name = "tb_usuario_autorizacao")
public class UserAuthority {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_USUARIO_AUTORIZACAO")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USUARIO", nullable=false)
	private UserEntity userEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_AUTORIZACAO", nullable=false)
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
