package com.mediref;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MedirefApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedirefApplication.class, args);
	}

}
