package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Group;
import service.GroupService;
	
public class GroupWebService {


	public static void addGroup(HttpServletRequest request, HttpServletResponse response) {

		int group = Integer.parseInt(request.getParameter("id"));
		int groupHeadId = Integer.parseInt(request.getParameter("groupHeadId"));
		String groupName = request.getParameter("groupName"); 
		
		// add db using these fields
		Group d = new Group(group, groupHeadId, groupName);
		System.out.println(d);

		// Call GroupService to add it.
		GroupService.addGroup(d);
 
		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}  
	}

	public static void getGroup(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id: " + id);

		Group d = GroupService.getGroup(id);
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		if (d != null) {
			try {
				String groupJSON = om.writeValueAsString(d);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(groupJSON);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // ("Served at: ").append(request.getContextPath());
		 
		}
		else {
			try {
				String notFound = "Oops, couldn't find that ID";
				response.getWriter().append(notFound);
			} catch (IOException e) { 
				e.printStackTrace();
			}	
		}
	}
	public static void listGroup(HttpServletRequest request, HttpServletResponse response) {
		List<Group> d = GroupService.listGroup(); 
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		try {
			String groupJSON = om.writeValueAsString(d);
//			response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
			response.getWriter().append(groupJSON);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // ("Served at: ").append(request.getContextPath());
	 
	}
}
