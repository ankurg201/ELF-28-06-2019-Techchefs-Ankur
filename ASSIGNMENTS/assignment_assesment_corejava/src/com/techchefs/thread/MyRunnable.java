package com.techchefs.thread;

import java.util.logging.Logger;

public class MyRunnable implements Runnable{
	
	private static final Logger LOGGER = Logger.getLogger("MyRunnable");
	@Override
	public void run() {
		for(int i = 0;i<10;i++) {
			LOGGER.info(Thread.currentThread().getName()+"  "+String.valueOf(i));
		}
	}

}
