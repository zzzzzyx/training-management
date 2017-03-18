package com.zzzzzyx.training_management.service;

import java.util.List;

import com.zzzzzyx.training_management.model.WaitingPayment;

public interface BankService {

	void transferUnderSupervision(long user_id, long institution_id, int price, String description);

	List<WaitingPayment> getAllWaitingPayment();

	void solvePayment(long paymentId);

}
