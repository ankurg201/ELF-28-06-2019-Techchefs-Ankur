package com.techchefs.message;

import java.util.Comparator;

public class MessageByDate implements Comparator<Message> {

	@Override
	public int compare(Message o1, Message o2) {

		if (o1.getDate().after(o2.getDate())) {
			return 1;
		} else if (o1.getDate().before(o2.getDate())) {
			return -1;
		} else {
			return 0;
		}
	}
}
