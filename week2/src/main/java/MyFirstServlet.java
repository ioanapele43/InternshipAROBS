
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="MyFirstServlet",urlPatterns = "/myPage")
public class MyFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        PrintWriter printWriter=resp.getWriter();
        resp.setContentType("text/html");
        printWriter.println("""
                <html>
                    <body>
                        <form name="loginForm" method="post" action="loginServlet">
                            Username: <input type="text" name="username"/> <br/>
                            Password: <input type="password" name="password"/> <br/>
                            <input type="submit" value="Login" />
                        </form>
                    </body>
                </html>
                """);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        // do some processing here...

        // get response writer
        PrintWriter writer = response.getWriter();

        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + username + "<br/>";
        htmlRespone += "Your password is: " + password + "</h2>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);

    }

}