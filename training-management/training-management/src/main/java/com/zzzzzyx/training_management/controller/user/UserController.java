package com.zzzzzyx.training_management.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.service.StudyService;

@Controller
public class UserController {

	@Autowired
	private StudyService studyService;
	
    @RequestMapping(value = "user/index.do", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model, HttpSession session){
    	long user_id = (long)session.getAttribute("auth_id");
    	List<Course> courseList = studyService.getAvailableCourseListByUserId(user_id);
    	model.addAttribute("courseList", courseList);
        return new ModelAndView("user/index");
    }
}
