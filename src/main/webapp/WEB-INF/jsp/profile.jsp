<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <jsp:include page="parts/head.jsp"/>
</head>
<body>
<jsp:include page="parts/header.jsp"/>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h2>${register ? 'Register new' : userTo.name.concat(' profile')}</h2>

            <div class="view-box">
                <form:form modelAttribute="userTo" class="form-horizontal" method="post"
                           action="${register ? 'register' : 'profile'}" charset="utf-8"
                           accept-charset="UTF-8">

                    <custom:inputField label="Name" name="name"/>
                    <custom:inputField label="Email" name="email"/>
                    <custom:inputField label="Password" name="password" inputType="password"/>
                    <custom:inputField label="Calories per day" name="caloriesPerDay" inputType="number"/>

                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <button type="submit" class="btn btn-primary">${register ? 'Add' : 'Update'}</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="parts/footer.jsp"/>
</body>
</html>
