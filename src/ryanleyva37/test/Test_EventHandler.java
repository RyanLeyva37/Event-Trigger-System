package ryanleyva37.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ryanleyva37.event.Event;
import ryanleyva37.event.EventKeyPress;
import ryanleyva37.event.Trigger;
import ryanleyva37.event.system.EventHandler;
import ryanleyva37.event.system.Handler;

public class Test_EventHandler {
	
	public static boolean hasBeenCalled;

	@Test
	public void testHandleEvent() {
		//Arrange
		Test_EventHandler.hasBeenCalled = false;
		EventHandler eventHandler = new EventHandler();
		Trigger trigger = buildTrigger();
		
		//Act
		eventHandler.handleEvent(new Event());
		
		//Assert
		assertEquals(true, Test_EventHandler.hasBeenCalled);
		
		trigger.unRegisterTrigger();
		
	}
	
	@Test
	public void testHandleEventNoAnnotation() {
		//Arrange
		Test_EventHandler.hasBeenCalled = false;
		Trigger trigger = buildTriggerNoAnnotation();
		EventHandler eventHandler = new EventHandler();

		//Act
		eventHandler.handleEvent(new Event());
		
		//Assert
		assertEquals(false, Test_EventHandler.hasBeenCalled);
		
		trigger.unRegisterTrigger();
		
	}
	
	
	@Test
	public void testHandleEventCustomeMethodName() {
		//Arrange
		Test_EventHandler.hasBeenCalled = false;
		EventHandler eventHandler = new EventHandler();
		Trigger trigger = buildTriggerCustomeMethod();

		//Act
		eventHandler.handleEvent(new Event());
		
		//Assert
		assertEquals(true, Test_EventHandler.hasBeenCalled);
		
		trigger.unRegisterTrigger();
	}
	
	@Test
	public void testHandleEventCustomeMethodNameNoAnnotation() {
		//Arrange
		Test_EventHandler.hasBeenCalled = false;
		EventHandler eventHandler = new EventHandler();
		Trigger trigger = buildTriggerCustomeMethodNoAnnotation();

		//Act
		eventHandler.handleEvent(new Event());
		
		//Assert
		assertEquals(false, Test_EventHandler.hasBeenCalled);
		trigger.unRegisterTrigger();
	}
	
	@Test
	public void TestHandleEventCustomeMethodCustomeEvent(){
		//Arrange
		Test_EventHandler.hasBeenCalled = false;
		EventHandler eventHandler = new EventHandler();
		Trigger trigger = buildTriggerCustomeMethodCustomeEvent();

		//Act
		eventHandler.handleEvent(new EventKeyPress(99));
		
		//Assert
		assertEquals(true, Test_EventHandler.hasBeenCalled);
		
		trigger.unRegisterTrigger();
	}
	
	
	@Test
	public void TestHandleEventCustomeMethodCustomeEventTooManyParameters(){
		//Arrange
		Test_EventHandler.hasBeenCalled = false;
		EventHandler eventHandler = new EventHandler();
		Trigger trigger = buildTriggerCustomeMethodCustomeEventTooManyParameters();

		//Act
		eventHandler.handleEvent(new EventKeyPress(99));
		
		//Assert
		assertEquals(false, Test_EventHandler.hasBeenCalled);
		
		trigger.unRegisterTrigger();
	}
	
	@Test
	public void TestHandleEventCustomeMethodCustomeEventNoAnnotation(){
		//Arrange
		Test_EventHandler.hasBeenCalled = false;
		EventHandler eventHandler = new EventHandler();
		Trigger trigger = buildTriggerCustomeMethodCustomeEventNoAnnotation();

		//Act
		eventHandler.handleEvent(new EventKeyPress(99));
		
		//Assert
		assertEquals(false, Test_EventHandler.hasBeenCalled);
		
		trigger.unRegisterTrigger();
	}
	
	
	private Trigger buildTrigger(){
		Trigger trigger = new Trigger("Test trigger", Trigger.class){
		
			@Override @Handler
			public void onEvent( Event event ) {
				Test_EventHandler.hasBeenCalled = true;
			}
		


		};
		
		trigger.registerTrigger();
		
		return trigger;
	}
	
	private Trigger buildTriggerNoAnnotation(){
		Trigger trigger = new Trigger("Test trigger", Trigger.class){
		
			@Override 
			public void onEvent( Event event ) {
				Test_EventHandler.hasBeenCalled = true;
			}
		


		};
		
		trigger.registerTrigger();
		
		return trigger;
	}
	
	private Trigger buildTriggerCustomeMethod(){
		Trigger trigger = new Trigger("Test trigger", Trigger.class){
		
			@Handler
			public void totallyRandom( Event event ) {
				Test_EventHandler.hasBeenCalled = true;
			}

		};
		
		trigger.registerTrigger();
		
		return trigger;
	}
	
	private Trigger buildTriggerCustomeMethodNoAnnotation(){
		Trigger trigger = new Trigger("Test trigger", Trigger.class){
		
			
			@SuppressWarnings("unused")
			public void totallyRandom( Event event ) {
				Test_EventHandler.hasBeenCalled = true;
			}
		


		};
		
		trigger.registerTrigger();
		
		return trigger;
	}
	
	private Trigger buildTriggerCustomeMethodCustomeEvent(){
		Trigger trigger = new Trigger("Test trigger", Trigger.class){
		
			@Handler
			public void totallyRandom( EventKeyPress event ) {
				Test_EventHandler.hasBeenCalled = true;
			}
		


		}; 
		
		trigger.registerTrigger();
		
		return trigger;
	}
	
	private Trigger buildTriggerCustomeMethodCustomeEventTooManyParameters(){
		Trigger trigger = new Trigger("Test trigger", Trigger.class){
		
			@Handler
			public void totallyRandom( EventKeyPress event, int i ) {
				Test_EventHandler.hasBeenCalled = true;
			}
		


		}; 
		
		trigger.registerTrigger();
		
		return trigger;
	}
	
	private Trigger buildTriggerCustomeMethodCustomeEventNoAnnotation(){
		Trigger trigger = new Trigger("Test trigger", Trigger.class){
		
			
			@SuppressWarnings("unused")
			public void totallyRandom( EventKeyPress event ) {
				Test_EventHandler.hasBeenCalled = true;
			}
		


		}; 
		
		trigger.registerTrigger();
		
		return trigger;
	}

}
