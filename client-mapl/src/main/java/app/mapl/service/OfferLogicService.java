package app.mapl.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import app.mapl.dao.OfferLogicDAO;
import app.mapl.dao.OfferLogicDAOImpl;
import app.mapl.models.Offer;
import app.mapl.models.OfferLogic;
import app.mapl.repositories.OfferLogicRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OfferLogicService { // This is static version of DAO method

	public static OfferLogicDAO electro = new OfferLogicDAOImpl();

	@Autowired
	private OfferLogicRepository offerLogicRepository;

	public static OfferLogicService getInstance() {
		return new OfferLogicService();
	}
	public static OfferLogic getOfferLogic(int el) {
		return electro.getOfferLogic(el);

	}
	public static OfferLogic getOfferLogic(String username) {
		return electro.getOfferLogic(username);

	}

	public  List<OfferLogic> getAllOfferLogic() {
		try {
			return (List<OfferLogic>) offerLogicRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public static  List<OfferLogic>  getAllOfferLogic(String username) {
		return electro.getAllOfferLogic(username);
	}

	public static boolean addOfferLogic(OfferLogic el) {
		return electro.addOfferLogic(el);
	}

	public static boolean updateOfferLogic(OfferLogic change) {
		return electro.updateOfferLogic(change);
	}

	public static boolean deleteOfferLogic(int el) {
		return electro.deleteOfferLogic(el);
	}

}
