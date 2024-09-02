package app.mapl.webservice;

import app.mapl.models.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/data/*")
public class FrontControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontControlServlet() {
		super();
		System.out.println("FrontControlServlet: /data/*");
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);  // CORS

//		System.out.println(ServletConfig.class);
//		System.out.println("ServletContext"+ServletContext.class);
//		System.out.println("ServletContext"+request.getSession().getServletContext());
//		System.out.println("getRequestedSessionId::"+request.getRequestedSessionId());
		String session_servlet =  request.getRequestedSessionId();
//		System.out.println("getContextPath()"+request.getContextPath());
//		System.out.println("ServletContext"+request.getServletPath());
//		System.out.println("getPathInfo"+request.getPathInfo());
//		System.out.println("getCookies"+Arrays.asList(request.getCookies()));

		User u = new User();
		u.setUserId(1);
		u.setFirstName("John");
		u.setLastName("Doe");
		u.setCusUrl("https://www.google.com");
		u.setEmail("thomas.maestas@hotmail.com");

		HttpSession sess = request.getSession();
		sess.setAttribute("user", u );
		sess.setMaxInactiveInterval(3600);
		sess.setAttribute("session_servlet", "{'sess.getSessionContext()' , "+ sess.getServletContext()+"},{ 'sess.isNew()', "+ sess.isNew()+"}");
		sess.setAttribute("session_servlet",session_servlet);
		System.out.println("FrontControlServlet user: " + sess.getAttribute("user"));

		String requestURI = request.getRequestURI();
		System.out.println("requestURI::" + requestURI);

		CommandHelper commandHelper = new CommandHelper();
		Command command = commandHelper.getCommand(requestURI);
		System.out.println("commandHelper.getCommand(requestURI)::" + command);

		if (command != null) {
			String view = command.execute(request, response);
			System.out.println("command.execute view::" + view);
			Dispatcher dispatcher = new Dispatcher();
			if(view != null) {
				dispatcher.dispatch(request, response, view);
			}
		} else {
			System.out.println("Command is null");
		}
//		CommandHelper.process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// for Preflight
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setAccessControlHeaders(resp);
		resp.setStatus(HttpServletResponse.SC_OK);
	}
//
	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, HEAD, OPTIONS");
	}
// https://chrome.google.com/webstore/detail/moesif-orign-cors-changer/digfbfaphojjndkpccljibejjbppifbc?hl=en-US

}
