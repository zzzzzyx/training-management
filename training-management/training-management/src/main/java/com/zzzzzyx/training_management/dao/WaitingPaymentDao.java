package com.zzzzzyx.training_management.dao;

import java.util.List;

import com.zzzzzyx.training_management.model.WaitingPayment;

public interface WaitingPaymentDao {

	void save(WaitingPayment w);

	List<WaitingPayment> getAllWaitingPayment();

	WaitingPayment getWaitingPaymentById(long paymentId);

	void delete(WaitingPayment wp);

}
