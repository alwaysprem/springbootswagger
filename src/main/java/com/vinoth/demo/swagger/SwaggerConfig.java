package com.vinoth.demo.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** 
 * Reference : 
 * https://dzone.com/articles/spring-boot-restful-api-documentation-with-swagger 
 * https://www.youtube.com/watch?v=HHyjWc0ASl8
 * https://www.javainuse.com/spring/boot_swagger
 * **/
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.vinoth.demo.controller")).paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return (regex("/rest.*"));
		/** For multiple rest url **/
		/* return or(regex("/api/posts.*"), regex("/api/javainuse.*")); */
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring boot Swagger").description("Vinoth POC")
				.termsOfServiceUrl("http://google.com").contact("vinovino0588@gmail.com").license("sample License")
				.licenseUrl("https://google.com").version("1.0").build();
	}
}
