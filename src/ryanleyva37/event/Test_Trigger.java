package ryanleyva37.event;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_Trigger {

	@Test
	public void testConstructor() {
		//Arrange
		String testName = "Test trigger";
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
	}
	
	@Test
	public void testRegisterTrigger(){
		//Arrange
		String testName = "Test trigger";
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
	}
	
	@Test
	public void testGetTriggerClass() {
		
		//Arrange
		Class<Trigger> triggerClass = Trigger.class;
		Trigger before;
		Trigger after;
		
		//Act
		before = new Trigger("test", triggerClass);
		before.registerTrigger();
		after = Trigger.getTrigger(triggerClass);
		
		//Assert
		assertEquals(after, before);
	}
	
	@Test
	public void testGetTriggerString() {
		
		//Arrange
		String testName = "Test trigger12";
		Trigger before;
		Trigger after;
		
		//Act
		before = new Trigger(testName, Trigger.class);
		before.registerTrigger();
		after = Trigger.getTrigger(testName);
		
		//Assert
		assertEquals(after, before);
	}

}
