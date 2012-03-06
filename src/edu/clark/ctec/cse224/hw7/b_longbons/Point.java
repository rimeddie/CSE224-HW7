package edu.clark.ctec.cse224.hw7.b_longbons;

public class Point {
	final int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Point && equals_impl((Point)obj);
	}
	
	private boolean equals_impl(Point obj) {
		return this.x == obj.x && this.y == obj.y;
	}

	@Override
	public int hashCode() {
		return Long.valueOf((((long)x) << 32) | (y & 0xFFFFFFFF)).hashCode();
	}
}
