package com.zzzzzyx.training_management.controller.institution;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.model.ClassChange;
import com.zzzzzyx.training_management.service.ClassService;

@Controller
public class OpenClassController {
	
	@Autowired
	private ClassService classService;

	@RequestMapping(value = "institution/openClass.do", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("institution/openClass","command", new ClassChange());
    }
	
	@RequestMapping(value = "institution/openClass.do", method = RequestMethod.POST)
    public ModelAndView open(@ModelAttribute("SpringWeb")ClassChange newClass, ModelMap model, HttpSession session){
		System.out.println((long)session.getAttribute("auth_id"));
		classService.openClass(newClass,(long)session.getAttribute("auth_id"));
        return new ModelAndView("institution/openClass","command", new ClassChange());
    }
}
