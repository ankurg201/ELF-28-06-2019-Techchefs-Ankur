package com.techchefs.common;

public class Test {

	public static void main(String[] args) {

		DriverManager.getConnection(args[0]).printMsg();
	}
}
