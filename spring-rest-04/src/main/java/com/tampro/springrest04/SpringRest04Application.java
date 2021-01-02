package com.tampro.springrest04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringRest04Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRest04Application.class, args);
	}

}
