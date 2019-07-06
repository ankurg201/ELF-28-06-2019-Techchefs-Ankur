package com.techchefs.atm;

import java.util.logging.Logger;

public class AtmTest {
	
	private static final Logger LOGGER = Logger.getLogger("AtmTest");

	public static void main(String[] args) {
		
		AtmCard atmCard = new AtmCard();
		atmCard.setBankName("bank of baroda");
		
		insertIntoAtm(atmCard);
	}
	
	private static void insertIntoAtm(AtmCard atmCard) {
		LOGGER.info("bank name= "+ atmCard.getBankName());
	}
}
