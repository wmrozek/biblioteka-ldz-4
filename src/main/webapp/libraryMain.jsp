<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.sda.biblioteka.spring.db.model.Book" %>
<%@ page import="java.util.Random" %>
<%@ page import="com.sda.biblioteka.spring.db.BookContext" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Biblioteka SDA Łódź</title>
</head>
<body>
    <%! boolean isLooged = true; %>
    <c:set var="isLoggedUserInPage" value="${isLoggedUser}"/>
    <%
        Random random = new Random();
        for (int i=0;i<3;i++){
            Book book = new Book();
            book.setId(random.nextInt(2));
            book.setTitle("Pan Tadeusz - wydanie: "+random.nextInt(10));
            book.setPrice(random.nextInt(100));
            BookContext.getInstance().addBook(book);
        }

    %>

    <c:if test="${isLoggedUser eq false}">
        <%--<jsp:forward page="/login"/>--%>
        <c:redirect url="/login"/>
    </c:if>


    <div style="float:left; width: 30%">
        <%@ include file="menu.jsp"%>

        <p>Ilość zarejestrowanych użytkowników: ${usersCount}</p>
        <p>Ilość książek w bibliotece: ${booksCount}</p>
        <!-- MENU -->
    </div>
    <div style="float:right; width: 70%">
        <h2>Witaj na stronie biblioteki SDA.</h2>
        <!-- CONTENT -->
        <h1>Dostępne książki w ofercie</h1>
        <table>
            <th>Id</th>
            <th>Tytuł</th>
            <th>Cena wypożyczenia</th>
            <c:forEach items="${books}" var="book">
                <tr>
                <c:choose>
                    <c:when test="${book.id > 0}">
                            <td><b>${book.id}</b></td>
                            <td>${book.title}</td>
                    </c:when>
                    <c:otherwise>
                            <td>${book.id}</td>
                            <td>${book.title}</td>
                    </c:otherwise>
                </c:choose>
                </tr>
            </c:forEach>
        </table>

        <h1>Dostępne książki w ofercie - skryptlet</h1>
        <table>
            <th>Id</th>
            <th>Tytuł</th>
            <%
                List<Book> books = (List<Book>) request.getAttribute("emptyList");
                for (Book book : books){
                    out.println("<tr>");
                    out.println("<td>"+book.getId()+"</td>");
                    out.println("<td>"+book.getTitle()+"</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        </table>
    </div>
    <div style="clear: both"/>

</body>
</html>
