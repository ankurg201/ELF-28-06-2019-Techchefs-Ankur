package com.techchefs.simpleinterest;

@FunctionalInterface
public interface SimpleInterest {

	double calculate(double principal, double rate, int time); 
	
}
