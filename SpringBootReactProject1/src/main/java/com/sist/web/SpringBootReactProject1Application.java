package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sist.web.*")
public class SpringBootReactProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactProject1Application.class, args);
	}

}
