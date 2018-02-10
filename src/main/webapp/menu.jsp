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
    <ul>
        <li><a href="./home">Strona główna</a></li>
    </ul>
</c:if>

