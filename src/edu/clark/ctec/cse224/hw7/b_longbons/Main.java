package edu.clark.ctec.cse224.hw7.b_longbons;

/*
 * http://piratepad.net/ioOBuYb7Es
 */
public class Main {
	static final Random random = new Random();
	static final EventQueue queue = new EventQueue();

	public static void main(String[] args) {
		GUI.createAndShowGui();
		EventQueue.Event evt = queue.schedule(new Days(1L), new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello, World!");
			}
		});
		queue.schedule(new Days(2L), new Runnable() {
			@Override
			public void run() {
				System.out.println("World!");
			}
		});
		queue.schedule(new Days(0L), new Runnable() {
			@Override
			public void run() {
				System.out.print("Hello, ");
			}
		});
		evt.cancel();

		// in the real world, probably forever
		while (!queue.empty()) {
			queue.dispatch();
			System.err.println("(" + queue.last_tick + ")");
		}
	}
}
