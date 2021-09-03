package com.pro.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//http://localhost:1000/common/swagger-ui.html#/
//http://localhost:1000/common/v2/api-docs
//For Documentation
@SpringBootApplication
//@EnableDiscoveryClient
@EnableCaching
public class CommonServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonServicesApplication.class, args);
	}

}
