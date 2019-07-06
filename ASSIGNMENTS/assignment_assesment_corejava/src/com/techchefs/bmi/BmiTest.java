package com.techchefs.bmi;

import java.util.Scanner;
import java.util.logging.Logger;

public class BmiTest {

	private static final Logger LOGGER = Logger.getLogger("BmiTest");

	public static void main(String[] args) {
		
		calculateBMI();
	}

	private static void calculateBMI() {
		Scanner scanner = new Scanner(System.in);
		LOGGER.info("Enter weight in Kilogram : ");
		float weight = scanner.nextFloat();
		LOGGER.info("Enter Height in Meters : ");
		float height = scanner.nextFloat();
		float bmi = (weight) / (height * height);
		// print the result
		printBMIResult(bmi);
	}

	private static void printBMIResult(float bmi) {
		String result = "";
		if (bmi < 18.5) {
			result = "underweight";
		} else if (bmi < 25) {
			result = "normal";
		} else if (bmi < 30) {
			result = "overweight";
		} else {
			result = "obese";
		}
		LOGGER.info("Your BMI is " + bmi + " and that means " + result);
	}
}
