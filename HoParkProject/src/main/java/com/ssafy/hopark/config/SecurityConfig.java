package com.ssafy.hopark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ssafy.hopark.filter.JwtFilter;

/**
 * 
 * @author hoyoung 
 * spring-security config파일 http통신에 적용할 보안 사항 작성 cors, csrf,
 *         인증없이 허용할 uri 등
 * 
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// securityfilterchain을 빈으로 등록해야 함
	// HttpSecurity 클래스는 filterchain을 구성하기위해 spring에서 제공하는 builder임
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.httpBasic().disable() // httpBasic을 이용한 인증은 안 씀(브라우저에서 username, pw 요구하는 기본 동작)
				.csrf().disable() // RESTful 서버라서 csrf도 끔
				.cors().and() // cors 허용함
				.authorizeHttpRequests() // 요청에 권한부여
				.antMatchers("/user/login", "/user/regist").permitAll() // http://localhost:8080/user/{login, regist} 요청은 무조건 허가함 (로그인 요청, 회원가입 요청)
				.antMatchers("/swagger-ui/**", "/swagger-resources/**", "/v2/api-docs", "/webjars/**").permitAll() // Swagger도 허용.. index.html말고 api적히는 문서 경로도 다 써줘야 정상작동함.
				.anyRequest().authenticated().and() // 그 외에 전부 인증 받아야 함
				.sessionManagement() // 세션 설정 시작(jwt사용 위해)
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // 토큰 관리를 위해 stateless적용 (서버에 세션저장소를 만들지 않고 stateless하게 유지함)
				.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class); // JwtFilter를 UsernamePasswordAuthenticationFilter 앞에 추가
		
		return httpSecurity.build(); // 설정 끝내고 build 해서 반환함
	}
	
	@Bean
	public JwtFilter jwtFilter() {
		return new JwtFilter();
	}
	
	// UserService에서 활용하기 위해 빈으로 등록함 (PasswordEncoder)
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
}
