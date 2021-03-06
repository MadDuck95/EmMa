package de.emma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	/**
	 * returns the ModelAndView attributes to the mainpage, for displaying the
	 * tile names.
	 * 
	 * @return returns the ModelAndView attributes to the mainpage.
	 */

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