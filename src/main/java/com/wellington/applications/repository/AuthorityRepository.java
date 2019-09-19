package com.wellington.applications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellington.applications.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
	Authority findByName(String name);
	
}
