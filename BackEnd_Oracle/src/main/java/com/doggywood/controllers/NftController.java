package com.doggywood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doggywood.entities.Nft;
import com.doggywood.services.NftService;

@CrossOrigin(origins = "*")
@RestController
public class NftController {

	@Autowired
	NftService ps;
	
	@RequestMapping(value = "/nfts", method = RequestMethod.POST, consumes = "application/json")
	public Nft createNft(@RequestBody Nft nft) {
		return ps.createNft(nft);
	}
	
	@GetMapping(value = "/nfts/{id}")
	public Nft getNftById(@PathVariable("id") int id) {
		return ps.getNftById(id);
	}

	@GetMapping(value = "/nfts")
	public List<Nft> getAllNfts() {
		return ps.getAllNfts();
	}

	@PutMapping(value = "/nfts", consumes = "application/json")
	public Nft updatesNft(Nft change) {
		return ps.updatesNft(change);
	}

	@DeleteMapping(value = "/nfts/{id}")
	public boolean deleteNft(@PathVariable("id") int id) {
		try {
			ps.deleteNft(ps.getNftById(id));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	//Come back to this to provide restfull route
	@GetMapping(value = "/customers/{cId}/nfts")
	public List<Nft> getAllNftsByCustomer(@PathVariable("cId") int cId) {
		return ps.getAllNftsByCustomer(cId);
	}
	 
}
