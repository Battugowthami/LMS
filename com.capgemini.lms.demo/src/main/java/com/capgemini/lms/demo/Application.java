package com.capgemini.lms.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "com.capgemini.lms.demo")
public class Application 
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
