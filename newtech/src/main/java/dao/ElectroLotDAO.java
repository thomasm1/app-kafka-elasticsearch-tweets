package dao;

import java.util.List;

import models.ElectroLot;

public interface ElectroLotDAO {
	
	// CRUD operations for model 
	public boolean addElectroLot(ElectroLot el);
	public ElectroLot getElectroLot(int id);
	public ElectroLot getElectroLot(String username); // for calling db with username!!
	public List<ElectroLot> getAllElectroLot();
	public List<ElectroLot> getAllElectroLot(String username);
	public boolean updateElectroLot(ElectroLot change);
	public boolean deleteElectroLot(int id); 
	
}
