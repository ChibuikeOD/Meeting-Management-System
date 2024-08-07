package com.Team4.SWENG455.SWENG._5.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Sweng455ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sweng455ProjectApplication.class, args);
	}

}
