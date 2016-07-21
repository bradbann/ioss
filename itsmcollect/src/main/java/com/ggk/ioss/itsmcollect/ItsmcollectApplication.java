package com.ggk.ioss.itsmcollect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ItsmcollectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsmcollectApplication.class, args);
	}
}
