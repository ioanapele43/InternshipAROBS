import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("The application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("The application stopped");
    }
}
