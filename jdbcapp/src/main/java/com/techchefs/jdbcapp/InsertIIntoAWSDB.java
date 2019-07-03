package com.techchefs.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class InsertIIntoAWSDB {
	private static final Logger LOGGER = Logger.getLogger("MyFirstJdbcPrograme");

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dbUrl = "jdbc:mysql://hello-aws-mysql.ci1388idva5z.ap-south-1.rds.amazonaws.com:3306/awsdb";
			con = DriverManager.getConnection(dbUrl, "root", "India123$");

			// 3. issue sql query via connection
			String query = "insert into employee_info (id, name, age, gender, salary, phone, account_number, "
					+ "email, designation, mngr_id, dept_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 11);
			pstmt.setString(2, "cherry");
			pstmt.setInt(3, 28);
			pstmt.setString(4, "female");
			pstmt.setInt(5, 4000000);
			pstmt.setLong(6, 9886757689L);
			pstmt.setInt(7, 87968574);
			pstmt.setString(8, "cherry@gmail.com");
			pstmt.setString(9, "Manager");
			pstmt.setInt(10, 1);
			pstmt.setInt(11, 1);

			count = pstmt.executeUpdate();
			if (count > 0) {
				LOGGER.info("succesfully inserted " + count + " record");
			} else {
				LOGGER.info("insertion failed");
			}

		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
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
