package de.emma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainCalendar {

	@RequestMapping(value = "/calendarMain.html")
	public ModelAndView addingCommmonObjects() {

		// ProjectsMain.html
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("calendarMainTitle", "Calendar");
		mav.addObject("newCalendar", "new Calendar Event");
		mav.addObject("viewExisting", "view existing Events");
		
		return mav;
	}
}
