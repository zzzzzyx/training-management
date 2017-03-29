package com.zzzzzyx.training_management.controller.institution;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zzzzzyx.training_management.model.Course;
import com.zzzzzyx.training_management.model.StudyConnection;
import com.zzzzzyx.training_management.service.StudyService;

@Controller
public class StudentManager {

	@Autowired
	StudyService studyService;

	@RequestMapping(value = "institution/studentList.do", method = RequestMethod.GET)
	public String index(ModelMap model, long courseId) {
		List<StudyConnection> studentList = studyService.getStudentListByCourseId(courseId);
		model.addAttribute("studentList", studentList);

		Course course = studyService.getCourse(courseId);
		model.addAttribute("course", course);
		return "institution/studentList";
	}

	@RequestMapping(value = "institution/registerMark.do", method = RequestMethod.GET)
	public ModelAndView registerMarkGet(ModelMap model, long connectionId) {
		model.addAttribute("connectionId", connectionId);
		return new ModelAndView("institution/registerMark", "command", new StudyConnection());
	}

	@RequestMapping(value = "institution/registerMark.do", method = RequestMethod.POST)
	public String registerMarkPost(@ModelAttribute("SpringWeb") StudyConnection sc, ModelMap model) {
		studyService.registerMark(sc.getId(),sc.getMark());
		return "redirect:index.do";
	}
	
	@RequestMapping(value = "institution/deleteStudent.do", method = RequestMethod.GET)
	public String deleteStudent(ModelMap model, long connectionId) {
		studyService.deleteStudent(connectionId);
		return "redirect:index.do";
	}
	
	@RequestMapping(value = "institution/registerNonUser.do", method = RequestMethod.GET)
	public ModelAndView registerNonUserGet(ModelMap model, long courseId) {
		model.addAttribute("courseId", courseId);
		return new ModelAndView("institution/registerNonUser", "command", new StudyConnection());
	}

	@RequestMapping(value = "institution/registerNonUser.do", method = RequestMethod.POST)
	public String registerNonUserPost(@ModelAttribute("SpringWeb") StudyConnection sc, ModelMap model, HttpSession session) {
		studyService.registerNonUser(sc.getCourse_id(), sc.getUsername(),(long)session.getAttribute("auth_id"));
		return "redirect:index.do";
	}
}
