package servproject1;
//import java.time.LocalDateTime;
import java.io.IOException;
//import java.io.PrintWriter; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import webservice.*;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) {
 
		HttpSession sess = request.getSession();
		sess.setMaxInactiveInterval(3600);
		sess.setAttribute("r-owner", "{'username', 'tom'},{'ordernum','222'}"); 
		System.out.println("RequestHelper: " + sess.getAttribute("r-owner"));
		 
//		sess.invalidate();  
		// This method will delegate other methods
		// on a different layer of our application
		// to process the request.

		String uri = request.getRequestURI();
		System.out.println(uri);
 
		switch (uri) {

		case "/cli/login.do": {
// LOGIN USER FORM
			try {
				LoginWebService.login(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
		}
		
// SIGN-IN USER FORM
		case "/cli/addUser.do": {
			UserWebService.createUser(request, response);
			break;
		} 
		case "/cli/getUser.do": {
			UserWebService.getUser(request, response);
			break;
		}
		case "/cli/listUser.do": {
			UserWebService.listUser(request, response);
			break;
		} 

//		case "/Task/MasterServlet": {
//			System.out.println("In MasterServlet *case*");
//			break;
//		}
		default: {
			try {
				response.sendError(451, "Get off my 451 lawn");
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		}

	}
}
