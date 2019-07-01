package com.techchefs.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TestA {
	private static final Logger LOGGER = Logger.getLogger("TestA");
	
	public static void main(String[] args) {
		
		List<Integer> al = new ArrayList<Integer>(Arrays.asList(2,6,4,9,6,4));
		
		List<Integer> x = al.stream().filter(i -> i %2 == 0).collect(Collectors.toList());
		
		List<Integer> y = al.stream().map(i -> i * i).collect(Collectors.toList());
		
		LOGGER.info(x.toString());
		LOGGER.info(y.toString());
		System.out.println("hello \"techchefs\" !!!");
	}
}