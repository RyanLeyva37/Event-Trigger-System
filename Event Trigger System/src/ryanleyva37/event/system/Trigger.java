package ryanleyva37.event.system;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import ryanleyva37.event.Event;
import ryanleyva37.event.EventKeyPress;
import ryanleyva37.event.Handler;

public class Trigger
{
    
	/** Static system name of trigger. */
    public final String SYSTEM_NAME;
    
    /** Used to pair trigger .class to instance created on startup. */
    private static HashMap<Class, Trigger> triggers = new HashMap<Class, Trigger>();
    
    /** Array of instances of triggers loaded in system. */
    private static Trigger[] triggerList = new Trigger[] {};

    /**
     * Initializes trigger with default values.
    */
    @Handler
    public Trigger( String systemName, Class cls )
    {
        this.SYSTEM_NAME = systemName;
        triggers.put( cls, this );
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
     * Returns list of trigger loaded.
    */
    public static Trigger[] getTriggers()
    {
        return triggerList;
    }




    /**
     * Returns trigger mapped to class.
    */
    public static Trigger getTriggers( Class cls )
    {
        return ( Trigger )triggers.get( cls );
    }
    
    


}
