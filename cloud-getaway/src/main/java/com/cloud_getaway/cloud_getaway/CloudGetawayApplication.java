package com.cloud_getaway.cloud_getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudGetawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGetawayApplication.class, args);
	}

}
