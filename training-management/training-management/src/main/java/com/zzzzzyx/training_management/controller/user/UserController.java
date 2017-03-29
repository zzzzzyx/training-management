package com.zzzzzyx.training_management.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.model.log.ConsumeLog;
import com.zzzzzyx.training_management.model.log.StudyLog;
import com.zzzzzyx.training_management.service.AuthService;
import com.zzzzzyx.training_management.service.LogService;
import com.zzzzzyx.training_management.service.StudyService;
import com.zzzzzyx.training_management.vo.Course4UserVO;

@Controller
public class UserController {

	@Autowired
	StudyService studyService;
	@Autowired
	AuthService authService;
	@Autowired
	LogService logService;
	
    @RequestMapping(value = "user/index.do", method = RequestMethod.GET)
    public String index(ModelMap model, HttpSession session){
    	
    	long user_id = (long)session.getAttribute("auth_id");
    	if(authService.needActivate(user_id)){
			return "redirect:activate.do";
		}
    	if(authService.isSuspended(user_id)){
			return "user/suspended";
		}
    	
    	List<Course> courseList = studyService.getAvailableCourseListByUserId(user_id);
    	model.addAttribute("courseList", courseList);
    	
    	List<Course4UserVO> attendingCourseList = studyService.getAttendingCourseVOListByUserId(user_id);
    	model.addAttribute("attendingCourseList", attendingCourseList);
    	
        return "user/index";
    }
    
    @RequestMapping(value = "user/showStatistics.do", method = RequestMethod.GET)
    public String showStatistics(ModelMap model, HttpSession session){
    	long user_id = (long)session.getAttribute("auth_id");
		List<StudyLog> logList = logService.getLogListByUserId(user_id);
		model.addAttribute("logList", logList);
		
		List<ConsumeLog> consumeLogList = logService.getConsumeLogListByUserId(user_id);
		model.addAttribute("consumeLogList", consumeLogList);
		
		return "user/showStatistics";
    }
}
