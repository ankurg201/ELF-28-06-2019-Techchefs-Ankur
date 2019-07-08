package com.techchefs.designpatterns.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@Getter
//@AllArgsConstructor
public final class MyImmutableClass {

	private String name;
	private int age;
	private int phone;
	
	public MyImmutableClass(String name, int age, int phone) {
		this.name=name;
		this.age=age;
		this.phone=phone;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getPhone() {
		return phone;
	}
}
