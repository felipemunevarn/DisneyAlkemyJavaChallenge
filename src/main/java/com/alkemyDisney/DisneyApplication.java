package com.alkemyDisney;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.alkemyDisney.model.Role;
import com.alkemyDisney.model.User;
import com.alkemyDisney.rest.RestRoleController;
import com.alkemyDisney.rest.RestUserController;

@CrossOrigin(origins = "*")
@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
public class DisneyApplication implements CommandLineRunner {
	
	private static Logger LOG = LoggerFactory.getLogger(DisneyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		LOG.info("Using spring security");		
	}
	
//	@Bean
//	CommandLineRunner run(RestRoleController roleController) {
//		return args -> {
//			roleController.insert(new Role(0, "USER", new HashSet<>()));
//			roleController.insert(new Role(0, "MANAGER", new HashSet<>()));
//			roleController.insert(new Role(0, "ADMIN", new HashSet<>()));
//		};		
//	}
	
//	@Bean
//	CommandLineRunner run(RestUserController userController) {
//		return args -> {
//			userController.associateRolesToUser(15, 15);
//			userController.associateRolesToUser(17, 18);
//		};		
//	}
}
