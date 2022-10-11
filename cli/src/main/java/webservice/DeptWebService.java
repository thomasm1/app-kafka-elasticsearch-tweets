package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Dept;
import service.DeptService;
	
public class DeptWebService {


	public static void addDept(HttpServletRequest request, HttpServletResponse response) {

		int deptId = Integer.parseInt(request.getParameter("id"));
		int deptHeadId = Integer.parseInt(request.getParameter("deptHeadId"));
		String deptName = request.getParameter("deptName"); 
		
		// add db using these fields
		Dept d = new Dept(deptId, deptHeadId, deptName);
		System.out.println(d);

		// Call DeptService to add it.
		DeptService.addDept(d);
 
		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}  
	}

	public static void getDept(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id: " + id);

		Dept d = DeptService.getDept(id);
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		if (d != null) {
			try {
				String deptJSON = om.writeValueAsString(d);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(deptJSON);
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
	public static void listDept(HttpServletRequest request, HttpServletResponse response) {
		List<Dept> d = DeptService.listDept(); 
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		try {
			String deptJSON = om.writeValueAsString(d);
//			response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
			response.getWriter().append(deptJSON);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // ("Served at: ").append(request.getContextPath());
	 
	}
}
