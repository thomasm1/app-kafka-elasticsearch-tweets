package app.mapl.webservice;

import java.io.IOException;
import java.util.List;

import app.mapl.dto.UserDto;
import app.mapl.models.User;
import app.mapl.repositories.UsersRepository;
import app.mapl.service.UsersServiceJPA;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserWebService {
	UsersRepository usersRepository;
	public void createUser(HttpServletRequest request, HttpServletResponse response) {

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
		String username = request.getParameter("username");
		System.out.println(username);
		String password = request.getParameter("password");
		String email = request.getParameter("email");

//		 add db using these fields
//		"user4", "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net"
//		User d = new User(999, groupsId,  username, password, email);
//		System.out.println("UserWebService: "+d);

		// Call UserService to add it.
	    usersRepository.save(new User(1, "t@t.com", "password", "lastNamedd", "firstnam", 1,   "5055087707" ,"user4@cryptomaven.xyz","http://www.dailytech.net", "photopaath", 0,0,null ));

		try {
			response.getWriter().append("Successfully added data to ORACLE (AWS) input: ").append(request.getContextPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
 
	public   void getUser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println("id: " + id);
		
		String username = request.getParameter("username");
		System.out.println("parameter: "+username);
		User u = usersRepository.findByEmail(username).orElseThrow();
		System.out.println("getUser(name):"+u.getUsername());

		User d = usersRepository.findByEmail(u.getUsername()).orElseThrow();

		String dbUser = d.getUsername();
		int dbId = d.getUserId();
		System.out.println(dbUser+"..getting userInfo:" );

		HttpSession sess = request.getSession();   
		sess.setAttribute("sessionId", sess.getId());
		sess.setAttribute("useradminname", dbUser);
		sess.setAttribute("useradminid", dbId);

		Cookie sessUser = new Cookie("sessUser", dbUser);
		Cookie sessId = new Cookie("sessId", Integer.toString(dbId));
		response.setContentType("text/html"); 
		response.addCookie(sessId);
		response.addCookie(sessUser);
 
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

//	int userId, int groupsId, int superId, String username, String password, String email

	public   void listUser(HttpServletRequest request, HttpServletResponse response) {
		
		List<User> d = usersRepository.findAll();


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
