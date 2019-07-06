package com.techchefs.immutable;

import java.util.logging.Logger;

public class MyImmutableClassTest {
	private static final Logger LOGGER = Logger.getLogger("MyImmutableClassTest");

	public static void main(String[] args) {
		
		MyImmutableClass immutableClass = new MyImmutableClass("abc", 16, 987654);
		LOGGER.info(immutableClass.getName());
	}
}
