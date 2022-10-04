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
import dao.RequestDao;
import models.Request;
import util.JDBCConnection;

//can't make static, so use the service layer 
public class RequestDaoImpl implements RequestDao {
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addReq(Request u) {
//		DB.users.put(u.getReqId(), u);
//		return true;
		System.out.println("Submitting to ReqDaoImpl: "+u);
		String sql = "CALL add_new_reqtable(?,?,?,?, ?,?,?,? ,?,?,?, ?,?,?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);//broke here!!
//			cs.setString(1, Integer.toString(u.getReqId()));
			cs.setString(1, Integer.toString(u.getUserId()));
			cs.setString(2, u.getReqName());
			cs.setString(3, u.getReqType());
			cs.setString(4, u.getReqDesc());
			
			cs.setString(5, u.getReqJustify());
			cs.setString(6, u.getReqDatetime());
			cs.setString(7, u.getReqPlace());
			cs.setString(8, u.getReqGradeType());
			
			cs.setString(9, u.getReqGradePass());
			cs.setString(10, Double.toString(u.getReqAmt()));
			cs.setString(11, Integer.toString(u.getStage()));

			cs.setString(12, u.getSuperText());
			cs.setString(13, u.getDheadText());
			cs.setString(14, u.getBencoText());
			cs.setString(15, u.getReqText());
			System.out.println("success to request!: stage #"+u.getStage());
			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double Check add_new_reqtable DB SQL");
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Request getReq(int reqid) {
//		return DB.users.get(id);
		try {
			String sql = "SELECT * FROM reqtable WHERE reqid =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(reqid));
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
			return new Request(
					rs.getInt("reqid"),
					rs.getInt("userid"), 
					rs.getString("reqName"), 
					rs.getString("reqType"),  
					rs.getString("reqDesc"),  
					rs.getString("reqJustify"),
					rs.getString("reqDatetime"), 
					rs.getString("reqPlace"),  
					rs.getString("reqGradeType"),  
					rs.getString("reqGradePass"), 
					rs.getDouble("reqAmt"), 
					rs.getInt("stage"),

					rs.getString("superText"),  
					rs.getString("dheadText"),  
					rs.getString("bencoText"),
					rs.getString("reqText")); 
			}
	}		catch (Exception e) {
		System.out.println("SQL issue with getting REQ: \n"+e);
	}
			return null;
		};  
		
//	@Override
//	public Request getReq(String r) {
//		return DB.requests.get(r);
//		try {
//			String sql = "SELECT * FROM reqtable WHERE username = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, getString(username));
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next())
//			{
//				return new Request(rs.getInt("userid"),
//						rs.getInt("deptid"), 
//						rs.getInt("superid"), 
//				rs.getString("username"),  
//				rs.getString("password"),  
//				rs.getString("email"));
//			}
//	}		catch (Exception e) {
//		System.out.println("SQL issue with getting USER: \n"+e);
//	}
//			return null;
//	};
 


	@Override
	public List<Request> listReq(int id) {
		String sql = "SELECT * FROM reqtable WHERE userid = ?";
		List<Request> reqArr = new ArrayList<Request>();
		Integer oldId = id;
		Integer newId = 8888;
		newId = ((oldId!=null) && (oldId >= 0))? oldId: newId;
		System.out.println(newId);

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// preparedStatements are safe from SQL injection & sanitize inputs
			ps.setString(1, Integer.toString(newId));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reqArr.add(new Request(rs.getInt("reqid"),
						rs.getInt("userid"), 
						rs.getString("reqName"), 
						rs.getString("reqType"),  
						rs.getString("reqDesc"),  
						rs.getString("reqJustify"),
						rs.getString("reqDatetime"), 
						rs.getString("reqPlace"),  
						rs.getString("reqGradeType"),  
						rs.getString("reqGradePass"), 
						rs.getDouble("reqAmt"), 
						rs.getInt("stage"),

						rs.getString("superText"),  
						rs.getString("dheadText"),  
						rs.getString("bencoText"),
						rs.getString("reqText")
						)); 
			}
			System.out.println(" WHERE userid= SQL is All Good !");
			return reqArr;
		} catch (SQLException e) {
			System.out.println("SQL issue with getting All REQUESTS WHERE userid=:\n "+e);
		}
		return null;
	}
	
	@Override
	public List<Request> listReq() {
//		List<Request> reqList = new ArrayList<Request>();
//		Set<Integer> keys = DB.reqs.keySet();
//		for (Integer k : keys)
//			reqList.add(DB.reqs.get(k));
//		return reqList;
		String sql = "SELECT * FROM reqtable";
		List<Request> reqArr = new ArrayList<Request>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// preparedStatements are safe from SQL injection & sanitize inputs
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reqArr.add(new Request(rs.getInt("reqid"),
						rs.getInt("userid"), 
						rs.getString("reqName"), 
						rs.getString("reqType"),  
						rs.getString("reqDesc"),  
						rs.getString("reqJustify"),
						rs.getString("reqDatetime"), 
						rs.getString("reqPlace"),  
						rs.getString("reqGradeType"),  
						rs.getString("reqGradePass"), 
						rs.getDouble("reqAmt"), 
						rs.getInt("stage"),

						rs.getString("superText"),  
						rs.getString("dheadText"),  
						rs.getString("bencoText"),
						rs.getString("reqText"))); 
			}
			System.out.println("SQL is All Good!");
			return reqArr;
		} catch (SQLException e) {
			System.out.println("SQL issue with getting All REQUESTS:\n "+e);
		}
		return null;
	}


	@Override
	public boolean updateReq(Request change) {
//		DB.users.replace(change.getReqId(), change);
//		return true;
		System.out.println("Submitting from ReqDaoImpl: "+change);
//	    String sql = "UPDATE reqtable SET  userId=?, reqName=?, reqType=?,  reqDesc=?,  reqJustify=?, reqDatetime=?, reqPlace=?, reqGradeType=?, reqGradePass=?,  reqAmt=?, stage=?, superText=?, dheadText=?, bencoText=?, reqText=?  WHERE reqId = ?";
		String sql = "UPDATE reqtable SET stage = ?, superText=?, dheadText=?, bencoText=?, reqText=?   WHERE reqId = ? ";	
		try {
			PreparedStatement ps = conn.prepareCall(sql); 
//			ps.setString(1, Integer.toString(change.getUserId()));
//			ps.setString(2, change.getReqName());
//			ps.setString(3, change.getReqType());
//			ps.setString(4, change.getReqDesc());
//			ps.setString(5, change.getReqJustify());
//			ps.setString(6, change.getReqDatetime());
//			ps.setString(7, change.getReqPlace());
//			ps.setString(8, change.getReqGradeType());
//			ps.setString(9, change.getReqGradePass());
//			ps.setString(10, Double.toString(change.getReqAmt()));
			ps.setString(1, Integer.toString(change.getStage()));

			ps.setString(2, change.getSuperText());
			ps.setString(3, change.getDheadText());
			ps.setString(4, change.getBencoText());
			ps.setString(5, change.getReqText());
			ps.setString(6, Integer.toString(change.getReqId()));
			ps.executeQuery();
			System.out.println("success updating request!: reqId#"+change.getReqId()+": getStage#"+change.getStage()+": getSuperText#"+change.getSuperText());
			return true;

		} catch (SQLException e) {
			System.out.println("Double Check updateReq DB SQL"+e);
		}
		return false; 
	}

	@Override
	public boolean deleteReq(int id) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public boolean deleteReq(int id) {
////		DB.users.remove(req);
////		String sql = "DELETE usertable WHERE username = ?";
////		
////		try {
////			PreparedStatement ps = conn.prepareStatement(sql); 
////			ps.setString(1, u);
////			
//////			int var = 1;
//////			System.out.println(var);
//////			System.out.println("never delete ... ");
////			
////			return true;
////		} catch (Exception e) {
////	 System.out.println("doublecheck deletions: \n"+e);
////		}
////		return false;
////		}
//		return false;
//	}
//
//
//}

}

