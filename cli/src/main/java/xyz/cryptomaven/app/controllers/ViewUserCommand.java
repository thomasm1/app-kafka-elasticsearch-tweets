package xyz.cryptomaven.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.cryptomaven.app.models.User;

public class ViewUserCommand implements CommandServlet {
 

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		User user = new User(1, "tom", "m");
		request.setAttribute("userDetails", user);
		return "User details here";
	}
 

}
