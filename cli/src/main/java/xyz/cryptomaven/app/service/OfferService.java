package xyz.cryptomaven.app.service;

import java.util.List;

import xyz.cryptomaven.app.dao.OfferDAO;
import xyz.cryptomaven.app.dao.OfferDAOimpl;
import xyz.cryptomaven.app.models.Offer;

public class OfferService {

	public static OfferDAO offerdaoImpl = new OfferDAOimpl();

	public static boolean createOffer(Offer o) {
		System.out.println("service received:+ " + o + "\n");
		return offerdaoImpl.createOffer(o);
	}

	public static Offer getOffer(int id) {
		return offerdaoImpl.getOffer(id);
	};

	public static List<Offer> getAllOffers() {
		return offerdaoImpl.getAllOffers();
	};

	public static List<Offer> getAllOffersCust(String username) {
		return offerdaoImpl.getAllOffersCust(username);
	};

	public static boolean updateOffer(Offer change) {
		return offerdaoImpl.updateOffer(change);
	}

	public static boolean deleteOffer(int id) {
		return offerdaoImpl.deleteOffer(id);
	}

	public static boolean rejectOtherOffers(Offer rejectionChanges) {
		return offerdaoImpl.rejectOtherOffers(rejectionChanges);
	}
}
