package com.sda.biblioteka.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="BookAdded", urlPatterns = "/bookAdded")
public class BookAddedServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookNumber = req.getParameter("bookNumber");
        resp.getOutputStream().println("Ksiazka zapisana pod numerem "+bookNumber);
    }
}
