package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableDiscoveryClient
@EnableWebMvc
@EnableFeignClients
@SpringBootApplication
public class TripBookingMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripBookingMicroServiceApplication.class, args);
	}

}
