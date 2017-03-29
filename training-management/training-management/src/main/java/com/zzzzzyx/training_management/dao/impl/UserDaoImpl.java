package com.zzzzzyx.training_management.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.dao.UserDao;
import com.zzzzzyx.training_management.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(User u) {
		sessionFactory.getCurrentSession().save(u);
	}

	@Override
	public User getByUserId(long user_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("auth_id", user_id));
		return (User) criteria.uniqueResult();
	}

	@Override
	public void toActivatedStatusAndRenewActivationDate(long auth_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("auth_id", auth_id));
		User user = (User) criteria.uniqueResult();
		user.setStatus(User.Status_available);
		user.setActivationTime(new Date());
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void deleteUserById(long auth_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("auth_id", auth_id));
		User c = (User) criteria.uniqueResult();
		sessionFactory.getCurrentSession().delete(c);
	}

	@Override
	public long getPointByUserId(long user_id) {
		User u = this.getByUserId(user_id);
		return u.getPoint();
	}

	@Override
	public void setPointToZero(long user_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("auth_id", user_id));
		User user = (User) criteria.uniqueResult();
		user.setPoint(0);
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void acumulatePoint(long fromUserId, int add) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("auth_id", fromUserId));
		User user = (User) criteria.uniqueResult();
		user.setPoint(user.getPoint() + add);
		sessionFactory.getCurrentSession().save(user);
	}
	
}
