package app.mapl.dao;

import app.mapl.dataLoader.FileDataStore;
import app.mapl.models.Nft;
import app.mapl.models.dto.UserNftbuy;
import app.mapl.config.JDBCConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class NftDAOimpl  implements NftDAO {

	private static final Logger log = LoggerFactory.getLogger(NftDAOimpl.class);

	public static Connection conn = JDBCConnection.getConnection();

///////////      CREATE     ///////////////
	public boolean createNft(Nft c) {

		return false;
	}

//////////////  GET(ID)  ///////////////////
	public Nft getNft(int id) {

		return null;
	}

	public List<Nft> getAllNftsIOwn(String username) {

	return null;
	}

////////////// GET OFFLINE CARS AND OFFERS ///////////////////
	@Override
	public List<Nft> getNfts() {
		return  FileDataStore.getNfts();
	}

////////////// GETALL (ADMIN VIEW)  ///////////////////
	public List<Nft> getAllNfts() {   // *Admin View of *all* nfts in NftLot (also purchased nfts).

		return null;
	}

//////////////GETALL (USER VIEW)  ///////////////////
	public List<Nft> getAllNftsCust() {    // *User View of NftLot (Only unpurchased nfts).

		return null;
	}

////////////// UPDATE  ///////////////////
	public boolean updateNft(Nft change) {

		return false;

	}

////////////// DELETE ///////////////////  *Not to be used in order to preserve records.
	public boolean deleteNft(int id) {
//		DB.nfts.remove(id);
//		return true;
		String sql = "DELETE nfttable WHERE nftid = ?";
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

	public void saveUserNftbuy(UserNftbuy userNftbuy) {
		FileDataStore.add(userNftbuy);
	}



}
