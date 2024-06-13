package app.mapl.webservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import app.mapl.models.auth.User;

public class ViewUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println("session: " + session);

        User user = (User) session.getAttribute("user");

        System.out.println("ViewUserCommand: " + user);
        request.setAttribute("userDetails", user);
        return "viewUserDetails";
    }

}
