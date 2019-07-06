package com.techchefs.passedfemale;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.techchefs.topper.Student;

public class Test {

	private static final Logger LOGGER = Logger.getLogger("Test");

	public static void main(String[] args) {

		List<Student> list = new ArrayList<Student>();

		list.add(new Student(70, "female"));
		list.add(new Student(80, "male"));
		list.add(new Student(20, "female"));
		list.add(new Student(40, "female"));
		list.add(new Student(90, "male"));

		LOGGER.info(String.valueOf(list.stream()
				.filter(student -> student.getGender().equalsIgnoreCase("female") && student.getPercentage() > 30)
				.count()));
	}
}
