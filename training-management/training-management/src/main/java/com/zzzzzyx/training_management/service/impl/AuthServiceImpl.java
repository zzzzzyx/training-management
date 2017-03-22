package com.zzzzzyx.training_management.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzzzzyx.training_management.dao.AuthDao;
import com.zzzzzyx.training_management.dao.BankAccountDao;
import com.zzzzzyx.training_management.dao.UserDao;
import com.zzzzzyx.training_management.model.Authentication;
import com.zzzzzyx.training_management.model.BankAccount;
import com.zzzzzyx.training_management.model.User;
import com.zzzzzyx.training_management.service.AuthService;
import com.zzzzzyx.training_management.service.BankService;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthDao authDao;
	@Autowired
	UserDao userDao;
	@Autowired
	BankAccountDao bankAccountDao;
	@Autowired
	BankService bankService;
	
	@Override
	public boolean register(Authentication user) {
		boolean result = authDao.save(user);
		
		if(user.getUserKind().equals(Authentication.UserKind_User)){
			long user_id = authDao.getIdByUsername(user.getUsername());
			User u = new User();
			u.setAuth_id(user_id);
			u.setLevel(0);
			u.setPoint(0);
			u.setStatus(User.Status_unactivated);
			userDao.save(u);
		}
		
		return result;
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

	@Override
	public boolean needActivate(long user_id) {
		User u = userDao.getByUserId(user_id);
		if(u.getStatus().equals(User.Status_unactivated)){
			return true;
		}else
			return false;
	}

	@Override
	public void activate(BankAccount bankAccount, long auth_id) {
		long money = bankAccountDao.getMoneyByNoAndPsw(bankAccount);
		if(money >= 1000){
			bankService.payActivation(bankAccount.getCardNumber());
			authDao.bindBankAccount(bankAccount.getCardNumber(), auth_id);
			userDao.toActivatedStatusAndRenewActivationDate(auth_id);
		}
	}

	@Override
	public void changeBankAccount(BankAccount bankAccount, long auth_id) {
		long money = bankAccountDao.getMoneyByNoAndPsw(bankAccount);
		if(money >= 0){
			authDao.bindBankAccount(bankAccount.getCardNumber(), auth_id);
		}
	}

	@Override
	public void withdrawUser(long auth_id) {
		authDao.deleteUserById(auth_id);
		userDao.deleteUserById(auth_id);
	}

	@Override
	public boolean isSuspended(long auth_id) {
		User user = userDao.getByUserId(auth_id);
		long timeDiv = new Date().getTime() - user.getActivationTime().getTime();
        long dayDiv = timeDiv /( 1000 * 24 * 60 * 60);
        
        if(dayDiv > 365 * 2){
        	this.withdrawUser(auth_id);//超过一年，注销账户
        }
        else if(dayDiv > 365){
        	long bankAccountNo = authDao.getBankCardNumberById(auth_id);
        	long money = bankAccountDao.getMoneyByBankAccountNumber(bankAccountNo);
        	if(money >= 1000){
        		userDao.toActivatedStatusAndRenewActivationDate(auth_id);
        	}else{
        		return true;
        	}
        }
		return false;
	}

}
