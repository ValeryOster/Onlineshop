package de.onlineshop.main;

import de.onlineshop.main.service.FotoService;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description
 *
 * @author Valery Oster
 * @version 1.0
 */
@WebServlet(value = "/sell", asyncSupported = true)
@MultipartConfig(
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*30,
        location = "/tmp",
        fileSizeThreshold = 1024*1024)
public class SellServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final AsyncContext ac = request.startAsync();
        ac.start(new FotoService(ac));
    }
}
