package com.zzzzzyx.training_management.service;

import java.util.List;

import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.model.StudyConnection;
import com.zzzzzyx.training_management.vo.Course4UserVO;

public interface StudyService {

	List<Course> getAvailableCourseListByUserId(long user_id);

	void attendCourse(long attendId, long attribute);

	List<Course4UserVO> getAttendingCourseVOListByUserId(long userId);

	void cancelCourse(long courseId, long attribute);

	Course getCourse(long courseId);

	List<StudyConnection> getStudentListByCourseId(long courseId);

	void registerMark(long id, int mark);

	void deleteStudent(long connectionId);

	void registerNonUser(long course_id, String username, long attribute);


}
