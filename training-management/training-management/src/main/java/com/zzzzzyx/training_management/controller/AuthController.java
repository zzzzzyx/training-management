package com.zzzzzyx.training_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.model.Authentication;
import com.zzzzzyx.training_management.service.UserService;

@Controller
@SessionAttributes("auth_id")  
public class AuthController {

	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("login", "command", new Authentication());
    }
    
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(@ModelAttribute("SpringWeb")Authentication user, ModelMap model){
    	Authentication realUser = userService.login(user);
    	if(realUser == null){
    		return "loginFail";
    	}else{
    		
    		model.addAttribute("auth_id", realUser.getId());
    		
    		switch(realUser.getUserKind()){
			case Authentication.UserKind_Institution:return "redirect:institution/index.do";
			case Authentication.UserKind_Manager:return "redirect:manager/index.do";
			case Authentication.UserKind_User:
				break;
			default:
				break;
    		}
			return "redirect:index.do";
    	}
    }
    
    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    public ModelAndView registerGet(){
        return new ModelAndView("register", "command", new Authentication());
    }
    
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String registerPost(@ModelAttribute("SpringWeb")Authentication user, ModelMap model){
    	userService.register(user);
        return "redirect:index.do";
    }
}