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
import java.util.concurrent.atomic.AtomicInteger;

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
        AtomicInteger t=(AtomicInteger)ctx.getAttribute("totalusers");
        AtomicInteger c=(AtomicInteger)ctx.getAttribute("currentusers");

        session.setAttribute("totalusers",t.get());
        session.setAttribute("currentusers",c.get());
        resp.sendRedirect("welcome.jsp");

    }

}
