package com.zzzzzyx.training_management.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.dao.AuthDao;
import com.zzzzzyx.training_management.model.Authentication;

@Repository
public class AuthDaoImpl implements AuthDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean save(Authentication auth) {
		sessionFactory.getCurrentSession().save(auth);
		return true ;
	}

	@Override
	public Authentication getByUsername(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Authentication.class);
		criteria.add(Restrictions.eq("username", username));
		return (Authentication) criteria.uniqueResult();
	}

	@Override
	public long getBankCardNumberById(long fromUserId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Authentication.class);
		criteria.add(Restrictions.eq("id", fromUserId));
		return ((Authentication) criteria.uniqueResult()).getBankCardNumber();
	}

	@Override
	public long getIdByUsername(String username) {
		return this.getByUsername(username).getId();
	}

	@Override
	public void bindBankAccount(long cardNumber, long auth_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Authentication.class);
		criteria.add(Restrictions.eq("id", auth_id));
		Authentication auth = (Authentication) criteria.uniqueResult();
		auth.setBankCardNumber(cardNumber);
		sessionFactory.getCurrentSession().save(auth);
	}

	@Override
	public void deleteUserById(long auth_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Authentication.class);
		criteria.add(Restrictions.eq("id", auth_id));
		Authentication c = (Authentication) criteria.uniqueResult();
		sessionFactory.getCurrentSession().delete(c);
	}

	
}
