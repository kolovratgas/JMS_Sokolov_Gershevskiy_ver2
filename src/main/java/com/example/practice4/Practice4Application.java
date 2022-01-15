package com.example.practice4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Practice4Application {

	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(Practice4Application.class, args);
	}
}
