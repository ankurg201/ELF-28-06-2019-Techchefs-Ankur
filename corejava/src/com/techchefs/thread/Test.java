package com.techchefs.thread;

public class Test {
	public static void main(String[] args) {
		PVR ref = new PVR();
		
		Browser t1 = new Browser(ref);
		t1.start();
		
		Browser t2 = new Browser(ref);
		t2.start();
		
		Browser t3 = new Browser(ref);
		t3.start();
	}
}
