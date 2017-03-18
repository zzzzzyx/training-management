package com.zzzzzyx.training_management.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzzzzyx.training_management.service.StudyService;

@Controller
public class StudyController {

	@Autowired
	private StudyService studyService;
	
	@RequestMapping(value = "user/attend.do", method = RequestMethod.GET)
    public String attend(ModelMap model, long courseId, HttpSession session){
		studyService.attendCourse(courseId, (long)session.getAttribute("auth_id"));
		return "redirect:index.do";
    }
}
