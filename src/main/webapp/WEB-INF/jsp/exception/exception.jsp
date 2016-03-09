<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../parts/head.jsp"/>
</head>
<body>
    <jsp:include page="../parts/header.jsp"/>

    <div class="jumbotron">
        <div class="container">
            <br>
            <h4>Application error: </h4>
            <h2>${exception.message}</h2>
        </div>
    </div>

    <jsp:include page="../parts/footer.jsp"/>
</body>
</html>