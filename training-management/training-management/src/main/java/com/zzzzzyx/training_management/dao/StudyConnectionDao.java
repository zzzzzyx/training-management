package com.zzzzzyx.training_management.dao;

import java.util.List;

import com.zzzzzyx.training_management.model.StudyConnection;

public interface StudyConnectionDao {

	List<Long> getConnectingCourseIdListByUserId(long user_id);

	void save(StudyConnection s);

	void deleteConnectionByCourseIdAndUserID(long courseId, long userId);

	List<StudyConnection> getListByCourseId(long courseId);

	void setMarkById(long id, int mark);

	StudyConnection getById(long connectionId);

	void deleteConnectionByConnectionId(long connectionId);

	List<StudyConnection> getListByInsId(Long ins_id);

	List<StudyConnection> getListByUserId(Long user_id);

}
