# Event/Trigger System

A Simple to use solution for all your event/trigger needs!

![](https://image.ibb.co/chZVix/Untitled.png)

# Goals/Index:
1. How to create an Event Processor, Trigger and Event

2. How to create Event Handlers

3. How to register triggers

4. How to trigger an event

# 1 - How to create an Event Processor, Trigger and Event

###Create Event processor

Declaring a public static Event Processor and instantiating it on (initialization/declaration) is recommended

    public static EventProcessor EV = new EventProcessor();

    
###Create Triggers 

When it comes to creating triggers you have two options, as a superclass or a stand alone instance

Superclass example:

    public class ExistingClass extends Trigger{
    
       @Override @Handler
       public void onEvent( Event event ) {
       //TODO: Handle event
       }
    }


Stand alone instance example:

    Trigger trigger = new Trigger("Test trigger", Trigger.class){
    		
    	@Override @Handler
    	public void onEvent( Event event ) {
    	//TODO: Handle event
    	}
    };

It is important to note triggers must be registered using **.registerTrigger(EventProcessor)** in order for the Event Processor to execute the event handlers.
**.unRegisterTrigger(EventProcessor)** will make the Event Processor ignore said trigger.-

### Create Event/Custom Events
    
Creating an Event is as simple as creating any other variable.

This example can be used as a generic event and the EventProcessor will send it to any trigger requesting generic events.

    Event e = new Event();



Creating a custom event can be done as shown:

    public class CustomEvent extends Event{
    
    }

At this point you can add your own variables as well as getters and setters, every event includes a boolean (and getters and setters) to cancel events.

	public class CustomEvent extends Event{
	
		int i;
	
		String s;
	
		public CustomEvent(int i, String s) {
			this.i = i;
			this.s = s;
		}

		public int getI() {
			return i;
		}
	
		public void setI(int i) {
			this.i = i;
		}
	
		public String getS() {
			return s;
		}
	
		public void setS(String s) {
			this.s = s;
		}
		
	}

 
# 2 - How to create Event Handlers


Assuming you have created a trigger (See #1), creating an event handler can be done as shown:

	public class ExampleTrigger extends Trigger {

		public ExampleTrigger(String systemName, Class<?> cls) {
			super(systemName, cls);
		}
		@Handler
		public void exampleEventHandler(Event e) {
			
		}

	}

The exampleEventHandler method will be executed any time a generic Event instance is passed through the EventProcessor created earlier. 

It is important to note all event handlers must contain the **@Handler** annotation. 

It should also be noted the name of the method can be changed and the EventProcessor will still detect it 

Now lets say we want to create an event handler for the custom event we created earlier, this can be done as shown:

	public class ExampleTrigger extends Trigger {

		public ExampleTrigger(String systemName, Class<?> cls) {
			super(systemName, cls);
		}
		@Handler
		public void exampleEventHandler(CustomEvent e) {
			
		}

	}

You may notice the code is very similar, this is because in order to change the events passed through the handler, the argument object type is the only thing that needs to be changed. 





# 3 - How to register triggers

After creating a Trigger object it must be registered with an Event Processor in order to be used. After being registered the Event processor will find and utilize event handlers in said trigger.

Triggers can be registered as shown:

	EventProcessor eventProcessor = new EventProcessor();
	ExampleTrigger trigger = new ExampleTrigger("example", ExampleTrigger.class);
	trigger.registerTrigger(eventProcessor);
		
trigger is now registered with eventProcessor. Now if eventProcessor receives an event it will be be sent to the event handlers in trigger.

On the other hand if you would like to disable a trigger you can UN-register triggers using the following line:

	trigger.unRegisterTrigger(eventProcessor)


# 4 - How to trigger an Event

Assuming you've created an Event Processor and have a trigger instance created and registered the following code will be used to trigger an event:

	eventProcessor.handleEvent(New Event());

This will send the new Event instance to the appropriate event handlers found in the triggers registered with eventProcessor.

.handleEvent will also return the event after being processed, this is useful when dealing with custom events with custom variables or if you want the event to be cancel-able 

The following example shows how you would use custom events

	CustomEvent e = new CustomEvent();
	e = eventProcessor.handleEvent(e);
