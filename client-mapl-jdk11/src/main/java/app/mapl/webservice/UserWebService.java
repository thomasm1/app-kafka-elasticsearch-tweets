package app.mapl.webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.mapl.models.User;
import app.mapl.service.UserService;

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
		int groupsId = Integer.parseInt(request.getParameter("groupsId"));
		System.out.println(groupsId);
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String password = request.getParameter("password");
		String email = request.getParameter("email");

//		 add db using these fields
//		"user4", "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net"
//		User d = new User(999, groupsId,  userName, password, email);
//		System.out.println("UserWebService: "+d);

		// Call UserService to add it.
		UserService.createUser(new User("user4", "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net", "photopaath", "usergrup",0,0,"id"));

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
		System.out.println("getUser(name):"+u.getUserName());
		
		User d = UserService.getUser(u.getUserName());
		System.out.println("getUser(name):"+d.getUserId());
		 
		String dbUser = d.getUserName();
		int dbId = d.getUserId();
		int dbGroups = d.getGroups();
		System.out.println(dbUser+"..getting userInfo:" );

		HttpSession sess = request.getSession();   
		sess.setAttribute("sessionId", sess.getId());
		sess.setAttribute("useradminname", dbUser);
		sess.setAttribute("useradminid", dbId);
		sess.setAttribute("usergroups", dbGroups);

		Cookie sessUser = new Cookie("sessUser", dbUser);
		Cookie sessId = new Cookie("sessId", Integer.toString(dbId));
		Cookie sessGroups = new Cookie("sessGroups", Integer.toString(dbGroups));
		response.setContentType("text/html"); 
		response.addCookie(sessId);
		response.addCookie(sessUser);
		response.addCookie(sessGroups);
 
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

//	int userId, int groupsId, int superId, String userName, String password, String email

	public static void listUser(HttpServletRequest request, HttpServletResponse response) {
		
		List<User> d = UserService.getUsers();
		

		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		try {
			String userJSON = om.writeValueAsString(d);
			response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
			
			response.getWriter().append(userJSON);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // ("Served at: ").append(request.getContextPath());

	}

	public static void register(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("register");
	}

	public static void update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("update");
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete");
	}

	public static void get(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("get");
	}

	public static void getAll(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("getAll");
	}
}
