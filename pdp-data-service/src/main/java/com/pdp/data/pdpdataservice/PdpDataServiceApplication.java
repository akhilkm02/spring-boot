package com.pdp.data.pdpdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PdpDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdpDataServiceApplication.class, args); 
	}

}
