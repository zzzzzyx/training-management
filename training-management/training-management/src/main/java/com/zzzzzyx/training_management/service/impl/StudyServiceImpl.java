package com.zzzzzyx.training_management.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzzzzyx.training_management.dao.CourseDao;
import com.zzzzzyx.training_management.dao.StudyConnectionDao;
import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.model.StudyConnection;
import com.zzzzzyx.training_management.service.BankService;
import com.zzzzzyx.training_management.service.StudyService;

@Service
@Transactional
public class StudyServiceImpl implements StudyService {

	@Autowired
	CourseDao courseDao;
	
	@Autowired
	StudyConnectionDao studyConnectionDao;
	
	@Autowired
	BankService bankService;
	
	@Override
	public List<Course> getAvailableCourseListByUserId(long user_id) {
		List<Course> availableList = courseDao.getAvailableCourseList();
		List<Long> connectingCourseIdList = studyConnectionDao.getConnectingCourseIdListByUserId(user_id);
		
		Iterator<Course> iterator = availableList.iterator();//为了解决遍历时删除的问题，使用迭代器
		while(iterator.hasNext()){
			if(connectingCourseIdList.contains(iterator.next().getId())){
				iterator.remove();
			}
		}
		return availableList;
	}
	
	@Override
	public List<Course> getAttendingCourseListByUserId(long user_id) {
		List<Course> courseList = courseDao.getAllAttendingCourseByUserId(user_id);
		return courseList;
	}

	@Override
	public void attendCourse(long courseId, long user_id) {
		Course course = courseDao.getCourseById(courseId);
		StudyConnection s = new StudyConnection();
		s.setCourse_id(courseId);
		s.setUser_id(user_id);
		s.setInstitution_id(course.getInstitution_id());
		s.setPaymentMethod(StudyConnection.PaymentMethod_card);
		s.setUser(true);
		studyConnectionDao.save(s);
		
		bankService.transferUnderSupervision(user_id, course.getInstitution_id(), course.getPrice(),
				"User(id:" + user_id + ") 申请加入课程(id:" + courseId + ") holding by institution(id:"
				 + course.getInstitution_id() + ").");
	}

	@Override
	public void cancelCourse(long courseId, long userId) {
		studyConnectionDao.deleteConnectionByCourseIdAndUserID(courseId, userId);
		Course course = courseDao.getCourseById(courseId);
		switch(course.getStatus()){
		case Course.Status_waiting:
			bankService.transferUnderSupervision(course.getInstitution_id(), userId, course.getPrice(),
					"User(id:" + userId + ") 申请取消预订课程(课程id:" + courseId + ") holding by institution(id:"
					 + course.getInstitution_id() + "), 系统判定全额退款.");
			break;
		case Course.Status_studying:
			bankService.transferUnderSupervision(course.getInstitution_id(), userId, course.getPrice()/5,
					"User(id:" + userId + ") 申请取消退出进行中的课程(课程id:" + courseId + ") holding by institution(id:"
					 + course.getInstitution_id() + "), 系统判定退款20%.");
			break;
		}
	}


}
