package app.mapl.webservice;

import app.mapl.repositories.OffersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import app.mapl.models.Offer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OfferWebService  {
	OffersRepository offersRepository;
	public   void addOffer(HttpServletRequest request, HttpServletResponse response) {

		int userId = Integer.parseInt(request.getParameter("userId"));

			 Offer o = new Offer();
		 			 o.setUsername("test");
					  o.setCoinId(1);
					  o.setOfferAmt(1.0);
					  o.setOfferMos(1);

		System.out.println("ReqWebServ submit: " + o);
		// Call OfferService to add it.
		offersRepository.save(o);

		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			System.out.println("error adding??" + e1);
			;
//			e1.printStackTrace();
		}
	}
		 	//// EC2 WORKS   Offer URL: http://3.86.59.44:8080/project1/getOffer.do?reqId=101
	public   void getOffer(HttpServletRequest request, HttpServletResponse response) {

		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");

		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" + e1);
//			e1.printStackTrace();
		}

		int id = Integer.parseInt(request.getParameter("reqId"));
		System.out.println("just got parameter #:" + id);

		Optional<Offer> d = offersRepository.findById(id);
		if (d.isPresent()) {
			System.out.println("OfferWebServ: " + d.get());
		} else {
			System.out.println("OfferWebServ: " + d);
		}
		System.out.println(d.get());

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
	public   void listOffer(HttpServletRequest request, HttpServletResponse response) {
 
		String uid = request.getParameter("userId");
		String uuid = (uid == "") ? "0" : uid;
		Integer intId = Integer.parseInt(uuid);
		System.out.println("uid=" + uid + " intId=" + intId + "userId=" + uid);

		String uname = request.getParameter("username");
			List<Offer> offerList = offersRepository.findAllByUsername(uname);
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

	public   void updateOffer(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");

		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" + e1);
		}
		
		int reqId = Integer.parseInt(request.getParameter("reqId")); 

 
		Optional<Offer> rOptional = offersRepository.findById(reqId);
		Offer r = rOptional.get();
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
		offersRepository.saveAndFlush(r);

		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			System.out.println("error adding??" + e1);
			;
//			e1.printStackTrace();
		}

	}
}
 