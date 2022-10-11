package dao;

import java.util.List;
 
import models.Offer;

public interface OfferDAO {
	
	public boolean createOffer(Offer o); 
	public Offer getOffer(int id); 
	public List<Offer> getAllOffers(); 
	public List<Offer> getAllOffersCust(String username); 
	public boolean updateOffer(Offer change);
	public boolean 	rejectOtherOffers(Offer rejectionChanges);
	public boolean deleteOffer(int id);
	
} 