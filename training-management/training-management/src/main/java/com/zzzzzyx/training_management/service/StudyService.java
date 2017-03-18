package com.zzzzzyx.training_management.service;

import java.util.List;

import com.zzzzzyx.training_management.model.Course;

public interface StudyService {

	List<Course> getAvailableCourseListByUserId(long user_id);

	void attendCourse(long attendId, long attribute);

}
