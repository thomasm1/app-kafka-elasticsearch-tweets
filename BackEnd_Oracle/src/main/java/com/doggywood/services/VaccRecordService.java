package com.doggywood.services;

import java.util.List;

import com.doggywood.entities.VaccRecord;

public interface VaccRecordService {

	public VaccRecord createVaccRecord(VaccRecord vr);
	public VaccRecord getVaccRecordById(int id);
	public List<VaccRecord> getVaccRecordsByPetId(int petId);
	public List<VaccRecord> getAllVaccRecords();
	public VaccRecord updateVaccRecord(VaccRecord vr);
	public boolean deleteVaccRecord(VaccRecord vr);
 
}
