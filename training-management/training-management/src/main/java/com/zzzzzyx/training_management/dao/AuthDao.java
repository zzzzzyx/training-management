package com.zzzzzyx.training_management.dao;

import com.zzzzzyx.training_management.model.Authentication;

public interface AuthDao {

	public boolean save(Authentication auth);
	
	public Authentication getByUsername(String username);

	public long getBankCardNumberById(long fromUserId);

	public long getIdByUsername(String username);

	public void bindBankAccount(long cardNumber, long auth_id);

	public void deleteUserById(long auth_id);
}
