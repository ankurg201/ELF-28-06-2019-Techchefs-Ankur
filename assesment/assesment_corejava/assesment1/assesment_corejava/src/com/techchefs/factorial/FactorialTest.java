package com.techchefs.factorial;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FactorialTest {
	private static final Logger LOGGER = Logger.getLogger("FactorialTest");

	public static void main(String[] args) {

		final int number = 5;
		int factorial = 1;
		for (int i = number; i > 0; i--) {
			factorial = factorial * i;
		}
		
		LOGGER.log(Level.INFO, String.valueOf(factorial));
	}

}
