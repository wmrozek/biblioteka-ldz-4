package com.sda.biblioteka.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDate;

@WebFilter(filterName = "AddInfoFilter", servletNames = "AddBookServlet")
public class AddInfoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (!httpServletRequest.getMethod().equalsIgnoreCase("POST")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        servletRequest.setAttribute("addedDate", LocalDate.now());
        String userAgent = httpServletRequest.getHeader("User-Agent");
        servletRequest.setAttribute("addedUserAgent", userAgent);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
