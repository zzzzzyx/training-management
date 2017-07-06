package com.zzzzzyx.training_management.controller.chart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.dao.GenerateDataDao;
import com.zzzzzyx.training_management.model.globalData.ins.user.RegisterCourseNum;
import com.zzzzzyx.training_management.model.globalData.ins.user.RegisterStudentNum;
import com.zzzzzyx.training_management.model.globalData.manager.income.MonthIncome;
import com.zzzzzyx.training_management.model.globalData.manager.income.MonthIncomeIncrease;
import com.zzzzzyx.training_management.model.globalData.manager.income.MonthIncomeRate;

@Controller
public class Chart_InsController {

	@Autowired
	GenerateDataDao gdDao;
	
    @RequestMapping(value = "chart/institution/index.do", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model){
    	
    	List<RegisterStudentNum> registerStudentNum = gdDao.getRegisterStudentNumList();
    	model.addAttribute("registerStudentNum", registerStudentNum);
    	
    	List<RegisterCourseNum> registerCourseNum = gdDao.getRegisterCourseNumList();
    	model.addAttribute("registerCourseNum", registerCourseNum);
    	
        return new ModelAndView("chart/institution/index");
    }
    @RequestMapping(value = "chart/institution/income.do", method = RequestMethod.GET)
    public ModelAndView income(ModelMap model){
    	
    	List<MonthIncome> monthIncome = gdDao.getMonthIncomeList();
    	model.addAttribute("monthIncome", monthIncome);
    	
    	List<MonthIncomeRate> monthIncomeRate = gdDao.getMonthIncomeRateList();
    	model.addAttribute("monthIncomeRate", monthIncomeRate);
    	
    	List<MonthIncomeIncrease> monthIncomeIncrease = gdDao.getMonthIncomeIncreaseList();
    	model.addAttribute("monthIncomeIncrease", monthIncomeIncrease);
    	
        return new ModelAndView("chart/institution/income");
    }
    @RequestMapping(value = "chart/institution/customer.do", method = RequestMethod.GET)
    public ModelAndView customer(ModelMap model){
    	
        return new ModelAndView("chart/institution/customer");
    }
    
}
