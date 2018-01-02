package de.onlineshop.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description
 *
 * @author Valery Oster
 * @version 1.0
 */
@WebServlet("/sell")
@MultipartConfig
public class SellServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final Part part = request.getPart("foto");
        final PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("Content-Type: " + part.getContentType() + "<br>");
        out.println("Size: " + part.getSize() + "<br>");
        out.println("Name: " + part.getName() + "<br>");
        out.println("Filename: " + part.getSubmittedFileName() + "<br>");
    }
}
