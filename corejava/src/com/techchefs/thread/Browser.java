package com.techchefs.thread;

import java.util.logging.Logger;

public class Browser extends Thread {

	PVR ref;

	public Browser(PVR ref) {
		// TODO Auto-generated constructor stub
		this.ref = ref;
	}

	public void run() {
		ref.book();
	}

}
