package com.ssafy.hopark.model.dao;

import com.ssafy.hopark.model.dto.User;
import com.ssafy.hopark.model.dto.Work;

public interface UserDao {

	User selectOne(String id);

	int insertOne(User user);

	int updateUserProfile(User user);

	int deleteUserProfile(String principal);

	int updateWork(Work work);

}
