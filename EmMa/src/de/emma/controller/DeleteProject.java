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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.emma.model.Employee;
import de.emma.model.Project;

@Controller
public class DeleteProject {

	// values to create connection
	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";

	// add common elements to site
	/**
	 * define title elements with specific values for registering a project and
	 * the successpage after registering.
	 * 
	 */
	@ModelAttribute
	public void addingCommonObjects(Model displayModel) {
		// deletProject.html
		displayModel.addAttribute("delteProjectTitle", "delete project");

		// registeredEmployee.html
		displayModel.addAttribute("deletedProjectTitle", "Success! the project is deleted!");
	}

	/**
	 * Get all projects from the database and set all in a table to select a
	 * project for deletion and hand over the project object.
	 * 
	 * @return the project object and the table to the delete project page.
	 * 
	 */
	@RequestMapping(value = "/deleteProject.html", method = RequestMethod.GET)
	public ModelAndView initProjects(Model model) {

		ModelAndView mav = new ModelAndView("deleteProject");

		Hashtable<String, String> projectsTable = new Hashtable<String, String>();

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			// statement for query
			String sql1 = "SELECT * FROM projects";

			st.execute("USE " + database);

			// get result from query
			ResultSet res = st.executeQuery(sql1);

			// show result in console
			while (res.next()) {
				projectsTable.put(res.getString("pnr"), "|| " + res.getString("pDesc") + " || " + "Start date: "
						+ res.getString("startDate") + " - End date: " + res.getString("endDate"));
			}

			System.out.println("");

			res.close();
			st.close();

		} catch (Exception e) {
			System.out.println("couldnt load projects due to the error: " + e);
		}

		mav.addObject("projectsTable", projectsTable);
		mav.addObject("initProjects", new Project());

		return mav;
	}

	// Mapping for the deleted project

	/**
	 * Delete the selected project and show the success page after deletion.
	 * 
	 * @param project
	 *            get the submitted project values from the delete project page.
	 * 
	 * @return the success page after deletion of an project.
	 * 
	 */
	@RequestMapping(value = "/deletedProject.html", method = RequestMethod.POST)
	public String delete(@ModelAttribute("initProjects") Project project) {

		try {

			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			String sql1 = "DELETE FROM projects WHERE pnr = ?";
			String sql2 = "DELETE FROM proj_team WHERE pnr = ?";
			st.execute("USE " + database);

			PreparedStatement prep1 = con.prepareStatement(sql1);
			PreparedStatement prep2 = con.prepareStatement(sql2);

			prep1.setObject(1, project.getpDesc());
			prep1.executeUpdate();

			prep2.setObject(1, project.getpDesc());
			prep2.executeUpdate();

		} catch (Exception e) {
			System.out.println("couldnt delete the project due following error: " + e);
		}

		return "deletedProject";
	}

}
