package de.emma.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CalDAO {
	
	// variables to establish connection to database
	private String url = "jdbc:mysql://localhost:3306";
	private String password = "";
	private String user = "root";
	private String database = "employeemanager";
	
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
				cal.setCalId(res.getString("calId"));
				cal.setCalTitle(res.getString("calTitle"));
				cal.setStartDate(res.getString("startDate"));
				cal.setEndDate(res.getString("endDate"));
				
				calList.add(cal);
			}
		
			System.out.println(calList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return calList;
	}
}
