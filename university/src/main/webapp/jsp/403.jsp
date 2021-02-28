<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Not permitted</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>

<div class="container">
    <!-- Sidebar -->
    <div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
        <h3 class="w3-bar-item"><spring:message code="menu.menu"/></h3>
        <a href="/home" class="w3-bar-item w3-button"><spring:message code="menu.home"/></a>
        <a href="/show-entrants" class="w3-bar-item w3-button"><spring:message code="menu.entrants"/></a>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a href="/admin_panel" class="w3-bar-item w3-button"><spring:message code="menu.adminpanel"/></a>
        </security:authorize>
        <a href="/login?logout" class="w3-bar-item w3-button"><spring:message code="menu.logout"/></a>

    </div>

    <div style="margin-left: 10%">
        <!-- Page Content -->
        <div class="w3-container w3-red w3-center">
            <h3> <spring:message code="page403.message"/></h3>
        </div>
        <br><br>
        <div class="w3-container w3-center">
            <form action="/logout" method="post">

                <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="page403.submit"/></button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </div>

</div>
<!-- /container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>