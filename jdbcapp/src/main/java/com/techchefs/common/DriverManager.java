package com.techchefs.common;

public class DriverManager {
	
	private DriverManager driverManager;
	
	public static Connection getConnection(String str) {
		Connection ref;
		if(str.equals("ONE")) {
			ref = new A();  
		} else {
			ref = new B(); 
		}
		return ref;
	}
}
