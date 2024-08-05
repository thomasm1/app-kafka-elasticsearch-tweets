package app.mapl.service;

import app.mapl.dao.NftDAO;
import app.mapl.dao.NftDAOimpl;
import app.mapl.models.Nft;

import java.util.List;

public class NftService {

	public static NftDAO nftdao = new NftDAOimpl();
 
//	 * This method is now a static version of the getNft() method. To get a nft by
//	 * its ID, call: NftService.getNft(id);
	 
	public static boolean createNft(Nft c) {
		return nftdao.createNft(c);
	}

	public static Nft getNft(int id) {
		return nftdao.getNft(id);
	};

	public static List<Nft> getAllNftsIOwn(String username) {
		return nftdao.getAllNftsIOwn(username);
	};

	public static List<Nft> getAllNfts() {
		return nftdao.getAllNfts();
	};

	public static List<Nft> getAllNftsCust() {
		return nftdao.getAllNftsCust();
	};

	public static boolean updateNft(Nft change) {
		return nftdao.updateNft(change);
	}

	public static boolean deleteNft(int id) {
		return nftdao.deleteNft(id);
	}

	public static void nftlotViewAll() {
		System.out.println(getAllNftsCust());
	};

}
