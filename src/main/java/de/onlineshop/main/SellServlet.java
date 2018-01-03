package de.onlineshop.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Description
 *
 * @author Valery Oster
 * @version 1.0
 */
@WebServlet("/sell")
@MultipartConfig(
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*30,
        location = "/tmp",
        fileSizeThreshold = 1024*1024)
public class SellServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final String title = request.getParameter("title");
        final String description = request.getParameter("description");
        final String price = request.getParameter("price");
        final Part part = request.getPart("foto");
        OutputStream os = null;
        InputStream is = null;

        try {
            String path = "/tmp/"
                    + part.getSubmittedFileName();
            File file = new File(path);
            os = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int i = 0;
            is = part.getInputStream();
            while ((i = is.read(b)) != -1) {
                os.write(b, 0, i);
            }
        } catch (Exception ex) {
            throw new ServletException(
                    ex.getMessage());
        } finally {
            os.close();
            is.close();
        }

        final PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<br>Hochgeladener Artikel: " + title);
        out.println("<br>Beschreibung: " + description);
        out.println("<br>Preis: " + price);
        out.println("<br>Bild: " + part.getSubmittedFileName());
        out.println("</body>");
        out.println("</html>");
    }
}
