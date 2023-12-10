package app.mapl.webControllers;

import jakarta.validation.Valid;

import app.mapl.models.Offer;
import app.mapl.service.OffersServiceImpl;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("username")
@RequiredArgsConstructor
public class OfferController {

	private OffersServiceImpl offersServiceImpl;

	public OfferController(OffersServiceImpl offersServiceImpl){
		this.offersServiceImpl = offersServiceImpl;
	}

	
	@RequestMapping("/list-offers")
	public String listAllOffers(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<Offer> offers = offersServiceImpl.getAllOffersCust(username);
		model.addAttribute("offers", offers);
		
		return "listOffers";
	}

	@RequestMapping(value="/add-offer", method = RequestMethod.GET)
	public String showNewOfferPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		Offer offer = new Offer(0, username, 0, 88.88, 12, "PENDING","DESC", LocalDate.now().plusYears(1), false);
		model.put("offer", offer);
		return "offer";
	}
	//GET, POST

	@RequestMapping(value="add-offer", method = RequestMethod.POST)
	public String addNewOffer(ModelMap model, @Valid Offer offer, BindingResult result) {

		if(result.hasErrors()) {
			return "offer";
		}

		String username = getLoggedInUsername(model);
		Offer o = new Offer(0, username, 0, 88.88, 12, "PENDING","DESC", LocalDate.now().plusYears(1), false);
		offersServiceImpl.createOffer(o);
		return "redirect:list-offers";
	}

	@RequestMapping("delete-offer")
	public String deleteOffer(@RequestParam int id) {
		//Delete offer

		offersServiceImpl.deleteOffer(id);
		return "redirect:list-offers";

	}

	@RequestMapping(value="update-offer", method = RequestMethod.GET)
	public String showUpdateOfferPage(@RequestParam int id, ModelMap model) {
		Offer offer = offersServiceImpl.getOffer(id);
		model.addAttribute("offer", offer);
		return "offer";
	}

	@RequestMapping(value="update-offer", method = RequestMethod.POST)
	public String updateOffer(ModelMap model, @Valid Offer offer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "offer";
		}
		
		String username = getLoggedInUsername(model);
		offer.setUsername(username);
		offersServiceImpl.updateOffer(offer);
		return "redirect:list-offers";
	}

	private String getLoggedInUsername(ModelMap model) {
//		Authentication authentication =
//				SecurityContextHolder.getContext().getAuthentication();
//		return authentication.getName();
		return (String) model.get("username");
	}

}