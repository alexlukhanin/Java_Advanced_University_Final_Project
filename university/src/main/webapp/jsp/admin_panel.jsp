<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>!
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
            </c:if>


            <div class="w3-container admin_panel">
                <h2>Add new Faculty</h2>
                    <form:form method="POST" action="${contextPath}/add_faculty" enctype="multipart/form-data">

                        <div class="column_wrapper" style="display: flex; flex-wrap: wrap">
                            <div class="column1" style="margin: 0px 20px 5px 20px">
                                <label for="facultyName">Faculty name</label><br>
                                <input type="text" id="facultyName" name="facultyName"><br>
                                <label for="numberOfStudents">Number of students</label><br>
                                <input type="number" id="numberOfStudents" name="numberOfStudents" value="1"><br>
                                <label for="facultyLogo">Faculty logo</label><br>
                                <input type="file" id="facultyLogo" name="facultyLogo"><br>
                            </div>
                            <div class="column2" style="margin: 0px 20px 5px 20px">
                                <label for="firstSubject">First Subject:</label><br>
                                <input type="text" id="firstSubject" name="firstSubject" value="Ukrainian" readonly><br>
                                <label for="secondSubject">Second Subject:</label><br>
                                <input type="text" id="secondSubject" name="secondSubject" value="Mathematics" readonly><br>
                                <label for="thirdSubject">Third Subject:</label><br>
<%--                                <input type="text" id="third_subject" name="third_subject">--%>
                                <select name="thirdSubject" id="thirdSubject">
                                    <option value="English">English</option>
                                    <option value="Biology">Biology</option>
                                    <option value="History">History</option>
                                    <option value="Physics">Physics</option>
                                    <option value="Chemistry">Chemistry</option>
                                </select>
                            </div>
                        </div>
                        <input type="submit" value="Submit" style="margin-left: 20px; color: white; width: 250px; background-color: darkred">
                    </form:form>
                <br>
                <h2>List of the Faculties: </h2>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Faculty name</th>
                        <th>Number of Students</th>
                        <th>Subjects</th>
                        <th>Logo</th>
                        <th>Edit</th>
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
                                <td> <%--<a href="#">Edit</a>  <br>--%><a href="#">Delete</a> </td>
                            </tr>
                        </c:forEach>
                    </c:if>


                    </tbody>
                </table>
            </div>
        </div>
    </div>


<!-- /container -->
    <script>
        $(document).ready(function () {
            $("#myInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>


</body>
</html>