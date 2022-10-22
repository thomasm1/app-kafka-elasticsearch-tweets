package com.doggywood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggywood.entities.Pet;
import com.doggywood.repositories.PetRepository;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	PetRepository pr;
	
	@Override
	public Pet createPet(Pet pet) {
		return pr.save(pet);
	}

	@Override
	public Pet getPetById(int id) {
		return pr.findById(id).get();
	}

	@Override
	public List<Pet> getAllPets() {
		return (List<Pet>)pr.findAll();
	}

	@Override
	public Pet updatesPet(Pet change) {
		return pr.save(change);
	}

	@Override
	public boolean deletePet(Pet pet) {
		try {
			pr.delete(pet);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Pet> getAllPetsByCustomer(int cId) {
		return pr.findByCustId(cId);
	}

}
