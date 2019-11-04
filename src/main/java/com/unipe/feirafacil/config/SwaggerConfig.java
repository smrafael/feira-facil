package com.unipe.feirafacil.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.models.auth.In;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.unipe.feirafacil.api"))              
          .paths(PathSelectors.any())                          
          .build()
          .securitySchemes(Arrays.asList(new ApiKey("JWT Bearer", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
          .securityContexts(Arrays.asList(securityContext()));                                         
    }
    
    private SecurityContext securityContext() {
	return SecurityContext.builder()
		.securityReferences(defaultAuth())
		.forPaths(PathSelectors.ant("/**"))
		.build();
    }

    private List<SecurityReference> defaultAuth() {
	AuthorizationScope authorizationScope = new AuthorizationScope("ADMIN", "accessEverything");
	AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	authorizationScopes[0] = authorizationScope;
	return Arrays.asList(new SecurityReference("JWT Bearer", authorizationScopes));
    }
    
}
