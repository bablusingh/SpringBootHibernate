package com.app.aiolus;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements  WebMvcConfigurer {
	
	
	@Bean
	public Docket productApi1() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Version 1").select()
				.apis(RequestHandlerSelectors.basePackage("com.app.aiolus.controllers"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiInfo1());
	}

	
	private ApiInfo apiInfo1() {
		return new ApiInfo("Aiolus Technologies Api Information", "Rest Servives Description Of API.", "1.0",
				"Terms of Service", new Contact("AiolusTech", "http://www.Aiolustech.com", "contact@aiolustech.com"),
				"AiolusTech Licensing", "http://www.Aiolustech.com", Collections.emptyList());
	}

	 @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html")
	    .addResourceLocations("classpath:/META-INF/resources/");

	    registry.addResourceHandler("/webjars/**")
	    .addResourceLocations("classpath:/META-INF/resources/webjars/");
	  }
	

}
