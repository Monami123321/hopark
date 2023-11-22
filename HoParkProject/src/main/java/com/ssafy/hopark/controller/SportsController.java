package com.ssafy.hopark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hopark.model.dto.Sports;
import com.ssafy.hopark.model.dto.SportsSearchCondition;
import com.ssafy.hopark.model.service.SportsService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sports")
public class SportsController {

	private static final String SUCCESS = "request successed";
	private static final String FAIL = "request failed";

	@Autowired
	SportsService sportsService;

	@ApiOperation(value = "DB에 저장된 모든 운동 정보를 반환합니다.", notes = "Authenticated인 요청만 가능, jwt는 bearer 까지 모두 포함해서 보내야 함, role은 따로 없습니다.")
	@GetMapping("getAll")
	public ResponseEntity<?> getAllSports() {
		List<Sports> list = sportsService.getAllSports();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Sports>>(list, HttpStatus.OK);

	}
	@ApiOperation(value = "전달받은 검색조건에 따라 운동 리스트를 반환합니다.", notes = "SportsSearchCondition에 딱 맞는 객체만 동적쿼리로 조회하여 반환합니다.(모두 AND 조건)")
	@PostMapping("search")
	public ResponseEntity<?> searchByCondition(@RequestBody SportsSearchCondition searchCondition) {
		List<Sports> list = sportsService.searchByCondition(searchCondition);
		
		System.out.println(searchCondition.toString());

		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Sports>>(list, HttpStatus.OK);

	}

}
