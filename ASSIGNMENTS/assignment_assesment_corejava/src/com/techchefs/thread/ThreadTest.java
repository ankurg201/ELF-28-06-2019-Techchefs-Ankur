package com.techchefs.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		executorService.execute(new MyRunnable());
		
		executorService.shutdown();
	}
}
