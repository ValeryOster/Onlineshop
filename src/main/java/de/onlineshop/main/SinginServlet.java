package de.onlineshop.main;

import de.onlineshop.main.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description
 *
 * @author Valery Oster
 * @version 1.0
 */
@WebServlet("/signin")
public class SinginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Context-Type","text/html;charset=UTF-8");

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final HttpSession session = request.getSession();
        final Customer customer = (Customer) session.getAttribute("customer");
        final PrintWriter out = response.getWriter();

        String cookie_email = null;
        String cookie_password = null;

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>Cookie-Name</td>");
        out.println("<td>Cookie-Value</td>");
        out.println("</tr>");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            out.println("<tr>");
            out.println("<td>"+name+"</td>");
            out.println("<td>"+value+"</td>");
            out.println("</tr>");
            if("email".equals(name)) {
                cookie_email = value;
            } else if("password".equals(name)) {
                cookie_password = value;
            }
        }
        out.println("</table>");

        if(email.equals(cookie_email) && password.equals(cookie_password) ) {
            out.println("<h1>Benutzer ist valide!</h1>");
        } else {
            out.println("<h1>Benutzer ist nicht valide!</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
