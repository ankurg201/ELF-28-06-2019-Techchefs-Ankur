package com.techchefs.interest;

import org.junit.jupiter.api.Test;

/**
 * simpleinterestTest cases junit.
 * 
 * @author ankur
 *
 */
public class SimpleInterestTest {

	@Test
	public void getSimpleInterestTest() {
		final SimpleInterest si = new SimpleInterest();
		final Integer interest = si.getSimpleInterest(2000, 6, 2);
		
		assert interest == 240;
	}
	
	@Test
	public void getFactorialTest() {
		final SimpleInterest si = new SimpleInterest();
		final Integer factorial = si.getFactorial(5);
		
		assert factorial == 120;
	}
	
	@Test
	public void getPercentageTestSuccess() {
		final SimpleInterest si = new SimpleInterest();
		final Integer percentage = si.getPercentage(20, 5);
		
		assert percentage == 25;
	}
}
