package com.zzzzzyx.training_management.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.model.ClassChange;
import com.zzzzzyx.training_management.service.ClassChangeService;

@Controller
public class ManagerController {

	@Autowired
	private ClassChangeService classService;
	
    @RequestMapping(value = "manager/index.do", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model){
    	List<ClassChange> list = classService.getAllClassChange();
    	model.addAttribute("classChangeList", list);
        return new ModelAndView("manager/index");
    }
}
