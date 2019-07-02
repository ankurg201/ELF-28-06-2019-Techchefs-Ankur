package com.techchefs.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class PreparedStatementExample3 {
	private static final Logger LOGGER = Logger.getLogger("MyFirstJdbcPrograme");

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
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
			// String dbUrl =
			// "jdbc:mysql://localhost:3306/techchefs_db?user=root&password=admin";
			// con = DriverManager.getConnection(dbUrl);

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techchefs_db", "root", "admin");

			// 3. issue sql query via connection
			String query = "insert into employee_info (id, name, age, gender, salary, phone, account_number, "
					+ "email, designation, mngr_id, dept_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 10);
			pstmt.setString(2, "gary");
			pstmt.setInt(3, 28);
			pstmt.setString(4, "female");
			pstmt.setInt(5, 400000);
			pstmt.setLong(6, 9886757689L);
			pstmt.setInt(7, 87968574);
			pstmt.setString(8, "Gary@gmail.com");
			pstmt.setString(9, "Sr software engineer");
			pstmt.setInt(10, 1);
			pstmt.setInt(11, 1);

			count = pstmt.executeUpdate();
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
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
