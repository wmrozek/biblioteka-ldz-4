<%@ page import="com.sda.biblioteka.spring.db.model.Book" %>
<%@ page import="java.util.Random" %>
<%@ page import="com.sda.biblioteka.spring.db.BookContext" %>
<%@ page import="com.sda.biblioteka.tools.RandomNumberGenerator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Biblioteka SDA Łódź</title>
</head>
<body>

    <div style="float:left; width: 30%">
        <%@ include file="menu.jsp"%>
        <p>Ilość zarejestrowanych użytkowników: ${usersCount}</p>
        <p>Ilość książek w bibliotece: ${booksCount}</p>
        <%
            Integer usersCountParam = (Integer) request.getAttribute("usersCount");
            RandomNumberGenerator.drawLottoNumber();
            out.println("<p>Ilość użytkowników - skryptlet: "+usersCountParam);
        %>
        <!-- MENU -->
    </div>
    <div style="float:right; width: 70%">
        <h2>Witaj na stronie biblioteki SDA.</h2>
        <h5>Logowanie</h5>
        <form action="./login"  method="POST">
            <label>Login: </label>
            <input type="text" name="login"/>
            <label>Hasło: </label>
            <input type="password" name="password"/>
            <input type="submit" value="Zarejestruj" />


        </form>
        <!-- CONTENT -->
    </div>
    <div style="clear: both"/>

</body>
</html>
