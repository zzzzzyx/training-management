package com.zzzzzyx.training_management.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.dao.StudyConnectionDao;
import com.zzzzzyx.training_management.model.StudyConnection;

@Repository
public class StudyConnectionDaoImpl implements StudyConnectionDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getConnectingCourseIdListByUserId(long user_id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select course_id from StudyConnection where user_id = :user_id").setLong("user_id", user_id);
		return query.list();
	}

	@Override
	public void save(StudyConnection s) {
		sessionFactory.getCurrentSession().save(s);
	}

	@Override
	public void deleteConnectionByCourseIdAndUserID(long courseId, long userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyConnection.class);
		criteria.add(Restrictions.eq("user_id", userId));
		criteria.add(Restrictions.eq("course_id", courseId));
		StudyConnection sc = (StudyConnection) criteria.uniqueResult();
		sessionFactory.getCurrentSession().delete(sc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudyConnection> getListByCourseId(long courseId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyConnection.class);
		criteria.add(Restrictions.eq("course_id", courseId));
		return criteria.list();
	}

	@Override
	public void setMarkById(long id, int mark) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyConnection.class);
		criteria.add(Restrictions.eq("id", id));
		StudyConnection sc = (StudyConnection) criteria.uniqueResult();
		sc.setMark(mark);
		if(mark > 0){
			sc.setFinished(true);
		}
		sessionFactory.getCurrentSession().save(sc);
	}

	@Override
	public StudyConnection getById(long connectionId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyConnection.class);
		criteria.add(Restrictions.eq("id", connectionId));
		return (StudyConnection) criteria.uniqueResult();
	}

	@Override
	public void deleteConnectionByConnectionId(long connectionId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyConnection.class);
		criteria.add(Restrictions.eq("id", connectionId));
		StudyConnection sc = (StudyConnection) criteria.uniqueResult();
		sessionFactory.getCurrentSession().delete(sc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudyConnection> getListByInsId(Long ins_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyConnection.class);
		criteria.add(Restrictions.eq("institution_id", ins_id));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudyConnection> getListByUserId(Long user_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyConnection.class);
		criteria.add(Restrictions.eq("user_id", user_id));
		return criteria.list();
	}

}
