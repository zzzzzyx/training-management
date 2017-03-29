package com.zzzzzyx.training_management.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.dao.StudyLogDao;
import com.zzzzzyx.training_management.model.log.StudyLog;

@Repository
public class StudyLogDaoImpl implements StudyLogDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(StudyLog s) {
		sessionFactory.getCurrentSession().save(s);
	}

	@Override
	public StudyLog getStudyLog(String logKind, long user_id, long course_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyLog.class);
		criteria.add(Restrictions.eq("logKind", logKind));
		criteria.add(Restrictions.eq("user_id", user_id));
		criteria.add(Restrictions.eq("course_id", course_id));
		if(criteria.list().isEmpty()){
			return null;
		}
		return (StudyLog)criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudyLog> getLogListByUserId(long user_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyLog.class);
		criteria.add(Restrictions.eq("user_id", user_id));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudyLog> getLogListByInsId(long user_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyLog.class);
		criteria.add(Restrictions.eq("ins_id", user_id));
		return criteria.list();
	}

}
