//package systemCars;
//
// 
//import java.util.ArrayList; 
//import java.util.List;
//
//import models.Offer; 
//import service.OfferService;
////import dao.DAOimplement; 
//  
//public class OffersMain {
//
//	public void createOffer(Offer c) { 
//		Boolean newOffer = OfferService.createOffer(c);
//		System.out.println("Offer sucessfully submitted: + "+ newOffer+ "\n"); 
//	}
//	
//	public static void getOfferID(int id) { 
//		Offer newest = OfferService.getOffer(id);
//		System.out.println("instantiating offer id #"+id+"\n"); 
//		System.out.println(newest);
//	}
//	public static List<Offer> getOffers() { 
//		List<Offer> offerList = OfferService.getAllOffers();
//		for (Offer offer : offerList) {
//			System.out.println(offer); 
//		}
////		System.out.println(offerList);
//		return offerList;
//	}
//	 
//	public OffersMain() {   // Show all the offers on lot.
//
//		List<Offer> offerList = OfferService.getAllOffers();
//		System.out.println("OffersMain view: "+ offerList); 
//		System.out.println("The Customer Offer UI application is running ..."); 
//		 
//      
//	}
// 
//}
