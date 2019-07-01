package com.techchefs.functional;

public class Testk {

	public static void main(String[] args) {
		BoyFactroy b = Boy::new;

		Boy boy = b.getBoy("ankur", 29, 5);
		
		System.out.println(boy.age);
	}
}
