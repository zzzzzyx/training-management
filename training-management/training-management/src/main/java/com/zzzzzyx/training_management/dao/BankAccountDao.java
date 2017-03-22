package com.zzzzzyx.training_management.dao;

import com.zzzzzyx.training_management.model.BankAccount;

public interface BankAccountDao {

	void addMoneyOfAnAccount(long fromCardNumber, long l);

	long getMoneyByNoAndPsw(BankAccount bankAccount);

}
