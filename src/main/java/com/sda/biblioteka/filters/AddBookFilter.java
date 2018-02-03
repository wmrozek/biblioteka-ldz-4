package com.sda.biblioteka.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AddBookFilter", servletNames = "AddBookServlet")
public class AddBookFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse response = null;
        if(servletResponse instanceof HttpServletResponse){
            response = (HttpServletResponse) servletResponse;
        }

        if (!httpServletRequest.getMethod().equalsIgnoreCase("POST")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String title = servletRequest.getParameter("title");
        String author = servletRequest.getParameter("author");

        if (title == null || title.isEmpty()){
            response.sendRedirect("./error?message=bad_title");
            return;
        }
        if (author == null || author.isEmpty()){
            response.sendRedirect("./error?message=bad_author");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
