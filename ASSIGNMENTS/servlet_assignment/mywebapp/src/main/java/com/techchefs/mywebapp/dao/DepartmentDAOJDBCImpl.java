package com.techchefs.mywebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.techchefs.mywebapp.beans.DepartmentInfoBean;
import com.techchefs.mywebapp.beans.EmployeeInfoBean;

public class DepartmentDAOJDBCImpl implements DepartmentDAO{
	private static final Logger LOGGER = Logger.getLogger("EmployeeDAO");

	public List<DepartmentInfoBean> getAllDepartmentInfo() {
		String query = "select * from department_info";
		String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db";

		try (Connection con = DriverManager.getConnection(dbUrl, "root", "admin");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			List<DepartmentInfoBean> beans = new ArrayList<DepartmentInfoBean>();
			while (rs.next()) {
				DepartmentInfoBean bean = new DepartmentInfoBean();
				bean.setDeptId(rs.getInt("id"));
				bean.setDeptName(rs.getString("name"));
				beans.add(bean);
			}
			return beans;
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public DepartmentInfoBean getDepartmentInfo(String id) {
		DepartmentInfoBean bean = null;
		try {
			bean = getDepartmentInfo(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public DepartmentInfoBean getDepartmentInfo(int id) {
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

			DepartmentInfoBean bean = new DepartmentInfoBean();
			while (rs.next()) {
				bean.setDeptId(rs.getInt("id"));
				bean.setDeptName(rs.getString("name"));
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

	@Override
	public boolean createDepartmentInfo(DepartmentInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDepartmentInfo(DepartmentInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDepartmentInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDepartmentInfo(String id) {
		// TODO Auto-generated method stub
		return false;
	}
}
