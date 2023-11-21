package com.ssafy.hopark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hopark.model.dto.Sports;
import com.ssafy.hopark.model.service.SportsService;

@RequestMapping("/sports")
@RestController
public class SportsController {
	
	private static final String SUCCESS = "request successed";
	private static final String FAIL = "request failed";
	
	@Autowired
	SportsService sportsService;
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAllSports() {
		List<Sports> list = sportsService.getAllSpots();
		if(list == null || list.size() == 0) {
			return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Sports>>(list,HttpStatus.OK);
		
		
	}
	
	

}
