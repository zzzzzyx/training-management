package com.zzzzzyx.training_management.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.dao.ConsumeLogDao;
import com.zzzzzyx.training_management.model.log.ConsumeLog;

@Repository
public class ConsumeLogDaoImpl implements ConsumeLogDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(ConsumeLog s) {
		sessionFactory.getCurrentSession().save(s);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ConsumeLog> getConsumeLogListByUserId(long user_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ConsumeLog.class);
		criteria.add(Restrictions.eq("user_id", user_id));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsumeLog> getConsumeLogListByInsId(long user_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ConsumeLog.class);
		criteria.add(Restrictions.eq("ins_id", user_id));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsumeLog> getCompleteLogListByConsumeKind(String consumeKind) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ConsumeLog.class);
		criteria.add(Restrictions.eq("consumeKind", consumeKind));
		return criteria.list();
	}

}
