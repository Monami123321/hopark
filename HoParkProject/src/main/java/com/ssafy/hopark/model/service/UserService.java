package com.ssafy.hopark.model.service;

import com.ssafy.hopark.model.dto.User;

public interface UserService {

	boolean login(User user);

	boolean regist(User user);

	boolean updateUserProfile(User user, String targetId);

	boolean deleteUserProfile(String principal);

}
