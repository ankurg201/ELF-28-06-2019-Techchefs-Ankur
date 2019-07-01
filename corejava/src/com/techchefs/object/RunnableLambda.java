package com.techchefs.object;

import java.util.logging.Logger;

public class RunnableLambda implements Runnable{
	
	private static final Logger LOGGER = Logger.getLogger("RunnableLambda");

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			LOGGER.info(i+" ");
		}
	}
}
