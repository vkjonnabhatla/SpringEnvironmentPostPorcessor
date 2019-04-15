package com.example.http.headers.SpringEnvironmentPostPorcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEnvironmentPostProcessorApplication {

	public SpringEnvironmentPostProcessorApplication(){
		System.out.println("SpringEnvironmentPostProcessorApplication default constructor");
	}

	public static void main(String[] args) {
		System.out.println("SpringEnvironmentPostProcessorApplication main method");
		SpringApplication.run(SpringEnvironmentPostProcessorApplication.class, args);
	}

}
