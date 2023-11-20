package com.ssafy.hopark.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	// Swagger 요청 경로와 ui.html 파일 경로를 미리 등록해둠
	private final String swaggerLocation = "classpath:/META-INF/resources/webjars/springfox-swagger-ui/";
	private final String swaggerRequest = "/swagger-ui/**";
	
	// CORS 전역 처리 - 모든 경로에서 모든 요청에 대해 허용
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**").allowedOrigins("http://localhost:8080", "http://localhost:5173").allowedMethods("GET","POST","PUT","DELETE");
	}
	
	// 정적 파일 제공 처리 - 요청 경로 및 파일 제공하는 경로 등록
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(swaggerRequest)
		.addResourceLocations(swaggerLocation); // Swagger 등록
		
	}
	

}
