package de.onlineshop.main.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SecurityFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String code = servletRequest.getParameter("code");
        if ("supergeheim123".equals(code)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            final String remoteAddr = servletRequest.getRemoteAddr();
            final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            final String requestURI = httpServletRequest.getRequestURI();
            final ServletContext sc = servletRequest.getServletContext();
            sc.log("Warning: improper access "
                            + "by remoteAddr "
                            + remoteAddr
                            + " on "
                            + requestURI );
            final RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("signedout.html");
            dispatcher.forward(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
