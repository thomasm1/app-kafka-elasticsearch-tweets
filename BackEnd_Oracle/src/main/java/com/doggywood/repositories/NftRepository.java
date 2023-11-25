package com.doggywood.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doggywood.entities.Nft;

@Repository
public interface NftRepository extends CrudRepository<Nft, Integer> {

	List<Nft> findByCustId(int CId);
	
}
