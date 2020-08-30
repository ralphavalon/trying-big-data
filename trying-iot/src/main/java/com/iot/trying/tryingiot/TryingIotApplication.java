package com.iot.trying.tryingiot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TryingIotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TryingIotApplication.class, args);
	}

}
