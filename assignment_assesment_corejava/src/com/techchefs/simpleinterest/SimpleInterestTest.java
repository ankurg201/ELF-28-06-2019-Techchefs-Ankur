package com.techchefs.simpleinterest;

import java.util.logging.Logger;

public class SimpleInterestTest {
	private static final Logger LOGGER = Logger.getLogger("SimpleInterestTest");

	public static void main(String[] args) {

		double principal = 5000;
		double rate = 6;
		int time = 2;

		SimpleInterest simpleInterest = (double p, double r, int t) -> (principal * rate * time) / 100;

		double interest = simpleInterest.calculate(principal, rate, time);

		LOGGER.info(String.valueOf(interest));
	}
}
