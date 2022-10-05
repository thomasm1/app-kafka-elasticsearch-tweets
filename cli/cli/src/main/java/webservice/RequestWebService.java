package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Request;
import service.RequestService;

public class RequestWebService {

	public static void addRequest(HttpServletRequest request, HttpServletResponse response) {

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
		Request d = new Request(reqId, userId, reqName, reqType, reqDesc, reqJustify, reqDatetime, reqPlace,
				reqGradeType, reqGradePass, reqAmt, stage, superText, dheadText, bencoText, reqText);
		System.out.println("ReqWebServ submit: " + d);
		System.out.println("ReqWebServ stage: " + stage);
		// Call RequestService to add it.
		RequestService.addReq(d);

		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			System.out.println("error adding??" + e1);
			;
//			e1.printStackTrace();
		}
	}
		 	//// EC2 WORKS   Request URL: http://3.86.59.44:8080/project1/getRequest.do?reqId=101
	public static void getRequest(HttpServletRequest request, HttpServletResponse response) {

		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");

		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" + e1);
//			e1.printStackTrace();
		}

		int id = Integer.parseInt(request.getParameter("reqId"));
		System.out.println("just got parameter #:" + id);

		Request d = RequestService.getReq(id);
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		if (d != null) {
			try {
				String requestJSON = om.writeValueAsString(d);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(requestJSON);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
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
       /// EC2  DOES NOT WORK =>       Request URL: http://3.86.59.44:8080/project1/listRequest.do?userId=4
	public static void listRequest(HttpServletRequest request, HttpServletResponse response) {
 
//		String uid = request.getParameter("userId");
		String uid = request.getParameter("userAdminId");
		String uuid = (uid == "") ? "8888" : uid;
		Integer intId = Integer.parseInt(uuid);
		System.out.println("uid=" + uid + " intId=" + intId + "userId=" + uid);

		if ((intId > 0) && (intId != 8888)) {
			List<Request> d = RequestService.listReq(intId);
			ObjectMapper om = new ObjectMapper();
			if (d.size() > 0) {
				try {
					String requestJSON = om.writeValueAsString(d);
//					response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
					response.getWriter().append(requestJSON);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // ("Served at: ").append(request.getContextPath());
			} else {
				try {
					response.getWriter().append("No Reimbursement Requests have been made.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (intId == 8888) {
			List<Request> dd = RequestService.listReq();
			System.out.println(dd);

			ObjectMapper om = new ObjectMapper();
			try {
				String requestJSON = om.writeValueAsString(dd);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(requestJSON);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // ("Served at: ").append(request.getContextPath());
		}

	}

	public static void updateReq(HttpServletRequest request, HttpServletResponse response) {
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
 
		Request r = RequestService.getReq(reqId);
		// add db using these fields
		System.out.println("ReqWebServ old one: " + r);
		r = new Request(reqId, r.getUserId(), r.getReqName(), r.getReqType(), r.getReqDesc(), r.getReqJustify(),
				r.getReqDatetime(), r.getReqPlace(), r.getReqGradeType(), r.getReqGradePass(), r.getReqAmt(), stage,
				superText, dheadText, bencoText, reqText);
		System.out.println("ReqWebServ new one: " + r);
		// Call RequestService to update it.
		RequestService.updateReq(r);

		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			System.out.println("error adding??" + e1);
			;
//			e1.printStackTrace();
		}

	}
}
 