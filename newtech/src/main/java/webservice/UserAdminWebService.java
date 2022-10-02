package webservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.UserAdmin;
import service.UserAdminService;

public class UserAdminWebService {

	public static void addUserAdmin(HttpServletRequest request, HttpServletResponse response) {

		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");
			
		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" +e1);
//			e1.printStackTrace();
		}
//		int userId = Integer.parseInt(request.getParameter("id"));
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		System.out.println(deptId);
		int superId = Integer.parseInt(request.getParameter("superId"));
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String password = request.getParameter("password");
		String email = request.getParameter("email");

//		 add db using these fields 
		UserAdmin d = new UserAdmin(999, deptId, superId, userName, password, email);
		System.out.println("UserAdminWebService: "+d);

		// Call UserAdminService to add it.
		UserAdminService.addUserAdmin(d);

		try {
			response.getWriter().append("Successfully added data to ORACLE (AWS) input: " + request.getContextPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
 
	public static void getUserAdmin(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println("id: " + id);
		
		String userName = request.getParameter("username");
		System.out.println("parameter: "+userName);
		UserAdmin u = UserAdminService.getUserAdmin(userName);
		System.out.println("getUserAdmin(name):"+u.getUserAdminName());
		
		UserAdmin d = UserAdminService.getUserAdmin(u.getUserAdminId());
		System.out.println("getUserAdmin(name):"+d.getUserAdminId());
		 
		String dbUserAdmin = d.getUserAdminName();
		int dbId = d.getUserAdminId();
		int dbSuper = d.getSuperId();
		int dbDept = d.getDeptId();
		System.out.println(dbUserAdmin+"..getting userInfo:" ); 

		HttpSession sess = request.getSession();   
		sess.setAttribute("sessionId", sess.getId());
		sess.setAttribute("username", dbUserAdmin);  
		sess.setAttribute("userid", dbId);  
		sess.setAttribute("usersuper", dbSuper); 
		sess.setAttribute("userdept", dbDept); 

		Cookie sessUserAdmin = new Cookie("sessUserAdmin", dbUserAdmin);
		Cookie sessId = new Cookie("sessId", Integer.toString(dbId));
		Cookie sessSuper = new Cookie("sessSuper", Integer.toString(dbSuper));
		Cookie sessDept = new Cookie("sessDept", Integer.toString(dbDept));
		response.setContentType("text/html"); 
		response.addCookie(sessId);
		response.addCookie(sessUserAdmin);
		response.addCookie(sessSuper);
		response.addCookie(sessDept);
 
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

//	int userId, int deptId, int superId, String userName, String password, String email  

	public static void listUserAdmin(HttpServletRequest request, HttpServletResponse response) {
		
		List<UserAdmin> d = UserAdminService.listUserAdmin(); 
		

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
