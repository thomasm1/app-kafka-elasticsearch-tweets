package app.mapl.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import app.mapl.models.Offer;
import app.mapl.service.OffersServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OfferWebService  {

	public static void addOffer(HttpServletRequest request, HttpServletResponse response) {

		int userId = Integer.parseInt(request.getParameter("userId"));

			 Offer o = new Offer();
		 			 o.setUsername("test");
					  o.setCoinId(1);
					  o.setOfferAmt(1.0);
					  o.setOfferMos(1);

		System.out.println("ReqWebServ submit: " + o);
		// Call OfferService to add it.
		OffersServiceImpl.createOffer(o);

		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			System.out.println("error adding??" + e1);
			;
//			e1.printStackTrace();
		}
	}
		 	//// EC2 WORKS   Offer URL: http://3.86.59.44:8080/project1/getOffer.do?reqId=101
	public static void getOffer(HttpServletRequest request, HttpServletResponse response) {

		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");

		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" + e1);
//			e1.printStackTrace();
		}

		int id = Integer.parseInt(request.getParameter("reqId"));
		System.out.println("just got parameter #:" + id);

		Offer d = OffersServiceImpl.getOffer(id);
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		if (d != null) {
			try {
				String requestJSON = om.writeValueAsString(d);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(requestJSON);
			} catch (IOException e1) {
				e1.printStackTrace();
			} // ("Served at: ").append(request.getContextPath());

		} else {
			try {
				String notFound = "Oops, couldn't find that ID";
				response.getWriter().append(notFound);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
       /// EC2  DOES NOT WORK =>       Offer URL: http://3.86.59.44:8080/project1/listOffer.do?userId=4
	public static void listOffer(HttpServletRequest request, HttpServletResponse response) {
 
		String uid = request.getParameter("userId");
		String uuid = (uid == "") ? "0" : uid;
		Integer intId = Integer.parseInt(uuid);
		System.out.println("uid=" + uid + " intId=" + intId + "userId=" + uid);

		String uname = request.getParameter("username");
			List<Offer> offerList = OffersServiceImpl.getAllOffersCust(uname);
			ObjectMapper om = new ObjectMapper();
			if (offerList.size() > 0) {    //   HAS ID
				try {
					String requestJSON = om.writeValueAsString(offerList);
					response.getWriter().append("\n Welcome to Subservlet. You are accessing .do File\n request.getContextPath()");
					response.getWriter().append(request.getContextPath());
					response.getWriter().append(requestJSON);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					response.getWriter().append("No Reimbursement Requests have been made.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	public static void updateOffer(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");

		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" + e1);
		}
		
		int reqId = Integer.parseInt(request.getParameter("reqId")); 

 
		Offer r = OffersServiceImpl.getOffer(reqId);
		// add db using these fields
		System.out.println("OfferWebServ old one: " + r);
		r = new Offer(reqId,
				r.getUsername(),
				r.getCoinId(),
				r.getOfferAmt(),
				r.getOfferMos(),
				r.getOfferStatus(),
				r.getDescription(),
				r.getTargetDate(),
				r.isDone()
		);
		System.out.println("OfferWebServ new one: " + r);
		// Call OfferService to update it.
		OffersServiceImpl.updateOffer(r);

		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			System.out.println("error adding??" + e1);
			;
//			e1.printStackTrace();
		}

	}
}
 