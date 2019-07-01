package com.techchefs.enums;

import java.util.logging.Logger;

public class TestA {
	
	private static final Logger LOGGER = Logger.getLogger("TestA");
	
	public static void main(String[] args) {
		LOGGER.info(Gender.MALE + " " + Gender.MALE.ordinal());
		LOGGER.info(Gender.FEMALE + " " + Gender.FEMALE.ordinal());
	}
}
