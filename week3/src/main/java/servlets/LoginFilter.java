package servlets;

import user.UserDao;

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
        System.out.println("\n"+username+" "+password);
       // UserDao userDao=new UserDao();
        if(username.equals("ioanap")&& password.equals("1234")){
        //if (userDao.login(username,password)) {
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            servletResponse.getWriter().println("Incorrect inputs "+username+" "+password+"klkl");
        }
    }



    @Override
    public void destroy() {

    }
}
