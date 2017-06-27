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
			String statement = "CREATE DATABASE IF NOT EXISTS " + database + " default charset utf8"
					+ " COLLATE utf8_general_ci;";
			st.execute(statement);
			st.execute("USE " + database);

			// create employee table with entries
			st.execute("CREATE TABLE IF NOT EXISTS employee (" + "employeeId INT(6) NOT NULL AUTO_INCREMENT, "
					+ "firstName CHAR(25)," + " lastName CHAR(25)," + " adress VARCHAR(25)," + " zip INTEGER(25),"
					+ " city CHAR(25)," + " departmentNr INTEGER(25)," + " title CHAR(25)," + " salary INTEGER(25),"
					+ " holidays INTEGER(25)," + " PRIMARY KEY(employeeId)" + ")");

			// create projects
			st.execute("CREATE TABLE IF NOT EXISTS projects (" + "pnr INT(6) NOT NULL AUTO_INCREMENT, "
					+ "pDesc CHAR(60)," + " startDate DATE," + " endDate DATE,"+ " pText CHAR(250)," + " PRIMARY KEY(pnr)" + ")");

			// create proj_team
			st.execute("CREATE TABLE IF NOT EXISTS proj_team (" + "prEnr INT(6) NOT NULL AUTO_INCREMENT, "
					+ "eNr1 INT(25)," + "eNr2 INT(25)," + "eNr3 INT(25)," + "eNr4 INT(25)," + "pnr INT(25),"
					+ "PRIMARY KEY(prEnr)" + ")");

			// create calendar table
			st.execute("CREATE TABLE IF NOT EXISTS calendar (" + "calId INTEGER(6) NOT NULL AUTO_INCREMENT,"
					+ "calTitle CHAR(250)," + "startDate CHAR(25)," + "endDate CHAR(25)," + "PRIMARY KEY(calId)" + ")");
			
			// create department table with entries
			st.execute("CREATE TABLE IF NOT EXISTS department (" + "depId INTEGER(6) NOT NULL AUTO_INCREMENT,"
					+ "depName VARCHAR(25)," + "PRIMARY KEY(depId)" + ")");

			st.execute("INSERT INTO department (depId,depName) VALUES" + "('1','MES-Developement'),"
					+ " ('2','Business-Intelligence')," + "('3','Consulting')," + "('4','Human Resource'),"
					+ "('5','Finance')," + "('6','Information Technology')");

			//create users table with administrator  
			st.execute("CREATE  TABLE IF NOT EXISTS users ("+
					"username VARCHAR(45) NOT NULL,"+
					"password VARCHAR(45) NOT NULL,"+
					"enabled TINYINT NOT NULL DEFAULT 1,"+
					"PRIMARY KEY (username)" +")");
			st.execute("INSERT INTO users (username,password,enabled) " + 
					   "VALUES ('admin','admin', true)");
			
			//create user_roles table with administrator
			st.execute("CREATE TABLE user_roles (" +
					  "user_role_id int(11) NOT NULL AUTO_INCREMENT," +
					  "username varchar(45) NOT NULL," +
					  "role varchar(45) NOT NULL," +
					  "PRIMARY KEY (user_role_id)," +
					  "UNIQUE KEY uni_username_role (role,username)," +
					  "KEY fk_username_idx (username)," +
					  "CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)"+")");
			
			st.execute("INSERT INTO user_roles (username, role)" +
					   "VALUES ('admin','ROLE_USER')");
			
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