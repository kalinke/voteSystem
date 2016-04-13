package com.globo.bbbvoting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BBBVotingApplication {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(BBBVotingApplication.class);
    
	public static void main(String[] args) {
		SpringApplication.run(BBBVotingApplication.class, args);
		LOGGER.info("Application started successfully");
	}
}
