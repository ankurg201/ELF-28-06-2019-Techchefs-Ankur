package com.techchefs.train;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The TrainTest.
 * 
 * @author ankur
 *
 */
public class TrainTest {
	private static final Logger LOGGER = Logger.getLogger("TrainTest");

	public static void main(String[] args) {

		int trainNo = 104;

		Train t1 = new Train();
		t1.setName("kalka exp");
		t1.setNumber(101);
		Train t2 = new Train();
		t2.setName("bangalore mail");
		t2.setNumber(102);
		Train t3 = new Train();
		t3.setName("karnatka exp");
		t3.setNumber(103);
		Train t4 = new Train();
		t4.setName("pune exp");
		t4.setNumber(104);

		final List<Train> trainList = new ArrayList<Train>();
		trainList.add(t1);
		trainList.add(t2);
		trainList.add(t3);
		trainList.add(t4);

		searchTrain(trainNo, trainList);

	}

	/**
	 * searchTrain will find train by trainno from trainlist and print train no and
	 * train name.
	 * 
	 * @param trainNo   the int
	 * @param trainList the list
	 */
	private static void searchTrain(final int trainNo, final List<Train> trainList) {

		trainList.stream().forEach(train -> {
			if (trainNo == train.getNumber()) {
				LOGGER.info(
						"found train with train number= " + train.getNumber() + " and train name= " + train.getName());
			}
		});
	}
}
