package com.ssafy.hopark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hopark.model.dto.User;
import com.ssafy.hopark.model.service.UserService;
import com.ssafy.hopark.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	JwtUtil jwtUtil; // 로그인 성공하면 토큰 발급용
	

	private static final String SUCCESS = "request successed";
	private static final String FAIL = "request failed";
	
	@ApiOperation(value = "id, pw가 정확히 들어오면 jwt를 발급하여 반환합니다.")
	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody User user) {
		boolean res = userService.login(user);
		if (!res) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}
		// 로그인이 잘 됐으면 jwt 발급, header에 담아서 클라이언트에게 응답
		
		String token = jwtUtil.generateToken(user.getId()); // 날아온 id를 기준으로 토큰발급
		
		HttpHeaders header =  new HttpHeaders();
		header.set("Authorization", "Bearer " + token); // 토큰 심는 헤더 규칙 -> Authorization: Bearer token(띄어쓰기 필요)
				
		
		return new ResponseEntity<String>(SUCCESS, header, HttpStatus.OK);

	}

}
