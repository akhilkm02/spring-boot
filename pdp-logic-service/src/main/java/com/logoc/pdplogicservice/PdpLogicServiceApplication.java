package com.logoc.pdplogicservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableEurekaClient
public class PdpLogicServiceApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getResrTemplate() {
		return new RestTemplate();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(PdpLogicServiceApplication.class, args);
	}

}
