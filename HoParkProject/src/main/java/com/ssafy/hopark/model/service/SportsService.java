package com.ssafy.hopark.model.service;

import java.util.List;

import com.ssafy.hopark.model.dto.Sports;
import com.ssafy.hopark.model.dto.SportsSearchCondition;

public interface SportsService {

	List<Sports> getAllSports();

	List<Sports> searchByCondition(SportsSearchCondition searchCondition);

	List<Sports> pickSports();

}
