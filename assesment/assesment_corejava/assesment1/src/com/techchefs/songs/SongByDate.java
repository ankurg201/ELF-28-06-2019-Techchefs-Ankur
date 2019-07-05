package com.techchefs.songs;

import java.util.Comparator;

public class SongByDate implements Comparator<Song> {

	@Override
	public int compare(Song o1, Song o2) {

		if (o1.getDate().after(o2.getDate())) {
			return 1;
		} else if (o1.getDate().before(o2.getDate())) {
			return -1;
		} else {
			return 0;
		}
	}
}
