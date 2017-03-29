package com.zzzzzyx.training_management.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzzzzyx.training_management.dao.AuthDao;
import com.zzzzzyx.training_management.dao.CourseDao;
import com.zzzzzyx.training_management.dao.StudyConnectionDao;
import com.zzzzzyx.training_management.dao.UserDao;
import com.zzzzzyx.training_management.model.Authentication;
import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.model.StudyConnection;
import com.zzzzzyx.training_management.model.User;
import com.zzzzzyx.training_management.service.StatisticsService;
import com.zzzzzyx.training_management.vo.InstitutionVO;
import com.zzzzzyx.training_management.vo.UserVO;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	AuthDao authDao;
	@Autowired
	UserDao userDao;
	@Autowired
	CourseDao courseDao;
	@Autowired
	StudyConnectionDao studyConnectionDao;
	
	@Override
	public List<InstitutionVO> getInsList() {
		List<Authentication> authList = authDao.getInsList();
		
		List<InstitutionVO> insList = new ArrayList<>();
		for(Authentication auth : authList){
			Long ins_id = auth.getId();
			List<Course> courseList = courseDao.getCourseListByInsId(ins_id);
			List<StudyConnection> studyConnectionList = studyConnectionDao.getListByInsId(ins_id);
			
			InstitutionVO insVO = new InstitutionVO();
			insVO.setId(ins_id);
			insVO.setName(auth.getUsername());
			insVO.setCourseCount(courseList.size());
			insVO.setStudyConnectionCount(studyConnectionList.size());
			insList.add(insVO);
		}
		
		return insList;
	}

	@Override
	public List<UserVO> getUserList() {
		List<Authentication> authList = authDao.getUserList();
		
		List<UserVO> userList = new ArrayList<>();
		for(Authentication auth : authList){
			Long user_id = auth.getId();
			User user = userDao.getByUserId(user_id);
			List<StudyConnection> studyConnectionList = studyConnectionDao.getListByUserId(user_id);
			
			UserVO userVO = new UserVO();
			userVO.setId(user_id);
			userVO.setName(auth.getUsername());
			userVO.setPoint(user.getPoint());
			userVO.setLastActivationTillToday(user.getLastActivationTillToday());
			userVO.setAttendedCourseCount(studyConnectionList.size());
			userVO.setFinishedCourseCount(countFinish(studyConnectionList));
			userVO.setAverageMark(countAverageMark(studyConnectionList));
			userList.add(userVO);
		}
		
		return userList;
	}

	private int countFinish(List<StudyConnection> studyConnectionList) {
		int finishedCount = 0;
		for(StudyConnection sc : studyConnectionList){
			int mark = sc.getMark();
			if(mark > 0){
				finishedCount ++;
			}
		}
		return finishedCount;			
	}

	private int countAverageMark(List<StudyConnection> finishedStudyConnectionList) {
		int temp = 0;
		int finishedCount = 0;
		for(StudyConnection sc : finishedStudyConnectionList){
			int mark = sc.getMark();
			if(mark > 0){
				temp += sc.getMark();
				finishedCount ++;
			}
		}
		if(finishedCount != 0){
			return temp/finishedCount;			
		}else{
			return -1;
		}
	}

}
