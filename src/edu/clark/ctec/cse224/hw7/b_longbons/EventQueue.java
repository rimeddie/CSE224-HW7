package edu.clark.ctec.cse224.hw7.b_longbons;

import java.util.PriorityQueue;

public class EventQueue {
	// TODO: The GUI (once implemented) should read this
	// or should we instead change dispatch() to call all events
	// until it reaches the specified tick?
	Days last_tick = new Days();
	
	public static class Event implements Comparable<Event> {
		private Runnable runnable;
		private final Days tick;

		private Event(Days tick, Runnable runnable) {
			this.tick = tick;
			this.runnable = runnable;
		}

		public void cancel() {
			this.runnable = null;
		}

		@Override
		public int compareTo(Event o) {
			return tick.compareTo(o.tick);
		}
	}

	private final PriorityQueue<Event> events = new PriorityQueue<Event>(); 

	public Event schedule(Days tick, Runnable runnable) {
		Event e = new Event(tick, runnable);
		events.add(e);
		return e;
	}

	public boolean empty() {
		return events.isEmpty();
	}

	private Runnable pop() {
		Event e = events.poll();
		if (e == null)
			return null;
		// Should this be conditional or not? But see comment above.
		// if (e.runnable != null)
			last_tick = e.tick;
		return e.runnable; // may also be null
	}

	public void dispatch() {
		Runnable runnable = pop();
		if (runnable != null)
			runnable.run();
	}

}
