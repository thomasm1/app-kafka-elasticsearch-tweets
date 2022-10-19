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
//https://github.com/google/gson/blob/master/UserGuide.md
import com.google.gson.Gson;

//import com.fasterxml.jackson.databind.ObjectMapper;

import models.User;
import models.Group;
import service.UserService;
import service.GroupService;

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
		String dbUser = null;
		int dbSuper = 0;
		int dbGroup = 0;
		/// ALL DEPTHEADS' IDs LISTED
		List<Group> allGroupHeads = GroupService.listGroup();
//		List<User> myGroupMemberObjs = new ArrayList<User>();
		List<Integer> myGroupMemberIds = new ArrayList<>();

		/// ALL SUPER's subs' IDs LISTED
		List<User> allSuperIds = UserService.getAllUsers();
		List<Integer> mySubsIds = new ArrayList<>();

		// ALL SUPER's subs' OBJECTS LISTED
		List<User> mySubsObjs = new ArrayList<User>();
		// (GSON) ALL SUPER's subs' OBJECTS LISTED

		List<User> uu = UserService.getUsers();
		List<User> uuu = UserService.getUsers();
		Boolean valid = false;
		Boolean isSuper = false;
		System.out.println("this user is not verified as a Supervisor, checking tho...");
		Boolean isGroupHead = false;
		System.out.println("this user is not verified as a Group Head, checking tho...");

		for (User u : uu) { // this is user object logged in
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				System.out.println("logged in! " + u.getUsername() + " matches " + username + "\n" + "and "
						+ u.getPassword() + " matches " + password + " :-)... welcome");
				valid = true;
				/// GET USER DETAILS
				User userLogged = UserService.getUser(u.getUsername());
				System.out.println(userLogged.toString());
				dbUser = userLogged.getUsername();
				dbId = userLogged.getUserId();
				dbGroup = userLogged.getGroup();
				System.out.println("dbGroup: " + dbGroup + ", passes validation: " + valid);

				
				System.out.println("list of my mySubs: " + mySubsIds);
// MAKE COOKIE *IS SUPERVISOR 
				Cookie isSuperCookie = new Cookie("isSuper", isSuper.toString());
				response.addCookie(isSuperCookie);
// COLLECT MY SUBORDINATES, PUT IN COOKIE
				System.out.println("list of my mySubs objs: " + mySubsObjs);
				int i = 0;
				for (User m : mySubsObjs) {
					Integer mySubId = m.getUserId();
					Cookie SubId = new Cookie("sessOid" + i, Integer.toString(mySubId));
					response.addCookie(SubId);
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
			System.out.println("User: " + username + " is validated: " + valid);

			request.setAttribute("dbUser", dbUser);
			request.setAttribute("dbId", dbId);
			request.setAttribute("dbGroup", dbGroup);

			// COOKIES
			response.setContentType("text/html");
			response.getWriter().append("visiting LoginWebServices");
			Cookie sessUser = new Cookie("sessUser", dbUser);
			Cookie sessId = new Cookie("sessId", Integer.toString(dbId));
			Cookie sessGroup = new Cookie("sessGroup", Integer.toString(dbGroup));
			response.addCookie(sessId);
			response.addCookie(sessUser);
			response.addCookie(sessGroup);
			System.out.println("..just made cookies...");

			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);

		} else {
			System.out.println("failed validation");
			RequestDispatcher rdd = request.getRequestDispatcher("login.html");
			rdd.forward(request, response);
			request.setAttribute("errorMessage", "Oops, invalid credentials, typo maybe?");
		}

  	}

}
