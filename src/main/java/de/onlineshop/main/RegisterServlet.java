package de.onlineshop.main;

import de.onlineshop.main.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Description
 *
 * @author Valery Oster
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/register"}, loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Registrierung</h1>");
        out.println("Datum: " + new Date());
        out.println("Remote address: " + request.getRemoteAddr());
        out.println("</body>");
        out.println("</html>");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("Context-Type","text/html;charset=UTF-8");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final PrintWriter out = response.getWriter();
        final HttpSession session = request.getSession();
        final Customer customer = new Customer();
        final Cookie cookieMail = new Cookie("email", email);
        final Cookie cookiePasswd = new Cookie("password", password);

        response.addCookie(cookieMail);
        response.addCookie(cookiePasswd);

        customer.setEmail(email);
        customer.setPassword(password);
        session.setAttribute("customer", customer);

        final RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
}
