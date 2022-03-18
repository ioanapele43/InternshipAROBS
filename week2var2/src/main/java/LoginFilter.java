import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/Login")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = servletRequest.getParameter("user");
        String password = servletRequest.getParameter("pass");

        if (username.equals("admin") && password.equals("pass")) {
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            servletResponse.getWriter().println("Incorrect inputs");
        }
    }

    @Override
    public void destroy() {

    }
}
