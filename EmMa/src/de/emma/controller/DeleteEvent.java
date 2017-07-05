package de.emma.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.emma.model.Calendar;
import de.emma.model.Project;

@Controller
public class DeleteEvent {
	// values to create connection
	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";

	// add common elements to site
	/**
	 * define title elements with specific values for the delete calender and
	 * the deleted event page.
	 * 
	 */
	@ModelAttribute
	public void addingCommonObjects(Model displayModel) {
		// deletProject.html
		displayModel.addAttribute("delteEventTitle", "delete calendar event");

		// registeredEmployee.html
		displayModel.addAttribute("deletedEventTitle", "Success! the event is deleted!");
	}

	/**
	 * Get all calendar events from the database and set all in a table to
	 * select a event for deletion and hand over the project object.
	 * 
	 * @return the calendar object and the table to the delete project page.
	 * 
	 */

	@RequestMapping(value = "/deleteEvent.html", method = RequestMethod.GET)
	public ModelAndView initEvents() {

		ModelAndView mav = new ModelAndView("deleteEvent");

		Hashtable<String, String> eventsTable = new Hashtable<String, String>();

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			// statement for query
			String sql1 = "SELECT * FROM calendar";

			st.execute("USE " + database);

			// get result from query
			ResultSet res = st.executeQuery(sql1);

			// show result in console
			while (res.next()) {
				eventsTable.put(res.getString("calId"), "|| " + res.getString("calTitle") + " || " + "Start date: "
						+ res.getString("startDate") + " - End date: " + res.getString("endDate"));

			}

			System.out.println("");

			res.close();
			st.close();

		} catch (Exception e) {
			System.out.println("couldnt load events due to the error: " + e);
		}

		mav.addObject("eventsTable", eventsTable);
		mav.addObject("initEvents", new Calendar());

		return mav;
	}

	// Mapping for the deleted project

	/**
	 * delete the submitted calendar event from the database.
	 * 
	 * @param calendar
	 *            get the submitted calendar values.
	 * @param model
	 *            cast the calendar event to the model.
	 * 
	 * @return the success page for deletion of an calendar event.
	 * 
	 */
	@RequestMapping(value = "/deletedEvent.html", method = RequestMethod.POST)
	public String delete(@ModelAttribute("initProjects") Calendar calendar, Model model) {

		model.addAttribute("deletedEvent", calendar);

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			String sql1 = "DELETE FROM calendar WHERE calId = ?";
			st.execute("USE " + database);

			PreparedStatement prep1 = con.prepareStatement(sql1);

			prep1.setObject(1, calendar.getCalTitle());
			prep1.executeUpdate();

		} catch (Exception e) {
			System.out.println("couldnt delete the event due following error: " + e);
		}

		return "deletedEvent";
	}
}
