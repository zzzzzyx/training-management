package com.zzzzzyx.training_management.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzzzzyx.training_management.dao.ConsumeLogDao;
import com.zzzzzyx.training_management.dao.StudyConnectionDao;
import com.zzzzzyx.training_management.dao.StudyLogDao;
import com.zzzzzyx.training_management.model.StudyConnection;
import com.zzzzzyx.training_management.model.log.ConsumeLog;
import com.zzzzzyx.training_management.model.log.StudyLog;
import com.zzzzzyx.training_management.service.LogService;

@Service
@Transactional
public class LogServiceImpl implements LogService {

	@Autowired
	StudyLogDao studyLogDao;
	@Autowired
	ConsumeLogDao consumeLogDao;
	@Autowired
	StudyConnectionDao studyConnectionDao;

	@Override
	public void logStudy(String logKind, long user_id, long course_id, long institution_id) {
		StudyLog s = new StudyLog();
		s.setLogKind(logKind);
		s.setUser_id(user_id);
		s.setCourse_id(course_id);
		s.setIns_id(institution_id);
		s.setTime(new Date());
		studyLogDao.save(s);
	}

	@Override
	public void logStudyFinish(long studyConnectionId) {
		StudyConnection sc = studyConnectionDao.getById(studyConnectionId);
		StudyLog log = studyLogDao.getStudyLog(StudyLog.LogKind_finish, sc.getUser_id(), sc.getCourse_id());
		
		if(log == null){
			this.logStudy(StudyLog.LogKind_finish, sc.getUser_id(), sc.getCourse_id(), sc.getInstitution_id());
		}
	}

	@Override
	public List<StudyLog> getLogListByUserId(long user_id) {
		return studyLogDao.getLogListByUserId(user_id);
	}

	@Override
	public List<StudyLog> getLogListByInsId(long user_id) {
		return studyLogDao.getLogListByInsId(user_id);
	}

	@Override
	public void logConsume(String consumeKind, long userId, long courseId, long institution_id, int price) {
		ConsumeLog cl = new ConsumeLog();
		cl.setConsumeKind(consumeKind);
		cl.setUser_id(userId);
		cl.setCourse_id(courseId);
		cl.setIns_id(institution_id);
		cl.setMoney(price);
		cl.setTime(new Date());
		consumeLogDao.save(cl);
	}

	@Override
	public void logActivation(long auth_id) {
		this.logConsume(ConsumeLog.ConsumeKind_activation, auth_id, 0, 0, 1000);
	}

	@Override
	public List<ConsumeLog> getConsumeLogListByUserId(long user_id) {
		return consumeLogDao.getConsumeLogListByUserId(user_id);
	}

	@Override
	public List<ConsumeLog> getConsumeLogListByInsId(long user_id) {
		return consumeLogDao.getConsumeLogListByInsId(user_id);
	}

	@Override
	public List<ConsumeLog> getCompleteActivationLogList() {
		return consumeLogDao.getCompleteLogListByConsumeKind(ConsumeLog.ConsumeKind_activation);
	}

	@Override
	public List<ConsumeLog> getCompleteAttendLogList() {
		return consumeLogDao.getCompleteLogListByConsumeKind(ConsumeLog.ConsumeKind_attend);
	}

	@Override
	public List<ConsumeLog> getCompleteRefundLogList() {
		return consumeLogDao.getCompleteLogListByConsumeKind(ConsumeLog.ConsumeKind_refund);
	}

}
