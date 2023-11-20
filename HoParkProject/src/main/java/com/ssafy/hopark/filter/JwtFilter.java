package com.ssafy.hopark.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ssafy.hopark.util.JwtUtil;



// OncePerRequestFilter는 한 요청에 필터가 한 번만 동작하도록 도와준다.
// 처음 로그인하고, 다른 페이지로 이동할 때마다 필터가 동작하지 않도록 이걸 상속해서 쓰자
public class JwtFilter extends OncePerRequestFilter {
	
	@Value(value = "${jwt.key}") // 토큰 검증을 위한 키 (발급할 때 썼던 키)
	private String SECRET_KEY;
	
	
	@Autowired
	JwtUtil jwtUtil;
	
	
	// Http 요청 헤더에서 jwt 추출하기
	private String extractJwt(HttpServletRequest req) {
		// http 요청 헤드에 같이 날아온 토큰 검사 -> Authorization : Bearer <token> 형태이므로 getHeader로 값 가져옴.
        final String authorizationHeader = req.getHeader("Authorization");
        
        // 헤더에서 토큰 추출
        // Authorization : Bearer <token> (토큰 시작이 value에서 7번 인덱스부터임)
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7); // 7번인덱스부터 끝까지 자름(여기서부터가 jwt)
            
        }
        return null;
        
	}
	
	// dofilter와 동일하지만 한 번만 수행됨을 보장하는 메서드임. 상위 클래스에 미리 정의되어 있음.
	// 토큰 유효성 검사 로직을 이 메서드에 작성함.
	   @Override
	    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
	            throws ServletException, IOException {

	        // JWT를 헤더에서 추출
	        String token = extractJwt(req);
//	        System.out.println(token + "두필터 토큰");
//	        System.out.println(jwtUtil.validateToken(token) + "검사검사");
	        
	        
	        if (token != null && jwtUtil.validateToken(token)) {
	            // JWT를 검증하고 유효한 경우 사용자 인증 설정
	            String userId = jwtUtil.extractUserId(token);
//	            System.out.println(userId + "여기 필터임");
	            
	            // Authentication은 spring security에서 인가를 관리하는 객체임 하위 구현체로 구현함.
	            // Authentication은 securitycontextholder에 등록되고 관리됨
	            // jwt를 활용해서 검증하고 있기 때문에, credential(2번째 파라미터) -> null임
	            // authorities(3번째 파라미터) -> 따로 controller에 메서드마다 role을 정해놓지 않아서 null임 (ex . ADMIN 등)
	            Authentication authentication = new UsernamePasswordAuthenticationToken(userId, null, null);
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	        }

	        // 다음 필터로 이동
	        filterChain.doFilter(req, res);
	    }
	
	
	
	
	

}
