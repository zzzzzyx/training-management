package com.zzzzzyx.training_management.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.service.AuthService;
import com.zzzzzyx.training_management.service.StudyService;

@Controller
public class UserController {

	@Autowired
	StudyService studyService;
	
	@Autowired
	AuthService authService;
	
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
    	
    	List<Course> attendingCourseList = studyService.getAttendingCourseListByUserId(user_id);
    	model.addAttribute("attendingCourseList", attendingCourseList);
    	
        return "user/index";
    }
}
