<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <jsp:include page="parts/head.jsp"/>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header navbar-brand"><spring:message code="app.title"/></div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form:form class="navbar-form" role="form" action="spring_security_check"
                               method="post">
                        <div class="form-group">
                            <input type="text" placeholder="Email" class="form-control" name='username'>
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" class="form-control" name='password'>
                        </div>
                        <button type="submit" class="btn btn-success"><spring:message code="app.login"/></button>
                    </form:form>
                </li>
                <jsp:include page="parts/lang.jsp"/>
            </ul>
        </div>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <c:if test="${error}">
            <div class="error">
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>
        <c:if test="${not empty message}">
            <div class="message">
                <spring:message code="${message}"/>
            </div>
        </c:if>
    </div>
</div>
<div class="container">
    <div class="lead">
        Description of the project
    </div>
</div>
<jsp:include page="parts/footer.jsp"/>
</body>
</html>
