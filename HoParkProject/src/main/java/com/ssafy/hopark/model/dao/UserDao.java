package com.ssafy.hopark.model.dao;

import com.ssafy.hopark.model.dto.User;

public interface UserDao {

	User selectOne(String id);

}
