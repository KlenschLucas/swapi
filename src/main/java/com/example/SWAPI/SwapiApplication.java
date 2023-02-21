package com.example.SWAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableFeignClients
@SpringBootApplication
@CrossOrigin("http://localhost:4200")
public class SwapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwapiApplication.class, args);
	}

}
