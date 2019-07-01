package com.techchefs.functional;

public class TestH {
	static void sum(int a, int b) {
		int c= a+b;
		System.out.println("sum is :"+c);
	}
	
	public static void main(String[] args) {
		MyMath myMath = TestH :: sum;
	}
}
