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
		final Grass g = new Grass(new Point(0, 0));
		map.add(g);
		queue.schedule(new Days(0), new Runnable() {
			
			@Override
			public void run() {
				map.remove(g);
			}
		});
		GUI.createAndShowGui();
	}
}
