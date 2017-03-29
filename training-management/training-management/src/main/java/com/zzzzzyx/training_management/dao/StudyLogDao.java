package com.zzzzzyx.training_management.dao;

import java.util.List;

import com.zzzzzyx.training_management.model.log.StudyLog;

public interface StudyLogDao {

	void save(StudyLog s);

	StudyLog getStudyLog(String logkindFinish, long user_id, long course_id);

	List<StudyLog> getLogListByUserId(long user_id);

	List<StudyLog> getLogListByInsId(long user_id);

}
