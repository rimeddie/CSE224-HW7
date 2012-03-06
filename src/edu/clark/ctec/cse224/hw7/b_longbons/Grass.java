package edu.clark.ctec.cse224.hw7.b_longbons;

import java.awt.Color;

public class Grass extends MapObject {
	public Grass(Point point) {
		super(point);
	}

	@Override
	Color get_color() {
		return Color.GREEN;
	}
}
