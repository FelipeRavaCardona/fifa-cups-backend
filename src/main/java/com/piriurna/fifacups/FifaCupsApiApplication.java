package com.piriurna.fifacups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.piriurna" })
public class FifaCupsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FifaCupsApiApplication.class, args);
	}

}
