package com.techchefs.singleton;

public class CustomSingleton {
	
	private static CustomSingleton customSingleton = null;

	private CustomSingleton() {

	}

	public  static CustomSingleton getObject() {
		
		Object mutex = new Object();
		
		if(customSingleton == null) {
			
			synchronized (mutex) {
				if(customSingleton == null) {
					customSingleton = new CustomSingleton();
				}
			}
		}
		return customSingleton;
	}
}
