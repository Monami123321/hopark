package com.ssafy.hopark.model.dao;

import java.util.List;

import com.ssafy.hopark.model.dto.Sports;
import com.ssafy.hopark.model.dto.SportsSearchCondition;

public interface SportsDao {

	List<Sports> selectAll();

	List<Sports> selectByCondition(SportsSearchCondition searchCondition);

}
