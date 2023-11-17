package com.ssafy.hopark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hopark.model.dto.User;
import com.ssafy.hopark.model.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	private static final String SUCCESS = "request successed";
	private static final String FAIL = "request failed";

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody User user) {
		boolean res = userService.login(user);
		if (!res) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

	}

}
