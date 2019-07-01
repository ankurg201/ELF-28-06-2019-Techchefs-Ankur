package com.techchefs.object;

import java.util.logging.Logger;

public class TestB {
	
	private static final Logger LOGGER = Logger.getLogger("TestB");

	public static void main(String[] args) {
		
		
		Runnable x = () -> {
			for(int i = 0;i<5;i++) {
				LOGGER.info(i+" ");
			}
		};
		
		Thread t = new Thread(x);
		t.start();
		
		Thread t2 = new Thread(x);
		t2.start();
	}
}
