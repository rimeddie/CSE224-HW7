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
		TickDate.setCurrentDate(new TickDate());
		for(int ix = 0; ix<5; ix++){
		new Grass(new Point(random.nextInt(16000)-8000, random.nextInt(16000)-8000)).init(new TickDate());
		new Rabbit(new Point(random.nextInt(16000)-8000, random.nextInt(16000)-8000));
		new Fox(new Point(random.nextInt(16000)-8000, random.nextInt(16000)-8000));
		}
		GUI.createAndShowGui();
	}
}
