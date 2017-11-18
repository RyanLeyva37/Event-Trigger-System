package ryanleyva37.event.system;

public @interface Handler {
	
	public boolean enabled() default true;
	
}
