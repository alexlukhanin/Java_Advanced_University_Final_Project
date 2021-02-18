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

    <title>Admin panel</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">





</head>
<body>


    <!-- Sidebar -->
    <div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
        <h3 class="w3-bar-item">Menu</h3>
        <a href="/home" class="w3-bar-item w3-button">Home</a>
        <a href="/show-entrants" class="w3-bar-item w3-button">All entrants</a>
        <a href="/admin_panel" class="w3-bar-item w3-button">Admin Panel</a>
        <a href="/login?logout" class="w3-bar-item w3-button">Logout</a>
<%--        <a onclick="document.forms['logoutForm'].submit()" class="w3-bar-item w3-button">Logout</a>--%>
    </div>


    <!-- Page Content -->
    <div style="margin-left: 10%">
        <div class="w3-container w3-red w3-center"  >
            <h1>Admin Panel</h1>
        </div>

        <div class="w3-container">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form>

                <div class="w3-container" style="height: 50px; width: 100%">
                    <h4>  Welcome, administrator  ${pageContext.request.userPrincipal.name} </h4>
                </div>
            </c:if>


            <div class="w3-container" >
                    <form method="POST" action="${contextPath}/add_faculty" >
                        <h4>Add new Faculty</h4>
                        <label for="faculty_name">Faculty name</label><br>
                        <input type="text" id="faculty_name" name="faculty_name">
                        <input type="submit" value="Submit">
                    </form>
                <br>
                <h4>List of the Faculties: </h4>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Faculty name</th>
                        <th>Number of Students</th>
                        <th>Subjects</th>
                        <th>Email</th>
                        <th>Marks</th>
                    </tr>
                    </thead>
                    <tbody id="myTable">

                    <c:forEach items="${facultyRegistrations}" var="currentRegistration">
                        <tr>
                            <td>${currentRegistration.faculty.name}</td>
                            <td>${currentRegistration.user.firstName}</td>
                            <td>${currentRegistration.user.lastName}</td>
                            <td>${currentRegistration.user.email}</td>
                            <td>${currentRegistration.faculty.subjects}<br>${currentRegistration.marks}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
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