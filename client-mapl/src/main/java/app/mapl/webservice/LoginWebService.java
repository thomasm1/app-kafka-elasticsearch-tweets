package app.mapl.webservice;

import java.io.IOException;
//import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

//https://github.com/google/gson/blob/master/UserGuide.md

//import com.fasterxml.jackson.databind.ObjectMapper;

//import app.mapl.service.UserService;
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

		UsersServiceImpl userService = new UsersServiceImpl();


		Boolean valid = false;
		Boolean isSuper = false;
		System.out.println("this user is not verified as a Supervisor, checking tho...");
		Boolean isGroupsHead = false;
		System.out.println("this user is not verified as a Groups Head, checking tho...");



		System.out.println("if valid.." + valid);
		if (valid) {
			HttpSession sess = request.getSession();
			sess.setAttribute("sessionId", sess.getId());
			sess.setAttribute("username", username);
			sess.setAttribute("validated", "validated");
			System.out.println("User: " + username + " is validated: " + valid);

			request.setAttribute("dbUser", dbUser);
			request.setAttribute("dbId", dbId);

			// COOKIES
			response.setContentType("text/html");
			response.getWriter().append("visiting LoginWebServices");
			Cookie sessUser = new Cookie("sessUser", dbUser);
			Cookie sessGroups = new Cookie("sessGroup", Integer.toString(dbGroups));
			response.addCookie(new Cookie("sess.getId().toString()",sess.getId().toString()));
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
