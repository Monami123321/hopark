package com.ssafy.hopark.model.dao;

import java.util.List;

import com.ssafy.hopark.model.dto.Sports;

public interface SportsDao {

	List<Sports> selectAll();

}
