package de.emma.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.emma.model.Employee;

@Controller
public class Calendar {
	
	// variables to establish connection to database
	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";
	
	@RequestMapping(value="/calendar.html")
	public ModelAndView initCalendar() {
		
		ModelAndView mav = new ModelAndView("calendar");

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
				System.out.println(res.getString("calId") + " " + res.getString("calTitle")+ " " + res.getString("startDate")+ " " + res.getString("endDate"));

				// set result in the HashTable
				calendarTable.put(res.getString("calId"), res.getString("calTitle"));

			}
			System.out.println("");

			res.close();
			st.close();

		} catch (Exception e) {
			System.out.println("Couldnt load calendar events due to error " + e);
		}

		mav.addObject("calendarHashTable", calendarTable);
		mav.addObject("initCalendar", new de.emma.model.Calendar());

		return mav;
		
	}
	
	public List<de.emma.model.Calendar> getCal(){
		List<de.emma.model.Calendar> calList = new ArrayList<de.emma.model.Calendar>();
		
		try{
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			String sql = "SELECT * FROM" + " calendar";
			PreparedStatement prepst = con.prepareStatement(sql);
			st.execute("USE " + database);
			prepst.executeQuery();

			ResultSet res = prepst.getResultSet();
			while(res.next()){
				de.emma.model.Calendar cal = new de.emma.model.Calendar();
				cal.setCalTitle(res.getString("calTitle"));
				cal.setStartDate(res.getString("startDate"));
				cal.setEndDate(res.getString("endDate"));
				
				calList.add(cal);
				System.out.println(res.getString("calTitle") + " " + res.getString("startDate")+ " " + res.getString("endDate"));
			}
			System.out.println("");
			
			res.close();
			prepst.close();
			
		}catch(Exception e){
			System.out.println("couldnt load calendar events due to the error: " + e);
		}
		
		return calList;
	}
		 
}
