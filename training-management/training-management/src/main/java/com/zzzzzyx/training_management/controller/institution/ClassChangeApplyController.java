package com.zzzzzyx.training_management.controller.institution;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.model.ClassChange;
import com.zzzzzyx.training_management.model.Course;
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
	
	@RequestMapping(value = "institution/delete.do", method = RequestMethod.GET)
    public String delete(long courseId){
		classService.deleteClass(courseId);
		return "redirect:index.do";
    }
	
	@RequestMapping(value = "institution/change.do", method = RequestMethod.GET)
    public ModelAndView changeIndex(ModelMap model, long courseId){
		Course course = classService.getCourseById(courseId);
		model.put("course", course);
		model.put("courseId", courseId);
        return new ModelAndView("institution/changeClass","command", new ClassChange());
    }
	
	@RequestMapping(value = "institution/change.do", method = RequestMethod.POST)
    public String changenPost(@ModelAttribute("SpringWeb")ClassChange newClass, HttpSession session){
		classService.changeClass(newClass,(long)session.getAttribute("auth_id"));
		return "redirect:index.do";
    }
	
	@ModelAttribute("statusList")
	public Map<String, String> getStatusList(){
		Map<String, String> statusList = new HashMap<String, String>();
		statusList.put(Course.Status_waiting, "等待开课");
		statusList.put(Course.Status_studying, "已开课");
		statusList.put(Course.Status_end, "已结束");
		return statusList;
	}
}
