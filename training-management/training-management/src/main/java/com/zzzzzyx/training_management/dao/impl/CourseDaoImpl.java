package com.zzzzzyx.training_management.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.dao.CourseDao;
import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.vo.Course4UserVO;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAvailableCourseList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
		criteria.add(Restrictions.eq("status", Course.Status_waiting));
		return criteria.list();
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Course> getAllAttendingCourseByUserId(long user_id) {
//		List<Course> l = sessionFactory.getCurrentSession().createQuery(
//				"select c from StudyConnection sc,Course c where sc.user_id = :user_id and c.id=sc.course_id")
//				.setLong("user_id", user_id).list();
//		return l;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course4UserVO> getAllAttendingCourseVOByUserId(long user_id) {
		List<Course4UserVO> l = sessionFactory.getCurrentSession().createQuery(
				"select new com.zzzzzyx.training_management.vo.Course4UserVO(c.id,c.courseName, c.teacherName"
				+ ", c.price, c.startTime, c.endTime, c.institution_id, c.status, sc.mark, sc.isFinished) "
				+ "from StudyConnection sc,Course c where sc.user_id = :user_id and c.id=sc.course_id")
				.setLong("user_id", user_id).list();
		return l;
	}

}
