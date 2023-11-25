package com.doggywood.services;

import java.util.List;

import com.doggywood.entities.Nft;
import com.doggywood.repositories.NftRepository;

@Service
public class NftServiceImpl implements NftService {

	@Autowired
	NftRepository pr;
	
	@Override
	public Nft createNft(Nft nft) {
		return pr.save(nft);
	}

	@Override
	public Nft getNftById(int id) {
		return pr.findById(id).get();
	}

	@Override
	public List<Nft> getAllNfts() {
		return (List<Nft>)pr.findAll();
	}

	@Override
	public Nft updatesNft(Nft change) {
		return pr.save(change);
	}

	@Override
	public boolean deleteNft(Nft nft) {
		try {
			pr.delete(nft);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Nft> getAllNftsByCustomer(int cId) {
		return pr.findByCustId(cId);
	}

}
