package ryanleyva37.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ryanleyva37.event.Event;

public class Test_Event {

	@Test
	public void testSetCancled() {
		Event e = new Event();
		e.setCancled(true);
		assertEquals(true, e.isCancled());
	}

}
