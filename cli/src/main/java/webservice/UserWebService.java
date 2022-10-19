package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.User;
import service.UserService;

public class UserWebService {

	public static void createUser(HttpServletRequest request, HttpServletResponse response) {

		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");
			
		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" +e1);
//			e1.printStackTrace();
		}
//		int userId = Integer.parseInt(request.getParameter("id"));
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		System.out.println(groupId);
		int superId = Integer.parseInt(request.getParameter("superId"));
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String password = request.getParameter("password");
		String email = request.getParameter("email");

//		 add db using these fields 
		User d = new User(999, groupId, superId, userName, password, email);
		System.out.println("UserWebService: "+d);

		// Call UserService to add it.
		UserService.createUser(d);

		try {
			response.getWriter().append("Successfully added data to ORACLE (AWS) input: " + request.getContextPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
 
	public static void getUser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println("id: " + id);
		
		String userName = request.getParameter("username");
		System.out.println("parameter: "+userName);
		User u = UserService.getUser(userName);
		System.out.println("getUser(name):"+u.getUsername());
		
		User d = UserService.getUser(u.getUsername());
		System.out.println("getUser(name):"+d.getUserId());
		 
		String dbUser = d.getUsername();
		int dbId = d.getUserId();
		int dbGroup = d.getGroup();
		System.out.println(dbUser+"..getting userInfo:" );

		HttpSession sess = request.getSession();   
		sess.setAttribute("sessionId", sess.getId());
		sess.setAttribute("useradminname", dbUser);
		sess.setAttribute("useradminid", dbId);
		sess.setAttribute("usergroup", dbGroup); 

		Cookie sessUser = new Cookie("sessUser", dbUser);
		Cookie sessId = new Cookie("sessId", Integer.toString(dbId));
		Cookie sessGroup = new Cookie("sessGroup", Integer.toString(dbGroup));
		response.setContentType("text/html"); 
		response.addCookie(sessId);
		response.addCookie(sessUser);
		response.addCookie(sessGroup);
 
		ObjectMapper om = new ObjectMapper();
		if (d != null) {
			try {
				String userJSON = om.writeValueAsString(d);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(userJSON);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // ("Served at: ").append(request.getContextPath());

		}  
	}

//	int userId, int groupId, int superId, String userName, String password, String email  

	public static void listUser(HttpServletRequest request, HttpServletResponse response) {
		
		List<User> d = UserService.getUsers();
		

		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		try {
			String userJSON = om.writeValueAsString(d);
//			response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
			
			response.getWriter().append(userJSON);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // ("Served at: ").append(request.getContextPath());

	}
}
