package com.doggywood.services;

import java.util.List;

import com.doggywood.entities.Nft;

public interface NftService {

	public Nft createNft(Nft nft);
	public Nft getNftById(int id);
	public List<Nft> getAllNftsByCustomer(int cId);
	public List<Nft> getAllNfts();
	public Nft updatesNft(Nft change);
	public boolean deleteNft(Nft nft);
	
}
