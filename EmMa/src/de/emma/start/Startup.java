package de.emma.start;

import java.sql.*;

public class Startup {
	private String driverClass;
	private String user;
	private String password;
	private String url;
	private String database;

	public void connectDB() {
		try {
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			String statement_1 = "CREATE DATABASE IF NOT EXISTS " + database + " default charset utf8"
					+ " COLLATE utf8_general_ci;";
			st.execute(statement_1);
			st.execute("USE " + database);
			st.execute("CREATE TABLE IF NOT EXISTS employee (" + "firstName VARCHAR(25)," + " lastName VARCHAR(25),"
					+ " adress VARCHAR(25)," + " zip INTEGER(25)," + " city VARCHAR(25)," + " department VARCHAR(25),"
					+ " title VARCHAR(25)," + " salary INTEGER(25)," + " holidays INTEGER(25))");
			st.close();
			con.close();

		} catch (Exception e) {
			System.out.println("follwing error occured due to: " + e);
		}

	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

}