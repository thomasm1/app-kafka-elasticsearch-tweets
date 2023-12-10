package app.mapl.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import app.mapl.dao.OfferDAO;
import app.mapl.dao.OfferDAOimpl;
import app.mapl.models.Offer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile(value={"dev"})
@RequiredArgsConstructor
public class OffersServiceImpl {
	private final static Logger log = LoggerFactory.getLogger(OffersServiceImpl.class);

	public static OfferDAO offerdaoImpl;

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

			Predicate<? super Offer> predicate =
					offer -> offer.getUsername().equalsIgnoreCase(username);

		   List<Offer> offers = offerdaoImpl.getAllOffers();

			return offers.stream().filter(predicate).collect(Collectors.toList());

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
