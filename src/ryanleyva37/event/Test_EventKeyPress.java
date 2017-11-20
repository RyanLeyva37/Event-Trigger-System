package ryanleyva37.event;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_EventKeyPress {

	@Test
	public void testConstructor() {
		EventKeyPress e = new EventKeyPress(25);
		assertEquals(25, e.getKey());
	}

}
