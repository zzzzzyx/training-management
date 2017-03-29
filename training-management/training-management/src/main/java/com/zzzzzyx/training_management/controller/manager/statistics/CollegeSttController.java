package com.zzzzzyx.training_management.controller.manager.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzzzzyx.training_management.model.log.ConsumeLog;
import com.zzzzzyx.training_management.service.LogService;

@Controller
public class CollegeSttController {

	@Autowired
	LogService logService;

	@RequestMapping(value = "manager/collegeStatistics.do", method = RequestMethod.GET)
	public String collegeStatisticsIndex(ModelMap model) {

		List<ConsumeLog> activationLogList = logService.getCompleteActivationLogList();
		model.addAttribute("activationLogList", activationLogList);
		
		List<ConsumeLog> attendLogList = logService.getCompleteAttendLogList();
		model.addAttribute("attendLogList", attendLogList);
		
		List<ConsumeLog> refundLogList = logService.getCompleteRefundLogList();
		model.addAttribute("refundLogList", refundLogList);
		
		return "manager/collegeStatistics/index";
	}
}
