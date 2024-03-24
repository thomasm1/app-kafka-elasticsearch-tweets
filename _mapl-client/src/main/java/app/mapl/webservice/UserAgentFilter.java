package app.mapl.webservice;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class UserAgentFilter implements Filter {
        public void destroy() {
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            String userAgent = req.getHeader("User-Agent");

            if (userAgent.contains("MSIE")) {
//                res.sendRedirect("http://www.google.com");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/response.jsp");
                requestDispatcher.forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        }
        public void init(FilterConfig config) throws ServletException {
        }
}
