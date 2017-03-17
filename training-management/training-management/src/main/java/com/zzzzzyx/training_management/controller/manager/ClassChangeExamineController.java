package com.zzzzzyx.training_management.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzzzzyx.training_management.service.ClassChangeService;

@Controller
public class ClassChangeExamineController {

	@Autowired
	private ClassChangeService classService;
	
	@RequestMapping(value = "manager/allow.do", method = RequestMethod.GET)
    public String allow(ModelMap model, long changeId){
		classService.allowChange(changeId);
		return "redirect:index.do";
    }
	
	@RequestMapping(value = "manager/deny.do", method = RequestMethod.GET)
    public String deny(ModelMap model, long changeId){
		classService.denyChange(changeId);
    	return "redirect:index.do";
    }
}
