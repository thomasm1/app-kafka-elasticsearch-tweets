package app.mapl.webservice;

import app.mapl.models.User;
import app.mapl.repositories.UsersRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class ViewLoginCommand implements Command {

    UsersRepository usersRepository;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println("session: " + session);
//        session.setAttribute("user", new User(Arrays.toString(request.getParameterValues("username")), "Doe"));

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("email: " + email);
        System.out.println("password: " + password);

        User user = (User) session.getAttribute("user");
        Optional<User> userRepo = usersRepository.findByEmailAndPassword(request.getParameter("email"), request.getParameter("password"));
        System.out.println("userRepo: " + userRepo);
        if (userRepo.isPresent()) {
            session.setAttribute("user", userRepo);
            return "userDetails";
        }

        return null;
    }

}
