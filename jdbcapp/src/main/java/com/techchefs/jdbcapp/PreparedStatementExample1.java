package com.techchefs.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreparedStatementExample1 {
	private static final Logger LOGGER = Logger.getLogger("MyFirstJdbcPrograme");

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
			String query = "select * from employee_info where id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			rs = pstmt.executeQuery();

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
				if (pstmt != null) {
					pstmt.close();
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
