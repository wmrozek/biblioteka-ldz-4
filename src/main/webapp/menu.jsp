<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${isLoggedUser eq false}">
    <ul>
        <li><a href="./home">Strona główna</a></li>
        <li><a href="./register">Rejestracja</a></li>
        <li><a href="./login">Logowanie</a></li>
    </ul>
</c:if>
<c:if test="${isLoggedUser eq true}">
    <p>Witaj, <%= session.getAttribute("login")%></p>
    <c:if test="${sessionScope.get('login') ne ''}">
        <p>Witaj jeszcze raz, <%= session.getAttribute("login")%></p>
    </c:if>
    <ul>
        <li><a href="./home">Strona główna</a></li>
    </ul>
</c:if>

