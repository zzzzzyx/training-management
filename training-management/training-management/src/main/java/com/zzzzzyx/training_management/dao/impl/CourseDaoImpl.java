package com.zzzzzyx.training_management.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.dao.CourseDao;
import com.zzzzzyx.training_management.model.Course;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(Course newCourse) {
		sessionFactory.getCurrentSession().save(newCourse);
	}

	@Override
	public void deleteCourseById(long course_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
		criteria.add(Restrictions.eq("id", course_id));
		Course c = (Course) criteria.uniqueResult();
		sessionFactory.getCurrentSession().delete(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCourseListByInsId(long institution_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
		criteria.add(Restrictions.eq("institution_id", institution_id));
		return criteria.list();
	}

	@Override
	public Course getCourseById(long courseId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
		criteria.add(Restrictions.eq("id", courseId));
		return (Course) criteria.uniqueResult();
	}

	@Override
	public void update(Course newCourse) {
		sessionFactory.getCurrentSession().update(newCourse);
	}

}
