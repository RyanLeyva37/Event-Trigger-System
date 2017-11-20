package ryanleyva37.event;

import static org.junit.Assert.*;

import org.junit.Test;



public class Test_Trigger {

	@Test
	public void testConstructor() {
		
		//Arrange
		String testName = "Test trigger1";
		Class<Trigger> triggerClass = Trigger.class;
		Trigger before;
		Trigger after;
		
		//Act
		before = new Trigger(testName, triggerClass);
		before.registerTrigger();
		after = Trigger.getTrigger(triggerClass);
		
		//Assert
		assertEquals(after.SYSTEM_NAME, before.SYSTEM_NAME);
		assertEquals(after, before);
		
		before.unRegisterTrigger();
		

	}
	
	@Test
	public void testRegisterTrigger(){

		//Arrange
		String testName = "Test trigger2";
		Class<Trigger> triggerClass = Trigger.class;
		Trigger before = new Trigger(testName, triggerClass);
		Trigger afterClass;
		Trigger afterList;
		
		//Act
		before.registerTrigger();
		afterClass = Trigger.getTrigger(triggerClass);
		afterList = Trigger.getTrigger(testName);
		
		//Assert
		assertEquals(afterClass, before);
		assertEquals(afterList, before);
		
		before.unRegisterTrigger();
		

	}
	
	@Test
	public void testUnRegisterTrigger(){

		//Arrange
		String testName = "Test trigger3";
		Class<Trigger> triggerClass = Trigger.class;
		Trigger before = new Trigger(testName, triggerClass);
		Trigger afterClass;
		Trigger afterList;
		before.registerTrigger();
		
		//Act
		before.unRegisterTrigger();
		afterClass = Trigger.getTrigger(triggerClass);
		afterList = Trigger.getTrigger(testName);
		


		//Assert
		assertEquals(afterClass, null);
		assertEquals(afterList, null);
		

		
	}
	
	@Test
	public void testGetTriggerClass() {
		
		//Arrange
		Class<Trigger> triggerClass = Trigger.class;
		Trigger before;
		Trigger after;
		
		//Act
		before = new Trigger("Test trigger 4", triggerClass);
		before.registerTrigger();
		after = Trigger.getTrigger(triggerClass);
		
		//Assert
		assertEquals(after, before);
		
		before.unRegisterTrigger();
	}
	
	@Test
	public void testGetTriggerString() {
		
		//Arrange
		String testName = "Test trigger 5";
		Trigger before;
		Trigger after;
		
		//Act
		before = new Trigger(testName, Trigger.class);
		before.registerTrigger();
		after = Trigger.getTrigger(testName);
		
		//Assert
		assertEquals(after, before);
		
		before.unRegisterTrigger();
	}

}
