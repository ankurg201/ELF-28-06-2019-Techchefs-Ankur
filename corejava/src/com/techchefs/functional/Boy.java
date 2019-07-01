package com.techchefs.functional;

public class Boy {
	
	String name;
	int age;
	int height;
	
	Boy(String name, int age, int height){
		System.out.println("constructor");
		this.age = age;
		this.name = name;
		this.height = height;
	}
}
