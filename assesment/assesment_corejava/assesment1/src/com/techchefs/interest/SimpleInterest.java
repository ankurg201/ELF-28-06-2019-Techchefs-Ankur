package com.techchefs.interest;

/**
 * simple interest.
 * 
 * @author ankur
 *
 */
public class SimpleInterest {

	public Integer getSimpleInterest(final int principal, final int rate, final int time) {

		return (principal * rate * time) / 100;
	}

	public Integer getFactorial(final int number) {

		int factorial = 1;
		for (int i = number; i > 0; i--) {
			factorial = factorial * i;
		}
		return factorial;
	}

	public Integer getPercentage(final int v1, final int v2) {

		return (100 * v2) / v1;
	}
}
