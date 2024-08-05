package app.mapl.dao;

import app.mapl.models.Nft;

import java.util.List;

public interface NftDAO {
	
	public boolean createNft(Nft c); // void
	public Nft getNft(int id);
	public List<Nft> getAllNfts();
	public List<Nft> getAllNftsCust();
	public List<Nft> getAllNftsIOwn(String username);
	public boolean updateNft(Nft change); // void
	public boolean deleteNft(int id); // void 
	
	public List<Nft> getNfts();
	 
	
} 