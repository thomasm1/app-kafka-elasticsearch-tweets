package servproject1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		setAccessControlHeaders(response);
//		PrintWriter writer = response.getWriter();
//		writer.write("test response from myServlet");
		HttpSession sess = request.getSession();
		sess.setMaxInactiveInterval(3600); 
//		sess.setAttribute("m-owner", "{'username', 'tom'},{'ordernum','222'}"); 
		System.out.println("MasterServlet: " + sess.getAttribute("m-owner"));
		 
		RequestHelper.process(request, response);
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
