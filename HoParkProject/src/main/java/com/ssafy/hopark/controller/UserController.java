package com.ssafy.hopark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hopark.model.dto.User;
import com.ssafy.hopark.model.service.UserService;
import com.ssafy.hopark.util.JwtUtil;

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
		header.set("Access-Control-Expose-Headers", "Authorization"); // 안 하면 axios 응답에서 토큰이 안 보임.
//		System.out.println("응답 잘 감");
//		System.out.println(token + "토큰임");
//		System.out.println(header.toString() + "헤더임");
		return new ResponseEntity<String>(SUCCESS, header, HttpStatus.OK);

	}
	
	// 회원가입 메서드
	@ApiOperation(value = "회원가입 메서드 입니다.",notes = "입력된 정보를 DB에 저장합니다. 비밀번호는 BCryptPasswordEncoder를 통해 암호화 합니다.")
	@PostMapping("regist")
	public ResponseEntity<String> regist(@RequestBody User user) {
		System.out.println(user.toString());
		
		boolean res = userService.regist(user);
		
		if(!res) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>(SUCCESS,HttpStatus.CREATED);
		
		
	}
	@ApiOperation(value = "회원정보 수정 메서드 입니다.", notes = "로그인 상태일 때만 동작합니다. 입력된 정보로 DB를 수정합니다.")
	@PutMapping("update")
	public ResponseEntity<String> updateUserProfile(@RequestBody User user) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 토큰 인증정보가 저장된 SecurityContextHolder에서 Principal(id가 저장됨)을 가져왔음
		String principal = (String)authentication.getPrincipal(); 
		
		
		boolean res = userService.updateUserProfile(user, principal);
		
		if(!res) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
		
		
	}
	@ApiOperation(value = "회원탈퇴 메서드입니다.", notes = "로그인 상태에서만 동작합니다. 토큰을 검사하여 SecurityContextHolder에 저장된 Authentication 기준으로 DB를 삭제합니다.")
	@DeleteMapping("delete")
	public ResponseEntity<String> deleteUserProfile() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 토큰 인증정보가 저장된 SecurityContextHolder에서 Principal(id가 저장됨)을 가져왔음
		String principal = (String)authentication.getPrincipal(); 
		
		boolean res = userService.deleteUserProfile(principal);
		
		if(!res) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
			
		
	}

}
