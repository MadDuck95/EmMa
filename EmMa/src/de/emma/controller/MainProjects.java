package de.emma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainProjects {

	/**
	 * returns the ModelAndView attributes to the main project page, for
	 * displaying the tile names.
	 * 
	 * @return returns the ModelAndView attributes to the projectpage.
	 */

	@RequestMapping(value = "/projectsMain.html")
	public ModelAndView addingCommmonObjects() {

		// ProjectsMain.html
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectsMainTitle", "Projects");
		mav.addObject("newProject", "new Project");
		mav.addObject("viewExisting", "view existing projects");
		mav.addObject("deleteProject", "delete projects");

		return mav;
	}
}
