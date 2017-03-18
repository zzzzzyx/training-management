package com.zzzzzyx.training_management.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.dao.WaitingPaymentDao;
import com.zzzzzyx.training_management.model.WaitingPayment;

@Repository
public class WaitingPaymentDaoImpl implements WaitingPaymentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(WaitingPayment w) {
		sessionFactory.getCurrentSession().save(w);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WaitingPayment> getAllWaitingPayment() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(WaitingPayment.class);
		return criteria.list();
	}

	@Override
	public WaitingPayment getWaitingPaymentById(long paymentId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(WaitingPayment.class);
		criteria.add(Restrictions.eq("id", paymentId));
		return (WaitingPayment) criteria.uniqueResult();
	}

	@Override
	public void delete(WaitingPayment wp) {
		sessionFactory.getCurrentSession().delete(wp);
	}

}
