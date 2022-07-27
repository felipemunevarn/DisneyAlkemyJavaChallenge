package com.alkemyDisney;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

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

}
