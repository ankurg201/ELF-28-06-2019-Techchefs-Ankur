package com.techchefs.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyFirstJdbcTryWithResources {
	private static final Logger LOGGER = Logger.getLogger("MyFirstJdbcTryWithResources");

	public static void main(String[] args) {

		String query = "select * from employee_info";
		String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db";

		try (Connection con = DriverManager.getConnection(dbUrl, "root", "admin");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			while (rs.next()) {
				LOGGER.log(Level.INFO, "ID-> " + rs.getInt("id"));
				LOGGER.log(Level.INFO, "NAME-> " + rs.getString("name"));
				LOGGER.log(Level.INFO, "AGE-> " + rs.getInt("age"));
				LOGGER.log(Level.INFO, "GENDER-> " + rs.getString("gender"));
				LOGGER.log(Level.INFO, "====================================");
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
