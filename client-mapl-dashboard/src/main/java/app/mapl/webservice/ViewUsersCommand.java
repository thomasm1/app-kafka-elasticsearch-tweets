package app.mapl.webservice;

import app.mapl.models.auth.User;
import app.mapl.repositories.UsersRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class ViewUsersCommand implements Command {
    UsersRepository usersRepository;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println("session: " + session);

        List<User> listUsers = usersRepository.findAll( );
        System.out.println("listUsers: " + listUsers);
        if (listUsers != null) {
            session.setAttribute("listUsers", listUsers);
            return "listUsers";
        }

        return null;
    }
}
