package webservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
//import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
//https://github.com/google/gson/blob/master/UserAdminGuide.md
import com.google.gson.Gson;

import models.Request;

//import com.fasterxml.jackson.databind.ObjectMapper;

import models.UserAdmin;
import models.Dept;
import service.RequestService;
import service.UserAdminService;
import service.DeptService;

public class LoginWebService {

	public static void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");

		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" + e1);
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username1: " + username + "; password1: " + password);
		int dbId = 0;
		String dbUserAdmin = null;
		int dbSuper = 0;
		int dbDept = 0;
		/// ALL DEPTHEADS' IDs LISTED
		List<Dept> allDeptHeads = DeptService.listDept();
//		List<UserAdmin> myDeptMemberObjs = new ArrayList<UserAdmin>();
		List<Integer> myDeptMemberIds = new ArrayList<>();

		/// ALL SUPER's subs' IDs LISTED
		List<UserAdmin> allSuperIds = UserAdminService.listUserAdmin();
		List<Integer> mySubsIds = new ArrayList<>();

		// ALL SUPER's subs' OBJECTS LISTED
		List<UserAdmin> mySubsObjs = new ArrayList<UserAdmin>();
		// (GSON) ALL SUPER's subs' OBJECTS LISTED

		List<UserAdmin> uu = UserAdminService.listUserAdmin();
		List<UserAdmin> uuu = UserAdminService.listUserAdmin();
		Boolean valid = false;
		Boolean isSuper = false;
		System.out.println("this user is not verified as a Supervisor, checking tho...");
		Boolean isDeptHead = false;
		System.out.println("this user is not verified as a Dept Head, checking tho...");

