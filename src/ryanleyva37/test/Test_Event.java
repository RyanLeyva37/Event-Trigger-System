package ryanleyva37.event;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_Event {

	@Test
	public void testSetCancled() {
		Event e = new Event();
		e.setCancled(true);
		assertEquals(true, e.isCancled());
	}

}
