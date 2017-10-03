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
<script type="text/javascript">
function myFunction(volunteerId) {
	location.href = "employeevolunteer.htm?vId=" + volunteerId; 
	alert("Email sent to the volunteer regarding project assignment");
	}
	</script>
<title>Employee Login</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="user" value="${sessionScope.user}" />
	<c:set var="project" value="${sessionScope.project}" />
	<c:set var="volunteers" value="${sessionScope.unvolunteers}" />
	<c:set var="victims" value="${sessionScope.victims}" />

	<a href="${contextPath}/logout.htm">Logout</a>
	<br />
	<div class="container">
		<h2>Employee</h2>
		<form action="${contextPath}/employeelogin.htm" method="post">
			<div class="form-group">
				<label for="pic" style="color: linen;">Employee:</label> <img
					name="pic" id="pic" height="150" width="150" src="${user.filename}" />
			</div>
			<div class="form-group">
				<label for="fname" style="color: linen;">First name:</label> <input
					class="form-control" id="fname" name="fname"
					value="${user.firstName}" disabled="disabled" />
			</div>
			<div class="form-group">
				<label for="lname" style="color: linen;">Last name:</label> <input
					class="form-control" id="lname" name="lname"
					value="${user.lastName}" disabled="disabled" />
			</div>
			<div class="form-group">
				<label for="project" style="color: linen;">Project Name:</label> <input
					class="form-control" id="project" name="project"
					value="${project.projectName}" disabled="disabled" />
			</div>
			<button type="submit" class="btn btn-lg">Update Project
				Details</button>
		</form>
	</div>
	<br />
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<td style="color: linen;" width="30%">Volunteer Id</td>
					<td style="color: linen;" width="30%">SSN</td>
					<td style="color: linen;" width="30%">Assign to project</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${volunteers}" var="v">
					<tr>
						<td style="color: linen;">${v.volunteerId}</td>
						<td style="color: linen;">${v.ssn}</td>
						<td><button type="submit"
								onClick="myFunction(${v.volunteerId})" class="btn btn-lg"
								value="Assign volunteer to project?"></button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	<div class="container">
		<form action="${contextPath}/addvictim.htm">
			<table class="table table-hover">
				<thead>
					<tr>
						<td style="color: linen;" width="30%">Victim Id</td>
						<td style="color: linen;" width="30%">Name</td>
						<td style="color: linen;" width="30%">Age</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${victims}" var="vic">
						<tr>
							<td style="color: linen;">${vic.victimId}</td>
							<td style="color: linen;">${vic.victimName}</td>
							<td style="color: linen;">${vic.victimAge}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="submit" class="btn btn-lg">Add Victim</button>
		</form>
	</div>
</body>
</html>