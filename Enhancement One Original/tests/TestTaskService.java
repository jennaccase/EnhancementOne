package tests;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import projectpackage.TaskService;
import projectpackage.Task;

class TestTaskService {

	@Test
	void testTaskConstructor() {
		var taskService = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			var newTask = new Task(null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			var newTask = new Task("123", null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			var newTask = new Task("123", "Name", null);
		});
		//id too long
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			var newTask = new Task("12345678901", "Name", "Description");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			var newTask = new Task("123456789", "This name is too long", "Description");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			var newTask = new Task("123456789", "Name", "This description is too long so it will throw an error");
		});
		
		//test setters
		var newTask = new Task("123", "Name", "Description");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			newTask.SetTaskID(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			newTask.SetTaskName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			newTask.SetTaskDesc(null);
		});
	}
	
	@Test
	void testGetters() {
		var taskService = new TaskService();
		assertTrue(taskService.GetTaskCount() == 0);
		assertTrue(taskService.GetTaskCount() != 1);
		assertTrue(taskService.GetTaskList().isEmpty());
		taskService.PrintTaskList();
	}
	
	@Test
	void testAddTaskToTaskList() {
		TaskService taskService = new TaskService();
		//null name
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.AddTask(null,  "Task Description");
		});
		//null description
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.AddTask("Task Name", null);
		});
		//name too long
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.AddTask("This name is too long", "Task Description");
		});
		//description too long
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.AddTask("Task Name", "This description is too long and will throw an error");
		});
		taskService.AddTask("Task Name", "Task Description");
		assertTrue(taskService.GetTaskCount() == 1);
		assertTrue(!taskService.GetTaskList().isEmpty());
		taskService.PrintTaskList();
	}
	
	@Test
	void testRemoveTaskFromList() {
		var taskService = new TaskService();
		//empty
		taskService.RemoveTask("1234567890");
		//null id
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.RemoveTask(null);
		});
		//id too long
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.RemoveTask("12345678901");
		});
		//add task to remove
		taskService.AddTask("This new Task", "This is a task description");
		Task task = taskService.GetTaskList().elementAt(0);
		//does not exist
		taskService.RemoveTask("123");
		taskService.RemoveTask(task.GetID());
		assertTrue(taskService.GetTaskCount() == 0);
		assertTrue(taskService.GetTaskList().isEmpty());
	}
	
	@Test
	void testUpdateTask() {
		var taskService = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.UpdateTask(null, "update", 0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.UpdateTask("1234567", null, 0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.UpdateTask("123456", "update", -1);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.UpdateTask("1234567890123", "update", 0);
		});
		
		taskService.UpdateTask("123456", "update", 1);
		taskService.AddTask("New Task", "This is a task description");
		Task task = taskService.GetTaskList().elementAt(0);
		
		//default remove
		taskService.UpdateTask(task.GetID(), "update", 0);
		
		//update name
		taskService.UpdateTask(task.GetID(), "NewTaskName", 1);
		assertEquals("NewTaskName", taskService.GetTaskList().elementAt(0).GetTaskName());
		
		//update bad name
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.UpdateTask(task.GetID(), "This name is too long", 1);
		});
		
		//update description
		taskService.UpdateTask(task.GetID(), "This is a new description", 2);
		assertEquals("This is a new description", taskService.GetTaskList().elementAt(0).GetTaskDescription());
		
		//update bad description
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			taskService.UpdateTask(task.GetID(), "This description is too long anf will throw an error", 2);
		});
	}
}
		
	
