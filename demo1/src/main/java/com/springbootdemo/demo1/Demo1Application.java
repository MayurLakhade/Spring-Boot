package com.springbootdemo.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*
 * @SpringBootApplication
 * :-This annotation is used to mark the main class of a spring boot application.
 * it encapsulates @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan
 * 
 * @ComponentScan
 * :- It is used when we want to scan a package for beans.
 * It is used with the annotation @Configuration. we can also specify the base package to scan for spring component.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
