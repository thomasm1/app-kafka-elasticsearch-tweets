package service;

import java.util.List;

import dao.OfferDAO;
import dao.OfferDAOimpl;
import models.Offer;

public class OfferService {

	public static OfferDAO offerdao = new OfferDAOimpl();
	public static OfferDAO offerdao2 = new OfferDAOimpl(); 

	public static boolean createOffer(Offer o) {
		System.out.println("service received:+ " + o + "\n");
		return offerdao.createOffer(o);
	}

	public static Offer getOffer(int id) {
		return offerdao.getOffer(id);
	};

	public static List<Offer> getAllOffers() {
		return offerdao.getAllOffers();
	};

	public static List<Offer> getAllOffersCust(String username) {
		return offerdao.getAllOffersCust(username);
	};

	public static boolean updateOffer(Offer change) {
		return offerdao.updateOffer(change);
	}

	public static boolean deleteOffer(int id) {
		return offerdao.deleteOffer(id);
	}

	public static boolean rejectOtherOffers(Offer rejectionChanges) {
		return offerdao.rejectOtherOffers(rejectionChanges);
	}
}
