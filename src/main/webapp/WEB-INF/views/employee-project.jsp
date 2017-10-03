<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	background-image:
		url(https://www.myscbc.org/wp-content/uploads/2013/03/background-images-for-websites-hd-background-wallpaper-40.jpg);
}

a {
	font-size: 20px;
	color: snow;
}

h2 {
	color: limegreen;
}

p {
	color: seashell;
}

label {
	font-size: 20px;
}
</style>
<title>Employee Project</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="fundsAvailable" value="${sessionScope.funds}" />
	<c:set var="project" value="${sessionScope.project}" />
	
	<a href="${contextPath}/logout.htm">Logout</a>
	<br />
	<div class="container">
		<h2>Employee Project Details</h2>
		<h3>Project Name: ${project.projectName}</h3>
		<form action="${contextPath}/employeeproject.htm" method="post">
			<table class="table table-hover">

				<tr>
					<td style="color: linen;">Project Aim:</td>
					<td><input name="aim" value="${project.projectAim}" size="30"
						pattern="^[a-zA-Z ]{2,30}$" required="required" /></td>
				</tr>
				<tr>
					<td style="color: linen;">Project Description:</td>
					<td><input name="desc" value="${project.projectDescription}"
						size="150" pattern="^[a-zA-Z ]{2,150}$" required="required" /></td>
				</tr>
				<tr>
					<td style="color: linen;">Funds Allocated:</td>
					<td><input value="${project.fundsAllocated}"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<td style="color: linen;">Funds Available:</td>
					<td><input value="${fundsAvailable.totalFunds}"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<td style="color: linen;">Add funds:</td>
					<td><input type="number" pattern="^\d{10}$" name="addFunds"
						min="1" max="${fundsAvailable}" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-lg"
						value="Update Project details" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>