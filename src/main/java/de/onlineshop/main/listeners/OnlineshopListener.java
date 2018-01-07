package de.onlineshop.main.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Description
 *
 * @author Valery Oster
 * @version 1.0
 */
@WebListener
public class OnlineshopListener implements HttpSessionListener{
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        context.log("Session created: " + se.toString());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        context.log("Session destroyed: " + se.toString());
    }
}
