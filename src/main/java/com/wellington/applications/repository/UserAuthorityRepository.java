package com.wellington.applications.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wellington.applications.entity.UserAuthority;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {
	
	@Query(value = "SELECT u FROM UserAuthority u WHERE u.userEntity.id = :userId")
	List<UserAuthority> findByUserId(@Param("userId") Long userId);

}