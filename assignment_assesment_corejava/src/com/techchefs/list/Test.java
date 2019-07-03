package com.techchefs.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

public class Test {
	
	private static final Logger LOGGER = Logger.getLogger("Test");

	public static void main(String[] args) {
		
		List<Integer> list = getList("vector");
		
		LOGGER.info(list.getClass().toString());
	}
	
	private static List<Integer> getList(final String type) {
		
		List<Integer> list = null;
		if(type.equalsIgnoreCase("arraylist")) {
			list = new ArrayList<Integer>();
		}else if(type.equalsIgnoreCase("vector")) {
			list = new Vector<Integer>();
		}else if(type.equalsIgnoreCase("linkedlist")) {
			list = new LinkedList<Integer>();
		}
		return list;
	}
}
