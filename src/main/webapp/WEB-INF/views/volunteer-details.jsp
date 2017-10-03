<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
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
<title>Volunteer Details</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="user" value="${sessionScope.user}" />
	<c:set var="volunteer" value="${sessionScope.volunteer}" />
	<c:set var="project" value="${sessionScope.project}" />
	<a href="${contextPath}/logout.htm">Logout</a>
	<br />
	<div class="container">
		<h2>Volunteer Details</h2>
		<div ng-app="myapp">
			<form action="${contextPath}/volunteerDetails.htm" method="post">
				<div class="form-group">
					<label for="pic" style="color: linen;">Employee:</label> <img
						name="pic" id="pic" height="150" width="150"
						src="${user.filename}" />
				</div>
				<div class="form-group">
					<label for="fname" style="color: linen;">First name:</label> <input
						class="form-control" pattern="^[a-zA-Z ]{2,30}$" id="fname"
						name="fname" value="${user.firstName}" disabled="disabled" />
				</div>
				<div class="form-group">
					<label for="lname" style="color: linen;">Last name:</label> <input
						class="form-control" pattern="^[a-zA-Z ]{2,30}$" id="lname"
						name="lname" value="${user.lastName}" disabled="disabled" />
				</div>
				<div class="form-group">
					<label for="volunteerId" style="color: linen;">Volunteer
						Id:</label> <input class="form-control" pattern="^\d{10}$"
						id="volunteerId" name="volunteerId"
						value="${volunteer.volunteerId}" disabled="disabled" />
				</div>
				<div class="form-group">
					<label for="ssn" style="color: linen;">SSN:</label> <input
						class="form-control" pattern="^\d{10}$" id="ssn" name="ssn"
						value="${volunteer.ssn}" disabled />
				</div>
				<div class="form-group">
					<label for="projectname" style="color: linen;">Project
						assigned to:</label> <input class="form-control" id="projectname"
						name="projectname" value="${project.projectName}"
						disabled="disabled" />
				</div>
				<div class="form-group">
					<label for="projectaim" style="color: linen;">Project aim:</label>
					<input class="form-control" id="projectaim" name="projectaim"
						value="${project.projectAim}" disabled="disabled" />
				</div>
				<div class="form-group">
					<label for="projectdescription" style="color: linen;">Project
						Description:</label> <input class="form-control" id="projectdescription"
						name="projectdescription" value="${project.projectDescription}"
						disabled="disabled" />
				</div>
				<p style="color: linen;">Unassign from the project?</p>
				<label class="radio-inline"><input type="radio"
					ng-model="myVar" name="optradio" value="yes" checked="checked">Yes</label>
				<label class="radio-inline"><input type="radio"
					ng-model="myVar" name="optradio" value="no">No</label>

				<div ng-switch="myVar">
					<div ng-switch-when="yes">
						<p style="color: linen;">Are you available for another
							project?</p>
						<label class="radio-inline"><input type="radio"
							name="avail" value="yes">Yes</label> <label class="radio-inline"><input
							type="radio" name="avail" value="no" checked="checked">No</label>
					</div>
				</div>
				<button type="submit" class="btn btn-lg">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>