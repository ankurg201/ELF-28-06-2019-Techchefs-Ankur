package com.techchefs.studentpredicate;

import java.util.function.Predicate;
import java.util.logging.Logger;

public class StudentTest {

	private static final Logger LOGGER = Logger.getLogger("StudentTest");

	public static void main(String[] args) {

		Student student = new Student(40, "male");

		Predicate<Integer> result = percentage -> (percentage > 30);

		LOGGER.info(String.valueOf(result.test(student.getPercentage())));
	}

}
