package service;
 
//import java.util.ArrayList;
import java.util.List;
//import java.util.Set;

import dao.TaskDao;
import dao.TaskDaoImpl;
//import db.DB;
import models.Task; 

public class TaskService {

	public static TaskDao taskdao = new TaskDaoImpl();

	public static boolean addTask(Task t) { 
//		 DB.tasks.put(t.getTaskId(), t);
//		return null;
		
		System.out.println("Adding w TaskService   ...");
		 return taskdao.addTask(t);
	}
	public static Task getTask(int taskId) {
//		return DB.tasks.get(taskId);
		System.out.println("Getting TaskService class ...");
		return taskdao.getTask(taskId); 
	} 
	
	public static  List<Task> listTask() {  
//		List<Task> taskList = new ArrayList<Task>();
//		Set<Integer> keys = DB.tasks.keySet();
//		for(Integer k: keys)
//			taskList.add(DB.tasks.get(k));
//		return taskList;
		System.out.println("Passing TaskService class ...");
		return taskdao.listTask();
		
	}
	
}
