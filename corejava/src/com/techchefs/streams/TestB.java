package com.techchefs.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TestB {
	private static final Logger LOGGER = Logger.getLogger("TestB");

	public static void main(String[] args) {

		List<Integer> al = new ArrayList<Integer>(Arrays.asList(5, 6, 4, 3, 2));

		long x = al.stream().filter(i -> i % 2 == 0).count();
		
		LOGGER.info(String.valueOf(x));
		
		Comparator<Integer> c = (i,j) -> i.compareTo(j) * -1;
		
		LOGGER.info(al.stream().sorted(c).collect(Collectors.toList()).toString());
	}
}
