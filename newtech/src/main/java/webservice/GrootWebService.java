package webservice;
  
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Groot;
import service.GrootService;

public class GrootWebService {

	public static void getGroot(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		Groot p = GrootService.getGroot(id);
		
		ObjectMapper om = new ObjectMapper();
		
		try {
			String grootJSON = om.writeValueAsString(p);
			response.getWriter().append(grootJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	We need another method in our webservice to handle
//	adding groot. We already have a Service method
//	to do such. We just need to convert the info.
	
	public static void addGroot(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper om = new ObjectMapper();
		Groot p;
		try {
			p = om.readValue(request.getInputStream(), Groot.class);
		
		//First get all 3 parameters we passed in:
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String type = request.getParameter("type");
		
//		System.out.println(id + " " + name + " " + type);
//		//Then we will make a Groot from those fields:
//		Groot p = new Groot(id, name, type);
		
		//Call your GrootService to add it.
		GrootService.addGroot(p);
		
		//Send a simple response back in the response
		//just indicating something like:
			response.getWriter().append(om.writeValueAsString(p));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getAllGroot(HttpServletRequest request, HttpServletResponse response) {
		
		List<Groot> grootList = GrootService.getAllGroot();
		
		ObjectMapper om = new ObjectMapper();
		
		try {
			response.getWriter().append(om.writeValueAsString(grootList));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
