package xyz.cryptomaven.app.controllers;

public class CommandHelper {

	public Command getCommand(String requestURI) {
		if(requestURI.contains("viewUserDetails.do")) {
			return new ViewUserCommand();
		}
		return null;
	}
}
