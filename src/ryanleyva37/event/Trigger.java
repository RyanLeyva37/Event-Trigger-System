package ryanleyva37.event;


import java.util.ArrayList;
import java.util.HashMap;

import ryanleyva37.event.Event;
import ryanleyva37.event.system.Handler;
/**
 * @author Ryan Leyva
 * Code Coverage: 98.6%
 */
public class Trigger
{
    
	/** Static system name of trigger. */
    public final String SYSTEM_NAME;
    
    /** Used to pair trigger .class to instance created on startup. */
    private static HashMap<Class<?>, Trigger> triggers = new HashMap<Class<?>, Trigger>();
    
    /** Array of instances of triggers loaded in system. */
    private static ArrayList<Trigger> triggerList = new ArrayList<Trigger>();
    
    private Class<?> cls;

    /**
     * Initializes trigger with default values.
    */
    public Trigger( String systemName, Class<?> cls )
    {
        this.SYSTEM_NAME = systemName;
        this.cls = cls;
    }
    
    public Trigger registerTrigger(){
        triggers.put( cls, this );
        triggerList.add(this);
        return this;
    }
    
    public Trigger unRegisterTrigger(){
        triggers.remove(this.cls);
        triggerList.remove(this);
    	return this;
    }
    
    /**
     * Generic event method called when event is triggered
    */
    @Handler
    public void onEvent( Event event ) {}
    
    /**
     * Returns trigger based on system name.
    */
    public static Trigger getTrigger( String name )
    {
        for ( Trigger trigger : getTriggers() )
        {

            if ( trigger.SYSTEM_NAME.equalsIgnoreCase( name ) )
            {	
            	System.out.println(trigger.SYSTEM_NAME);
                return trigger;
            }
        }

        return null;
    }
    
    /**
     * Returns trigger mapped to class.
    */
    public static Trigger getTrigger( Class<?> cls )
    {
        return triggers.get( cls );
    }
    
    /**
     * Returns list of trigger loaded.
    */
    public static ArrayList<Trigger> getTriggers()
    {
        return triggerList;
    }





    
    


}
