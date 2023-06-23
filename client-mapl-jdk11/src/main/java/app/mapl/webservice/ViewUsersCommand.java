package app.mapl.webservice;

import app.mapl.models.User;
import app.mapl.repositories.UsersRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
