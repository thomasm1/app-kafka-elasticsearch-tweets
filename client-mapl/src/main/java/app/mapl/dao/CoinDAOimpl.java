package app.mapl.dao;

import app.mapl.bootstrap.FileDataStore;
import app.mapl.models.Coin;
import app.mapl.config.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoinDAOImpl implements CoinDAO {

	public static Connection conn = JDBCConnection.getConnection();

///////////      CREATE     ///////////////
	public boolean createCoin(Coin c) {
//		DB.coins.put(c.getCoinID(), c);
//		return true;

		String sql = "CALL add_new_coin(?,?,?,?)";

		try {
			PreparedStatement cs = conn.prepareStatement(sql);
			cs.setString(1, c.getCoinToken());
			cs.setString(2, c.getCoinSymbol());
			cs.setString(3, Double.toString(c.getPriceTotal()));
			cs.setString(4, Integer.toString(c.isPurchased()));
			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double-check DB connection on creating coins");
			e.printStackTrace();
		}
		return false;
	}

//////////////  GET(ID)  ///////////////////
	public Coin getCoin(int id) {
//		return DB.coins.get(id);
		try {
			String sql = "SELECT * FROM cointable WHERE coinid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Coin(rs.getInt("coinID"), rs.getString("coinToken"), rs.getString("coinSymbol"),
						rs.getDouble("priceTotal"), rs.getInt("purchased"));
			}
		} catch (SQLException e) {
			System.out.println("Double-check DB connection on get-id");
			e.printStackTrace();
		}
		return null;
	}

	public List<Coin> getAllCoinsIOwn(String username) {
String sql = "SELECT o.username,  o.coinid,  o.offerstatus,  o.offermos, c.coinid, c.cointoken, c.coinsymbol, c.pricetotal FROM offers o JOIN cointable c ON c.coinid = o.coinid WHERE o.offerstatus = 'APPROVED' AND o.username = ?";
	List<Coin> coin = new ArrayList<Coin>();
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);    //
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			coin.add(new Coin(rs.getInt("coinID"), rs.getString("coinToken"), rs.getString("coinSymbol"), rs.getDouble("priceTotal"), rs.getInt("purchased")));
		}
		return coin;
	} catch (SQLException e) {
		System.out.println("Double-check DB connection on get-all-owned...");
		e.printStackTrace();
	}
	return null;
	}

////////////// GET OFFLINE CARS AND OFFERS ///////////////////
	@Override
	public List<Coin> getCoins() {
		return  FileDataStore.getCoins();
	}

////////////// GETALL (ADMIN VIEW)  ///////////////////
	public List<Coin> getAllCoins() {   // *Admin View of *all* coins in CoinLot (also purchased coins).
//		List<Coin> coinList = new ArrayList<Coin>();
//		Set<Integer> keys = DB.coins.keySet();
//		for(Integer k: keys)
//			coinList.add(DB.coins.get(k));
//		return coinList;
		String sql = "SELECT * FROM cointable";
		List<Coin> coin = new ArrayList<Coin>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				coin.add(new Coin(rs.getInt("coinID"), rs.getString("coinToken"), rs.getString("coinSymbol"), rs.getDouble("priceTotal"), rs.getInt("purchased")));
			}
			return coin;
		} catch (SQLException e) {
			System.out.println("Double-check DB connection on get-alls");
			e.printStackTrace();
		}
		return null;
	}

//////////////GETALL (CUSTOMER VIEW)  ///////////////////
	public List<Coin> getAllCoinsCust() {    // *Customer View of CoinLot (Only unpurchased coins).
		String sql = "SELECT * FROM cointable WHERE purchased=?";
		List<Coin> coin = new ArrayList<Coin>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);    //
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				coin.add(new Coin(rs.getInt("coinID"), rs.getString("coinToken"), rs.getString("coinSymbol"), rs.getDouble("priceTotal"), rs.getInt("purchased")));
			}
			return coin;
		} catch (SQLException e) {
			System.out.println("Double-check DB connection on gets");
			e.printStackTrace();
		}
		return null;
	}

////////////// UPDATE  ///////////////////
	public boolean updateCoin(Coin change) {
//		DB.coins.replace(change.getCoinID(), change); // (T t, String[] params);
//		return true;
		String sql = "UPDATE cointable SET coinToken=?, coinSymbol=?, priceTotal=?, purchased=? WHERE coinID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, change.getCoinToken());
			ps.setString(2, change.getCoinSymbol());
			ps.setString(3, Double.toString(change.getPriceTotal()));
			ps.setString(4, Integer.toString(change.isPurchased()));
			ps.setString(5, Integer.toString(change.getCoinId()));
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			System.out.println("Double-check DB foreign-keys on updates");
			e.printStackTrace();
		}
		return false;

	}

////////////// DELETE ///////////////////  *Not to be used in order to preserve records.
	public boolean deleteCoin(int id) {
//		DB.coins.remove(id);
//		return true;
		String sql = "DELETE cointable WHERE coinid = ?";
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
