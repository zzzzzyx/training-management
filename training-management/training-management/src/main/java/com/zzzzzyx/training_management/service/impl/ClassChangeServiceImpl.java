package com.zzzzzyx.training_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzzzzyx.training_management.dao.ClassChangeDao;
import com.zzzzzyx.training_management.dao.CourseDao;
import com.zzzzzyx.training_management.model.ClassChange;
import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.service.ClassChangeService;

@Service
@Transactional
public class ClassChangeServiceImpl implements ClassChangeService {

	@Autowired
	ClassChangeDao classChangeDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Override
	public void openClass(ClassChange newClassChange, long institution_id) {
		newClassChange.setChangeKind(ClassChange.ChangeKind_register);
		newClassChange.setInstitution_id(institution_id);
		newClassChange.setCourse_status(Course.Status_waiting);
		newClassChange.setDescription("Institution " + institution_id + " apply for opening a new course.");
		classChangeDao.save(newClassChange);
	}

	@Override
	public List<ClassChange> getAllClassChange() {
		return classChangeDao.getAll();
	}

	@Override
	public void allowChange(long changeId) {
		ClassChange classChange = classChangeDao.getClassChangeById(changeId);
		switch(classChange.getChangeKind()){
		case ClassChange.ChangeKind_delete:
			courseDao.deleteCourseById(classChange.getCourse_id());
			break;
		case ClassChange.ChangeKind_change:
		case ClassChange.ChangeKind_register:
			Course newCourse = new Course(classChange);
			courseDao.save(newCourse);
			break;
		}
		classChangeDao.deleteClassChangeById(changeId);
	}

	@Override
	public void denyChange(long changeId) {
		classChangeDao.deleteClassChangeById(changeId);
	}

	@Override
	public List<Course> getCourseListByInsId(long institution_id) {
		return courseDao.getCourseListByInsId(institution_id);
	}

}
