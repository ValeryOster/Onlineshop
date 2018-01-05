package de.onlineshop.main.filters;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"},
            filterName = "LoggingFilter",
            asyncSupported = true,
            dispatcherTypes = { DispatcherType.FORWARD, DispatcherType.ASYNC, DispatcherType.REQUEST,
            DispatcherType.INCLUDE, DispatcherType.ERROR})
public class LoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        ServletContext sc = servletRequest.getServletContext();
        sc.log("LoggingFilter ....");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
