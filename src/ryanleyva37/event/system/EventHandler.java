package ryanleyva37.event.system;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

import ryanleyva37.event.Event;
import ryanleyva37.event.Trigger;
import ryanleyva37.test.Test_EventHandler;

/**
 * @author Ryan Leyva
 * Code Coverage: 94.6%
 */
public class EventHandler
{
    public Event handleEvent( Event event )
    {
        for ( Trigger trigger : Trigger.getTriggers() ) //Loops through initialized triggers
        {
          	System.out.println(Trigger.getTriggers().size());
        	for( Method method : trigger.getClass().getMethods() ) //Loops through methods found in trigger class
        	{
        		Annotation annotation = method.getAnnotation(Handler.class);
        		if( annotation == null)
        		{
        			continue;
        		}
        		if(	 contains( method.getParameterTypes(), event.getClass() )						//(If parameter type of arguments in method contain event class OR
					 && method.getParameterTypes().length==1
				  )
        		{
        			try {

						AccessController.doPrivileged(new PrivilegedExceptionAction() {
							public Object run() throws Exception {
								if (!method.isAccessible()) {
									method.setAccessible(true);
								}
								method.invoke(trigger, new Object[]{event});
								return null;
							}
						});
					}
					catch ( IllegalArgumentException  e ) { System.out.println( "ERROR: IllegalArgumentException"  ); }
        			catch ( PrivilegedActionException e ) { System.out.println( "ERROR: PrivilegedActionException" ); }
        		}
        	}
        }



        return event;	//returns event method for further use. 
    }
    
    private boolean contains( Object[] list, Object object )
    {
    	for( Object o : list )
    	{
    		if( o.equals( object ) )return true;
    	}
    	return false;
    }
}
