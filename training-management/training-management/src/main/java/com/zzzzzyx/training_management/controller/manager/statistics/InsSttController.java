package com.zzzzzyx.training_management.controller.manager.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.model.StudyConnection;
import com.zzzzzyx.training_management.service.ClassChangeService;
import com.zzzzzyx.training_management.service.StatisticsService;
import com.zzzzzyx.training_management.service.StudyService;
import com.zzzzzyx.training_management.vo.InstitutionVO;

@Controller
public class InsSttController {

	@Autowired
	StatisticsService statisticsService;
	@Autowired
	ClassChangeService classService;
	@Autowired
	StudyService studyService;
	
    @RequestMapping(value = "management/insStatistics.do", method = RequestMethod.GET)
    public String insStatisticsIndex(ModelMap model){
    	
    	List<InstitutionVO> insList = statisticsService.getInsList();
    	model.addAttribute("insList", insList);
    	
        return "manager/insStatistics/index";
    }
    
    @RequestMapping(value = "management/showCourse.do", method = RequestMethod.GET)
    public String showCourse(ModelMap model, long insId){
    	
    	List<Course> courseList = classService.getCourseListByInsId(insId);
    	model.addAttribute("courseList", courseList);
        return "manager/insStatistics/showCourse";
    }
    
    @RequestMapping(value = "management/courseStudentList.do", method = RequestMethod.GET)
    public String courseStudentList(ModelMap model, long courseId){
    	
    	List<StudyConnection> studentList = studyService.getStudentListByCourseId(courseId);
		model.addAttribute("studentList", studentList);

		Course course = studyService.getCourse(courseId);
		model.addAttribute("course", course);
		
        return "manager/insStatistics/courseStudentList";
    }
}
