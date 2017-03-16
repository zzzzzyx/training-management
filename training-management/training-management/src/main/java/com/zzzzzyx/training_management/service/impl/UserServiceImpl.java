package com.zzzzzyx.training_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzzzzyx.training_management.dao.AuthDao;
import com.zzzzzyx.training_management.model.Authentication;
import com.zzzzzyx.training_management.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	AuthDao authDao;
	
	@Override
	public boolean register(Authentication user) {
		user.setUserKind(Authentication.UserKind_User);
		return authDao.save(user);
	}

	@Override
	public Authentication login(Authentication user) {
		Authentication realUser = authDao.getByUsername(user.getUsername());
		if(realUser != null && realUser.getPassword().equals(user.getPassword())){
			return realUser;
		}else{
			return null;
		}
	}

}
