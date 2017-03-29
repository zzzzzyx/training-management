package com.zzzzzyx.training_management.controller.manager.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzzzzyx.training_management.service.StatisticsService;
import com.zzzzzyx.training_management.service.StudyService;
import com.zzzzzyx.training_management.vo.Course4UserVO;
import com.zzzzzyx.training_management.vo.UserVO;

@Controller
public class StudentSttController {

	@Autowired
	StatisticsService statisticsService;
	@Autowired
	StudyService studyService;
	
    @RequestMapping(value = "manager/userStatistics.do", method = RequestMethod.GET)
    public String insStatisticsIndex(ModelMap model){
    	
    	List<UserVO> userList = statisticsService.getUserList();
    	model.addAttribute("userList", userList);
    	
        return "manager/userStatistics/index";
    }
    
    @RequestMapping(value = "manager/showAttendingCourse.do", method = RequestMethod.GET)
    public String showAttendingCourse(ModelMap model, long userId){
    	
    	List<Course4UserVO> attendingCourseList = studyService.getAttendingCourseVOListByUserId(userId);
    	model.addAttribute("attendingCourseList", attendingCourseList);
    	
        return "manager/userStatistics/showAttendingCourse";
    }
    
}
