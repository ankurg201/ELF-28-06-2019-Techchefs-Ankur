package com.techchefs.topper;

public class Student {

	private int marks;
	private String gender;

	public Student(int marks, String gender) {
		this.marks = marks;
		this.gender = gender;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
