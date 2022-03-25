package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/register")
public class RegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = servletRequest.getParameter("user");
        String password = servletRequest.getParameter("pass");

        if (username.length()>5 || password.length()>4) {
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            servletResponse.getWriter().println("Incorrect inputs");
        }
    }



    @Override
    public void destroy() {

    }
}
