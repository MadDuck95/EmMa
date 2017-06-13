package de.emma.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/calendar")
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		// variables to establish connection to database
		private String url = "jdbc:mysql://localhost:3306";
		private String password = "";
		private String user = "root";
		private String database = "employeemanager";
	
    public CalendarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		
		//Convert FullCalendar from Java to JSON
        Gson gson = new Gson();
        String jsonAppointment = gson.toJson(calList);
        
        System.out.println(jsonAppointment);
        
        //Printout the JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().write(jsonAppointment);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
