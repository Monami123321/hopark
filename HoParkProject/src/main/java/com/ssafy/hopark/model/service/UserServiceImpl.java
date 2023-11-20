package com.ssafy.hopark.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.hopark.model.dao.UserDao;
import com.ssafy.hopark.model.dto.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	// 비밀번호 DB저장 및 검증 시 이용할 PasswordEncoder -> spring-security에서 제공함
	// BCryptPasswordEncoder 는 해싱 시 원본과 상관 없이 60자 이하의 문자열이 반환됨. salt도 자동으로 추가해줌 -> 이 값을 DB에 저장
	// BCryptPasswordEncoder 는 해싱할 때마다 다른 값이 나와서 비밀번호 검증을 위한 메서드를 따로 제공하고 있음 (matches)
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	

	// 로그인 메서드
	// 전달된 user의 id로 db에서 가져온다음, 유효하지 않은 id거나 비밀번호가 다르면 false, 아니면 true
	@Override
	public boolean login(User user) {
		User selected = userDao.selectOne(user.getId());
		
		// 가져온 User DTO가 null이면 잘못된 id가 전달 된 것 -> false
		
		if (selected == null) {
			return false;
		}
		
		// 가져온 User DTO의 비밀번호와 입력된 비밀번호가 일치하는지 확인 -> 안 맞으면 false
		
		if(!passwordEncoder.matches(user.getPassword(), selected.getPassword())) {
			return false;
		}
		
	
		return true;
	}


	// 넘어온 User DTO에서 password를 해싱하고 DB로 넘긴다.
	@Override
	public boolean regist(User user) {
		String orgPassword = user.getPassword();
		String hashedPassword = passwordEncoder.encode(orgPassword);
		user.setPassword(hashedPassword);
		
		int res = userDao.insertOne(user);
		
		if(res == 0) {
			return false;	
		}
		return true;
		
		
		
	}

	// 로그인 상태인 유저의 회원정보를 수정한다 targetId -> DB에서 바꿀 id,
	@Override
	public boolean updateUserProfile(User user, String targetId) {
		
		user.setId(targetId);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		int res = userDao.updateUserProfile(user);
		
		if(res == 0) {
			return false;	
		}
		return true;
		
		
	}


	@Override
	public boolean deleteUserProfile(String principal) {
		int res = userDao.deleteUserProfile(principal);
		
		if(res == 0) {
			return false;	
		}
		return true;
	}

}
