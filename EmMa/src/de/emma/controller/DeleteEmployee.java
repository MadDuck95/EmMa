package de.emma.controller;

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

import com.sun.org.apache.bcel.internal.generic.NEW;

import de.emma.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Controller
public class DeleteEmployee {

	// variables to establish connection to database
	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";

	// add common elements to site

	/**
	 * define title elements with there specific values for deleting an employee
	 * and the successpage after deletion.
	 * 
	 */
	@ModelAttribute
	public void addingCommonObjects(Model displayModel) {
		// deleteEmployee.html
		displayModel.addAttribute("deleteEmployeeTitle", "delete an existing employee");

		// deletedEmployee.html
		displayModel.addAttribute("deletedText", "Success! The employee was sumbited and deleted!");
	}

	// Mapping for deleting an Employee

	/**
	 * Get all employees from the database and set all in a table to select a
	 * employee for deletion.
	 * 
	 * @return the employee object and the table to the delete employee page.
	 * 
	 */
	@RequestMapping(value = "/deleteEmployee.html", method = RequestMethod.GET)
	private ModelAndView initEmployees() {

		ModelAndView mav = new ModelAndView("deleteEmployee");

		Hashtable<String, String> hashtable = new Hashtable<String, String>();

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			// statement for query
			String sql = "SELECT * FROM employee";
			st.execute("USE " + database);

			// get result from query
			ResultSet res = st.executeQuery(sql);

			// show result in console
			while (res.next()) {
				System.out.println(res.getString("firstName") + " " + res.getString("lastName"));

				// set result in the HashTable
				hashtable.put(res.getString("employeeId"),
						"|| " + res.getString("title") + " || " + res.getString("lastName") + " "
								+ res.getString("firstName") + " - " + res.getString("adress") + " - "
								+ res.getString("zip") + " " + res.getString("city"));

			}
			System.out.println("");

			res.close();
			st.close();

		} catch (Exception e) {
			System.out.println("couldnt load employees due to the error: " + e);
		}

		mav.addObject("employeeHashTable", hashtable);
		mav.addObject("getEmployee", new Employee());

		return mav;
	}

	// Mapping for the deleted Employee

	/**
	 * Delete the selected employee and show the success page after deletion.
	 * 
	 * @param employee
	 *            get all employee related values from the database.
	 * 
	 * @return the success page after deletion of an employee.
	 * 
	 */
	@RequestMapping(value = "/deletedEmployee.html", method = RequestMethod.POST)
	public String delete(@ModelAttribute("getEmployee") Employee employee) {

		String returnVal = "deletedEmployee";

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			String sql = "DELETE FROM employee WHERE employeeId = ?";
			st.execute("USE " + database);

			PreparedStatement prep = con.prepareStatement(sql);

			prep.setObject(1, employee.getLastName());
			prep.executeUpdate();

		} catch (Exception e) {
			System.out.println("couldnt delete the employee due following error: " + e);
		}

		return returnVal;
	}
}
