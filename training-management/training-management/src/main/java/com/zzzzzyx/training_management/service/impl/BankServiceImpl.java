package com.zzzzzyx.training_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzzzzyx.training_management.dao.AuthDao;
import com.zzzzzyx.training_management.dao.BankAccountDao;
import com.zzzzzyx.training_management.dao.UserDao;
import com.zzzzzyx.training_management.dao.WaitingPaymentDao;
import com.zzzzzyx.training_management.model.User;
import com.zzzzzyx.training_management.model.WaitingPayment;
import com.zzzzzyx.training_management.service.BankService;

@Service
@Transactional
public class BankServiceImpl implements BankService {

	@Autowired
	AuthDao authDao;
	@Autowired
	UserDao userDao;
	@Autowired
	WaitingPaymentDao waitingPaymentDao;
	@Autowired
	BankAccountDao bankAccountDao;
	
	@Override
	public void transferUnderSupervision(long fromUserId, long toUserId, int money,String description, boolean isForAttendClass) {
		
		long fromCardNumber = authDao.getBankCardNumberById(fromUserId);
		long toCardNumber = authDao.getBankCardNumberById(toUserId);
		
		if(isForAttendClass){
			User u = userDao.getByUserId(fromUserId);
			double percent = u.getDiscountPercent();
			if(percent < 1){
				int money_discount = (int) (money * percent);
				description += "���Ż�" + (money - money_discount) + "Ԫ��";
				money =  money_discount;
			}
			userDao.acumulatePoint(fromUserId, money/10);
			
		}
		
		WaitingPayment w = new WaitingPayment(); 
		w.setMoney(money);
		w.setDescription(description);
		w.setFromCardNumber(fromCardNumber);
		w.setToCardNumber(toCardNumber);
		
		waitingPaymentDao.save(w);
	}

	@Override
	public List<WaitingPayment> getAllWaitingPayment() {
		return waitingPaymentDao.getAllWaitingPayment();
	}

	@Override
	public void solvePayment(long paymentId) {
		WaitingPayment wp = waitingPaymentDao.getWaitingPaymentById(paymentId);
		bankAccountDao.addMoneyOfAnAccount(wp.getFromCardNumber(), -wp.getMoney());
		bankAccountDao.addMoneyOfAnAccount(wp.getToCardNumber(), wp.getMoney());
		waitingPaymentDao.delete(wp);
	}

	@Override
	public void payActivation(long cardNumber) {
		bankAccountDao.addMoneyOfAnAccount(cardNumber, -1000);
	}

}
