package edu.clark.ctec.cse224.hw7.b_longbons;

import java.awt.Color;

public class Fox extends MapObject {

	private EventQueue.Event move;
	
	public Fox(Point point) {
		super(point);
		Main.map.add(this);
		move = Main.queue.schedule(TickDate.getCurrentDate().plus(Main.random.fuzz(1)), new Runnable() {
			@Override
			public void run() {
				move();
				
			}
		});
	}

	@Override
	Color get_color() {
		return Color.ORANGE;
	}
	
	private void move() {
		move.cancel();
		this.location.x = this.location.x + Main.random.nextInt(11) - 5;
		this.location.y = this.location.y + Main.random.nextInt(11) - 5;
		/*move = Main.queue.schedule(TickDate.getCurrentDate().plus(Main.random.fuzz(1)), new Runnable() {
			
			@Override
			public void run() {
				move();
				
			}
		});*/
	}
}
