package com.techchefs.sound;

import java.util.logging.Logger;

public class Test {
	
	private static final Logger LOGGER = Logger.getLogger("Test");
	
	public static void main(String[] args) {
		
		animalSound(new Dog());
		
		animalSound(new Lion());
		
	}
	
	private static void animalSound(Animal animal) {
		LOGGER.info(animal.Sound());
	}
}
