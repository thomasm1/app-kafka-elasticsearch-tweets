package app.mapl.webservice;

import java.io.IOException;
//import java.io.IOException;

import app.mapl.service.UsersService;
import com.mysql.cj.log.Log;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


//import com.fasterxml.jackson.databind.ObjectMapper;

//import app.mapl.service.UserService;

@Slf4j
@WebServlet(urlPatterns = { "/signin", "/login}" })
public class LoginWebService   extends HttpServlet {

	@Value("${spring.datasource.driver-class-name}")
	private static String APP_DRIVER;

	@Autowired
	private final UsersService userService;
	public LoginWebService(UsersService userService) {
		this.userService = userService;
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			System.out.println(Class.forName(APP_DRIVER));
			log.info("... JDBC Drive successfully connected.");

		} catch (ClassNotFoundException e1) {
			log.info("oops, Driver not found :-O...\n" + e1);
		}

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		log.info("email1: " + email + "; password1: " + password);
		userService.loginUser(email, password);
		int dbId = 0;
		String dbUser = null;
		int dbSuper = 0;
		int dbGroups = 0;
		/// ALL DEPTHEADS' IDs LISTED


		Boolean valid = false;
		Boolean isSuper = false;
		log.info("this user is not verified as a Supervisor, checking tho...");
		Boolean isGroupsHead = false;
		log.info("this user is not verified as a Groups Head, checking tho...");



		log.info("if valid.." + valid);
		if (valid) {
			HttpSession sess = request.getSession();
			sess.setAttribute("sessionId", sess.getId());
			sess.setAttribute("email", email);
			sess.setAttribute("validated", "validated");
			log.info("User: " + email + " is validated: " + valid);

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
			log.info("..just made cookies...");

			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);

		} else {
			log.info("failed validation");
			RequestDispatcher rdd = request.getRequestDispatcher("login.html");
			rdd.forward(request, response);
			request.setAttribute("errorMessage", "Oops, invalid credentials, typo maybe?");
		}

  	}

	public static void logout(HttpServletRequest request, HttpServletResponse response) {
		log.info("logging out...");

	}
}
