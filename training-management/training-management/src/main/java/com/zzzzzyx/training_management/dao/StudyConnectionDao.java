package com.zzzzzyx.training_management.dao;

import java.util.List;

import com.zzzzzyx.training_management.model.StudyConnection;

public interface StudyConnectionDao {

	List<Long> getConnectingCourseIdListByUserId(long user_id);

	void save(StudyConnection s);

}
