package com.zzzzzyx.training_management.controller.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.service.BankService;
import com.zzzzzyx.training_management.service.ClassChangeService;

@Controller
public class Chart_ManagerController {

	@Autowired
	ClassChangeService classService;
	@Autowired
	BankService bankService;
	
    @RequestMapping(value = "chart/management/index.do", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model){
//    	List<ClassChange> classChangelist = classService.getAllClassChange();
//    	List<WaitingPayment> waitingPaymentList = bankService.getAllWaitingPayment();
//    	
//    	model.addAttribute("classChangeList", classChangelist);
//    	model.addAttribute("waitingPaymentList", waitingPaymentList);
    	
        return new ModelAndView("chart/manager/index");
    }
}
