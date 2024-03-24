package app.mapl.webservice;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewOfferCommand  implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));

//        AverageModel model = new AverageModel();
       final double mean = (double) (num1 + num2) / 2;
        request.setAttribute("result", mean);

        String offer = request.getParameter("offer");
        request.setAttribute("offer","Discount for offer "+offer+" is 50%" );

        return "offer";
    }

}
