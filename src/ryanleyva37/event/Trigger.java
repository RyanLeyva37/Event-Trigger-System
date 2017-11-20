package ryanleyva37.event;


import java.util.ArrayList;
import java.util.HashMap;

import ryanleyva37.event.Event;
import ryanleyva37.event.system.Handler;

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
    @Handler
    public Trigger( String systemName, Class<?> cls )
    {
        this.SYSTEM_NAME = systemName;
        this.cls = cls;
    }
    
    public void registerTrigger(){
        triggers.put( cls, this );
        triggerList.add(this);
    }
    
    /**
     * Generic event method called when event is triggered
    */
    public void onEvent( Event event ) {}
    
    /**
     * Returns trigger based on system name.
    */
    public static Trigger getTrigger( String name )
    {
        for ( Trigger trigger : triggerList )
        {

            if ( trigger.SYSTEM_NAME.equalsIgnoreCase( name ) )
            {
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
