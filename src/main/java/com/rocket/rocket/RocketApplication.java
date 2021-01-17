package com.rocket.rocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class RocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketApplication.class, args);
	}

}