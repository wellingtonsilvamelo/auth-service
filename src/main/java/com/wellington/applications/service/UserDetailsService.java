package com.wellington.applications.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wellington.applications.model.UserEntity;
import com.wellington.applications.repository.UserAuthorityRepository;
import com.wellington.applications.repository.UserRepository;

@Service(value = "userService")
@Transactional(rollbackOn=Exception.class)
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findFirstByUsername(username);		
		if(userEntity == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(userEntity.getUsername(), userEntity.getPassword(), getAuthority(userEntity.getUserId()));
	}

	private List<SimpleGrantedAuthority> getAuthority(Long userId) {
		List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		userAuthorityRepository.findByUserId(userId).stream()
			.forEach(u -> {
				grantedAuthorities.add(new SimpleGrantedAuthority(u.getAuthority().getName()));
			});
		
		return grantedAuthorities;
	}
}