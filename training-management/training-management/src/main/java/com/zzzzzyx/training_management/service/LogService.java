package com.zzzzzyx.training_management.service;

import java.util.List;

import com.zzzzzyx.training_management.model.log.ConsumeLog;
import com.zzzzzyx.training_management.model.log.StudyLog;

public interface LogService {

	void logStudy(String logkind, long user_id, long course_id, long institution_id);

	void logStudyFinish(long studyConnectionId);

	List<StudyLog> getLogListByUserId(long user_id);

	List<StudyLog> getLogListByInsId(long user_id);

	
	void logConsume(String consumekind, long userId, long courseId, long institution_id, int price);

	void logActivation(long auth_id);

	List<ConsumeLog> getConsumeLogListByUserId(long user_id);

	List<ConsumeLog> getConsumeLogListByInsId(long user_id);

	List<ConsumeLog> getCompleteActivationLogList();

	List<ConsumeLog> getCompleteAttendLogList();

	List<ConsumeLog> getCompleteRefundLogList();

}
