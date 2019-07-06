package com.techchefs.snacks;

import java.util.logging.Logger;

public class Test {
	
	private static final Logger LOGGER = Logger.getLogger("Test");

	public static void main(String[] args) {
		
		Object obj = getSnack("kurkure");
		
		if(obj instanceof Kurkure) {
			Kurkure kurkure = (Kurkure) obj;
			LOGGER.info(kurkure.toString());
		}else if(obj instanceof Lays) {
			Lays lays = (Lays) obj;
			LOGGER.info(lays.toString());
		}
	}
	
	private static Object getSnack(String type) {
		
		Object obj = null;
		
		if(type == "kurkure") {
			obj = new Kurkure();
		}else if(type.equalsIgnoreCase("lays")) {
			obj = new Lays();
		}
		return obj;
	}
}