		for (UserAdmin u : uu) { // this is user object logged in
			if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
				System.out.println("logged in! " + u.getUserName() + " matches " + username + "\n" + "and "
						+ u.getPassword() + " matches " + password + " :-)... welcome");
				valid = true;
				/// GET USER DETAILS
				UserAdmin userLogged = UserAdminService.getUserAdmin(u.getUserId());
				System.out.println(userLogged.toString());
				dbUserAdmin = userLogged.getUserName();
				dbId = userLogged.getUserId();
				dbSuper = userLogged.getSuperId();
				dbDept = userLogged.getDeptId();
				System.out.println("dbDept: " + dbDept + ", passes validation: " + valid);

				for (UserAdmin s : allSuperIds) { // I am listed as a super by these users...
					if (s.getSuperId() == userLogged.getUserId()) {
						isSuper = true;
						System.out.println( s.getSuperId() +"==== *IS* verified as a Supervisor: " + isSuper + "==========");
						// GET contact info of sub:
						System.out.println("LOOPING, after if: #Sub's id: " + s.getUserId() + ", #sub's name:" + s.getUserName()
								+ ", his/her email: " + s.getEmail()); 
						mySubsIds.add(s.getUserId()); // WORKS!!!==>>> SEND OUT 
						mySubsObjs.add(s);
					} 
				}
				
				System.out.println("list of my mySubs: " + mySubsIds);
// MAKE COOKIE *IS SUPERVISOR 
				Cookie isSuperCookie = new Cookie("isSuper", isSuper.toString());
				response.addCookie(isSuperCookie);
// COLLECT MY SUBORDINATES, PUT IN COOKIE
				System.out.println("list of my mySubs objs: " + mySubsObjs);
				int i = 0;
				for (UserAdmin m : mySubsObjs) {
					Integer mySubId = m.getUserId();
					Cookie SubId = new Cookie("sessOid" + i, Integer.toString(mySubId));
					response.addCookie(SubId);
					i++;
				}

				ObjectMapper om = new ObjectMapper();
				if (mySubsObjs != null) {
					try {
						String requestJSON = om.writeValueAsString(mySubsObjs);
						response.getWriter().append(requestJSON);
						PrintWriter r = response.getWriter().append(requestJSON);
						

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
		}
		for (UserAdmin u2 : uu) {
			if (u2.getUserName().equals(username)) { // this is user object logged in
				UserAdmin userLogged2 = UserAdminService.getUserAdmin(u2.getUserId());
				/// GET Dept DETAILS
				for (Dept dpt : allDeptHeads) {
					if (userLogged2.getUserId() == dpt.getDeptHeadId()) { // <<this logged in ==deptHead
						isDeptHead = true;
						System.out.println("..oh, this user *IS* verified as a Dept. Head.");

						System.out.println("======is Dept Head: " + isDeptHead + "=======");
						Dept deptToSee = DeptService.getDept(userLogged2.getDeptId()); // < get dept details
						System.out.println("deptHead Id: " + deptToSee.getDeptId() + ", Head: "
								+ deptToSee.getDeptHeadId() + ", logged-in Id: " + userLogged2.getUserId());
						System.out.println("deptHeadIds details: " + deptToSee.toString());
						for (UserAdmin uMember : uuu) {
							if (deptToSee.getDeptId() == uMember.getDeptId()) {
								myDeptMemberIds.add(uMember.getUserId()); // WORKS!!!
								System.out.println("list of my  Dept Underlings: 1 " + myDeptMemberIds);
							}
							System.out.println("list of my  Dept Underlings: 2 " + myDeptMemberIds);
						}
						System.out.println("list of my  Dept Underlings: 3 " + myDeptMemberIds);
					}
					System.out.println("list of my  Dept Underlings:4 " + myDeptMemberIds);
				}
				System.out.println("list of my deptMember objs: 5 " + myDeptMemberIds);
				int i = 0;
				for (UserAdmin m : mySubsObjs) {
					Integer myDids= m.getUserId();
					Cookie MyDcookie = new Cookie("dsessOid" + i, Integer.toString(myDids));
					response.addCookie(MyDcookie);
					i++;
				}
			}
		}
		System.out.println("if valid.." + valid);
		if (valid) {
			HttpSession sess = request.getSession();
			sess.setAttribute("sessionId", sess.getId());
			sess.setAttribute("username", username);
			sess.setAttribute("validated", "validated");
			System.out.println("UserAdmin: " + username + " is validated: " + valid);

			request.setAttribute("dbUserAdmin", dbUserAdmin);
			request.setAttribute("dbId", dbId);
			request.setAttribute("dbSuper", dbSuper);
			request.setAttribute("dbDept", dbDept);

			// If supervisor --> mySubsIds; Objs
			System.out.println("If supervisor --> mySubsIds; Objs");
			request.setAttribute("mySubsId", mySubsIds);
			request.setAttribute("mySubsId.toString()", mySubsIds.toString());
			request.setAttribute("mySubsObjs", mySubsObjs);
			request.setAttribute("mySubsObjs.toString()", mySubsObjs.toString());
			// COOKIES
			response.setContentType("text/html");
			response.getWriter().append("visiting LoginWebServices");
			Cookie sessUserAdmin = new Cookie("sessUserAdmin", dbUserAdmin);
			Cookie sessId = new Cookie("sessId", Integer.toString(dbId));
			Cookie sessSuper = new Cookie("sessSuper", Integer.toString(dbSuper));
			Cookie sessDept = new Cookie("sessDept", Integer.toString(dbDept));
			response.addCookie(sessId);
			response.addCookie(sessUserAdmin);
			response.addCookie(sessSuper);
			response.addCookie(sessDept);
			System.out.println("..just made cookies...");

			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);

		} else {
			System.out.println("failed validation");
			RequestDispatcher rdd = request.getRequestDispatcher("login.html");
			rdd.forward(request, response);
			request.setAttribute("errorMessage", "Oops, invalid credentials, typo maybe?");
		}
//class BagOfPrimitives {
//	  private int value1 = 1;
//	  private String value2 = "abc";
//	  private transient int value3 = 3;
//	  BagOfPrimitives() {  // no-args constructor
//	  }
//	}

		// Serialization
//		BagOfPrimitives obj = new BagOfPrimitives();
//		UserAdmin objUserAdmin = new UserAdmin();
//		Gson gson = new Gson();
//		String jsonmySubsObjs = gson.toJson(mySubsObjs);  

		/// GSON ///
		// Serialization
//	Gson gson = new Gson();
//	gson.toJson(1);            // ==> 1
//	gson.toJson("abcd");       // ==> "abcd"
//	gson.toJson(new Long(10)); // ==> 10
//	int[] values = { 1 };
//	gson.toJson(values);       // ==> [1]
		// Deserialization
//	int one = gson.fromJson("1", int.class);
//	Integer one = gson.fromJson("1", Integer.class);
//	Long one = gson.fromJson("1", Long.class);
//	Boolean false = gson.fromJson("false", Boolean.class);
//	String str = gson.fromJson("\"abc\"", String.class);
//	String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);
		/////////////////////
//class BagOfPrimitives {
//	  private int value1 = 1;
//	  private String value2 = "abc";
//	  private transient int value3 = 3;
//	  BagOfPrimitives() {
//	    // no-args constructor
//	  }
//	}
		// Serialization
//		BagOfPrimitives obj = new BagOfPrimitives();
//		Gson gson = new Gson();
//		String json = gson.toJson(obj);  
		// ==> json is {"value1":1,"value2":"abc"}
		// Deserialization
//	 JavaScript
//	 BagOfPrimitives obj2 = gson.fromJson(json, BagOfPrimitives.class);
		// ==> obj2 is just like obj
///////
//		int id = Integer.parseInt(request.getParameter("id"));
//		System.out.println("just got parameter #:" + id);
//
//		Request d = RequestService.getReq(id);
//		System.out.println(d);
//
//		ObjectMapper om = new ObjectMapper();
//		if (d != null) {
//			try {
//				String requestJSON = om.writeValueAsString(d);
////				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
//				response.getWriter().append(requestJSON);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} // ("Served at: ").append(request.getContextPath());
//		 
//		}
//		else {
//			try {
//				String notFound = "Oops, couldn't find that ID";
//				response.getWriter().append(notFound);
//			} catch (IOException e) { 
//				e.printStackTrace();
//			}	
//		}
/////
	}

}
