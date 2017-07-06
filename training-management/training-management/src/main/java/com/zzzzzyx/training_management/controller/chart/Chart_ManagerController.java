package com.zzzzzyx.training_management.controller.chart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.dao.GenerateDataDao;
import com.zzzzzyx.training_management.model.globalData.manager.course.InsToCourse;
import com.zzzzzyx.training_management.model.globalData.manager.course.KindToCourse;
import com.zzzzzyx.training_management.model.globalData.manager.course.LengthToCourse;
import com.zzzzzyx.training_management.model.globalData.manager.course.PriceToCourse;
import com.zzzzzyx.training_management.model.globalData.manager.income.MonthIncome;
import com.zzzzzyx.training_management.model.globalData.manager.income.MonthIncomeIncrease;
import com.zzzzzyx.training_management.model.globalData.manager.income.MonthIncomeRate;
import com.zzzzzyx.training_management.model.globalData.manager.ins.MarkToIns;
import com.zzzzzyx.training_management.model.globalData.manager.ins.StudentToIns;
import com.zzzzzyx.training_management.model.globalData.manager.user.AttendCourseLevel;
import com.zzzzzyx.training_management.model.globalData.manager.user.ComsumeLevel;
import com.zzzzzyx.training_management.model.globalData.manager.user.RegisterUserNum;
import com.zzzzzyx.training_management.model.globalData.manager.user.RegisterUserTotal;

@Controller
public class Chart_ManagerController {

	@Autowired
	GenerateDataDao gdDao;
	
    @RequestMapping(value = "chart/management/index.do", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model){
    	
    	List<RegisterUserNum> registerUserNum = gdDao.getRegisterUserNumList();
    	model.addAttribute("registerUserNumList", registerUserNum);
    	
    	List<RegisterUserTotal> registerUserTotal = gdDao.getRegisterUserTotalList();
    	model.addAttribute("registerUserTotalList", registerUserTotal);
    	
    	List<ComsumeLevel> consumeLevel = gdDao.getConsumeLevelList();
    	model.addAttribute("consumeLevelList", consumeLevel);
    	
    	List<AttendCourseLevel> attendCourseLevel = gdDao.getAttendCourseLevelList();
    	model.addAttribute("attendCourseLevelList", attendCourseLevel);
        return new ModelAndView("chart/manager/index");
    }
    
    @RequestMapping(value = "chart/management/income.do", method = RequestMethod.GET)
    public ModelAndView income(ModelMap model){
    	
    	List<MonthIncome> monthIncome = gdDao.getMonthIncomeList();
    	model.addAttribute("monthIncome", monthIncome);
    	
    	List<MonthIncomeRate> monthIncomeRate = gdDao.getMonthIncomeRateList();
    	model.addAttribute("monthIncomeRate", monthIncomeRate);
    	
    	List<MonthIncomeIncrease> monthIncomeIncrease = gdDao.getMonthIncomeIncreaseList();
    	model.addAttribute("monthIncomeIncrease", monthIncomeIncrease);
    	
        return new ModelAndView("chart/manager/income");
    }
    
    @RequestMapping(value = "chart/management/course.do", method = RequestMethod.GET)
    public ModelAndView course(ModelMap model){
    	
    	List<PriceToCourse> priceToCourse = gdDao.getPriceToCourseList();
    	model.addAttribute("priceToCourse", priceToCourse);
    	List<LengthToCourse> lengthToCourse = gdDao.getLengthToCourseList();
    	model.addAttribute("lengthToCourse", lengthToCourse);
    	List<InsToCourse> insToCourse = gdDao.getInsToCourseList();
    	model.addAttribute("insToCourse", insToCourse);
    	List<KindToCourse> kindToCourse = gdDao.getKindToCourseList();
    	model.addAttribute("kindToCourse", kindToCourse);
    	
        return new ModelAndView("chart/manager/course");
    }
    @RequestMapping(value = "chart/management/ins.do", method = RequestMethod.GET)
    public ModelAndView ins(ModelMap model){
    	
    	List<MarkToIns> markToIns = gdDao.getMarkToInsList();
    	model.addAttribute("markToIns", markToIns);
    	List<StudentToIns> studentToIns = gdDao.getStudentToInsList();
    	model.addAttribute("studentToIns", studentToIns);
    	
        return new ModelAndView("chart/manager/ins");
    }
    @RequestMapping(value = "chart/management/customer.do", method = RequestMethod.GET)
    public ModelAndView customer(ModelMap model){
    	
        return new ModelAndView("chart/manager/customer");
    }
}
