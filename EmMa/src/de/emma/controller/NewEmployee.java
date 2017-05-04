package de.emma.controller;

import java.sql.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.emma.model.Employee;

@Controller
public class NewEmployee {

	@RequestMapping(value = "/newEmployee.html", method = RequestMethod.GET)
	public ModelAndView newEmployee() {

		ModelAndView model = new ModelAndView("newEmployee");
		model.addObject("title", "Register a new employee");

		return model;
	}

	@RequestMapping(value = "/registeredEmployee.html", method = RequestMethod.POST)
	public ModelAndView abschicken(@ModelAttribute("e1") Employee e1) {

		String lastName = e1.getLastName();
		String firstName = e1.getFirstName();
		String address = e1.getAdress();
		int zip = e1.getZip();
		String city = e1.getCity();
		String department = e1.getDepartment();
		String title = e1.getTitle();
		int salary = e1.getSalary();
		int holidays = e1.getHolidays();

		String url = "jdbc:mysql://localhost:3306";
		String password = "";
		String user = "root";
		String database = "employeemanager";

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement prepst = con.prepareStatement(sql);

			st.execute("USE " + database);

			prepst.setString(1, firstName);
			prepst.setString(2, lastName);
			prepst.setString(3, address);
			prepst.setInt(4, zip);
			prepst.setString(5, city);
			prepst.setString(6, department);
			prepst.setString(7, title);
			prepst.setInt(8, salary);
			prepst.setInt(9, holidays);
			prepst.executeUpdate();
			prepst.close();

			st.close();

			ModelAndView model1 = new ModelAndView("registeredEmployee");
			model1.addObject("title", "Success! The employee " + lastName + " " + firstName + " ist now registered!");

			return model1;

		} catch (Exception e) {

			System.out.println("couldnt register the new employee due to the error: " + e);

			ModelAndView model = new ModelAndView("registeredEmployee");
			model.addObject("title", "Failure! The employee " + lastName + " " + firstName + " couldnt be registered!");

			return model;
		}
	}
}