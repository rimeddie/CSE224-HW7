package edu.clark.ctec.cse224.hw7.b_longbons;

import java.util.PriorityQueue;

public class EventQueue {
	
	public static class Event implements Comparable<Event> {
		private Runnable runnable;
		private final TickDate tick;

		private Event(TickDate tick, Runnable runnable) {
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

	public Event schedule(TickDate tick, Runnable runnable) {
		Event e = new Event(tick, runnable);
		events.add(e);
		return e;
	}

	public boolean empty() {
		return events.isEmpty();
	}

	public void dispatch_through(TickDate when) {
		while (true) {
			Event e = events.peek();
			if (e == null)
				return;
			if (e.tick.compareTo(when) > 0)
				return;
			events.poll(); // returns e again
			if (e.runnable == null)
				continue;
			e.runnable.run();
		}
	}
	
	TickDate next_event_tick() {
		Event e = events.peek();
		if (e == null)
			return null;
		return e.tick;
	}
}
