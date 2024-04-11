package com.brunoandreotti.gametrackerhexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GametrackerHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GametrackerHexagonalApplication.class, args);
	}

}
