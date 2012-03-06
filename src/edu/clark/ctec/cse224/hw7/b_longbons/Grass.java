package edu.clark.ctec.cse224.hw7.b_longbons;

import java.awt.Color;

public class Grass extends MapObject {
	private EventQueue.Event death;

	public Grass(Point point) {
		super(point);
	}
	
	@Override
	Color get_color() {
		return Color.GREEN;
	}
	
	void init(TickDate tick) {
		Main.map.add(this);
		death = Main.queue.schedule(tick.plus(Main.random.fuzz(8*30)), new Runnable() {
			@Override
			public void run() {
				kill();
			}
		});
	}
	
	void kill() {
		death.cancel();
		Main.map.remove(this);
	}
}
