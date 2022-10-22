package com.doggywood.services;

import java.util.List;

import com.doggywood.entities.Pet;

public interface PetService {

	public Pet createPet(Pet pet);
	public Pet getPetById(int id);
	public List<Pet> getAllPetsByCustomer(int cId); 
	public List<Pet> getAllPets();
	public Pet updatesPet(Pet change);
	public boolean deletePet(Pet pet);
	
}
