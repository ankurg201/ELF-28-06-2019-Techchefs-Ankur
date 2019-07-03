package com.techchefs.countobject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Test {

	private static final Logger LOGGER = Logger.getLogger("Test");

	public static void main(String[] args) {

		List<Animal> list = new ArrayList<Animal>();
		list.add(new Dog());
		list.add(new Lion());
		list.add(new Dog());
		list.add(new Lion());
		list.add(new Dog());

		int dogCount = 0;
		int lionCount = 0;

		for (Animal animal : list) {
			if (animal instanceof Dog) {
				dogCount++;
			} else if (animal instanceof Lion) {
				lionCount++;
			}
		}

		LOGGER.info("dog count = " + dogCount + "  lion count = " + lionCount);

	}
}
