package servproject1;
//import java.time.LocalDateTime;
import java.io.IOException;
//import java.io.PrintWriter; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
 
import webservice.TaskWebService; 
import webservice.DeptWebService;
import webservice.LoginWebService;
import webservice.UserAdminWebService;
import webservice.RequestWebService;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) {
 
		HttpSession sess = request.getSession();
		sess.setMaxInactiveInterval(3600);
		sess.setAttribute("r-owner", "{'username', 'tom'},{'ordernum','222'}"); 
		System.out.println("RequestHelper: " + sess.getAttribute("r-owner"));
		 
//		sess.invalidate();  
		// This method will delegate other methods
		// on a different layer of our application
		// to process the request.

		String uri = request.getRequestURI();
		System.out.println(uri);
 
		switch (uri) {

		case "/cli/login.do": {
// LOGIN USER FORM
			try {
				LoginWebService.login(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
		}
		
// SIGN-IN USER FORM
		case "/cli/addUserAdmin.do": {
			UserAdminWebService.addUserAdmin(request, response);
			break;
		} 
		case "/cli/getUserAdmin.do": {
			UserAdminWebService.getUserAdmin(request, response);
			break;
		}
		case "/cli/listUserAdmin.do": {
			UserAdminWebService.listUserAdmin(request, response);
			break;
		} 
// Request Form
		case "/cli/addRequest.do": {
			RequestWebService.addRequest(request, response);
			break;
		} 
// Get Request details - takes param   [reqId] 
		case "/cli/getRequest.do": {           /////// WORKS ON EC2
		try {
			RequestWebService.getRequest(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
			break;
		}
// takes parameter    [userId]
// Collect user's requests (and pending)
		case "/cli/listRequest.do": {
			RequestWebService.listRequest(request, response);
			break;
		} 
// takes parameter    [ (stage, reqUpdateId, supervisorId, text)] 
//"reqId="+reqUpdateId+"&stage="+stage+"&superText="+superText+"&dheadText="+dheadText+"&bencoText="+bencoText+"&reqText="+reqText
		// Collect user's requests (and pending)
		case "/cli/updateRequest.do": {
		try {
			RequestWebService.updateReq(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
			break;
		} 
		case "/cli/addTask.do": {
			TaskWebService.addTask(request, response);
			break;
		} 
		case "/cli/getTask.do": {
			TaskWebService.getTask(request, response);
			break;
		}
		case "/cli/listTask.do": {
			TaskWebService.listTask(request, response);
			break;
		} 
		
		case "/cli/addDept.do": {
			DeptWebService.addDept(request, response);
			break;
		} 
		case "/cli/getDept.do": {
			DeptWebService.getDept(request, response);
			break;
		}
		case "/cli/listDept.do": {
			DeptWebService.listDept(request, response);
			break;
		} 

		 
//		case "/Task/MasterServlet": {
//			System.out.println("In MasterServlet *case*");
//			break;
//		}
		default: {
			try {
				response.sendError(451, "Get off my 451 lawn");
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		}

	}
}
