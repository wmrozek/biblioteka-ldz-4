package com.sda.biblioteka.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddBookServlet", urlPatterns = {"/addBookForm", "/addBook"})
public class AddBookServlet extends HttpServlet {
    private static int booksCount = 0;

    private static final String HTML_START = "<html><head></head><body>";
    private static final String HTML_END = "</body></html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getRequestURI().contains("addBookForm")){
            resp.sendError(403);
            return;
        }
        ServletOutputStream out = resp.getOutputStream();
        out.println(HTML_START);

        out.println("<form action=\"./addBook\" method=\"POST\">\n" +
                "  Tytul:<br>\n" +
                "  <input type=\"text\" name=\"title\">\n" +
                "  <br>\n" +
                " Autor:<br>\n" +
                "  <input type=\"text\" name=\"author\" >\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n");

        out.println(HTML_END);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("addBookForm")){
            resp.sendError(403);
            return;
        }
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        booksCount++;
        resp.sendRedirect("./bookAdded?bookNumber="+booksCount);

    }
}
