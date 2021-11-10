package com.magoo.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingServiceApplication.class, args);
	}

}
