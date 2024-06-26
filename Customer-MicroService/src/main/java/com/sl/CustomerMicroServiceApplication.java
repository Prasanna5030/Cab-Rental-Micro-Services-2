package com.sl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroServiceApplication.class, args);
	}

}
