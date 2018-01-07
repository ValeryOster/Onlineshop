package de.onlineshop.main.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/sell"},
            filterName = "LoggingFilter",
            asyncSupported = true)
public class LoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("Oster Valery is here !!!");
        ServletContext sc = servletRequest.getServletContext();
        sc.log("LoggingFilter ....");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    public void destroy() {

    }
}
