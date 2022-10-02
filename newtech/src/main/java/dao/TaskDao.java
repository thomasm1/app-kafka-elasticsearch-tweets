package dao;

import java.util.List;

import models.Task;

public interface TaskDao {
	public boolean addTask(Task u); 
	public Task getTask(int id); 
	public Task getTask(String taskname); 
	public List<Task> listTask(); 
	public boolean updateTask(Task change);
	public boolean deleteTask(String taskname);
	 
}
