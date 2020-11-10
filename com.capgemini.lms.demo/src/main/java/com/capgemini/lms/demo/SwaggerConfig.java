package com.capgemini.lms.demo;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.ant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(pathsToBeDocumented()).build();
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> pathsToBeDocumented() 
	{
		
		return or(ant("/author/**"),ant("/books/**"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Library Management API").description("Library Management REST API").license("Apache 2.0")
				.licenseUrl("https://www.javaguides.net/2019/10/spring-boot-crud-operations-example-with-jpa-hibernate.html").version("1.0.0").build();
	}
}
