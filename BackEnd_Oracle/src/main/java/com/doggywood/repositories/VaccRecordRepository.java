package com.doggywood.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.doggywood.entities.VaccRecord;

public interface VaccRecordRepository extends CrudRepository<VaccRecord, Integer> {
 
	List<VaccRecord> findAll();

	VaccRecord findById(int id);

	List<VaccRecord> findByPetId(int petId);


}
