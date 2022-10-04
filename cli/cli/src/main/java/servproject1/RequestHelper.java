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

		case "/project1/login.do": {
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
		case "/project1/addUserAdmin.do": {
			UserAdminWebService.addUserAdmin(request, response);
			break;
		} 
		case "/project1/getUserAdmin.do": {
			UserAdminWebService.getUserAdmin(request, response);
			break;
		}
		case "/project1/listUserAdmin.do": {
			UserAdminWebService.listUserAdmin(request, response);
			break;
		} 
// Request Form
		case "/project1/addRequest.do": {
			RequestWebService.addRequest(request, response);
			break;
		} 
// Get Request details - takes param   [reqId] 
		case "/project1/getRequest.do": {           /////// WORKS ON EC2
		try {
			RequestWebService.getRequest(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
			break;
		}
// takes parameter    [userId]
// Collect user's requests (and pending)
		case "/project1/listRequest.do": {
			RequestWebService.listRequest(request, response);
			break;
		} 
// takes parameter    [ (stage, reqUpdateId, supervisorId, text)] 
//"reqId="+reqUpdateId+"&stage="+stage+"&superText="+superText+"&dheadText="+dheadText+"&bencoText="+bencoText+"&reqText="+reqText
		// Collect user's requests (and pending)
		case "/project1/updateRequest.do": {
		try {
			RequestWebService.updateReq(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
			break;
		} 
		case "/project1/addTask.do": {
			TaskWebService.addTask(request, response);
			break;
		} 
		case "/project1/getTask.do": {
			TaskWebService.getTask(request, response);
			break;
		}
		case "/project1/listTask.do": {
			TaskWebService.listTask(request, response);
			break;
		} 
		
		case "/project1/addDept.do": {
			DeptWebService.addDept(request, response);
			break;
		} 
		case "/project1/getDept.do": {
			DeptWebService.getDept(request, response);
			break;
		}
		case "/project1/listDept.do": {
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
