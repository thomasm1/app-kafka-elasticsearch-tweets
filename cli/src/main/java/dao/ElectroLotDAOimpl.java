package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ElectroLot; 
import util.JDBCConnection;
import service.OfferService;
import service.CarService;
import service.UserService;

public class ElectroLotDAOimpl implements ElectroLotDAO {

	public static Connection conn = JDBCConnection.getConnection();

	public boolean addElectroLot(ElectroLot el) {
		String sql = "CALL add_new_electroLot(?,?,?, ?,?,?, ?,?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(el.getOfferid()));
			cs.setString(2, Integer.toString(el.getCarid()));
			cs.setString(3, el.getUsername());
			cs.setString(4, Double.toString(el.getPricetotal()));
			cs.setString(5, Double.toString(el.getOfferamt()));
			cs.setString(6, Double.toString(el.getBalance()));
			cs.setString(7, Integer.toString(el.getOffermos()));
			cs.setString(8, Integer.toString(el.getMonthsRemaining())); 
			cs.setString(9, Double.toString(el.getMonthlyPayments()));
			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Large Number Warning-Use higher precision");
			e.printStackTrace();
}
		return false;
	}
	public ElectroLot getElectroLot(int id) {
		try {
			String sql = "SELECT * FROM electroLot WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
//				return new ElectroLot(rs.getInt("ID"), rs.getString("NAME"), rs.getString("---"));
			}

		} catch (Exception e) {
			System.out.println("(id): check SQL");
			e.printStackTrace();
		}
		return null;
	}

	public ElectroLot getElectroLot(String username) {

		try {
			String sql = "SELECT * FROM electrolot WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				return new ElectroLot(rs.getInt("ID"), rs.getInt("OFFERID"), rs.getInt("CARID"), rs.getString("USERNAME"),  rs.getDouble("PRICETOTAL"), rs.getDouble("OFFERAMT"), rs.getDouble("BALANCE"), rs.getInt("OFFERMOS"), rs.getInt("monthsRemaining"), rs.getDouble("MONTHLYPAYMENTS"));
			}

		} catch (SQLException e) {
			System.out.println("GetElectrolot(username): check SQL");
			e.printStackTrace();
		}
		return null;
	}

	public List<ElectroLot> getAllElectroLot(String username) {
		String sql2 = "SELECT o.username,  o.carid,  o.offerstatus,  o.offermos, c.carid, c.carmake, c.carmodel, c.pricetotal FROM offertable o JOIN cartable c ON c.carid = o.carid WHERE o.offerstatus = 'APPROVED' AND o.username = ?";
		List<ElectroLot> electroLot = new ArrayList<ElectroLot>();
				
		try {   
			PreparedStatement ps = conn.prepareStatement(sql2);
			ps.setString(1, username); 
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 electroLot.add(new ElectroLot(rs.getInt("ID"),  rs.getInt("OFFERID"), rs.getInt("CARID"), 
						 rs.getString("USERNAME"),  rs.getDouble("PRICETOTAL"), rs.getDouble("OFFERAMT"), rs.getDouble("BALANCE"), rs.getInt("OFFERMOS"), rs.getInt("MonthsRemaining"), rs.getDouble("MonthlyPayments")));
	}
			return electroLot;
		} catch (SQLException e) {
			System.out.println("Double Check Updated DB's Electrolot customer's list");
			e.printStackTrace();
		}
		return null;
	}
	public List<ElectroLot> getAllElectroLot() {
		String sql = "SELECT * FROM electroLot";
		List<ElectroLot> electroLot = new ArrayList<ElectroLot>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 electroLot.add(new ElectroLot(rs.getInt("ID"),  rs.getInt("OFFERID"), rs.getInt("CARID"), 
						 rs.getString("USERNAME"),  rs.getDouble("PRICETOTAL"), rs.getDouble("OFFERAMT"), rs.getDouble("BALANCE"), rs.getInt("OFFERMOS"), rs.getInt("MonthsRemaining"), rs.getDouble("MonthlyPayments")));
			}
			return electroLot;
		} catch (SQLException e) {
			System.out.println("Double Check Updated DB's (GETALL) customer's list");
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateElectroLot(ElectroLot change) {
		String sql = "UPDATE electroLot SET username = ?, carid = ? WHERE offerid = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, change.getUsername()); 
			ps.setString(2, Integer.toString(change.getCarid()));
			ps.setString(3, Integer.toString(change.getOfferid()));

			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			System.out.println("Double Check Updated DB's Electrolot update customer's list");
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteElectroLot(int id) {
		String sql = "DELETE electroLot WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ps.executeQuery();

			return true;
		} catch (SQLException e) {
			System.out.println("exception " + e);
			System.out.println("Double Check Deletions on DB's customer's list");
			e.printStackTrace();
		}
		return false;
	}


}
