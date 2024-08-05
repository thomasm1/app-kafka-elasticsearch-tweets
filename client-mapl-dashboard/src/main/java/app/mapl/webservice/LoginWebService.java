package app.mapl.webservice;

import java.io.IOException;
import java.util.ArrayList;
//import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//https://github.com/google/gson/blob/master/UserGuide.md

//import com.fasterxml.jackson.databind.ObjectMapper;

import app.mapl.dto.UserDto;
import app.mapl.models.User;
import app.mapl.models.Groups;
//import app.mapl.service.UserService;
import app.mapl.service.GroupsService;
import app.mapl.service.UsersServiceImpl;

@WebServlet(urlPatterns = { "/signin", "/login}" })
public class LoginWebService   extends HttpServlet {




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
		int dbGroups = 0;
		/// ALL DEPTHEADS' IDs LISTED
		List<Groups> allGroupsHeads = GroupsService.listGroups();
//		List<User> myGroupsMemberObjs = new ArrayList<User>();
		List<Integer> myGroupsMemberIds = new ArrayList<>();

		/// ALL SUPER's subs' IDs LISTED
		UsersServiceImpl userService = new UsersServiceImpl();
		List<UserDto> allSuperIds = userService.getUsers();
		List<Integer> mySubsIds = new ArrayList<>();

		// ALL SUPER's subs' OBJECTS LISTED
		List<User> mySubsObjs = new ArrayList<User>();
		// (GSON) ALL SUPER's subs' OBJECTS LISTED

		List<UserDto> uu = userService.getUsers();
		List<UserDto> uuu = userService.getUsers();
		Boolean valid = false;
		Boolean isSuper = false;
		System.out.println("this user is not verified as a Supervisor, checking tho...");
		Boolean isGroupsHead = false;
		System.out.println("this user is not verified as a Groups Head, checking tho...");

		for (UserDto u : uu) { // this is user object logged in
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				System.out.println("logged in! " + u.getUsername() + " matches " + username + "\n" + "and "
						+ u.getPassword() + " matches " + password + " :-)... welcome");
				valid = true;
				/// GET USER DETAILS
				Optional<UserDto> userLogged = userService.getUser(u.getUsername());
				System.out.println(userLogged.toString());
				dbUser = userLogged.get().getUsername();
				dbId = userLogged.get().getUserId();

				System.out.println("dbGroups: " + dbGroups + ", passes validation: " + valid);

				
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
			request.setAttribute("dbGroups", dbGroups);

			// COOKIES
			response.setContentType("text/html");
			response.getWriter().append("visiting LoginWebServices");
			Cookie sessUser = new Cookie("sessUser", dbUser);
			Cookie sessId = new Cookie("sessId", Integer.toString(dbId));
			Cookie sessGroups = new Cookie("sessGroup", Integer.toString(dbGroups));
			response.addCookie(sessId);
			response.addCookie(sessUser);
			response.addCookie(sessGroups);
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

	public static void logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logging out...");

	}
}
