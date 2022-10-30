package xyz.cryptomaven.app.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

@WebServlet("/cli/*.do")
public class FrontController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		CommandHelper commandHelper = new CommandHelper(); 
		
		Command command = commandHelper.getCommand(requestURI);
		String view = command.execute(request, response);
		
		Dispatcher dispatcher = new Dispatcher();  
		dispatcher.dispatch(request,response, view);
		
//		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
			
}
