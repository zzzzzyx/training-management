package com.zzzzzyx.training_management.service;

import java.util.List;

import com.zzzzzyx.training_management.model.WaitingPayment;

public interface BankService {

	List<WaitingPayment> getAllWaitingPayment();

	void solvePayment(long paymentId);

	void payActivation(long cardNumber);

	void transferUnderSupervision(long fromUserId, long toUserId, int money, String description,
			boolean isForAttendClass);

}
