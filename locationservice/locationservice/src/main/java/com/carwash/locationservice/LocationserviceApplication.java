package com.carwash.locationservice;

import com.carwash.locationservice.service.LocationServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition
public class LocationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationserviceApplication.class, args);
	}

	@Bean
	public LocationServiceImpl getBean(){
		return new LocationServiceImpl();
	}
}
