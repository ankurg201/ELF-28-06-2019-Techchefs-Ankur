package com.techchefs.object;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.logging.Logger;

public class TestA {
	
	private static final Logger LOGGER = Logger.getLogger("TestA");

	public static void main(String[] args) {
		
		Employee employee1 = new Employee(1L, "ankur");
		Employee employee2 = new Employee(2L, "rahul");
		Employee employee3 = new Employee(3L, "arvind");
		Employee employee4 = new Employee(4L, "Vikas");
		Employee employee5 = new Employee(5L, "rohit");
		
		Comparator<Employee> c = (e,f) -> {
			if (e.getId() > f.getId()) {
				return 1;
			} else if (e.getId() < f.getId()) {
				return -1;
			} else {
				return 0;
			}
		};
		
		Comparator<Employee> c2 = (e,f) -> e.getName().compareTo(f.getName());
		
		TreeSet<Employee> ts = new TreeSet<Employee>();
		
		ts.add(employee1);
		ts.add(employee2);
		ts.add(employee3);
		ts.add(employee4);
		ts.add(employee5);
		
		for(Employee e : ts) {
			LOGGER.info(e.getId() + "  " +e.getName());
		}
	}
}
