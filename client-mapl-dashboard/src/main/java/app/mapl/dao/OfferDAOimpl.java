package app.mapl.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.mapl.dataLoader.BookmarkManager;
import app.mapl.util.JDBCConnection;

import java.util.ArrayList;
import java.util.List;
//import java.util.Set;

//import db.DB;
import app.mapl.models.Offer;

public class OfferDAOimpl implements OfferDAO {
	public static Connection conn = JDBCConnection.getConnection();

	public boolean createOffer(Offer o) {
//		DB.offers.put(c.getOfferID(), c);
//		return true;
		String sql = "CALL ADD_NEW_COINOFFER(?,?, ?,?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
//int offerID, int userID, int coinID, double offerAmt, int offerMos, String offerStatus 

//			cs.setString(1, Integer.toString(o.getOfferID()));
			cs.setString(1, o.getUsername());
			cs.setString(2, Integer.toString(o.getCoinId()));
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
			String sql = "SELECT * FROM offers WHERE offerid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				return new Offer(rs.getInt("offerid"), rs.getString("username"), rs.getInt("coinid"),
						rs.getDouble("offerAmt"), rs.getInt("offerMos"), rs.getString("offerStatus"));
			}

		} catch (Exception e) {
			System.out.println("Please double-check the offer #");
			e.printStackTrace();
 		}
		return null;
	}

	////////////// GET OFFLINE     OFFERS ///////////////////
	@Override
	public  List<Offer> getOffers() {
		return  BookmarkManager.TestDataStore.getOffers();
	}

	public List<Offer> getAllOffers() {

		String sql = "SELECT * FROM offers";
		List<Offer> offerArr = new ArrayList<Offer>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// preparedStatements are safe from SQL injection & sanitize inputs
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offerArr.add(new Offer(rs.getInt("offerid"), rs.getString("username"), rs.getInt("coinid"),
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
		
		String sql = "SELECT * FROM offers WHERE username=?";
		List<Offer> offerArr = new ArrayList<Offer>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offerArr.add(new Offer(rs.getInt("offerid"), rs.getString("username"), rs.getInt("coinid"),
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
		String sql = "UPDATE offers SET username=?, coinID=?, offerAmt=?, offerMos=?, offerStatus=? WHERE offerID = ?";
//int offerID, int userID, int coinID, double offerAmt, int offerMos, String offerStatus 
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, change.getUsername());
			ps.setString(2, Integer.toString(change.getCoinId()));
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
		String sql = "UPDATE offers SET offerStatus=? WHERE offerStatus=? AND coinID = ?";
//		(0, offerLook.getUsername(), uCoin.getCoinID(), 0.0, 0, "PENDING")
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "REJECTED"); 
			ps.setString(2, change.getOfferStatus());
			ps.setString(3, Integer.toString(change.getCoinId()));
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
