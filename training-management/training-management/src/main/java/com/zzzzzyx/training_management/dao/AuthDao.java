package com.zzzzzyx.training_management.dao;

import com.zzzzzyx.training_management.model.Authentication;

public interface AuthDao {

	public boolean save(Authentication auth);
	
	public Authentication getByUsername(String username);

	public long getBankCardNumberById(long fromUserId);
}
