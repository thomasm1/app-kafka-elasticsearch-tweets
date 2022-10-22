package com.doggywood.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doggywood.entities.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

	List<Pet> findByCustId(int CId);
	
}
