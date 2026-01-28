package com.mediref;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.mediref.repository.jpa")
@EnableElasticsearchRepositories(basePackages = "com.mediref.repository.search")
public class MedirefApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedirefApplication.class, args);
	}

}
