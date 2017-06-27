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

import de.emma.model.Employee;

@Controller
public class NewEmployee {
	
	// values to create connection
	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";

	// implement validator
	@Autowired
	@Qualifier("employeeValidator")
	private Validator validator;

	// set validator
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	// add common elements to site
	@ModelAttribute
	public void addingCommonObjects(Model displayModel) {
		// newEmployee.html
		displayModel.addAttribute("newEmployeeTitle", "register a new employee");

		// registeredEmployee.html
		displayModel.addAttribute("registeredEmployeeTitle", "Success! the employee is saved!");
	};
	
	public ModelAndView getDeparmtmentList(){
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}

	// add the employee bean to enable data binding
	@RequestMapping(value = "/newEmployee.html", method = RequestMethod.GET)
	public ModelAndView initEmployee(Model model) {

		ModelAndView mav = new ModelAndView("newEmployee");

		Hashtable<String, String> departmentTable = new Hashtable<String, String>();

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			// statement for query
			String sql = "SELECT * FROM department";
			st.execute("USE " + database);

			// get result from query
			ResultSet res = st.executeQuery(sql);

			// show result in console
			while (res.next()) {
				System.out.println(res.getString("depId") + " " + res.getString("depName"));

				// set result in the HashTable
				departmentTable.put(res.getString("depId"), res.getString("depName"));

			}
			System.out.println("");

			res.close();
			st.close();

		} catch (Exception e) {
			System.out.println("Couldnt load departments due to error " + e);
		}

		mav.addObject("departmentHashTable", departmentTable);
		mav.addObject("initEmployee", new Employee());

		return mav;

	}

	// binding submitted values
	@RequestMapping(value = "/registeredEmployee.html", method = RequestMethod.POST)
	public String submit(@ModelAttribute("initEmployee") @Validated Employee employee, BindingResult result,
			Model model) {

		model.addAttribute("newEmployee", employee);
		
		String returnVal = "registeredEmployee";

		// return error on the same page
		if (result.hasErrors()) {
			
			initEmployee(model);
			returnVal = "newEmployee";
		} else {
			model.addAttribute("newEmployee", employee);
		}

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			// prepared statement for query
			String sql = "INSERT INTO"
					+ " employee (firstName, lastName, adress, zip, city, departmentNr, title, salary, holidays) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement prepst = con.prepareStatement(sql);
			st.execute("USE " + database);

			// get the characteristics of the submitted employee
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
			
			
			st.execute("INSERT INTO users (username,password,enabled) " + 
					   "VALUES ('"+employee.getLastName().toLowerCase()+"','"+employee.getFirstName().toLowerCase()+"', true)");
			st.execute("INSERT INTO user_roles (username, role)" +
					   "VALUES ('"+employee.getLastName().toLowerCase()+"','ROLE_USER')");
			st.close();

		} catch (Exception e) {
			System.out.println("couldnt register the new employee due to the error: " + e);
		}

		// getter methods to retrieve the data of the employee model
		model.addAttribute("firstName", employee.getFirstName());
		model.addAttribute("lastName", employee.getLastName());
		model.addAttribute("adress", employee.getAdress());
		model.addAttribute("zip", employee.getZip());
		model.addAttribute("city", employee.getCity());
		model.addAttribute("department", employee.getDepartment());
		model.addAttribute("title", employee.getTitle());
		model.addAttribute("salary", employee.getSalary());
		model.addAttribute("holidays", employee.getHolidays());

		return returnVal;
	}
}
