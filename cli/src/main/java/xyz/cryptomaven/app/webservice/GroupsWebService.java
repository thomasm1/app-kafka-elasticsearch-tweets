package xyz.cryptomaven.app.webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import xyz.cryptomaven.app.models.Groups;
import xyz.cryptomaven.app.service.GroupsService;
	
public class GroupsWebService {


	public static void addGroups(HttpServletRequest request, HttpServletResponse response) {

		int groups = Integer.parseInt(request.getParameter("id"));
		int groupsHeadId = Integer.parseInt(request.getParameter("groupsHeadId"));
		String groupsName = request.getParameter("groupsName");
		
		// add db using these fields
		Groups d = new Groups(groups, groupsHeadId, groupsName);
		System.out.println(d);

		// Call GroupsService to add it.
		GroupsService.addGroups(d);
 
		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}  
	}

	public static void getGroups(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id: " + id);

		Groups d = GroupsService.getGroups(id);
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		if (d != null) {
			try {
				String groupsJSON = om.writeValueAsString(d);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(groupsJSON);
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
	public static void listGroups(HttpServletRequest request, HttpServletResponse response) {
		List<Groups> d = GroupsService.listGroups();
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		try {
			String groupsJSON = om.writeValueAsString(d);
//			response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
			response.getWriter().append(groupsJSON);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // ("Served at: ").append(request.getContextPath());
	 
	}
}
