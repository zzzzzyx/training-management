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
			Course newCourse = new Course(classChange);
			courseDao.update(newCourse);
			break;
		case ClassChange.ChangeKind_register:
			Course newCourse2 = new Course(classChange);
			courseDao.save(newCourse2);
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

	@Override
	public void deleteClass(long courseId) {
		Course course = courseDao.getCourseById(courseId);
		ClassChange classChange = new ClassChange(course);
		classChange.setChangeKind(ClassChange.ChangeKind_delete);
		classChange.setDescription("Institution " + classChange.getInstitution_id() + " apply for deleting a new course.");
		classChangeDao.save(classChange);
	}

	@Override
	public Course getCourseById(long courseId) {
		return courseDao.getCourseById(courseId);
	}

	@Override
	public void changeClass(ClassChange newClassChange, long ins_id) {
		newClassChange.setChangeKind(ClassChange.ChangeKind_change);
		newClassChange.setInstitution_id(ins_id);
		newClassChange.setDescription("更改后的课程为： " + courseDao.getCourseById(newClassChange.getCourse_id()));
		classChangeDao.save(newClassChange);
	}

}
