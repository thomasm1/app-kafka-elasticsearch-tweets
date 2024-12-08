package app.mapl.webservice;
//import java.time.LocalDateTime;
import java.io.IOException;
//import java.io.PrintWriter; 

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

//@Configuration
// Marks this class as configuration
// Specifies which package to scan
//@ComponentScan("app.mapl")
// Enables Spring's annotations
//@WebServlet("/*")
public class CommandHelper { //  implements WebApplicationInitializer {

	public Command getCommand(String requestURI) {
		if (requestURI.contains("/data/user")) {
			System.out.println("/data/user");
			return new ViewUserCommand();
		}
		else if ( requestURI.contains("/data/offer")) {
			System.out.println("/data/offer");
			return new ViewOfferCommand();
		}
		else if ( requestURI.contains("/data/login")) {
			System.out.println("/data/login");
			return new ViewLoginCommand();
		}
		else if ( requestURI.contains("/data/listUser")) {
			System.out.println("/data/listUser");
			return new ViewUsersCommand();
		} else {
		 return null;
		}
	}

//	public static void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String uri = request.getRequestURI();
//		System.out.println("uri: " + uri);
//		switch (uri) {
//			case "/data/offer":
//				OfferServlet c = new OfferServlet();
//				c.doPost(request, response);
//				System.out.println("offer|||||||||||||||||||||||||||||||||||||||||");
//				break;
//// SIGN-IN USER FORM
//			case "/data/login.do":
//				LoginWebService.login(request, response);
//				System.out.println("login");
//				break;
//			case "/data/logout.do":
//				LoginWebService.logout(request, response);
//				System.out.println("logout");
//				break;
//// Users
//			case "/data/get.do":
//				UserWebService.get(request, response);
//				System.out.println("get");
//				break;
//			case "/data/getUser.do": {
//				UserWebService.getUser(request, response);
//				break;
//			}
//			case "/data/listUser.do": {
//				UserWebService.listUser(request, response);
//				break;
//			}
//			case "/data/getAll.do":
//				UserWebService.getAll(request, response);
//				System.out.println("getAll");
//				break;
//
//// Register USER FORM
//			case "/data/addUser.do": {
//				UserWebService.createUser(request, response);
//				break;
//			}
//			case "/data/register.do":
//				UserWebService.register(request, response);
//				System.out.println("register");
//				break;
//			case "/data/update.do":
//				UserWebService.update(request, response);
//				System.out.println("update");
//				break;
//			case "/data/delete.do":
//				UserWebService.delete(request, response);
//				System.out.println("delete");
//				break;
//// Groups
//			case "/data/addGroups.do": {
//				GroupsWebService.addGroups(request, response);
//				break;
//			}
//			case "/data/getGroups.do": {
//				GroupsWebService.getGroups(request, response);
//				break;
//			}
//			case "/data/listGroups.do": {
//				GroupsWebService.listGroups(request, response);
//				break;
//			}
//// Request Form
////				case "/data/addRequest.do": {
////					RequestWebService.addRequest(request, response);
////					break;
////				}
//// Get Request details - takes param   [reqId]
////				case "/data/getRequest.do": {           /////// WORKS ON EC2
////					try {
////						RequestWebService.getRequest(request, response);
////					} catch (Exception e) {
////						// TODO: handle exception
////					}
////					break;
////				}
//// takes parameter    [userId]
//// Collect user's requests (and pending)
////				case "/data/listRequest.do": {
////					RequestWebService.listRequest(request, response);
////					break;
////				}
//// takes parameter    [ (stage, reqUpdateId, supervisorId, text)]
////"reqId="+reqUpdateId+"&stage="+stage+"&superText="+superText+"&dheadText="+dheadText+"&bencoText="+bencoText+"&reqText="+reqText
//			// Collect user's requests (and pending)
////
//
//			default: {
//				try {
//					response.sendError(451, "Get off my 451 lawn");
//					System.out.println("default");
//					break;
//				} catch (IOException e) {
//					System.out.println(e);
//				}
//			}
//		}
//	}
}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
////			ctx.register(Config.class);
//		ctx.setServletContext(servletContext);
//
//		ServletRegistration.Dynamic servlet = servletContext.addServlet("RequestHelper", new DispatcherServlet(ctx));
//		servlet.addMapping("/data/data/*");
//		servlet.setLoadOnStartup(1);
//
//		ServletRegistration.Dynamic offer = servletContext.addServlet("OfferServlet", new DispatcherServlet(ctx));
//		offer.addMapping("/data/offer");
//		offer.setLoadOnStartup(1);
//	}

