package com.doggywood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doggywood.entities.VaccRecord;
import com.doggywood.repositories.VaccRecordRepository;

@Service
public class VaccRecordServiceImpl implements VaccRecordService {

	@Autowired
	VaccRecordRepository vrr;
	
	@Override
	public VaccRecord createVaccRecord(VaccRecord vr) {
		return vrr.save(vr);
	}

	@Override
	public List<VaccRecord> getAllVaccRecords() {
		return (List<VaccRecord>)vrr.findAll();
	}
	@Override
	public VaccRecord getVaccRecordById(int id) {
		return vrr.findById(id);
	}

	@Override
	public List<VaccRecord> getVaccRecordsByPetId(int petId) {
		return vrr.findByPetId(petId);
	}

	@Override
	public VaccRecord updateVaccRecord(VaccRecord change) {
		return vrr.save(change);
	}

 
	@Override
	public boolean deleteVaccRecord(VaccRecord vr) {
		try {
			vrr.delete(vr);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}


}
