package com.techchefs.functional;

public class Test1 {
	
	public static void main(String[] args) {
		MyStudent std = new MyStudent();
		
		Average avg = std :: calculateAvg;
		
		avg.avg(21, 16, 19);
	}
}
