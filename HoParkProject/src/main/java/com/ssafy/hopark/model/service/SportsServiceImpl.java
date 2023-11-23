package com.ssafy.hopark.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hopark.model.dao.SportsDao;
import com.ssafy.hopark.model.dto.Sports;
import com.ssafy.hopark.model.dto.SportsSearchCondition;

@Service
public class SportsServiceImpl implements SportsService {

	@Autowired
	SportsDao sportsDao;
	
	private final Random random = new Random();
	

	@Override
	public List<Sports> getAllSports() {
		return sportsDao.selectAll();
	}

	@Override
	public List<Sports> searchByCondition(SportsSearchCondition searchCondition) {
		return sportsDao.selectByCondition(searchCondition);
	}

	@Override
	public List<Sports> pickSports() {
		List<Sports> list = sportsDao.selectAll();
		if(list.size()<4) {
			return null;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(set.size()<4) {
			set.add(random.nextInt(list.size()));
		}
		List<Sports> picked = new ArrayList<>();
		set.stream().forEach((n) -> picked.add(list.get(n)));
		return picked;

	}

}
