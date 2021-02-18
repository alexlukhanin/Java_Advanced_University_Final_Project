<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Not permitted</title>

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

		<div style="margin-left: 10%">
			<!-- Page Content -->
			<div class="w3-container w3-red w3-center">
				<h3> You have no permission to access page!</h3>
			</div>
			<br><br>
			<div class="w3-container w3-center">
				<form action="/logout" method="post">

					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in as different user</button>
					<input type="hidden" name="${_csrf.parameterName}" value ="${_csrf.token}"/>
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