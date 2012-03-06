package edu.clark.ctec.cse224.hw7.b_longbons;

import java.awt.Color;


public class Grass extends MapObject {
	private EventQueue.Event death;
	private EventQueue.Event spread;
	protected boolean isAlive;
	protected long timesEaten;

	public Grass(Point point) {
		super(point);
		Main.map.add(this);
	}
	
	@Override
	Color get_color() {
		return Color.GREEN;
	}
	
	void init(TickDate tick) {
		
		death = Main.queue.schedule(tick.plus(Main.random.fuzz(8*30)), new Runnable() {
			@Override
			public void run() {
				kill();
			}
		});
		
		spread = Main.queue.schedule(tick.plus(Main.random.fuzz(2*30)), new Runnable() {
			@Override
			public void run() {
				spread();
			}
		});
	}
	
	void kill() {
		death.cancel();
		Main.map.remove(this);
	}
	
	public void spread(){
		spread.cancel();
		for(int ix = 0; ix < 5; ix++){
			spawnGrass();
		}
	}
	
	void spawnGrass(){
		//new Grass(new Point(Main.random.nextInt(16000)-8000, Main.random.nextInt(16000)-8000)).init(new TickDate(TickDate.this.get()));
	}
}
