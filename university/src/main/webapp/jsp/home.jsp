<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="container">

    <!-- Sidebar -->
    <div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
        <h3 class="w3-bar-item">Menu</h3>
        <a href="/home" class="w3-bar-item w3-button">Home</a>
        <a href="/show-entrants" class="w3-bar-item w3-button">All entrants</a>
        <a href="/admin_panel" class="w3-bar-item w3-button">Admin Panel</a>
        <a href="/login?logout" class="w3-bar-item w3-button">Logout</a>
    </div>


    <!-- Page Content -->
    <div style="margin-left: 10%">
        <div class="w3-container w3-orange w3-center"  >
            <h1>Faculties</h1>
        </div>

        <div class="w3-container">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form>

                <div class="w3-container" style="height: 50px; width: 100%">
                    <h4>  Welcome ${pageContext.request.userPrincipal.name} </h4>
                </div>


            </c:if>
            <div class="w3-container" style="display: flex; flex-wrap: wrap">
                <c:if test="${not empty faculties}">
                    <c:forEach items="${faculties}" var="currentFaculty">

                        <div class="w3-card-4" style="width: 20%; margin: 2%">
                           <%-- <img
                                    src="https://www.wegagen.com/wp-content/themes/linstar23/assets/images/default-275x220.jpg"
                                    alt="Faculty logo" style="width: 100%">--%>
                            <div class="w3-container w3-center">
                                <h3>${currentFaculty.name}</h3>
                                <p>Number of students recruited:
                                        ${currentFaculty.numberOfStudents}</p>
                                <p>Necessary subjects for entry: ${currentFaculty.subjects}</p>
                            </div>
                            <a class="w3-button w3-block w3-dark-grey"
                               href="${contextPath}/faculty_reg?facultyId=${currentFaculty.id}&email=${pageContext.request.userPrincipal.name}">
                                Register</a>

                        </div>

                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>