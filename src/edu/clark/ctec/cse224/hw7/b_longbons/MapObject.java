package edu.clark.ctec.cse224.hw7.b_longbons;

import java.awt.Color;

public abstract class MapObject {
	Point location;
	public MapObject(Point point) {
		this.location = point;
	}
	abstract Color get_color();
}
