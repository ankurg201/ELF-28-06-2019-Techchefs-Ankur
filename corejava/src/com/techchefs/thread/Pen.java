package com.techchefs.thread;

import java.util.logging.Logger;

public class Pen extends Thread {
	
	static Logger log = Logger.getLogger("Pen");

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
		    log.info(this.getName()+" "+i);

			try {
				this.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("main start");
		Pen t1 = new Pen();
		t1.setName("Myname");
		t1.start();
		
		Pen t2 = new Pen();
		t2.setName("chinnu");
		t2.start();
		
		System.out.println("Main end");
	}
}
