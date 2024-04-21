package projectpackage;

public class Task {
	
	private String taskID;
	private String taskName;
	private String taskDesc;
	
	//constructor
	public Task(String id, String name, String description) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		taskID = id;
		taskName = name;
		taskDesc = description;
	}
	
	//getters
	public String GetID() {
		return taskID;
	}
	public String GetTaskName() {
		return taskName;
	}
	public String GetTaskDescription() {
		return taskDesc;
	}
	
	//setters
	public void SetTaskID(String id) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		taskID = id;
		}
	public void SetTaskName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		taskName = name;
		}
	public void SetTaskDesc(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		taskDesc = description;
		}
	}
