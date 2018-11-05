package com.github.yabaa.footballapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static final String BASE_API_PATH = "/api";

	public static final String BASE_API_V1_PATH = BASE_API_PATH + "/v1";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
