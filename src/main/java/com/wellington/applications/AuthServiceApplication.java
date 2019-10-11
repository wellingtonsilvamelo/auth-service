package com.wellington.applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthServiceApplication {
	
	/*@Autowired
	private UserRepository userRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			UserEntity userEntity = new UserEntity();
			userEntity.setUsername("tomwell");
			userEntity.setPassword(Util.generateBCrypt("tw060686"));
			this.userRepository.save(userEntity);

		};
	}*/

}
