package com.techchefs.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class StatementExample2 {
	private static final Logger LOGGER = Logger.getLogger("MyFirstJdbcPrograme");

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		int count = 0;
		try {
			// 1. load the driver.
			/*
			 * Driver driver = new Driver(); DriverManager.deregisterDriver(driver);
			 */

			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 2. get the db connection via driver
			String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db?user=root&password=admin";
			// con = DriverManager.getConnection(dbUrl);

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techchefs_db", "root", "admin");

			// 3. issue sql query via connection
			String query = "insert into employee_info (id, name, age, gender, salary, phone, account_number, "
					+ "email, designation, mngr_id, dept_id) values(8, 'neha', '16', 'female', 2000000, "
					+ "9567894567, 3245678, 'pooja@gmail.com', 'software engineer', 2, 1)";
			
			stmt = con.createStatement();
			count = stmt.executeUpdate(query);
			if (count > 0) {
				LOGGER.info("succesfully inserted " + count + " record");
			} else {
				LOGGER.info("insertion failed");
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

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
