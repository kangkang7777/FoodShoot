package com.wfuhui.config;

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
public class SwaggerConfig {

	@Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("mall-api")
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wfuhui.modules.api"))
                .paths(PathSelectors.any())
                .build();
	}

    private ApiInfo buildApiInf() {  
        return new ApiInfoBuilder()  
                .title("mall-api RESTFUL APIS")
                .description("Copyright © 2018, wfuhui. All Rights Reserved.")
                .contact(new Contact("微服汇", "http://www.wfuhui.com", "1397593242@qq.com"))
                .termsOfServiceUrl("http://www.wfuhui.com")  
                .version("1.0.0-SNAPSHOT")
                .build();  
    }
}
