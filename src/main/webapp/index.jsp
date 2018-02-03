<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.Random" %>
<%@ page import="com.sda.biblioteka.tools.RandomNumberGenerator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Hello world! Dzisiejsza data to: <%= LocalDate.now().toString()%></p>
    <p>Przeglądarka, którą mamy otwartą: <%= request.getHeader("User-Agent")%></p>

    <p>Elementy żądania: </p>
    <p>Request URL: <%= request.getRequestURL()%></p>
    <p>Nazwy parametrów: <%= request.getParameterNames()%></p>
    <p>Metoda HTTP: <%= request.getMethod()%></p>
    <p>Ilość ciasteczek: <%= request.getCookies().length%></p>
    <p>Context path: <%= application.getContextPath()%></p>

    <p>Twój szczęśliwy numerek na dzisiaj to: <%= new Random().nextInt(100)%></p>

    <p>Dzisiejsze typy lotto: <%= RandomNumberGenerator.drawLottoNumber()%></p>

</body>
</html>
