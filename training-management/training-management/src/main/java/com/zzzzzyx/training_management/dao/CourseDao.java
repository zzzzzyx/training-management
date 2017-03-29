package com.zzzzzyx.training_management.dao;

import java.util.List;

import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.vo.Course4UserVO;

public interface CourseDao {

	void save(Course newCourse);

	void deleteCourseById(long course_id);

	List<Course> getCourseListByInsId(long institution_id);

	Course getCourseById(long courseId);

	void update(Course newCourse);

	List<Course> getAvailableCourseList();

	List<Course4UserVO> getAllAttendingCourseVOByUserId(long user_id);

}