//package dao;
//
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
////import java.util.Set;
//import java.util.ArrayList;
//
//
////import db.DB;
//import dao.RequestDao;
//import models.Request;
//import util.JDBCConnection;
//
////can't make static, so use the service layer 
//public class RequestDaoImpl implements RequestDao {
//	public static Connection conn = JDBCConnection.getConnection();
//
//	@Override
//	public boolean addReq(Request u) {
////		DB.users.put(u.getReqId(), u);
////		return true;
//		System.out.println("Submitting to ReqDaoImpl: "+u);
//		String sql = "CALL add_new_reqtable(?,?,?,?, ?,?,?,? ,?,?,?)";
//		try {
//			CallableStatement cs = conn.prepareCall(sql);//broke here!!
////			cs.setString(1, Integer.toString(u.getReqId()));
//			cs.setString(1, Integer.toString(u.getUserId()));
//			cs.setString(2, u.getReqName());
//			cs.setString(3, u.getReqType());
//			cs.setString(4, u.getReqDesc());
//			cs.setString(5, u.getReqJustify());
//			cs.setString(6, u.getReqDatetime());
//			cs.setString(7, u.getReqPlace());
//			cs.setString(8, u.getReqGradeType());
//			cs.setString(9, u.getReqGradePass());
//			cs.setString(10, Double.toString(u.getReqAmt()));
//			cs.setString(11, Integer.toString(u.getStage()));
//			System.out.println("success to request!: stage#"+u.getStage());
//			cs.execute();
//			return true;
//
//		} catch (SQLException e) {
//			System.out.println("Double Check add_new_reqtable DB SQL");
//			System.out.println(e);
//		}
//		return false;
//	}
//
//	@Override
//	public Request getReq(int reqid) {
////		return DB.users.get(id);
//		try {
//			String sql = "SELECT * FROM reqtable WHERE reqid =?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, Integer.toString(reqid));
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next())
//			{
//			return new Request(
//					rs.getInt("reqid"),
//					rs.getInt("userid"), 
//					rs.getString("reqName"), 
//					rs.getString("reqType"),  
//					rs.getString("reqDesc"),  
//					rs.getString("reqJustify"),
//					rs.getString("reqDatetime"), 
//					rs.getString("reqPlace"),  
//					rs.getString("reqGradeType"),  
//					rs.getString("reqGradePass"), 
//					rs.getDouble("reqAmt"), 
//					rs.getInt("stage")); 
//			}
//	}		catch (Exception e) {
//		System.out.println("SQL issue with getting REQ: \n"+e);
//	}
//			return null;
//		};  
//		
////	@Override
////	public Request getReq(String r) {
////		return DB.requests.get(r);
////		try {
////			String sql = "SELECT * FROM reqtable WHERE username = ?";
////			PreparedStatement ps = conn.prepareStatement(sql);
////			ps.setString(1, getString(username));
////			ResultSet rs = ps.executeQuery();
////
////			while (rs.next())
////			{
////				return new Request(rs.getInt("userid"),
////						rs.getInt("deptid"), 
////						rs.getInt("superid"), 
////				rs.getString("username"),  
////				rs.getString("password"),  
////				rs.getString("email"));
////			}
////	}		catch (Exception e) {
////		System.out.println("SQL issue with getting USER: \n"+e);
////	}
////			return null;
////	};
// 
//
//
//	@Override
//	public List<Request> listReq(int id) {
//		String sql = "SELECT * FROM reqtable WHERE userid = ?";
//		List<Request> reqArr = new ArrayList<Request>();
//		Integer oldId = id;
//		Integer newId = 8888;
//		newId = ((oldId!=null) && (oldId >= 0))? oldId: newId;
//		System.out.println(newId);
//
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			// preparedStatements are safe from SQL injection & sanitize inputs
//			ps.setString(1, Integer.toString(newId));
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				reqArr.add(new Request(rs.getInt("reqid"),
//						rs.getInt("userid"), 
//						rs.getString("reqName"), 
//						rs.getString("reqType"),  
//						rs.getString("reqDesc"),  
//						rs.getString("reqJustify"),
//						rs.getString("reqDatetime"), 
//						rs.getString("reqPlace"),  
//						rs.getString("reqGradeType"),  
//						rs.getString("reqGradePass"), 
//						rs.getDouble("reqAmt"), 
//						rs.getInt("stage"))); 
//			}
//			System.out.println(" WHERE userid= SQL is All Good !");
//			return reqArr;
//		} catch (SQLException e) {
//			System.out.println("SQL issue with getting All REQUESTS WHERE userid=:\n "+e);
//		}
//		return null;
//	}
//	
//	@Override
//	public List<Request> listReq() {
////		List<Request> reqList = new ArrayList<Request>();
////		Set<Integer> keys = DB.reqs.keySet();
////		for (Integer k : keys)
////			reqList.add(DB.reqs.get(k));
////		return reqList;
//		String sql = "SELECT * FROM reqtable";
//		List<Request> reqArr = new ArrayList<Request>();
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			// preparedStatements are safe from SQL injection & sanitize inputs
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				reqArr.add(new Request(rs.getInt("reqid"),
//						rs.getInt("userid"), 
//						rs.getString("reqName"), 
//						rs.getString("reqType"),  
//						rs.getString("reqDesc"),  
//						rs.getString("reqJustify"),
//						rs.getString("reqDatetime"), 
//						rs.getString("reqPlace"),  
//						rs.getString("reqGradeType"),  
//						rs.getString("reqGradePass"), 
//						rs.getDouble("reqAmt"), 
//						rs.getInt("stage"))); 
//			}
//			System.out.println("SQL is All Good!");
//			return reqArr;
//		} catch (SQLException e) {
//			System.out.println("SQL issue with getting All REQUESTS:\n "+e);
//		}
//		return null;
//	}
//
//
//	@Override
//	public boolean updateReq(Request change) {
////		DB.users.replace(change.getReqId(), change);
////		return true;
//		System.out.println("Submitting from ReqDaoImpl: "+change);
////	    String sql = "UPDATE reqtable SET  userId=?, reqName=?, reqType=?,  reqDesc=?,  reqJustify=?,  reqDatetime=?, reqPlace=?, reqGradeType=?, reqGradePass=?,  reqAmt=?, stage=? WHERE reqId = ?";
//		String sql = "UPDATE reqtable SET stage = ? WHERE reqId = ?";	
//		try {
//			PreparedStatement ps = conn.prepareCall(sql); 
////			ps.setString(1, Integer.toString(change.getUserId()));
////			ps.setString(2, change.getReqName());
////			ps.setString(3, change.getReqType());
////			ps.setString(4, change.getReqDesc());
////			ps.setString(5, change.getReqJustify());
////			ps.setString(6, change.getReqDatetime());
////			ps.setString(7, change.getReqPlace());
////			ps.setString(8, change.getReqGradeType());
////			ps.setString(9, change.getReqGradePass());
////			ps.setString(10, Double.toString(change.getReqAmt()));
//			ps.setString(1, Integer.toString(change.getStage()));
//			ps.setString(2, Integer.toString(change.getReqId()));
//			ps.executeQuery();
//			System.out.println("success updating request!: reqId#"+change.getReqId());
//			return true;
//
//		} catch (SQLException e) {
//			System.out.println("Double Check updateReq DB SQL"+e);
//		}
//		return false; 
//	}
//
//	@Override
//	public boolean deleteReq(int id) {
////		DB.users.remove(req);
////		String sql = "DELETE usertable WHERE username = ?";
////		
////		try {
////			PreparedStatement ps = conn.prepareStatement(sql); 
////			ps.setString(1, u);
////			
//////			int var = 1;
//////			System.out.println(var);
//////			System.out.println("never delete ... ");
////			
////			return true;
////		} catch (Exception e) {
////	 System.out.println("doublecheck deletions: \n"+e);
////		}
////		return false;
////		}
//		return false;
//	}
//
//
//}
