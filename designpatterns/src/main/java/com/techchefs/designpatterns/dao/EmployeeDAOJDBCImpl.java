package com.techchefs.designpatterns.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.techchefs.designpatterns.beans.EmployeeInfoBean;

public class EmployeeDAOJDBCImpl implements EmployeeDAO{
	private static final Logger LOGGER = Logger.getLogger("EmployeeDAO");

	public List<EmployeeInfoBean> getAllEmployeeInfo() {
		String query = "select * from employee_info";
		String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db";

		try (Connection con = DriverManager.getConnection(dbUrl, "root", "admin");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			List<EmployeeInfoBean> beans = new ArrayList<EmployeeInfoBean>();
			while (rs.next()) {
				EmployeeInfoBean bean = new EmployeeInfoBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setAge(rs.getInt("age"));
				bean.setGender(rs.getString("gender"));
				bean.setAccountNumber(rs.getLong("account_number"));

				beans.add(bean);
			}
			return beans;
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public EmployeeInfoBean getEmployeeInfo(String id) {
		EmployeeInfoBean bean = null;
		try {
			bean = getEmployeeInfo(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public EmployeeInfoBean getEmployeeInfo(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db";

			con = DriverManager.getConnection(dbUrl, "root", "admin");

			String query = "select * from employee_info where id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			EmployeeInfoBean bean = new EmployeeInfoBean();
			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setAge(rs.getInt("age"));
				bean.setGender(rs.getString("gender"));
				bean.setAccountNumber(rs.getLong("account_number"));
			}
			return bean;
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
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
