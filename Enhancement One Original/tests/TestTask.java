package tests;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import projectpackage.Task;

class TestTask {

	@Test
	void testTaskConstructor() {
		//id too many characters
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("1234567890B", "TaskName", "TaskDescription");
		});
		//name too many characters
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("1234567890", "TaskNameABCDEFGHIJKLMN", "TaskDescription");
		});
		//description too many characters
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("1234567890", "TaskName", "TaskDescriptionABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJK");
		});
		//null id
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task(null, "TaskName", "TaskDescription");
		});
		//null name
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("1234567890", null, "TaskDescription");
		});
		//null description
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("1234567890", "TaskName", null);
		});
	}
	
	@Test
	void tetTaskConstructorAndGetters() {
		Task task = new Task("1234567890", "TaskName", "TaskDescription");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			task.SetTaskID(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			task.SetTaskID("This ID is too long");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			task.SetTaskName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			task.SetTaskName("This name is too long");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			task.SetTaskDesc(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			task.SetTaskDesc("This description is too long so it will throw an error");
		});
		
		task.SetTaskID("0123456789");
		task.SetTaskName("New Name");
		task.SetTaskDesc("New Description");
		assertTrue(task.GetID().equals("0123456789"));
		assertTrue(task.GetTaskName().equals("New Name"));
		assertTrue(task.GetTaskDescription().equals("New Description"));
	}
}
	


