package com.techchefs.studentpredicate;

public class Student {

	private int percentage;
	private String gender;

	public Student(int percentage, String gender) {
		this.percentage = percentage;
		this.gender = gender;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
