<%@ page import="com.sda.biblioteka.spring.db.model.Book" %>
<%@ page import="java.util.Random" %>
<%@ page import="com.sda.biblioteka.spring.db.BookContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Biblioteka SDA Łódź</title>
</head>
<body>
    <%
        Random random = new Random();
        for (int i=0;i<3;i++){
            Book book = new Book();
            book.setTitle("Pan Tadeusz - wydanie: "+random.nextInt(10));
            BookContext.getInstance().addBook(book);
        }
    %>
    <div style="float:left; width: 30%">
        <%@ include file="menu.jsp"%>

        <p>Ilość zarejestrowanych użytkowników: ${usersCount}</p>
        <p>Ilość książek w bibliotece: ${booksCount}</p>
        <!-- MENU -->
    </div>
    <div style="float:right; width: 70%">
        <h2>Witaj na stronie biblioteki SDA.</h2>
        <h5>Rejestracja</h5>
        <form action="./register" name="regForm" method="POST">
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
