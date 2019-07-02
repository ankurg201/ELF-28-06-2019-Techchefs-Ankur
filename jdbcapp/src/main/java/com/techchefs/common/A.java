package com.techchefs.common;

import java.util.logging.Logger;

public class A implements Connection {

	private static final Logger LOGGER = Logger.getLogger("A");

	@Override
	public void printMsg() {
		LOGGER.info("AAA");
	}

}
