package com.zzzzzyx.training_management.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.model.BankAccount;
import com.zzzzzyx.training_management.service.AuthService;

@Controller
public class QualificationController {

	@Autowired
	AuthService authService;
	
	@RequestMapping(value = "user/activate.do", method = RequestMethod.GET)
    public ModelAndView activateIndex(){
		return new ModelAndView("activate", "command", new BankAccount());
    }
	
	@RequestMapping(value = "user/activate.do", method = RequestMethod.POST)
    public String activatePost(@ModelAttribute("SpringWeb")BankAccount bankAccount, HttpSession session){
		authService.activate(bankAccount,(long)session.getAttribute("auth_id"));
        return "redirect:index.do";
    }
	
	@RequestMapping(value = "user/changeBankAccount.do", method = RequestMethod.GET)
    public ModelAndView changeAccountGet(){
		return new ModelAndView("user/changeAccount", "command", new BankAccount());
    }
	
	@RequestMapping(value = "user/changeBankAccount.do", method = RequestMethod.POST)
    public String changeAccountPost(@ModelAttribute("SpringWeb")BankAccount bankAccount, HttpSession session){
		authService.changeBankAccount(bankAccount,(long)session.getAttribute("auth_id"));
        return "redirect:index.do";
    }
	
	@RequestMapping(value = "user/withdraw.do", method = RequestMethod.GET)
    public String withdraw(HttpSession session){
		authService.withdrawUser((long)session.getAttribute("auth_id"));
		return "redirect:../index.do";
    }
	
	@RequestMapping(value = "user/showCardLevel.do", method = RequestMethod.GET)
    public String showCardLevel(ModelMap model, HttpSession session){
		long point = authService.getPoint((long)session.getAttribute("auth_id"));
		model.addAttribute("point", point);
		return "user/showCardLevel";
    }
	
	@RequestMapping(value = "user/pointToCash.do", method = RequestMethod.GET)
    public String pointToCash(ModelMap model, HttpSession session){
		authService.pointToCash((long)session.getAttribute("auth_id"));
		return "redirect:showCardLevel.do";
    }
	
}
