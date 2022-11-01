package xyz.cryptomaven.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandServlet {
	String execute(HttpServletRequest request, HttpServletResponse response);
}
