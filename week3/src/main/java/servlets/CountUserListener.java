package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class CountUserListener implements ServletRequestListener {
    ServletContext ctx;
    AtomicInteger total=new AtomicInteger();
    AtomicInteger current=new AtomicInteger();

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        current.addAndGet(-1);
        ctx.setAttribute("currentusers",current);
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        long executionTime=System.currentTimeMillis();
        total.addAndGet(1);
        current.addAndGet(1);

        ctx=servletRequestEvent.getServletContext();
        ctx.setAttribute("totalusers", total);
        ctx.setAttribute("currentusers", current);
        executionTime=System.currentTimeMillis()-executionTime;
        ctx.setAttribute("executionTime",executionTime);
    }
}