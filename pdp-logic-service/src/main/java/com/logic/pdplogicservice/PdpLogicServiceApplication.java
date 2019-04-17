package com.logic.pdplogicservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PdpLogicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdpLogicServiceApplication.class, args);
	}

}
