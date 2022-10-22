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

import com.doggywood.entities.Pet;
import com.doggywood.services.PetService;

@CrossOrigin(origins = "*")
@RestController
public class PetController {

	@Autowired
	PetService ps;
	
	@RequestMapping(value = "/pets", method = RequestMethod.POST, consumes = "application/json")
	public Pet createPet(@RequestBody Pet pet) {
		return ps.createPet(pet);
	}
	
	@GetMapping(value = "/pets/{id}")
	public Pet getPetById(@PathVariable("id") int id) {
		return ps.getPetById(id);
	}

	@GetMapping(value = "/pets")
	public List<Pet> getAllPets() {
		return ps.getAllPets();
	}

	@PutMapping(value = "/pets", consumes = "application/json")
	public Pet updatesPet(Pet change) {
		return ps.updatesPet(change);
	}

	@DeleteMapping(value = "/pets/{id}")
	public boolean deletePet(@PathVariable("id") int id) {
		try {
			ps.deletePet(ps.getPetById(id));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	//Come back to this to provide restfull route
	@GetMapping(value = "/customers/{cId}/pets")
	public List<Pet> getAllPetsByCustomer(@PathVariable("cId") int cId) {
		return ps.getAllPetsByCustomer(cId);
	}
	 
}
