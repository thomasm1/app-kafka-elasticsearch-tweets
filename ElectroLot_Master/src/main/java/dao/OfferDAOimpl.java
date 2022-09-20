package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.JDBCConnection;

import java.util.ArrayList;
import java.util.List;
//import java.util.Set;

//import db.DB;
import models.Offer; 

public class OfferDAOimpl implements OfferDAO {
	public static Connection conn = JDBCConnection.getConnection();

	public boolean createOffer(Offer o) {
//		DB.offers.put(c.getOfferID(), c);
//		return true;
		String sql = "CALL add_new_offer(?,?, ?,?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
//int offerID, int userID, int carID, double offerAmt, int offerMos, String offerStatus 

//			cs.setString(1, Integer.toString(o.getOfferID()));
			cs.setString(1, o.getUserName());
			cs.setString(2, Integer.toString(o.getCarID()));
			cs.setString(3, Double.toString(o.getOfferAmt()));
			cs.setString(4, Integer.toString(o.getOfferMos()));
			cs.setString(5, o.getOfferStatus());

			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("SQL offer connection failed, try again\n ... db must be warming up :-)");
			e.printStackTrace();
		}
		return false;
	}
 
	public Offer getOffer(int id) {
//		return DB.offers.get(id);
		try {
			String sql = "SELECT * FROM offertable WHERE offerid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				return new Offer(rs.getInt("offerid"), rs.getString("username"), rs.getInt("carid"),
						rs.getDouble("offerAmt"), rs.getInt("offerMos"), rs.getString("offerStatus"));
			}

		} catch (Exception e) {
			System.out.println("Please double-check the offer #");
			e.printStackTrace();
 		}
		return null;
	}

	public List<Offer> getAllOffers() {
//		List<Offer> offerList = new ArrayList<Offer>();
//		Set<Integer> keys = DB.offers.keySet();
//		for(Integer k: keys)
//			offerList.add(DB.offers.get(k));
//		return offerList;
		String sql = "SELECT * FROM offertable";
		List<Offer> offerArr = new ArrayList<Offer>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// preparedStatements are safe from SQL injection & sanitize inputs
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offerArr.add(new Offer(rs.getInt("offerid"), rs.getString("username"), rs.getInt("carid"),
						rs.getDouble("offerAmt"), rs.getInt("offerMos"), rs.getString("offerStatus")));
			}
			return offerArr;
		} catch (SQLException e) {
			System.out.println("getall offers SQL");
			e.printStackTrace();
}
		return null;
	}
	public List<Offer> getAllOffersCust(String username) {
//		List<Offer> offerList = new ArrayList<Offer>();
//		Set<Integer> keys = DB.offers.keySet();
//		for(Integer k: keys)
//			offerList.add(DB.offers.get(k));
//		return offerList; 
		
		String sql = "SELECT * FROM offertable WHERE username=?";
		List<Offer> offerArr = new ArrayList<Offer>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offerArr.add(new Offer(rs.getInt("offerid"), rs.getString("username"), rs.getInt("carid"),
						rs.getDouble("offerAmt"), rs.getInt("offerMos"), rs.getString("offerStatus")));
			}
			if (offerArr.size() == 0) {
				System.out.println("\nOops, you have no offers in the system:"+offerArr+"\n ...there's a first time for everything, press 4!\n");
			}
			return offerArr;
		} catch (SQLException e) {
			System.out.println("SQL issues ... try again please");
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateOffer(Offer change) {
//		DB.offers.replace(change.getOfferID(), change);
//		return true;
		String sql = "UPDATE offertable SET username=?, carID=?, offerAmt=?, offerMos=?, offerStatus=? WHERE offerID = ?";
//int offerID, int userID, int carID, double offerAmt, int offerMos, String offerStatus 
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, change.getUserName());
			ps.setString(2, Integer.toString(change.getCarID()));
			ps.setString(3, Double.toString(change.getOfferAmt()));
			ps.setString(4, Integer.toString(change.getOfferMos()));
			ps.setString(5, change.getOfferStatus());
			ps.setString(6, Integer.toString(change.getOfferID()));
			ps.executeQuery();

			return true;
		} catch (SQLException e) {
			System.out.println("update offers SQL");
			e.printStackTrace();
		}
		return false;

	}

	public boolean rejectOtherOffers(Offer change) {
//		DB.offers.replace(change.getOfferID(), change);
//		return true;
		String sql = "UPDATE offertable SET offerStatus=? WHERE offerStatus=? AND carID = ?";
//		(0, offerLook.getUserName(), uCar.getCarID(), 0.0, 0, "PENDING")
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "REJECTED"); 
			ps.setString(2, change.getOfferStatus());
			ps.setString(3, Integer.toString(change.getCarID()));
			ps.executeQuery();

			return true;
		} catch (SQLException e) {
		 	System.out.println("rejectAllOthers offers SQL");
			e.printStackTrace();

		}
		return false;

	}

	public boolean deleteOffer(int id) {
//		DB.offers.remove(id);
		return true;
	}

}
