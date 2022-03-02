package fr.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(value = {
		@PropertySource("classpath:application.properties"), 
		@PropertySource("classpath:datasource.properties")
		})
public class ApplicationCave {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCave.class, args);
	}

	
	
}
