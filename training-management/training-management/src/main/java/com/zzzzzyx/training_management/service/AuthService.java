package com.zzzzzyx.training_management.service;

import com.zzzzzyx.training_management.model.Authentication;
import com.zzzzzyx.training_management.model.BankAccount;

public interface AuthService {

	public boolean register(Authentication auth);
	
	public Authentication login(Authentication auth);

	public boolean needActivate(long id);

	public void activate(BankAccount bankAccount, long attribute);

	public void changeBankAccount(BankAccount bankAccount, long attribute);

	public void withdrawUser(long attribute);

	public boolean isSuspended(long user_id);
}
