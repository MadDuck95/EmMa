package de.emma.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.emma.model.Employee;

@Controller
public class CalendarController {

	// variables to establish connection to database
	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";

	/**
	 * get all calender and project events from the database and transform the
	 * data in to a json file.
	 * 
	 * @return return the modelandview object which contains the calendar object
	 *         and the jsonfile with all events. Show of the calendar.
	 * 
	 */

	@RequestMapping(value = "/calendar.html")
	public ModelAndView initCalendar() {

		ModelAndView mav = new ModelAndView("calendar");

		Hashtable<String, String> calendarTable = new Hashtable<String, String>();

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			// statement for query
			String sql1 = "SELECT * FROM calendar";
			String sql2 = "SELECT * FROM projects";
			st.execute("USE " + database);

			// get result from query
			ResultSet res = st.executeQuery(sql1);

			String eventsCal = "events";

			// JSON for calendar events
			JSONArray calEvents = new JSONArray();
			calEvents.add(eventsCal);

			// set every calendar entry in JSON
			while (res.next()) {
				JSONObject calJson = new JSONObject();

				calJson.put("calId", res.getString("calId"));
				calJson.put("end", res.getString("endDate"));
				calJson.put("start", res.getString("startDate"));
				calJson.put("title", res.getString("calTitle"));

				calEvents.add(calJson);
			}

			res.close();

			// JSON for projects
			String eventsPro = "events";
			JSONArray proArr = new JSONArray();

			ResultSet res2 = st.executeQuery(sql2);
			// set every project entry in JSON
			while (res2.next()) {
				JSONObject proJson = new JSONObject();

				proJson.put("pnr", res2.getString("pnr"));
				proJson.put("end", res2.getString("endDate"));
				proJson.put("start", res2.getString("startDate"));
				proJson.put("title", res2.getString("pDesc"));

				calEvents.add(proJson);
			}
			mav.addObject("calEvents", calEvents);
			res2.close();

			st.close();

		} catch (Exception e) {
			System.out.println("Couldnt load calendar events due to error " + e);
		}

		mav.addObject("calendarHashTable", calendarTable);
		mav.addObject("initCalendar", new de.emma.model.Calendar());

		return mav;
	}

}
