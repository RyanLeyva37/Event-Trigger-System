package ryanleyva37.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ryanleyva37.event.EventKeyPress;

public class Test_EventKeyPress {

	@Test
	public void testConstructor() {
		EventKeyPress e = new EventKeyPress(25);
		assertEquals(25, e.getKey());
	}

}
