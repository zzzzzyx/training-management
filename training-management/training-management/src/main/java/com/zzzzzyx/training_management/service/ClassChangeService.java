package com.zzzzzyx.training_management.service;

import java.util.List;

import com.zzzzzyx.training_management.model.ClassChange;
import com.zzzzzyx.training_management.model.Course;

public interface ClassChangeService {

	public void openClass(ClassChange newClass, long institution_id);
	
	public void deleteClass(long courseId);
	
	public List<ClassChange> getAllClassChange();

	public void allowChange(long changeId);
	
	public void denyChange(long changeId);

	public List<Course> getCourseListByInsId(long institution_id);

	public Course getCourseById(long courseId);

	public void changeClass(ClassChange newClass, long ins_id);

}
