package com.zzzzzyx.training_management.controller.institution;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.service.ClassChangeService;

@Controller
public class InstitutionController {

	@Autowired
	private ClassChangeService classService;
	
    @RequestMapping(value = "institution/index.do", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model, HttpSession session){
    	long institution_id = (long)session.getAttribute("auth_id");
    	List<Course> courseList = classService.getCourseListByInsId(institution_id);
    	model.addAttribute("courseList", courseList);
        return new ModelAndView("institution/index");
    }
}
