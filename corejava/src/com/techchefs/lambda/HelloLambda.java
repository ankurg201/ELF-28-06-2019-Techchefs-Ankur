package com.techchefs.lambda;
import java.util.function.Function;
import java.util.function.Predicate;

public class HelloLambda {
	
	public static void main(String[] args) {
		
		int[] b = {2, 5, 9, 6, 4, 3};
		
		Predicate<Integer> k = a -> a % 2 != 0;
		
		for(int i=0; i<b.length; i++) {
			if(k.test(b[i])) {
				System.out.println(b[i]);
			}
		}
		
		Function<Double, Double> f = r->3.142*r*r;
		
		double x=f.apply(5.2);
		System.out.println(x);
		
		
		String str = "hi how are you";
		
		//Function<String, Integer> f1 = str  -> str.length();
	}
}
