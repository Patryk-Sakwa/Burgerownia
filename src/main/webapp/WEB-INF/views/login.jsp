<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@include file="header.jsp" %>

<div style="background-color: #333333;position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); border-radius: 5px; padding: 10px"
     class="container">

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 style="text-align: center" class="form-heading">Logowanie</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Email" autofocus="true"/><br>
            <input name="password" type="password" class="form-control" placeholder="Hasło"/><br>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>
            <button style="margin-top: 10px; position: relative; left: 50%; -ms-transform: translateX(-50%); transform: translateX(-50%)"
                    class="btn btn-lg btn-primary btn-block" type="submit">Log In
            </button>
        </div>

    </form>

</div>
</body>
</html>
