package com.techchefs.message;

import java.util.Date;

/**
 * song information.
 * 
 * @author ankur
 *
 */
public class Message {

	private Integer messageId;
	
	private String messageName;
	
	private Date date;
	
	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}
}
