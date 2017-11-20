package ryanleyva37.event;

public class EventKeyPress extends Event {
	
	private int key;
	
	public EventKeyPress( int key ) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}

}
