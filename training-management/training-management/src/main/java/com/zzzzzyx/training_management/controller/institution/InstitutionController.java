package com.zzzzzyx.training_management.controller.institution;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.service.ClassService;


@Controller
public class InstitutionController {

	@Autowired
	private ClassService classService;
	
    @RequestMapping(value = "institution/index.do", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session){
    	long institution_id = (long)session.getAttribute("auth_id");
        return new ModelAndView("institution/index");
    }
}
