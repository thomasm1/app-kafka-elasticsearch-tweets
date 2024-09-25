package app.mapl.webservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/offer")
//    public class CouponServlet extends HttpServlet {
public class ViewOfferCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));

        AverageModel model = new AverageModel();
        int result = model.calculateAverage(num1, num2);
        request.setAttribute("result", result);

        String offer = request.getParameter("offer");
        request.setAttribute("offer","Discount for offer "+offer+" is 50%" );

        return "offer";
    }

}
