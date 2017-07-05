package de.emma.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import org.hibernate.cfg.annotations.ResultsetMappingSecondPass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.emma.model.Project;

@Controller
public class ExistingProjects {

	// values to create connection
	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";

	// add common elements to site

	/**
	 * define title elements with specific values for the existing project page.
	 * 
	 */
	@ModelAttribute
	public void addingCommonObjects(Model displayModel) {
		// existingProjects.html
		displayModel.addAttribute("existingProjects", "View existing projects");
	};

	/**
	 * return all projects via select to the existing project page.
	 * 
	 * @return the new project page.
	 * 
	 */
	@RequestMapping(value = "/existingProjects.html", method = RequestMethod.GET)
	public ModelAndView initProjects() {

		ModelAndView mav = new ModelAndView("existingProjects");

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

	/**
	 * return the selected project to a specific page which contains the
	 * selected attributes.
	 * 
	 * @param project
	 *            get the selected project from the selection page of the
	 *            projects.
	 * @param model
	 *            cast the retrieved data from the database to the model to show
	 *            the values in the specific page which contains the selected
	 *            attributes.
	 * @return the page with the selected project values.
	 * 
	 */

	@RequestMapping(value = "/existingProjectsSelect.html", method = RequestMethod.POST)
	public String select(@ModelAttribute("initProjects") Project project, Model model) {

		model.addAttribute("existingProjects", project);

		try {
			// build connection to the SQL Server
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			String sql = "SELECT * FROM" + " projects" + " WHERE pnr = ?";
			String sql2 = "SELECT proj_team.pnr, proj_team.eNr1, proj_team.eNr2, proj_team.eNr3, proj_team.eNr4 From proj_team WHERE proj_team.pnr = ?";
			String sql3 = "SELECT employee.firstName, employee.lastName, employee.employeeId FROM employee WHERE employee.employeeId = ?";

			PreparedStatement prepst = con.prepareStatement(sql);

			st.execute("USE " + database);

			prepst.setObject(1, project.getpDesc());
			prepst.executeQuery();

			ResultSet res = prepst.getResultSet();
			while (res.next()) {
				model.addAttribute("pnr", res.getInt("pnr"));
				model.addAttribute("pDesc", res.getString("pDesc"));
				model.addAttribute("startDate", res.getDate("startDate"));
				model.addAttribute("endDate", res.getDate("endDate"));
				model.addAttribute("pText", res.getString("pText"));

			}
			res.close();
			prepst.close();

			PreparedStatement prepst2 = con.prepareStatement(sql2);

			prepst2.setObject(1, project.getpDesc());
			prepst2.executeQuery();

			ResultSet res2 = prepst2.getResultSet();

			while (res2.next()) {

				String emp1 = res2.getString("eNr1");
				String emp2 = res2.getString("eNr2");
				String emp3 = res2.getString("eNr3");
				String emp4 = res2.getString("eNr4");

				// get names of employees involved in a project
				PreparedStatement prepst3 = con.prepareStatement(sql3);
				PreparedStatement prepst4 = con.prepareStatement(sql3);
				PreparedStatement prepst5 = con.prepareStatement(sql3);
				PreparedStatement prepst6 = con.prepareStatement(sql3);

				prepst3.setObject(1, emp1);
				prepst4.setObject(1, emp2);
				prepst5.setObject(1, emp3);
				prepst6.setObject(1, emp4);

				prepst3.executeQuery();
				prepst4.executeQuery();
				prepst5.executeQuery();
				prepst6.executeQuery();

				ResultSet res3 = prepst3.getResultSet();
				while (res3.next()) {
					model.addAttribute("emp1", res3.getString("firstName") + " " + res3.getString("lastName"));
				}
				res3.close();
				prepst3.close();

				ResultSet res4 = prepst4.getResultSet();
				while (res4.next()) {
					model.addAttribute("emp2", res4.getString("firstName") + " " + res4.getString("lastName"));
				}
				res4.close();
				prepst4.close();

				ResultSet res5 = prepst5.getResultSet();
				while (res5.next()) {
					model.addAttribute("emp3", res5.getString("firstName") + " " + res5.getString("lastName"));
				}
				res5.close();
				prepst5.close();

				ResultSet res6 = prepst6.getResultSet();
				while (res6.next()) {
					model.addAttribute("emp4", res6.getString("firstName") + " " + res6.getString("lastName"));
				}
				res6.close();
				prepst6.close();

			}
			res2.close();
			prepst2.close();

			st.close();

		} catch (Exception e) {
			System.out.println("couldnt load projects due to the error: " + e);
		}

		return "existingProjectsSelect";
	}

}