package com.ssafy.hopark.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hopark.model.dao.SportsDao;
import com.ssafy.hopark.model.dto.Sports;
import com.ssafy.hopark.model.dto.SportsSearchCondition;

@Service
public class SportsServiceImpl implements SportsService {

	@Autowired
	SportsDao sportsDao;

	@Override
	public List<Sports> getAllSports() {
		return sportsDao.selectAll();
	}

	@Override
	public List<Sports> searchByCondition(SportsSearchCondition searchCondition) {
		return sportsDao.selectByCondition(searchCondition);
	}

}
