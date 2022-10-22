package com.doggywood.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.doggywood.entities.VaccRecord; 
import com.doggywood.services.VaccRecordService; 

@CrossOrigin(origins = "*")
@RestController
public class VaccRecordController {

	@Autowired
	VaccRecordService vrs;
	
	// CREATE
	@PostMapping(value = "/records", consumes = "application/json")
	public VaccRecord createVaccRecord(@RequestBody VaccRecord vr) {
		return vrs.createVaccRecord(vr);
	}
	// GET
	@GetMapping(value = "/records")
	public List<VaccRecord> getAllVaccRecords() {
		return vrs.getAllVaccRecords();
	}
	
	@GetMapping(value = "/records/{id}")
	public VaccRecord getVaccRecordById(@PathVariable("id") int id) {
		return vrs.getVaccRecordById(id);
	}

	@GetMapping(value = "/records/pet/{id}")
	public List<VaccRecord> getVaccRecordsByPetId(@PathVariable("id") int petId) {
		return vrs.getVaccRecordsByPetId(petId);
	}
 
	//UPDATE
	@PutMapping(value = "/records", consumes = "application/json")
	public VaccRecord updateVaccRecord(@RequestBody  VaccRecord vr) {
		return vrs.updateVaccRecord(vr);
	}

	@DeleteMapping(value = "/records/{id}")
	public boolean deleteVaccRecord(@PathVariable("id") int id ) {
		return vrs.deleteVaccRecord(vrs.getVaccRecordById(id));
	}
}
