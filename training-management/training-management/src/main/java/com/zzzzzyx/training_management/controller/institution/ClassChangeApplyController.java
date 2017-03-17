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
import com.zzzzzyx.training_management.service.ClassChangeService;

@Controller
public class ClassChangeApplyController {
	
	@Autowired
	private ClassChangeService classService;

	@RequestMapping(value = "institution/openClass.do", method = RequestMethod.GET)
    public ModelAndView openIndex(){
        return new ModelAndView("institution/openClass","command", new ClassChange());
    }
	
	@RequestMapping(value = "institution/openClass.do", method = RequestMethod.POST)
    public String openPost(@ModelAttribute("SpringWeb")ClassChange newClass, HttpSession session){
		classService.openClass(newClass,(long)session.getAttribute("auth_id"));
		return "redirect:index.do";
    }
}
