import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", urlPatterns = "/Login")
public class Login  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        HttpSession session= req.getSession();
        session.setAttribute("user",username);
        session.setAttribute("pass",password);

        ServletContext ctx=getServletContext();
        int t=(Integer)ctx.getAttribute("totalusers");
        int c=(Integer)ctx.getAttribute("currentusers");

        session.setAttribute("totalusers",t);
        session.setAttribute("currentusers",c);
        resp.sendRedirect("welcome.jsp");

    }

}
