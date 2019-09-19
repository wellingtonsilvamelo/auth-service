package com.wellington.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.wellington.applications.model.UserEntity;
import com.wellington.applications.repository.UserRepository;
import com.wellington.applications.utils.Util;

@SpringBootApplication
@EnableEurekaClient
public class AuthServiceApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			UserEntity userEntity = new UserEntity();
			userEntity.setUsername("tomwell");
			userEntity.setPassword(Util.generateBCrypt("123"));
			this.userRepository.save(userEntity);

		};
	}

}
