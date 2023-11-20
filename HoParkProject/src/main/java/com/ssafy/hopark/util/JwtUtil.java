package com.ssafy.hopark.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// jwt 생성과 검증 로직 정의, 빈으로 등록함.
@Component
public class JwtUtil {
	
	// 암호화 키는 265비트를 요구해서 그냥 길게 작성함.
	// application.properties에 값을 미리 등록해놓고, 가져와서 쓰기 (jwt.key=value)
	@Value(value = "${jwt.key}")
	private String SECRET_KEY; // Jwt 암호화 키
	private Long ONE_HOUR = 60*1000L;
	private Long ONE_DAY = 60*1000*24L;
	
	
	// 토큰 생성 메서드. jwt는 header, payload, signature로 구성된다. 빌더를 통해 각각을 작성하고 리턴한다.
	// 암호화 키는 String -> byte[] -> Key 객체로 
	public String generateToken(String id) {
		Claims claims = Jwts.claims(); // claims는 일종의 Map으로 생각하면 됨. 정보를 저장할 공간 payload에 심어진다.
		claims.put("id", id);
		// 여기서 id은 axios에서 날아온 id임. spring security 관례에 맞춰서 그냥 작성함. (UserId)
		
		return Jwts.builder()
				.setHeaderParam("typ", "JWT") // jwt header 설정 "typ" : "JWT"
				.setClaims(claims) // 클레임을 payload에 넣기
				.setIssuedAt(new Date(System.currentTimeMillis())) //토큰 발급 날짜 지정 -> 확인해보면 payload에 심어짐
				.setExpiration(new Date(System.currentTimeMillis() + ONE_DAY)) // 토큰은 하루짜리임! -> 확인해보면 payload에 심어짐
				//.signWith(SignatureAlgorithm.HS256, secretKey.getBytes()) // 라이브러리 버전이 올라가면서 deprecated
				.signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()),SignatureAlgorithm.HS256) // signature 설정
				.compact();
		
	}
	
    // 토큰 유효성 검사
	// Jwts 클래스에서 제공하는 파싱 기능을 이용해서 유효성 검사를 할 수 있다.
	// parseClaimsJws는 주어진 key로 jwt를 파싱한다. 유효하면 claim을 반환하고, 아니면 예외를 던진다. claim은 일종의 map임을 기억하자
	// setSigningKey 파라미터가 byte[]임. 그냥 String 넣었다가 오류났다가 고쳤음
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // 유효하지 않은 토큰
            return false;
        }
    }

    // 토큰에서 id 추출
    // jwt에서 claim을 파싱하고 "id"라는 key로 value를 가져온다.
    public String extractUserId(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token).getBody(); // getBody는 claim이다. payload에 담긴 모든 key-val 쌍이 리턴된다고 생각하자.
        System.out.println(claims + "클레임입니다");
        return claims.get("id", String.class); // claims 메서드를 천천히 살펴보면 subject, exp 등 미리 지정한 메서드들도 있음. get은 개발자가 직접 넣은 key와 반환 class를 파라미터로 받음.
        
    }
	
	
	
	

}
