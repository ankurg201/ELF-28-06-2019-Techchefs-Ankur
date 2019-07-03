package com.techchefs.topper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Test {
	
	private static final Logger LOGGER = Logger.getLogger("Test");

	public static void main(String[] args) {

		List<Student> list = new ArrayList<Student>();

		list.add(new Student(70, "female"));
		list.add(new Student(80, "male"));
		list.add(new Student(40, "female"));
		list.add(new Student(90, "male"));

		List<Student> femaleList = list.stream().filter(student -> student.getGender().equalsIgnoreCase("female")).collect(Collectors.toList());
		LOGGER.info(String.valueOf(femaleList.get(0).getMarks()));
		
		List<Student> maleList = list.stream().filter(student -> student.getGender().equalsIgnoreCase("male")).collect(Collectors.toList());
		LOGGER.info(String.valueOf(maleList.get(0).getMarks()));
	}
}
