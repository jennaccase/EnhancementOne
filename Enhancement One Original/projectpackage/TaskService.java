package projectpackage;

import java.util.Random;
import java.util.Vector;

public class TaskService {

	private Vector<Task> taskList = new Vector<Task>();
	private int taskCount = 0;
	
	//list of tasks
	public Vector<Task> GetTaskList() {
		return taskList;
	}
	//count tasks
	public int GetTaskCount() {
		return taskCount;
	}
	//print
	public void PrintTaskList() {
		for (Task t : taskList) {
			System.out.println("Task ID: " + t.GetID() + " Name: " + t.GetTaskName());
			System.out.println("Description: " + t.GetTaskDescription() + "\n");
		}
	}
	//add task
	public void AddTask(String pName, String pDescription) {
		if (pName == null || pName.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		if (pDescription == null || pDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		String newID = GenerateUniqueID();
		var newTask = new Task(newID, pName, pDescription);
		taskList.add(newTask);
		taskCount = GetTaskCount() + 1;
		System.out.println("Task " + newTask.GetTaskName() + " created and added successfully");
	}
	private void AddTask(Task task) {
		taskList.add(task);
		taskCount = GetTaskCount() + 1;
	}
	private void RemoveTask(Task task) {
		taskList.remove(task);
		taskCount = GetTaskCount() - 1;
	}
	
	public void RemoveTask(String id) {
		if (taskList.isEmpty()) {
			System.out.println("There are no tasks to remove");
		}
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		int index = -1;
		for (Task t : taskList) {
			if (t.GetID() == id) {
				index = taskList.indexOf(t);
			}
		}
		if (index == -1) {
			System.out.println("Task not found");
			return;
		}
		else {
			taskList.remove(index);
			taskCount = GetTaskCount() - 1;
			System.out.println("Task was removed from the list");
		}
	}
	
	public void UpdateTask(String id, String update, int selection) {
		if (id == null || id.length() > 10 || update == null || selection < 0) {
			throw new IllegalArgumentException("Invalid Request");
		}
		if (taskList.isEmpty()) {
			System.out.println("There are no tasks to update");
			return;
		}
		int index = -1;
		for (Task t : taskList) {
			if (t.GetID() == id) {
				index = taskList.indexOf(t);
			}
		}
		if (index == 1) {
			System.out.println("Task not found");
			return;
		}
		Task updateTask = taskList.get(index);
		//conditional for updates
		// 1 is for name
		// 2 is for description
		switch(selection) {
		case 1: {
			updateTask.SetTaskName(update);;
			break;
		}
		case 2: {
			updateTask.SetTaskDesc(update);;
			break;
		}
		default: {
			System.out.println("Task not updated, error");
			break;
		}
		}
		RemoveTask(taskList.elementAt(index));
		AddTask(updateTask);
	}
	
	public String GenerateUniqueID() {
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueID = Integer.toString(newID);
		
		Vector<String> idList = new Vector<String>();
		for (Task t : taskList) {
			idList.add(t.GetID());
		}
		while (idList.contains(uniqueID) || uniqueID.length() > 10) {
			newID = rand.nextInt(1000000000);
			uniqueID = Integer.toString(newID);
		}
		idList = null;
		return uniqueID;
	}
	
}

