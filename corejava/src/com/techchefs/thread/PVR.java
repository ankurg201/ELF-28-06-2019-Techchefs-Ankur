package com.techchefs.thread;

import java.util.logging.Logger;

public class PVR {

	private static Logger log = Logger.getLogger("PVR");

	synchronized void book() {
		for (int i = 0; i < 10; i++) {
			log.info(Thread.currentThread().getName() + "  " + String.valueOf(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
