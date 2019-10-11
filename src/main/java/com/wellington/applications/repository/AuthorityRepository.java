package com.wellington.applications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellington.applications.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
}
