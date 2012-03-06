package edu.clark.ctec.cse224.hw7.b_longbons;

import java.util.HashSet;

/*
 * http://piratepad.net/ioOBuYb7Es
 */
public class Main {
	static final Random random = new Random();
	static final EventQueue queue = new EventQueue();
	static final HashSet<MapObject> map = new HashSet<MapObject>();

	public static void main(String[] args) {
		// initially spawn animals before swing gets started.
		for (int i=0; i<15; i++)
			new Grass(new Point(random.nextInt(16000)-8000, random.nextInt(16000)-8000)).init(new TickDate());
		GUI.createAndShowGui();
	}
}
