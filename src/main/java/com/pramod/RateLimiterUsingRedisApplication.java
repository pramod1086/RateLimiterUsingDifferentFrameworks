package com.pramod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RateLimiterUsingRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateLimiterUsingRedisApplication.class, args);
	}

}
