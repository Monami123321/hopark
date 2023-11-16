package com.ssafy.hopark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hopark.model.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

}
