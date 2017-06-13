package de.emma.controller;

import java.sql.*;
import java.util.Hashtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.emma.model.Calendar;

@Controller
public class NewCalendarEvent {
	
	// values to create connection
	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";


	// add common elements to site
	@ModelAttribute
	public void addingCommonObjects(Model displayModel) {
		// newCalendar.html
		displayModel.addAttribute("newCalendarTitle", "register a new calendar event");

		// registeredCalendar.html
		displayModel.addAttribute("registeredCalendarTitle", "Success! the calendar event is saved!");
	};
	
	public ModelAndView getCalendarList(){
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}

	// add the calendar bean to enable data binding
	@RequestMapping(value = "/newCalendar.html", method = RequestMethod.GET)
	public ModelAndView initCalendar(Model model) {

		ModelAndView mav = new ModelAndView("newCalendar");

		Hashtable<String, String> calendarTable = new Hashtable<String, String>();

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			// statement for query
			String sql = "SELECT * FROM calendar";
			st.execute("USE " + database);

			// get result from query
			ResultSet res = st.executeQuery(sql);

			// show result in console
			while (res.next()) {
				System.out.println(res.getString("calId") + " " + res.getString("calTitle"));

				// set result in the HashTable
				calendarTable.put(res.getString("calId"), res.getString("calTitle"));

			}
			System.out.println("");

			res.close();
			st.close();

		} catch (Exception e) {
			System.out.println("Couldnt load calendar due to error " + e);
		}

		mav.addObject("calendarHashTable", calendarTable);
		mav.addObject("initCalendar", new Calendar());

		return mav;

	}

	// binding submitted values
	@RequestMapping(value = "/registeredCalendar.html", method = RequestMethod.POST)
	public String submit(@ModelAttribute("initCalendar") Calendar calendar  , BindingResult result,
			Model model) {

		model.addAttribute("newCalendar", calendar);
		
		String returnVal = "registeredCalendar";

		// return error on the same page
		if (result.hasErrors()) {
			
			initCalendar(model);
			returnVal = "newCalendar";
		} else {
			model.addAttribute("newCalendar", calendar);
		}

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			// prepared statement for query
			String sql = "INSERT INTO"
					+ " calendar (calTitle,startDate,endDate) "
					+ "VALUES (?,?,?)";
			PreparedStatement prepst = con.prepareStatement(sql);
			st.execute("USE " + database);

			// get the characteristics of the submitted calendar Event
			prepst.setObject(1, calendar.getCalTitle());
			prepst.setObject(2, calendar.getStartDate());
			prepst.setObject(3, calendar.getEndDate());

			prepst.executeUpdate();
			prepst.close();

			st.close();

		} catch (Exception e) {
			System.out.println("couldnt register the new calendar event due to the error: " + e);
		}

		// getter methods to retrieve the data of the calendar model
		model.addAttribute("calTitle", calendar.getCalTitle());
		model.addAttribute("startDate", calendar.getStartDate());
		model.addAttribute("endDate", calendar.getEndDate());

		return returnVal;
	}
}
