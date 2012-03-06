package edu.clark.ctec.cse224.hw7.b_longbons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// grumble about reinventing std::chrono::time_point
public class TickDate implements Comparable<TickDate> {
	private static final DateFormat formatter = new SimpleDateFormat("MMMM dd");
	static {
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	private static Date date;
	private static TickDate currentDate;
	
	public TickDate() { this(0L); }
	public TickDate(long days) {
		date = new Date(days * 86400 * 1000);
	}

	@Override
	public int compareTo(TickDate o) {
		return getDate().compareTo(o.getDate());
	}
	
	@Override
	public String toString() {
		return formatter.format(getDate());
	}
	public TickDate plus(int i) {
		return new TickDate(get() + i);
	}
	long get() {
		return getDate().getTime() / (86400 * 1000);
	}
	public static Date getDate() {
		return date;
	}
	
	public static TickDate getCurrentDate() {
		return TickDate.currentDate;
	}
	public static void setCurrentDate(TickDate currentDate) {
		TickDate.currentDate = currentDate;
	}
}
