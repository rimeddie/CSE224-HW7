package edu.clark.ctec.cse224.hw7.b_longbons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// grumble about reinventing std::chrono::time_point
public class Days implements Comparable<Days> {
	private static final DateFormat formatter = new SimpleDateFormat("MMMM dd");
	static {
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	private final Date date = new Date();
	
	public Days() {}
	public Days(long days) {
		date.setTime(days * 86400 * 1000);
	}

	@Override
	public int compareTo(Days o) {
		return date.compareTo(o.date);
	}
	
	@Override
	public String toString() {
		return formatter.format(date);
	}
}
