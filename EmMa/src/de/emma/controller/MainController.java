package de.emma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public ModelAndView home() {
		
		ModelAndView model = new ModelAndView("main");
		
		model.addObject("title", "EmMa - EmployeeManager ");
		model.addObject("newEmployee", "new Employee ");
		model.addObject("calendar", "Calendar ");
		model.addObject("deleteEmployee", "delete Employee");
		model.addObject("projects", "Projects ");
		
		return model;
	}
}