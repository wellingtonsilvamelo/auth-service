package com.wellington.applications.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellington.applications.entity.UserAuthority;
import com.wellington.applications.repository.UserAuthorityRepository;

@Service
@Transactional(rollbackFor=Exception.class)
public class UserAuthorityServiceImpl  {
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepository;

	public List<UserAuthority> findByUserId(Long userId) {
		return userAuthorityRepository.findByUserId(userId);
	}

}