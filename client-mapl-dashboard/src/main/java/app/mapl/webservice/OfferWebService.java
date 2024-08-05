package app.mapl.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import app.mapl.models.Offer;
import app.mapl.service.OfferService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OfferWebService  {

	public static void addOffer(HttpServletRequest request, HttpServletResponse response) {

//		int reqId = Integer.parseInt(request.getParameter("reqId"));
		int userId = Integer.parseInt(request.getParameter("userId"));

		String reqName = request.getParameter("reqName");
		String reqType = request.getParameter("reqType");
		String reqDesc = request.getParameter("reqDesc");

		String reqJustify = request.getParameter("reqJustify");
		String reqDatetime = request.getParameter("reqDatetime");
		String reqPlace = request.getParameter("reqPlace");

		String reqGradeType = request.getParameter("reqGradeType");
		String reqGradePass = request.getParameter("reqGradePass");
		double reqAmt = Double.parseDouble(request.getParameter("reqAmt"));
//		int stage = Integer.parseInt(request.getParameter("stage"));
		int stage = 0; // Starts at stage 0
		int reqId = 99; // Procedure auto-loads reqId
		String superText = "";
		String dheadText = "";
		String bencoText = "";
		String reqText = "";

		// add db using these fields
		// reqId, r.getUsername(), r.getCoinId(), r.getOfferAmt(), r.getOfferMos(), r.getOfferStatus()

			 Offer o = new Offer();
		 			 o.setUsername("test");
					  o.setCoinId(1);
					  o.setOfferAmt(1.0);
					  o.setOfferMos(1);

		System.out.println("ReqWebServ submit: " + o);
		System.out.println("ReqWebServ stage: " + stage);
		// Call OfferService to add it.
		OfferService.createOffer(o);

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

		Offer d = OfferService.getOffer(id);
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
		String uuid = (uid == "") ? "8888" : uid;
		Integer intId = Integer.parseInt(uuid);
		System.out.println("uid=" + uid + " intId=" + intId + "userId=" + uid);

		if ((intId > 0) && (intId != 8888)) {
			/// TODO change to String paramater
//			List<Offer> d = OfferService.getAllOffers(username);
			List<Offer> d = OfferService.getAllOffers();
			ObjectMapper om = new ObjectMapper();
			if (d.size() > 0) {
				try {
					String requestJSON = om.writeValueAsString(d);
//					response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
					response.getWriter().append(requestJSON);
				} catch (IOException e1) {
					e1.printStackTrace();
				} // ("Served at: ").append(request.getContextPath());
			} else {
				try {
					response.getWriter().append("No Reimbursement Requests have been made.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (intId == 8888) {
			List<Offer> dd = OfferService.getAllOffers();
			System.out.println(dd);

			ObjectMapper om = new ObjectMapper();
			try {
				String requestJSON = om.writeValueAsString(dd);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(requestJSON);
			} catch (IOException e1) {
				e1.printStackTrace();
			} // ("Served at: ").append(request.getContextPath());
		}

	}

	public static void updateOffer(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");

		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" + e1);
//			e1.printStackTrace();
		}
		
		int reqId = Integer.parseInt(request.getParameter("reqId")); 
		int stage = Integer.parseInt(request.getParameter("stage"));
		String superText = request.getParameter("superText");
		String dheadText = request.getParameter("dheadText");
		String bencoText = request.getParameter("bencoText");
		String reqText = request.getParameter("reqText");
 
		Offer r = OfferService.getOffer(reqId);
		// add db using these fields
		System.out.println("OfferWebServ old one: " + r);
		r = new Offer(reqId, r.getUsername(), r.getCoinId(), r.getOfferAmt(), r.getOfferMos(), r.getOfferStatus());
		System.out.println("OfferWebServ new one: " + r);
		// Call OfferService to update it.
		OfferService.updateOffer(r);

		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			System.out.println("error adding??" + e1);
			;
//			e1.printStackTrace();
		}

	}
}
 