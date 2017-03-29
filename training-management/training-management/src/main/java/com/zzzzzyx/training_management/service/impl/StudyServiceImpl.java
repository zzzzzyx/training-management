package com.zzzzzyx.training_management.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzzzzyx.training_management.dao.AuthDao;
import com.zzzzzyx.training_management.dao.CourseDao;
import com.zzzzzyx.training_management.dao.StudyConnectionDao;
import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.model.StudyConnection;
import com.zzzzzyx.training_management.model.log.ConsumeLog;
import com.zzzzzyx.training_management.model.log.StudyLog;
import com.zzzzzyx.training_management.service.BankService;
import com.zzzzzyx.training_management.service.LogService;
import com.zzzzzyx.training_management.service.StudyService;
import com.zzzzzyx.training_management.vo.Course4UserVO;

@Service
@Transactional
public class StudyServiceImpl implements StudyService {

	@Autowired
	CourseDao courseDao;
	@Autowired
	StudyConnectionDao studyConnectionDao;
	@Autowired
	BankService bankService;
	@Autowired
	AuthDao authDao;
	@Autowired
	LogService logService;
	
	@Override
	public List<Course> getAvailableCourseListByUserId(long user_id) {
		List<Course> availableList = courseDao.getAvailableCourseList();
		List<Long> connectingCourseIdList = studyConnectionDao.getConnectingCourseIdListByUserId(user_id);
		
		Iterator<Course> iterator = availableList.iterator();//Ϊ�˽������ʱɾ�������⣬ʹ�õ�����
		while(iterator.hasNext()){
			if(connectingCourseIdList.contains(iterator.next().getId())){
				iterator.remove();
			}
		}
		return availableList;
	}

	@Override
	public void attendCourse(long course_id, long user_id) {
		Course course = courseDao.getCourseById(course_id);
		StudyConnection s = new StudyConnection();
		s.setCourse_id(course_id);
		s.setUser_id(user_id);
		s.setUsername(authDao.getById(user_id).getUsername());
		s.setInstitution_id(course.getInstitution_id());
		s.setUser(true);
		s.setMark(0);
		s.setFinished(false);
		studyConnectionDao.save(s);
		
		logService.logStudy(StudyLog.LogKind_attend, user_id, course_id, course.getInstitution_id());
		logService.logConsume(ConsumeLog.ConsumeKind_attend, user_id, course_id, course.getInstitution_id(), course.getPrice());
		
		bankService.transferUnderSupervision(user_id, course.getInstitution_id(), course.getPrice(),
				"User(id:" + user_id + ") �������γ�(id:" + course_id + ") holding by institution(id:"
				 + course.getInstitution_id() + ").", true);
	}

	@Override
	public void cancelCourse(long courseId, long userId) {
		studyConnectionDao.deleteConnectionByCourseIdAndUserID(courseId, userId);
		Course course = courseDao.getCourseById(courseId);
		switch(course.getStatus()){
		case Course.Status_waiting:
			
			logService.logStudy(StudyLog.LogKind_leaveBeforeStart, userId, courseId, course.getInstitution_id());
			logService.logConsume(ConsumeLog.ConsumeKind_refund, userId, courseId, course.getInstitution_id(), course.getPrice());
			
			bankService.transferUnderSupervision(course.getInstitution_id(), userId, course.getPrice(),
					"User(id:" + userId + ") ����ȡ��Ԥ���γ�(�γ�id:" + courseId + ") holding by institution(id:"
					 + course.getInstitution_id() + "), ϵͳ�ж�ȫ���˿�.", false);
			break;
		case Course.Status_studying:
			
			logService.logStudy(StudyLog.LogKind_leaveAfterStart, userId, courseId, course.getInstitution_id());
			
			bankService.transferUnderSupervision(course.getInstitution_id(), userId, course.getPrice()/5,
					"User(id:" + userId + ") ����ȡ���˳������еĿγ�(�γ�id:" + courseId + ") holding by institution(id:"
					 + course.getInstitution_id() + "), ϵͳ�ж��˿�20%.", false);
			break;
		}
	}

	@Override
	public Course getCourse(long courseId) {
		return courseDao.getCourseById(courseId);
	}

	@Override
	public List<StudyConnection> getStudentListByCourseId(long courseId) {
		return studyConnectionDao.getListByCourseId(courseId);
	}

	@Override
	public void registerMark(long id, int mark) {
		studyConnectionDao.setMarkById(id, mark);
		
		logService.logStudyFinish(id);
	}

	@Override
	public void deleteStudent(long connectionId) {
		StudyConnection sc = studyConnectionDao.getById(connectionId);
		Course course = courseDao.getCourseById(sc.getCourse_id());
		if(sc.isUser()){//����ǻ�Ա�����˿�
			
			logService.logStudy(StudyLog.LogKind_leaveAfterStart, sc.getUser_id(), sc.getCourse_id(), course.getInstitution_id());
			
			bankService.transferUnderSupervision(course.getInstitution_id(), sc.getUser_id(), course.getPrice(),
				"����(id:" + sc.getInstitution_id() + ") ���뽫ѧ��ǿ���߳��γ�(�γ�id:" + sc.getCourse_id() + ") " + "�߳�ѧ�����Ϊ��"
						+ sc.getUser_id() + ", ϵͳ�ж�ȫ���˿�.", false);
		}
		studyConnectionDao.deleteConnectionByConnectionId(connectionId);

	}

	@Override
	public void registerNonUser(long course_id, String username, long ins_id) {
		StudyConnection sc = new StudyConnection();
		sc.setCourse_id(course_id);
		sc.setUsername(username);
		sc.setInstitution_id(ins_id);
		sc.setUser_id(-1);
		sc.setMark(0);
		sc.setUser(false);
		sc.setFinished(false);
		studyConnectionDao.save(sc);
	}

	@Override
	public List<Course4UserVO> getAttendingCourseVOListByUserId(long user_id) {
		List<Course4UserVO> courseVOList = courseDao.getAllAttendingCourseVOByUserId(user_id);
		return courseVOList;
	}


}
