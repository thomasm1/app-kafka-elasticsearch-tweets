package app.mapl.webControllers;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LandingController {

	@RequestMapping(value="/v1/landing",method = RequestMethod.GET)
	public String gotoLandingPage(ModelMap model) {
//		model.put("username", getLoggedinUsername());
		model.put("username", "thomas");
		return "landing";
	}
	
//	private String getLoggedinUsername() {
//		Authentication authentication =
//				SecurityContextHolder.getContext().getAuthentication();
//		return authentication.getName();
//	}
}