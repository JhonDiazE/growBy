package com.model.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication()
public class ApiMainApplication {

  private static final Logger log = LoggerFactory.getLogger(ApiMainApplication.class);

  public static void main(String[] args) {
		SpringApplication.run(ApiMainApplication.class, args);
	}

	
}
