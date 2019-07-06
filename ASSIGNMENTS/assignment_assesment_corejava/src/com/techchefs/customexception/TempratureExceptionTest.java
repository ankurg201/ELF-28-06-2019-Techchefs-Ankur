package com.techchefs.customexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TempratureExceptionTest.
 * 
 * @author ankur
 *
 */
public class TempratureExceptionTest {

	private static final Logger LOGGER = Logger.getLogger("TempratureExceptionTest");

	public static void main(String[] args) {
		int serverRoomTemp = 25;
		try {
			validateServerRoomTemp(serverRoomTemp);

			LOGGER.log(Level.INFO, "server room tempraure below 18");
		} catch (TempratureException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
	}

	/**
	 * validating the temperature if it is more than 18 then raise exception.
	 * 
	 * @param serverRoomTemp
	 * @throws TempratureException
	 */
	private static void validateServerRoomTemp(int serverRoomTemp) throws TempratureException {

		if (serverRoomTemp > 18) {
			throw new TempratureException("Server Room Temprature is more than 18 centigrate");
		}
	}
}
