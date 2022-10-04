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
import models.Car;

public class CarDAOimpl implements CarDAO {

	public static Connection conn = JDBCConnection.getConnection();

///////////      CREATE     ///////////////
	public boolean createCar(Car c) {
//		DB.cars.put(c.getCarID(), c);
//		return true;

		String sql = "CALL add_new_car(?,?,?,?)"; 
 
		try { 
			PreparedStatement cs = conn.prepareStatement(sql); 
			cs.setString(1, c.getCarMake());
			cs.setString(2, c.getCarModel()); 
			cs.setString(3, Double.toString(c.getPriceTotal())); 
			cs.setString(4, Integer.toString(c.isPurchased()));  
			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double-check DB connection on creating cars");
			e.printStackTrace();
		}
		return false;
	}

//////////////  GET(ID)  ///////////////////
	public Car getCar(int id) {
//		return DB.cars.get(id);
		try {
			String sql = "SELECT * FROM cartable WHERE carid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Car(rs.getInt("carID"), rs.getString("carMake"), rs.getString("carModel"),
						rs.getDouble("priceTotal"), rs.getInt("purchased"));
			}
		} catch (SQLException e) {
			System.out.println("Double-check DB connection on get-id");
			e.printStackTrace();
		}
		return null;
	}

	public List<Car> getAllCarsIOwn(String username) { 
String sql = "SELECT o.username,  o.carid,  o.offerstatus,  o.offermos, c.carid, c.carmake, c.carmodel, c.pricetotal FROM offertable o JOIN cartable c ON c.carid = o.carid WHERE o.offerstatus = 'APPROVED' AND o.username = ?";
	List<Car> car = new ArrayList<Car>();
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);    //
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			car.add(new Car(rs.getInt("carID"), rs.getString("carMake"), rs.getString("carModel"), rs.getDouble("priceTotal"), rs.getInt("purchased")));		
		}
		return car;
	} catch (SQLException e) {
		System.out.println("Double-check DB connection on get-all-owned...");
		e.printStackTrace();
	}
	return null; 
	} 
	
////////////// GETALL (ADMIN VIEW)  ///////////////////
	public List<Car> getAllCars() {   // *Admin View of *all* cars in CarLot (also purchased cars).
//		List<Car> carList = new ArrayList<Car>();
//		Set<Integer> keys = DB.cars.keySet();
//		for(Integer k: keys)
//			carList.add(DB.cars.get(k));
//		return carList;
		String sql = "SELECT * FROM cartable";
		List<Car> car = new ArrayList<Car>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				car.add(new Car(rs.getInt("carID"), rs.getString("carMake"), rs.getString("carModel"), rs.getDouble("priceTotal"), rs.getInt("purchased")));		
			}
			return car;
		} catch (SQLException e) {
			System.out.println("Double-check DB connection on get-alls");
			e.printStackTrace();
		}
		return null;
	} 

//////////////GETALL (CUSTOMER VIEW)  ///////////////////
	public List<Car> getAllCarsCust() {    // *Customer View of CarLot (Only unpurchased cars).
		String sql = "SELECT * FROM cartable WHERE purchased=?";
		List<Car> car = new ArrayList<Car>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);    //
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				car.add(new Car(rs.getInt("carID"), rs.getString("carMake"), rs.getString("carModel"), rs.getDouble("priceTotal"), rs.getInt("purchased")));		
			}
			return car;
		} catch (SQLException e) {
			System.out.println("Double-check DB connection on gets");
			e.printStackTrace();
		}
		return null;
	}

////////////// UPDATE  ///////////////////
	public boolean updateCar(Car change) {
//		DB.cars.replace(change.getCarID(), change); // (T t, String[] params); 
//		return true;
		String sql = "UPDATE cartable SET carMake=?, carModel=?, priceTotal=?, purchased=? WHERE carID = ?";
	
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, change.getCarMake());
			ps.setString(2, change.getCarModel()); 
			ps.setString(3, Double.toString(change.getPriceTotal())); 
			ps.setString(4, Integer.toString(change.isPurchased())); 
			ps.setString(5, Integer.toString(change.getCarID())); 
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			System.out.println("Double-check DB foreign-keys on updates");
			e.printStackTrace();
		}
		return false;
	
	}

////////////// DELETE ///////////////////  *Not to be used in order to preserve records.
	public boolean deleteCar(int id) {
//		DB.cars.remove(id);
//		return true;
		String sql = "DELETE cartable WHERE carid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ps.executeQuery();

			return true;
		} catch (SQLException e) {
			System.out.println("Double-check DB foreign-keys on deletions");
			e.printStackTrace();
		}
		return false;
	}

	 
}
