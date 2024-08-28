package app.mapl.webservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Dispatcher {
    public void dispatch(HttpServletRequest request, HttpServletResponse response, String view){
        if(view != null) {
            try {
                request.getRequestDispatcher(mapPageToView(view)).forward(request, response);
            } catch (ServletException  | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String mapPageToView(String view) {
        if(view.contains("user")) {
            System.out.println("viewUserDetails|| |");
            return "/viewUserDetails.jsp";
        }
        if(view.contains("offer")) {
            System.out.println("offer");
            return "/index.jsp";
        }
        if(view.contains("login")) {
            System.out.println("login");
            return "/index.jsp";
        }
        if(view.contains("listUser")) {
            System.out.println("listUser");
            return "/index.jsp";
        }
        return "/index.jsp";
    }
}
