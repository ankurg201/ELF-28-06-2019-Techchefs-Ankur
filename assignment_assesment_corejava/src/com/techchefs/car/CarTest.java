package com.techchefs.car;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CarTest {
	
	private static final Logger LOGGER = Logger.getLogger("CarTest");

	public static void main(String[] args) {
		
		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car("maruti 800", "Maruti"));
		carList.add(new Car("baleno", "suzuki"));
		carList.add(new Car("honda city", "honda"));
		carList.add(new Car("wagnor", "suzuki"));
		carList.add(new Car("ivtek", "honda"));
		
		List<Car> carByBrand = carList.stream().filter(c -> c.getBrand().equalsIgnoreCase("suzuki")).collect(Collectors.toList());
		
		carByBrand.stream().forEach(c -> {
			LOGGER.info(c.getBrand() + "  " + c.getName());
		});
	}

}
