package com.techchefs.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPoolTest {
	private static final Logger LOGGER = Logger.getLogger("ConnectionPoolTest");

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getConnectionPool();
			
			con = pool.getConnectionFromPool();
			
			String query = "select * from employee_info where id = 1";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				LOGGER.log(Level.INFO, "ID-> " + rs.getInt("id"));
				LOGGER.log(Level.INFO, "NAME-> " + rs.getString("name"));
				LOGGER.log(Level.INFO, "AGE-> " + rs.getInt("age"));
				LOGGER.log(Level.INFO, "GENDER-> " + rs.getString("gender"));
				LOGGER.log(Level.INFO, "====================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				pool.returnConnectionToPool(con);
				
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
