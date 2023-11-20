package com.ssafy.hopark.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
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

		
		
		
		
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.hopark.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo())
				.securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SSAFIT 최종 프로젝트 호박").description("운동추천서비스 API입니다.").version("0.1").build();
	}
	
	
    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }
    
    // 메서드별 authorize 달아주기 (헤더에 jwt 심어서 swagger로 테스트 가능)
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .operationSelector(oc -> true)
                //.forPaths(PathSelectors.regex("/api/.*")) // swaggerfox3.0부터 사용 못 한다고 함
                .build();
    }
    
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "전역");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
        return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
    }

}
