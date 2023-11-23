package app.mapl.dao;

import java.util.List;
 
import app.mapl.models.Offer;

public interface OfferDAO {
	
	public boolean createOffer(Offer o); 
	public Offer getOffer(int id);

	////////////// GET OFFLINE     OFFERS ///////////////////
	public  List<Offer> getOffers();

	public List<Offer> getAllOffers();
	public List<Offer> getAllOffersCust(String username); 
	public boolean updateOffer(Offer change);
	public boolean 	rejectOtherOffers(Offer rejectionChanges);
	public boolean deleteOffer(int id);
	
} 