package app.mapl.webservice;

import app.mapl.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println("session: " + session);

        User user = (User) session.getAttribute("user");

        System.out.println("ViewUserCommand: " + user);
        request.setAttribute("userDetails", user);
        return "userDetails";
    }

}
