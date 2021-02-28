<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>!
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>


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
    <!-- Page Content -->
    <div style="margin-left: 10%">
        <div class="w3-container w3-red w3-center"  >
            <h1><spring:message code="admin.title"/></h1>
        </div>

        <div class="w3-container">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form>
            </c:if>


            <div class="w3-container admin_panel">
                <h2><spring:message code="admin.new"/></h2>
                    <form:form method="POST" action="${contextPath}/add_faculty" enctype="multipart/form-data">

                        <div class="column_wrapper" style="display: flex; flex-wrap: wrap">
                            <div class="column1" style="margin: 0px 20px 5px 20px">
                                <label for="facultyName"><spring:message code="admin.faculty_name"/></label><br>
                                <input type="text" id="facultyName" name="facultyName"><br>
                                <label for="numberOfStudents"><spring:message code="home.number_students"/></label><br>
                                <input type="number" id="numberOfStudents" name="numberOfStudents" value="1"><br>
                                <label for="facultyLogo"><spring:message code="admin.logo"/></label><br>
                                <input type="file" id="facultyLogo" name="facultyLogo" value=<spring:message code="admin.choose_file" />><br>
                            </div>
                            <div class="column2" style="margin: 0px 20px 5px 20px">
                                <label for="firstSubject"><spring:message code="admin.sub1"/>:</label><br>
                                <input type="text" id="firstSubject" name="firstSubject" value="Ukrainian" readonly><br>
                                <label for="secondSubject"><spring:message code="admin.sub2"/>:</label><br>
                                <input type="text" id="secondSubject" name="secondSubject" value="Mathematics" readonly><br>
                                <label for="thirdSubject"><spring:message code="admin.sub3"/>:</label><br>

                                <select name="thirdSubject" id="thirdSubject">
                                    <option value="English">English</option>
                                    <option value="Biology">Biology</option>
                                    <option value="History">History</option>
                                    <option value="Physics">Physics</option>
                                    <option value="Chemistry">Chemistry</option>
                                </select>
                            </div>
                        </div>
                        <input type="submit" value=<spring:message code="submit"/> style="margin-left: 20px; color: white; width: 250px; background-color: darkred">
                    </form:form>
                <br>
                <h2><spring:message code="admin.list"/>: </h2>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th><spring:message code="admin.faculty_name"/></th>
                        <th><spring:message code="home.number_students"/></th>
                        <th><spring:message code="admin.subjects"/></th>
                        <th><spring:message code="photo"/></th>
                        <th><spring:message code="admin.edit"/></th>
                    </tr>
                    </thead>
                    <tbody id="myTable">
                    <c:if test="${not empty faculties}">
                        <c:forEach items="${faculties}" var="currentFaculty">
                            <tr>
                                <td>${currentFaculty.name}</td>
                                <td>${currentFaculty.numberOfStudents}</td>
                                <td>${currentFaculty.subjects}</td>
                                <td> <img
                                        src="${currentFaculty.logoUrl}"
                                        alt="Faculty logo" style="width: 100px"></td>
                                <td> <%--<a href="#">Edit</a>  <br>--%>
                                    <a href="${contextPath}/admin_panel/delete/${currentFaculty.id}"><spring:message code="admin.delete"/></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>


                    </tbody>
                </table>
            </div>
        </div>
    </div>

<!-- /container -->
    <script src="js/table.js"></script>


</body>
</html>