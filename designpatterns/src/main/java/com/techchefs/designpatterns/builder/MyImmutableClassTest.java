package com.techchefs.designpatterns.builder;

import java.util.logging.Logger;

public class MyImmutableClassTest {
	private static final Logger LOGGER = Logger.getLogger("MyImmutableClassTest");

	public static void main(String[] args) {
		
		MyImmutableClass immutableClass = new MyImmutableClass("abc", 16, 987654);
		LOGGER.info(immutableClass.getName());
		
		EmployeeData data1 = new EmployeeData(1, "ank", 23);
		LOGGER.info(data1.toString());
		
		EmployeeData2 data2 = new EmployeeData2
				.EmployeeData2Builder()
				.id(123)
				.name("ank")
				.age(23)
				.build();
		
		LOGGER.info(data2.toString());
	}
}
