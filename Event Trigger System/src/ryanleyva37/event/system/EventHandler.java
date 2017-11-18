package ryanleyva37.event.system;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ryanleyva37.event.Event;
import ryanleyva37.event.Trigger;

public class EventHandler
{
    public Event handleEvent( Event event )
    {

        for ( Trigger trigger : Trigger.getTriggers() ) //Loops through initialized triggers
        {
          
            
        	for( Method method : trigger.getClass().getMethods() ) //Loops through methods found in trigger class
        	{
        		Annotation annotation = method.getAnnotation(Handler.class);
        		if( annotation == null)
        		{
        			continue;
        		}else{
        			System.out.println(method.getName());
        		}
        		if(		( contains( method.getParameterTypes(), event.getClass() )						//(If parameter type of arguments in method contain event class OR 
        			    ||contains( method.getParameterTypes(), Event.class ) )						//If parameter type of arguments in method contain generic event class) AND
        				&& method.getParameterTypes().length==1 && !method.getName().equals( "equals" )	//method has no other arguments AND method is not equals trigger method				
        					
        		  )
        		{
        			try {
							method.invoke( trigger, new Object[] { event } );	//executes method passing through event argument.
						} catch ( IllegalArgumentException e ) {
						} catch ( IllegalAccessException e ) {
						} catch ( InvocationTargetException e ) {
						}
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
