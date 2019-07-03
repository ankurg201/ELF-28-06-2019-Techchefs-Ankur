package com.techchefs.pool;

import static com.techchefs.pool.ConnectionPoolConstants.DB_URL;
import static com.techchefs.pool.ConnectionPoolConstants.PASSWORD;
import static com.techchefs.pool.ConnectionPoolConstants.POOL_SIZE;
import static com.techchefs.pool.ConnectionPoolConstants.USER_NM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {

	private int poolSize;
	private String dbUrl;
	private String userNM;
	private String password;

	private Vector<Connection> pool;
	private static ConnectionPool poolRef = null;

	public static ConnectionPool getConnectionPool() throws Exception {
		if (poolRef == null) {
			poolRef = new ConnectionPool();
		}
		return poolRef;
	}

	private ConnectionPool() throws Exception {
		loadProperties();
		initilizePool();
	}

	private void initilizePool() throws Exception {
		pool = new Vector<Connection>();
		Connection con = null;

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		for (int i = 0; i < poolSize; i++) {
			con = DriverManager.getConnection(dbUrl, userNM, password);
			pool.add(con);
		}
	}

	private void loadProperties() throws Exception {
		poolSize = Integer.parseInt(PropertiesUtil.getPropertiesUtil().getProperty(POOL_SIZE));
		dbUrl = PropertiesUtil.getPropertiesUtil().getProperty(DB_URL);
		userNM = PropertiesUtil.getPropertiesUtil().getProperty(USER_NM);
		password = PropertiesUtil.getPropertiesUtil().getProperty(PASSWORD);
	}

	public Connection getConnectionFromPool() {
		return pool.remove(0);
	}

	public void returnConnectionToPool(Connection con) {
		pool.add(con);
	}
}
