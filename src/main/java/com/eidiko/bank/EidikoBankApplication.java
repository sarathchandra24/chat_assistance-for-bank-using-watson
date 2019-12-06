package com.eidiko.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EidikoBankApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EidikoBankApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EidikoBankApplication.class);
	}
}
