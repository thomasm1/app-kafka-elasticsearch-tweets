package app.mapl.webservice;

import app.mapl.models.User;
import app.mapl.repositories.UsersRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewLoginCommand implements Command {

    UsersRepository usersRepository;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println("session: " + session);
//        session.setAttribute("user", new User(Arrays.toString(request.getParameterValues("username")), "Doe"));

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        User user = (User) session.getAttribute("user");
        User userRepo = usersRepository.findByUserNameAndPassword(request.getParameter("username"), request.getParameter("password"));
        System.out.println("userRepo: " + userRepo);
        if (userRepo != null) {
            session.setAttribute("user", userRepo);
            return "userDetails";
        }

        return null;
    }

}
