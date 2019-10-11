package com.wellington.applications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellington.applications.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findFirstByUsername(String username);
	
}
