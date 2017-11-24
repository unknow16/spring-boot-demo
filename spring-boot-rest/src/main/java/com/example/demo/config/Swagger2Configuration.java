package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

	@Bean
	public Docket accessToken() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api") //定义组
				.select() //选择哪些路径和api会生成document
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.paths(PathSelectors.regex("/rest/.*")) //拦截的接口路径
				.build() //创建
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("用户管理api接口文档")
				.description("用户管理api")
				.termsOfServiceUrl("http://www.baidu.com")
				.contact(new Contact("fuyi", "http://www.baidu.com", "1406751952@qq.com"))
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
				.version("1.0")
				.build();
				
	}
}
