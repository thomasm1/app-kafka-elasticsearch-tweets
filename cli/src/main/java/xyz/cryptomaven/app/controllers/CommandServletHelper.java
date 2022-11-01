package xyz.cryptomaven.app.controllers;

public class CommandServletHelper {

	public CommandServlet getCommand(String requestURI) {
		if(requestURI.contains("viewUserDetails.do")) {
			return (CommandServlet) new ViewUserCommand();
		}
		return null;
	}
}
