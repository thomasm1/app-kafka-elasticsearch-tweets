package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//import java.util.Set;
import java.util.ArrayList;

//import db.DB;
import dao.TaskDao;
import models.Task;
import util.JDBCConnection;

//can't make static, so use the service layer 
public class TaskDaoImpl implements TaskDao {
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addTask(Task t) {
//		DB.tasks.put(t.getTaskId(), t);
//		return true;
		System.out.println("Submitting to TaskDaoImpl: "+t);
		String sql = "CALL add_new_tasktable(?,?,?,?,?, ?,?,?,?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
//			cs.setString(1, Integer.toString(t.getTaskId()));
			cs.setString(1, Integer.toString(t.getReqId()));
			cs.setString(2, Integer.toString(t.getCurrUserId()));
			cs.setString(3, t.getTimeStamp());
			cs.setString(4, t.getCurrDocs()); 
			cs.setString(5, t.getUpdateReason()); 
			cs.setString(6, t.getUpdateReqType());
			cs.setString(7, t.getUpdateGradeType());
			cs.setString(8, t.getUpdateGradePass());
			cs.setString(9, Double.toString(t.getUpdateAmt()));
			cs.setString(10, Integer.toString(t.getUpdateStage()));

			System.out.println("success to request!: taskId#"+t.getTaskId());

			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double Check add_new_task DB SQL");
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Task getTask(int taskid) {
//		return DB.tasks.get(id);
		try {
			String sql = "SELECT * FROM reqtasktable WHERE taskid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(taskid));
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				return new Task(rs.getInt("taskid"),
						rs.getInt("reqId"), 
						rs.getInt("currUserId"),
						rs.getString("timeStamp"), 
						rs.getString("currDocs"),  
						rs.getString("updateReason"),   
						rs.getString("updateReqType"),
						rs.getString("updateGradeType"), 
						rs.getString("updateGradePass"),  
						rs.getDouble("updateAmt"), 
						rs.getInt("updateStage")); 
			}
	}		catch (Exception e) {
		System.out.println("SQL issue with getting Task: \n"+e);
	}
			return null;
		}; 
		

	@Override
	public Task getTask(String updateReason) {
//		return DB.tasks.get(taskname);
		try {
			String sql = "SELECT * FROM reqtasktable WHERE updateReason = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, getString(updateReason));
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				return new Task(rs.getInt("taskid"),
						rs.getInt("reqId"), 
						rs.getInt("currUserId"),
						rs.getString("timeStamp"), 
						rs.getString("currDocs"),  
						rs.getString("updateReason"),   
						rs.getString("updateReqType"),
						rs.getString("updateGradeType"), 
						rs.getString("updateGradePass"),  
						rs.getDouble("updateAmt"), 
						rs.getInt("updateStage"));
			}
	}		catch (Exception e) {
		System.out.println("SQL issue with getting USER: \n"+e);
	}
			return null;
	};

	private String getString(String taskname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> listTask() {
//		List<Task> taskList = new ArrayList<Task>();
//		Set<Integer> keys = DB.tasks.keySet();
//		for (Integer k : keys)
//			taskList.add(DB.tasks.get(k));
//		return taskList;
		String sql = "SELECT * FROM reqtasktable";
		List<Task> taskArr = new ArrayList<Task>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// preparedStatements are safe from SQL injection & sanitize inputs
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				taskArr.add(new Task(rs.getInt("taskid"),
						rs.getInt("reqId"), 
						rs.getInt("currUserId"),
						rs.getString("timeStamp"), 
						rs.getString("currDocs"),  
						rs.getString("updateReason"),   
						rs.getString("updateReqType"),
						rs.getString("updateGradeType"), 
						rs.getString("updateGradePass"),  
						rs.getDouble("updateAmt"), 
						rs.getInt("updateStage")));
			}
			System.out.println("SQL is All Good!");
			return taskArr;
		} catch (SQLException e) {
			System.out.println("SQL issue with getting All USER:\n "+e);
		}
		return null;
	}

	@Override
	public boolean updateTask(Task t) {
//		DB.tasks.replace(change.getTaskId(), change);
//		return true;
		String sql = "UPDATE tasktable SET taskId=?, reqId=?, currUserId=?, timeStamp=?, currDocs=?, updateReason=?, updateReqType=?,  updateGradeType=?, updateGradePass=?, updateAmt=?, updateStage=? WHERE getTaskId = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 	
			ps.setString(1, Integer.toString(t.getTaskId()));
			ps.setString(1, Integer.toString(t.getReqId()));
			ps.setString(2, Integer.toString(t.getCurrUserId()));
			ps.setString(3, t.getTimeStamp());
			ps.setString(4, t.getCurrDocs()); 
			ps.setString(5, t.getUpdateReason()); 
			ps.setString(6, t.getUpdateReqType());
			ps.setString(7, t.getUpdateGradeType());
			ps.setString(8, t.getUpdateGradePass());
			ps.setString(9, Double.toString(t.getUpdateAmt()));
			ps.setString(10, Integer.toString(t.getUpdateStage()));

			ps.executeQuery();
		
			return true;
		} catch (SQLException e) {
			System.out.println("SQL issue with updating USER:\n "+e);
		}
		return false;
	}

	@Override
	public boolean deleteTask(String taskname) {
//		DB.tasks.remove(taskname);
//		String sql = "DELETE tasktable WHERE taskname = ?";
//		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql); 
//			ps.setString(1, t);
//			
////			int var = 1;
////			System.out.println(var);
////			System.out.println("never delete ... ");
//			
//			return true;
//		} catch (Exception e) {
//	 System.out.println("doublecheck deletions: \n"+e);
//		}
//		return false;
//		}
		return false;
	}

}
