package com.techchefs.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Driver;

public class MyFirstJdbcPrograme {
	private static final Logger LOGGER = Logger.getLogger("MyFirstJdbcPrograme");

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. load the driver.
			Driver driver = new Driver();
			DriverManager.deregisterDriver(driver);

			// 2. get the db connection via driver
			String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db?user=root&password=admin";
			con = DriverManager.getConnection(dbUrl);

			// 3. issue sql query via connection
			String query = "select * from employee_info";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				LOGGER.log(Level.INFO, "ID-> " + rs.getInt("id"));
				LOGGER.log(Level.INFO, "NAME-> " + rs.getString("name"));
				LOGGER.log(Level.INFO, "AGE-> " + rs.getInt("age"));
				LOGGER.log(Level.INFO, "GENDER-> " + rs.getString("gender"));
				LOGGER.log(Level.INFO, "====================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. close all connection
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
