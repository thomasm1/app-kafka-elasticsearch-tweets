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
import dao.GroupDao;
import models.Group; 
import util.JDBCConnection;

//can't make static, so use the service layer 
public class GroupDaoImpl implements GroupDao {
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addGroup(Group d) {
	  
		System.out.println("Submitting to groupDaoImpl: "+d);
		String sql = "CALL add_new_reqgrouptable(?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql); 
//			cs.setString(1, Integer.toString(d.getReqId()));
			cs.setString(1, Integer.toString(d.getGroupHeadId()));
			cs.setString(2, d.getGroupName());
 
			System.out.println("success to group!: reqId#"+d.getGroupName());
			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double Check add_new_reqgrouptable DB SQL");
			System.out.println(e);
		}
		return false;
	}


	@Override
	public Group getGroup(int groupId) {
	  
		try {
			String sql = "SELECT * FROM reqgrouptable WHERE groupid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(groupId));
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
			return new Group(
					rs.getInt("groupId"),
					rs.getInt("groupHeadid"), 
					rs.getString("groupName")); 
			}
	}		catch (Exception e) {
		System.out.println("SQL issue with getting group: \n"+e);
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
//						rs.getInt("groupid"), 
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
public List<Group> listGroup() {
	 
//		List<Request> reqList = new ArrayList<Request>();
//		Set<Integer> keys = DB.reqs.keySet();
//		for (Integer k : keys)
//			reqList.add(DB.reqs.get(k));
//		return reqList;
		String sql = "SELECT * FROM reqgrouptable";
		List<Group> groupArr = new ArrayList<Group>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// preparedStatements are safe from SQL injection & sanitize inputs
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				groupArr.add(new Group(rs.getInt("groupid"),
						rs.getInt("groupHeadId"), 
						rs.getString("groupName"))); 
			}
			System.out.println("SQL is All Good!");
			return groupArr;
		} catch (SQLException e) {
			System.out.println("SQL issue with getting All groups:\n "+e);
		}
		return null;
	}

@Override
public boolean updateGroup(Group change) {
	// TODO Auto-generated method stub
	return false;
}
//	@Override
//	public boolean updateReq(Request change) {
//		DB.users.replace(change.getReqId(), change);
//		return true;
//		String sql = "UPDATE usertable SET password=?, fullname=?, iscust=?, isowner=? WHERE username = ?";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql); 
////			ps.setString(6, Integer.toString(change.getReqID()));
//			ps.setString(1, change.getPassword());
//			ps.setString(2, change.getReqName());
//			ps.setString(3, Integer.toString(change.isCust()));
//			ps.setString(4, Integer.toString(change.isOwner())); 
//			ps.setString(5, change.getReqname());
//			ps.executeQuery();
//		
//			return true;
//		} catch (SQLException e) {
//			System.out.println("SQL issue with updating USER:\n "+e);
//		}
//		return false;
//	}

	@Override
	public boolean deleteGroup(int id) {
//		DB.users.remove(req);
//		String sql = "DELETE usertable WHERE username = ?";
//		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql); 
//			ps.setString(1, d);
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
