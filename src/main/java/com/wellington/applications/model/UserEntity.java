package com.wellington.applications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_usuario")
public class UserEntity {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_USUARIO")
	private Long userId;
	
	@Column(name="LOGIN_USUARIO")
	private String username;
	
	@JsonIgnore
	@Column(name="HASH_SENHA_USUARIO")
	private String password;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}