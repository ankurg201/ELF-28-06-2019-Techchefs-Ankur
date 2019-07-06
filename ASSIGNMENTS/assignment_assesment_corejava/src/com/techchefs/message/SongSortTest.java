package com.techchefs.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SongSortTest {
	private static final Logger LOGGER = Logger.getLogger("SongSortTest");

	public static void main(String[] args) {
		
		final Message s1 = new Message();
		s1.setMessageId(1);
		s1.setMessageName("abc1");
		s1.setDate(new Date(System.currentTimeMillis()-50000000));
		final Message s2 = new Message();
		s2.setMessageId(2);
		s2.setMessageName("abc2");
		s2.setDate(new Date(System.currentTimeMillis()-10000000));
		final Message s3 = new Message();
		s3.setMessageId(3);
		s3.setMessageName("abc3");
		s3.setDate(new Date(System.currentTimeMillis()-1000000000));
		final Message s4 = new Message();
		s4.setMessageId(4);
		s4.setMessageName("abc4");
		s4.setDate(new Date(System.currentTimeMillis()-2000000));
		
		final List<Message> messageList = new ArrayList<Message>();
		messageList.add(s1);
		messageList.add(s2);
		messageList.add(s3);
		messageList.add(s4);
		
		LOGGER.log(Level.INFO, "before sorting by date");
		LOGGER.log(Level.INFO, messageList.toString());
		SortMessageByDate(messageList);
		
		LOGGER.log(Level.INFO, "after sorting by date");
		LOGGER.log(Level.INFO, messageList.toString());
	}
	
	/**
	 * 
	 * sort song based on date.
	 * 
	 * @param songList the list
	 * @return list, the list
	 */
	private static List<Message> SortMessageByDate(final List<Message> messageList){
		
		messageList.sort(new MessageByDate());
		
		return messageList;
	}
}
