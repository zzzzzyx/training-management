package com.zzzzzyx.training_management.service;

import com.zzzzzyx.training_management.model.Authentication;

public interface UserService {

	public boolean register(Authentication auth);
	
	public Authentication login(Authentication auth);
}
