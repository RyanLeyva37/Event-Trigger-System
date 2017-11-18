package ryanleyva37.event;

public @interface Handler {
	
	public boolean enabled() default true;
	
}
