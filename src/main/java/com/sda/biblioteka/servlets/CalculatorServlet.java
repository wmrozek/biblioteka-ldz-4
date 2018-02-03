package com.sda.biblioteka.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number1 = req.getParameter("number1");
        String number2 = req.getParameter("number2");
        Integer n1 = getNumber(number1);
        Integer n2 = getNumber(number2);
        resp.setContentType("text/html; charset=utf-8");
        ServletOutputStream out = resp.getOutputStream();
        if (n1 == null || n2 == null){
            out.println("Nie podano prawidlowych liczb!");
            return;
        }
        out.println(String.format("Dodawanie: %d + %d = %d", n1, n2, n1+n2));
        out.println(String.format("Odejmowanie: %d - %d = %d", n1, n2, n1-n2));
        out.println(String.format("Mnozenie: %d * %d = %d", n1, n2, n1*n2));
        out.println(String.format("Dzielenie: %d / %d = %d", n1, n2, n1/n2));
    }

    private Integer getNumber(String numberString){
        if (numberString == null || numberString.isEmpty()){
            return null;
        }
        try{
            return Integer.parseInt(numberString);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
