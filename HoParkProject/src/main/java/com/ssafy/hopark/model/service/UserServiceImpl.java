package com.ssafy.hopark.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hopark.model.dao.UserDao;
import com.ssafy.hopark.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	// 로그인 메서드
	// 전달된 user의 id로 db에서 가져온다음, 유효하지 않은 id거나 비밀번호가 다르면 false, 아니면 true
	@Override
	public boolean login(User user) {
		User selected = userDao.selectOne(user.getId());
		if (selected == null || selected.getPassword() != user.getPassword()) {
			return false;
		}
		return true;
	}

}
