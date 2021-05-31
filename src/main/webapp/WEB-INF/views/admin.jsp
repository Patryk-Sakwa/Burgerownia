<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div style="background-color: #333333;position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); border-radius: 5px; padding: 10px"
     class="container">

    <form:form method="POST" modelAttribute="burgerForm" class="form-addburger">
        <h2 class="form-burger-heading">Nowy burger!</h2>
        <spring:bind path="name">
            <div class="form-group">
                <form:input type="text" path="name" class="form-control" placeholder="Nazwa"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="description">
            <div class="form-group">
                <form:textarea cssStyle="height: 10em" type="text" path="description" class="form-control"
                               placeholder="Opis"></form:textarea>
            </div>
        </spring:bind>

        <spring:bind path="price">
            <div class="form-group">
                <form:input path="price" class="form-control" placeholder="Cena"></form:input>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Utwórz burgera</button>
    </form:form>
</div>

</body>
</html>
