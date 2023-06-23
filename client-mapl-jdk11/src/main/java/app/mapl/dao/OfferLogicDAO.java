package app.mapl.dao;

import java.util.List;

import app.mapl.models.OfferLogic;

public interface OfferLogicDAO {
	
	// CRUD operations for model 
	public boolean addOfferLogic(OfferLogic el);
	public OfferLogic getOfferLogic(int id);
	public OfferLogic getOfferLogic(String username); // for calling db with username!!
	public List<OfferLogic> getAllOfferLogic();
	public List<OfferLogic> getAllOfferLogic(String username);
	public boolean updateOfferLogic(OfferLogic change);
	public boolean deleteOfferLogic(int id);


}
