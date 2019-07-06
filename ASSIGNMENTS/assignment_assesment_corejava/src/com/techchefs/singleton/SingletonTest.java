package com.techchefs.singleton;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonTest {

	private static final Logger LOGGER = Logger.getLogger("SingletonTest");

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			CustomSingleton customSingleton = CustomSingleton.getObject();

			LOGGER.log(Level.INFO, customSingleton.toString());
		}
	}
}
