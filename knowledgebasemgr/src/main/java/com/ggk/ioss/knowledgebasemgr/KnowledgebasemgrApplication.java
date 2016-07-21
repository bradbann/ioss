package com.ggk.ioss.knowledgebasemgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class KnowledgebasemgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowledgebasemgrApplication.class, args);
	}
}
