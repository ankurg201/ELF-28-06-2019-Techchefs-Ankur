package com.techchefs.objectcontent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.techchefs.product.Product;

public class ObjectContentTest {
	
	private static final Logger LOGGER = Logger.getLogger("ObjectContentTest");

	public static void main(String[] args) {
		
		List<Product> productList = new ArrayList<Product>();

		productList.add(new Product("sony bravia", "TV", 20000.00F));
		productList.add(new Product("micromax action", "TV", 15000.00F));
		productList.add(new Product("honor play", "mobile", 16000.00F));
		productList.add(new Product("k20 pro", "mobile", 20000.00F));
		productList.add(new Product("yamaha fzs", "bike", 110000.00F));

		productList.stream().forEach(p -> {
			LOGGER.info(p.getProductName() + "  " + p.getProductType()+ "  "+ p.getCost());
		});
	}

}
