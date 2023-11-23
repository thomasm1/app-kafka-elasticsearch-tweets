package app.mapl.consoles;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppErrorController implements ErrorController {

	private static final Logger log =
			LoggerFactory.getLogger(AppErrorController.class);
	@GetMapping("/v1/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if(status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				return "errorpages/error-404";
			}
			else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "errorpages/error-500";
			}
			else if(statusCode == HttpStatus.FORBIDDEN.value()) {
				return "errorpages/error-403";
			}
		}

		return "errorpages/error";
	}


	public String getErrorPath() {
		return "/error";
	}
}
