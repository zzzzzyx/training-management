package com.zzzzzyx.training_management.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.model.ClassChange;
import com.zzzzzyx.training_management.service.ClassService;

@Controller
public class ClassChangeExamineController {

	@Autowired
	private ClassService classService;
	
	@RequestMapping(value = "manager/allow.do", method = RequestMethod.GET)
    public ModelAndView allow(ModelMap model){
    	List<ClassChange> list = classService.getAllClassChange();
    	model.addAttribute("classChangeList", list);
        return new ModelAndView("manager/index");
    }
	
	@RequestMapping(value = "manager/deny.do", method = RequestMethod.GET)
    public ModelAndView deny(ModelMap model){
    	List<ClassChange> list = classService.getAllClassChange();
    	model.addAttribute("classChangeList", list);
        return new ModelAndView("manager/index");
    }
}
