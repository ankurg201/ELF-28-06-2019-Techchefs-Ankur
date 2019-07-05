package com.techchefs.objectequality;

import java.util.logging.Logger;

import com.techchefs.product.Product;

public class ObjectEqualityTest {
	private static final Logger LOGGER = Logger.getLogger("ObjectEqualityTest");

	public static void main(String[] args) {
		
		Product p1 = new Product("sony bravia", "TV", 20000.00F);
		Product p2 = new Product("micromax action", "TV", 15000.00F);
		Product p3 = new Product("sony bravia", "TV", 20000.00F);
		
		LOGGER.info(String.valueOf(p1.equals(p3)));
	}
}
