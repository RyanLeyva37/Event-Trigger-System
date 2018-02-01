# Event/Trigger System
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*
*Under Construction*

A Simple to use solution for all your event/trigger needs!

Goals/Index:
1 - ✓ Create an Event Processor, Trigger and Event
2 - ✓ Event Processor should handle event methods no matter the method name
2 - ✓ Event Processor should read method arguments in event handlers to distribute apropriate events as arguments.
3 - ✓ Create custome annotation @Handler
4 - ✓ Event Processor should only use event methods if @Handler is present
5 - ✓ Creating custome events will only require an event class
6 - ✓ Creating custome event will require no extra code
7 - ✓ Triggering an event will only require one line of code
8 - ✓ Events instances should be returned after being proccessed to original declaration for further use.
9 - ✓ Require Trigger to be registered before it gets used

# 1 - Create a event handler
Solution:
  Created Trigger.java as a Superclass as well as generic Event handler method.
  
  Created EventProcessor.java to use as the main event proccessor.
  
  Created Event.java to use instances to represent events
  
How to use:
  Create Event processor
    Declaring a public static Event Processor variable and instanciating it on (start up/Declaration) is recommended
    ```
    public static EventProcessor EV;
    ```
    
  Create Triggers 
    When it comes to creating triggers you have two options, as a superclass or a stand alone instance
    Superclass example:
    ```
    public class ExistingClass extends Trigger{
      @Override @Handler
			public void onEvent( Event event ) {
				Test_EventHandler.hasBeenCalled = true;
			}
    }

    ```
    Stand alone instance example:
    ```
    Trigger trigger = new Trigger("Test trigger", Trigger.class){
		
			@Override @Handler
			public void onEvent( Event event ) {
				Test_EventHandler.hasBeenCalled = true;
			}
		};
    ```
    

# 2

# 3

# 4

# 5

# 6

# 7

# 8
