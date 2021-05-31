<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div style="background-color: #333333;position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); border-radius: 5px; padding: 10px">
<form method="post" action="/menu">
        <h1>Burgery</h1>
        <table>

            <th>Nazwa</th>
            <th>Opis</th>
            <th>Cena</th>

            <tr>
                <c:forEach items="${burgers}" var="burger">
                <td><input type="checkbox" name="idOfBurger" id="${burger.id}" value="${burger.id}"></td>
                <td>${burger.name}</td>
                <td>${burger.description}</td>
                <td>${burger.price}</td>
            </tr>
            </c:forEach>
        </table>
    <input type="submit" value="Zapłać">
</form>
</div>

</body>
</html>
