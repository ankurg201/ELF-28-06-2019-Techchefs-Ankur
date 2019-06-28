package com.techchefs.songs;

import java.util.Date;

/**
 * song information.
 * 
 * @author Administrator
 *
 */
public class Song {

	private Integer songId;
	
	private String songName;
	
	private Date date;

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(final Integer songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(final String songName) {
		this.songName = songName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}
}
