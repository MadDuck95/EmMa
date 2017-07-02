package de.emma.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.emma.model.Employee;
import de.emma.model.Project;

@Controller
public class NewProject {

	// values to create connection
	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";

	// add common elements to site
	@ModelAttribute
	public void addingCommonObjects(Model displayModel) {
		// newEmployee.html
		displayModel.addAttribute("newProject", "New Project");

		// registeredProject.html
		displayModel.addAttribute("registeredProject", "Success! the project was registered!");
	};

// create new project
	@RequestMapping(value = "/newProject.html", method = RequestMethod.GET)
	public String initEmployee(ModelMap map) {

		Employee emp = new Employee();
		Project pro = new Project();

		Hashtable<String, String> employeeTable = new Hashtable<String, String>();

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
				System.out.println(res.getString("employeeId") + " " + res.getString("lastName"));

				// set result in the HashTable
				employeeTable.put(res.getString("employeeId"),
						"|| " + res.getString("title") + " || " + res.getString("lastName") + " "
								+ res.getString("firstName") + " - " + res.getString("adress") + " - "
								+ res.getString("zip") + " " + res.getString("city"));

			}
			System.out.println("");

			res.close();
			st.close();

		} catch (Exception e) {
			System.out.println("Couldnt load employees due to error " + e);
		}

		map.addAttribute("pro", pro);
		map.addAttribute("emp", emp);

		map.addAttribute("employeeHashTable", employeeTable);

		return "newProject";
	}

// success page after registering
	@RequestMapping(value = "/registeredProject.html", method = RequestMethod.POST)
	public String submit(Employee emp, Project pro, Model model) {

		String empId = emp.getLastName();
		System.out.println(empId);

		String[] iDArr = empId.split("([,])");

		// get Id's of employees
		String emp1 = iDArr[0];
		String emp2 = iDArr[1];
		String emp3 = iDArr[2];
		String emp4 = iDArr[3];

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			// insert project name and date
			String sql1 = "INSERT INTO" + " projects (pDesc, startDate, endDate, pText)" + " VALUES (?,?,?,?)";

			// insert project employees
			String sql2 = "INSERT INTO" + " proj_team (eNr1, eNr2, eNr3, eNr4, pnr)" + " VALUES (?,?,?,?,?)";

			// get id of project
			String sql3 = "SELECT * FROM" + " projects" + " WHERE pDesc = ? AND startDate = ? AND endDate = ? ";

			PreparedStatement prepst1 = con.prepareStatement(sql1);
			PreparedStatement prepst2 = con.prepareStatement(sql2);
			PreparedStatement prepst3 = con.prepareStatement(sql3);

			st.execute("USE " + database);

			// set project description
			prepst1.setObject(1, pro.getpDesc());
			prepst1.setDate(2, pro.getStartDate());
			prepst1.setDate(3, pro.getEndDate());
			prepst1.setString(4, pro.getpText());

			prepst1.executeUpdate();
			prepst1.close();

			// get id of project
			prepst3.setString(1, pro.getpDesc());
			prepst3.setDate(2, pro.getStartDate());
			prepst3.setDate(3, pro.getEndDate());
			prepst3.executeQuery();

			ResultSet res = prepst3.getResultSet();
			while (res.next()) {
				String pnr = res.getString("pnr");

				// set employees and project in relationtable
				prepst2.setObject(1, emp1);
				prepst2.setObject(2, emp2);
				prepst2.setObject(3, emp3);
				prepst2.setObject(4, emp4);
				prepst2.setObject(5, pnr);

				model.addAttribute("proId", (pnr));

				prepst2.executeUpdate();
				prepst2.close();
			}

			prepst3.close();

			st.close();

		} catch (Exception e) {
			System.out.println("couldnt register the new project due to the error: " + e);
		}

		// get values for registered page
		model.addAttribute("lastName", emp.getLastName());
		model.addAttribute("proDesc", pro.getpDesc());
		model.addAttribute("startDate", pro.getStartDate());
		model.addAttribute("endDate", pro.getEndDate());
		model.addAttribute("proText", pro.getpText());

		return "registeredProject";
	}
}
