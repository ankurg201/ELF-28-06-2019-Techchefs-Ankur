package com.techchefs.topper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Test {

	private static final Logger LOGGER = Logger.getLogger("Test");

	public static void main(String[] args) {

		List<Student> list = new ArrayList<Student>();

		list.add(new Student(70, "female"));
		list.add(new Student(80, "male"));
		list.add(new Student(40, "female"));
		list.add(new Student(90, "male"));

		LOGGER.info(list.stream().filter(student -> student.getGender().equalsIgnoreCase("female"))
				.mapToInt(s -> s.getPercentage()).max().toString());

		LOGGER.info(list.stream().filter(student -> student.getGender().equalsIgnoreCase("male"))
				.mapToInt(s -> s.getPercentage()).max().toString());
	}
}
