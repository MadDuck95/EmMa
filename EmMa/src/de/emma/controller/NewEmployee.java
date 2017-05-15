package de.emma.controller;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.emma.model.Employee;

@Controller
public class NewEmployee {

	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";

	// add the employee bean to enable data binding
	@RequestMapping(value = "/newEmployee.html", method = RequestMethod.GET)
	public ModelAndView initEmployee() {

		return new ModelAndView("newEmployee", "initEmployee", new Employee());

	}

	// add common elements to site
	@ModelAttribute
	public void addingCommonObjects(Model displayModel) {
		// newEmployee.html
		displayModel.addAttribute("newEmployeeTitle", "register a new employee");

		// registeredEmployee.html
		displayModel.addAttribute("registeredEmployeeTitle", "Success! the employee is created!");
		displayModel.addAttribute("registrationText", "The following data was submitted and saved: ");
	};

	// binding submitted values - register new employee
	@RequestMapping(value = "/registeredEmployee.html", method = RequestMethod.POST)
	public String submit(@ModelAttribute("initEmployee") Employee employee, BindingResult result, ModelMap model) {

		// return error on the same page
		if (result.hasErrors()) {
			return "error";
		}

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			// prepared statement for query
			String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement prepst = con.prepareStatement(sql);
			st.execute("USE " + database);

			// get the characteristics of the submitted employee
			// SQL statement
			prepst.setObject(1, employee.getFirstName());
			prepst.setObject(2, employee.getLastName());
			prepst.setObject(3, employee.getAdress());
			prepst.setInt(4, employee.getZip());
			prepst.setObject(5, employee.getCity());
			prepst.setObject(6, employee.getDepartment());
			prepst.setObject(7, employee.getTitle());
			prepst.setObject(8, employee.getSalary());
			prepst.setObject(9, employee.getHolidays());

			prepst.executeUpdate();
			prepst.close();

			st.close();

		} catch (Exception e) {
			System.out.println("couldnt register the new employee due to the error: " + e);
		}

		// getter methods to retrieve the data of the employee model and display
		// on registeredEmployee.html
		model.addAttribute("firstName", employee.getFirstName());
		model.addAttribute("lastName", employee.getLastName());
		model.addAttribute("adress", employee.getAdress());
		model.addAttribute("zip", employee.getZip());
		model.addAttribute("city", employee.getCity());
		model.addAttribute("department", employee.getDepartment());
		model.addAttribute("title", employee.getTitle());
		model.addAttribute("salary", employee.getSalary());
		model.addAttribute("holidays", employee.getHolidays());

		return "registeredEmployee";
	}
}